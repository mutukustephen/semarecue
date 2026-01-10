package com.semarescue.android.data.repository

import com.semarescue.android.data.dao.MedicalProfileDao
import com.semarescue.android.data.entities.MedicalProfile
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MedicalRepository @Inject constructor(
    private val medicalProfileDao: MedicalProfileDao
) {
    fun getMedicalProfile(): Flow<MedicalProfile?> = medicalProfileDao.getMedicalProfile()

    suspend fun saveMedicalProfile(profile: MedicalProfile) {
        medicalProfileDao.insertMedicalProfile(profile)
    }
    
    suspend fun updateMedicalProfile(profile: MedicalProfile) {
        medicalProfileDao.updateMedicalProfile(profile)
    }
}
