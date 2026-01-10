package com.semarescue.android.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "incident_log")
data class IncidentLog(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val timestamp: Long,
    val description: String,
    val category: String // e.g., "Action", "Observation", "Vitals"
)
