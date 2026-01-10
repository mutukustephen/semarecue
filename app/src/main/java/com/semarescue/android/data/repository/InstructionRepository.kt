package com.semarescue.android.data.repository

import com.semarescue.android.data.dao.InstructionDao
import com.semarescue.android.data.entities.Instruction
import com.semarescue.android.data.entities.Step
import kotlinx.coroutines.flow.Flow

class InstructionRepository(private val instructionDao: InstructionDao) {

    fun getAllInstructions(): Flow<List<Instruction>> {
        return instructionDao.getAllInstructions()
    }

    fun getInstructionById(id: String): Flow<Instruction?> {
        return instructionDao.getInstruction(id)
    }

    fun getStepsForInstruction(instructionId: String): Flow<List<Step>> {
        return instructionDao.getStepsForInstruction(instructionId)
    }
}
