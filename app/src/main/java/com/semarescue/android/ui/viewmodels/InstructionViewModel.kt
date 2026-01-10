package com.semarescue.android.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.semarescue.android.data.entities.Instruction
import com.semarescue.android.data.entities.Step
import com.semarescue.android.data.repository.InstructionRepository
import com.semarescue.android.utils.LanguageManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InstructionViewModel @Inject constructor(
    private val repository: InstructionRepository
) : ViewModel() {

    init {
        android.util.Log.d("InstructionViewModel", "ViewModel initialized")
    }
    
    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()
    
    val currentLanguage = LanguageManager.currentLanguage
    
    val allInstructions: StateFlow<List<Instruction>> = combine(
        repository.getAllInstructions(),
        _searchQuery,
        currentLanguage
    ) { instructions, query, _ ->
        if (query.isBlank()) {
            instructions
        } else {
            instructions.filter { instruction ->
                instruction.keywords.contains(query, ignoreCase = true) ||
                instruction.title_en.contains(query, ignoreCase = true) ||
                instruction.title_sw.contains(query, ignoreCase = true)
            }
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )
    
    fun getInstructionById(id: String): StateFlow<Instruction?> {
        return repository.getInstructionById(id)
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = null
            )
    }
    
    fun getStepsForInstruction(instructionId: String): StateFlow<List<Step>> {
        return repository.getStepsForInstruction(instructionId)
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = emptyList()
            )
    }
    
    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }
    
    fun toggleLanguage() {
        LanguageManager.toggleLanguage()
    }
    
    fun setLanguage(language: LanguageManager.Language) {
        LanguageManager.setLanguage(language)
    }
}
