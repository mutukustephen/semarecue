package com.semarescue.android.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.semarescue.android.data.entities.MedicalProfile
import com.semarescue.android.data.repository.MedicalRepository
import com.semarescue.android.utils.LanguageManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MedicalViewModel @Inject constructor(
    private val repository: MedicalRepository,
    private val languageManager: LanguageManager
) : ViewModel() {

    private val _medicalProfile = MutableStateFlow<MedicalProfile?>(null)
    val medicalProfile: StateFlow<MedicalProfile?> = _medicalProfile.asStateFlow()

    val currentLanguage = languageManager.currentLanguage

    init {
        viewModelScope.launch {
            repository.getMedicalProfile().collect {
                _medicalProfile.value = it
            }
        }
    }

    fun saveProfile(
        name: String,
        bloodType: String,
        allergies: String,
        medications: String,
        emergencyNotes: String,
        isOrganDonor: Boolean
    ) {
        viewModelScope.launch {
            val current = _medicalProfile.value
            val newProfile = MedicalProfile(
                id = current?.id ?: 0,
                name = name,
                bloodType = bloodType,
                allergies = allergies,
                medications = medications,
                emergencyNotes = emergencyNotes,
                isOrganDonor = isOrganDonor
            )
            repository.saveMedicalProfile(newProfile)
        }
    }
}
