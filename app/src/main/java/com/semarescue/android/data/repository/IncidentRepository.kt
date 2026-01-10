package com.semarescue.android.data.repository

import com.semarescue.android.data.dao.IncidentLogDao
import com.semarescue.android.data.entities.IncidentLog
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class IncidentRepository @Inject constructor(
    private val incidentLogDao: IncidentLogDao
) {
    val allLogs: Flow<List<IncidentLog>> = incidentLogDao.getAllLogs()

    suspend fun addLog(description: String, category: String) {
        val log = IncidentLog(
            timestamp = System.currentTimeMillis(),
            description = description,
            category = category
        )
        incidentLogDao.insertLog(log)
    }
    
    suspend fun clearLogs() {
        incidentLogDao.clearLogs()
    }
}
