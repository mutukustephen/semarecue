package com.semarescue.android.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.semarescue.android.data.entities.IncidentLog
import kotlinx.coroutines.flow.Flow

@Dao
interface IncidentLogDao {
    @Query("SELECT * FROM incident_log ORDER BY timestamp DESC")
    fun getAllLogs(): Flow<List<IncidentLog>>

    @Insert
    suspend fun insertLog(log: IncidentLog)
    
    @Query("DELETE FROM incident_log")
    suspend fun clearLogs()
}
