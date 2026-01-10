package com.semarescue.android.data.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "steps",
    foreignKeys = [
        ForeignKey(
            entity = Instruction::class,
            parentColumns = ["id"],
            childColumns = ["instruction_id"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index(value = ["instruction_id"])]
)
data class Step(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val instruction_id: String,
    val step_number: Int,
    val text_en: String,
    val text_sw: String,
    val audio_asset_en: String?,
    val audio_asset_sw: String?,
    val graphic_asset: String?,
    val timer_seconds: Int? = null
)
