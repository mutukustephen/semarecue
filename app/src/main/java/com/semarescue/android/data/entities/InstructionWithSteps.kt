package com.semarescue.android.data.entities

import androidx.room.Embedded
import androidx.room.Relation

data class InstructionWithSteps(
    @Embedded val instruction: Instruction,
    @Relation(
        parentColumn = "id",
        entityColumn = "instruction_id"
    )
    val steps: List<Step>
)
