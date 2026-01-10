package com.semarescue.android.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.semarescue.android.data.repository.UserPreferencesRepository
import com.semarescue.android.utils.LanguageManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

import com.semarescue.android.data.entities.EmergencyContact
import com.semarescue.android.data.repository.EmergencyContactRepository

@HiltViewModel
class PanicModeViewModel @Inject constructor(
    private val emergencyContactRepository: EmergencyContactRepository
) : ViewModel() {
    
    val currentLanguage = LanguageManager.currentLanguage
    
    val emergencyContacts: StateFlow<List<EmergencyContact>> = emergencyContactRepository.allContacts
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )
    
    fun saveEmergencyContact(name: String, phone: String) {
        viewModelScope.launch {
            emergencyContactRepository.insertContact(EmergencyContact(name = name, phone = phone))
        }
    }
    
    fun deleteEmergencyContact(contact: EmergencyContact) {
        viewModelScope.launch {
            emergencyContactRepository.deleteContact(contact)
        }
    }

    fun sendSos(context: android.content.Context) {
        viewModelScope.launch {
            val contacts = emergencyContacts.value
            
            if (contacts.isNotEmpty()) {
                val location = com.semarescue.android.utils.LocationUtils.getCurrentLocation(context)
                val message = if (location != null) {
                    val mapLink = com.semarescue.android.utils.LocationUtils.getGoogleMapsLink(location)
                    "SOS! I need help. My location: $mapLink"
                } else {
                    "SOS! I need help. I cannot fetch my location right now."
                }
                
                var sentCount = 0
                contacts.forEach { contact ->
                    com.semarescue.android.utils.SmsUtils.sendSms(contact.phone, message)
                    sentCount++
                }
                
                android.widget.Toast.makeText(context, "SOS sent to $sentCount contacts", android.widget.Toast.LENGTH_SHORT).show()
            } else {
                android.widget.Toast.makeText(context, "No emergency contacts saved", android.widget.Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun toggleStrobe(context: android.content.Context) {
        com.semarescue.android.utils.FlashlightUtils.toggleStrobe(context, viewModelScope)
    }

    override fun onCleared() {
        super.onCleared()
        // Cleanup handled by utils
    }
}
