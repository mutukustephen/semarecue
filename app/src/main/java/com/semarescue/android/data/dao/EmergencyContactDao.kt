package com.semarescue.android.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.semarescue.android.data.entities.EmergencyContact
import kotlinx.coroutines.flow.Flow

@Dao
interface EmergencyContactDao {
    @Query("SELECT * FROM emergency_contacts ORDER BY name ASC")
    fun getAllContacts(): Flow<List<EmergencyContact>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertContact(contact: EmergencyContact)

    @Delete
    suspend fun deleteContact(contact: EmergencyContact)
    
    @Query("DELETE FROM emergency_contacts")
    suspend fun deleteAll()
}
