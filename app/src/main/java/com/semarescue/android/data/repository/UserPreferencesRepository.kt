package com.semarescue.android.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user_preferences")

class UserPreferencesRepository(private val context: Context) {
    
    private object PreferencesKeys {
        val EMERGENCY_CONTACT_NAME = stringPreferencesKey("emergency_contact_name")
        val EMERGENCY_CONTACT_PHONE = stringPreferencesKey("emergency_contact_phone")
    }
    
    val emergencyContactName: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[PreferencesKeys.EMERGENCY_CONTACT_NAME]
        }
    
    val emergencyContactPhone: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[PreferencesKeys.EMERGENCY_CONTACT_PHONE]
        }
    
    suspend fun saveEmergencyContact(name: String, phone: String) {
        context.dataStore.edit { preferences ->
            preferences[PreferencesKeys.EMERGENCY_CONTACT_NAME] = name
            preferences[PreferencesKeys.EMERGENCY_CONTACT_PHONE] = phone
        }
    }
    
    suspend fun clearEmergencyContact() {
        context.dataStore.edit { preferences ->
            preferences.remove(PreferencesKeys.EMERGENCY_CONTACT_NAME)
            preferences.remove(PreferencesKeys.EMERGENCY_CONTACT_PHONE)
        }
    }
}
