package com.semarescue.android.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.semarescue.android.data.entities.MedicalProfile
import kotlinx.coroutines.flow.Flow

@Dao
interface MedicalProfileDao {
    @Query("SELECT * FROM medical_profile LIMIT 1")
    fun getMedicalProfile(): Flow<MedicalProfile?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMedicalProfile(profile: MedicalProfile)

    @Update
    suspend fun updateMedicalProfile(profile: MedicalProfile)
    
    @Query("DELETE FROM medical_profile")
    suspend fun clearMedicalProfile()
}
