package com.semarescue.android.data.repository

import com.semarescue.android.data.dao.EmergencyContactDao
import com.semarescue.android.data.entities.EmergencyContact
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EmergencyContactRepository @Inject constructor(
    private val emergencyContactDao: EmergencyContactDao
) {
    val allContacts: Flow<List<EmergencyContact>> = emergencyContactDao.getAllContacts()

    suspend fun insertContact(contact: EmergencyContact) {
        emergencyContactDao.insertContact(contact)
    }

    suspend fun deleteContact(contact: EmergencyContact) {
        emergencyContactDao.deleteContact(contact)
    }
    
    suspend fun deleteAll() {
        emergencyContactDao.deleteAll()
    }
}
