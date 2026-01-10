package com.semarescue.android.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.semarescue.android.data.entities.IncidentLog
import com.semarescue.android.data.repository.IncidentRepository
import com.semarescue.android.utils.LanguageManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class IncidentViewModel @Inject constructor(
    private val repository: IncidentRepository,
    private val languageManager: LanguageManager
) : ViewModel() {

    val currentLanguage = languageManager.currentLanguage

    val logs: StateFlow<List<IncidentLog>> = repository.allLogs
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun addLog(description: String, category: String) {
        viewModelScope.launch {
            repository.addLog(description, category)
        }
    }
    
    fun clearLogs() {
        viewModelScope.launch {
            repository.clearLogs()
        }
    }
}
