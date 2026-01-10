package com.semarescue.android.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "medical_profile")
data class MedicalProfile(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val bloodType: String,
    val allergies: String,
    val medications: String,
    val emergencyNotes: String,
    val isOrganDonor: Boolean
)
