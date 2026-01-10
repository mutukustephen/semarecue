package com.semarescue.android.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "instructions")
data class Instruction(
    @PrimaryKey val id: String,
    val title_en: String,
    val title_sw: String,
    val icon_asset: String,
    val category: String,
    val keywords: String,
    val description_en: String? = null,
    val description_sw: String? = null
)
