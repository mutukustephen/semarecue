package com.semarescue.android.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.semarescue.android.data.entities.Instruction
import com.semarescue.android.data.entities.Step
import kotlinx.coroutines.flow.Flow

@Dao
interface InstructionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInstructions(instructions: List<Instruction>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSteps(steps: List<Step>)

    @Transaction
    @Query("SELECT * FROM instructions")
    fun getAllInstructions(): Flow<List<Instruction>>

    @Transaction
    @Query("SELECT * FROM instructions WHERE id = :id")
    fun getInstruction(id: String): Flow<Instruction?>

    @Query("SELECT * FROM steps WHERE instruction_id = :instructionId ORDER BY step_number ASC")
    fun getStepsForInstruction(instructionId: String): Flow<List<Step>>
    
    @Query("SELECT COUNT(*) FROM instructions")
    suspend fun getInstructionCount(): Int
}
