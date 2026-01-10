package com.semarescue.android.workers

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.semarescue.android.data.AppDatabase
import com.semarescue.android.data.entities.Instruction
import com.semarescue.android.data.entities.Step
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SeedDatabaseWorker(
    context: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {

    override suspend fun doWork(): Result = withContext(Dispatchers.IO) {
        try {
            android.util.Log.d("SeedDatabaseWorker", "Starting database seeding...")
            val filename = "initial_content.json"
            applicationContext.assets.open(filename).use { inputStream ->
                val jsonString = inputStream.bufferedReader().use { it.readText() }
                android.util.Log.d("SeedDatabaseWorker", "JSON read successfully. Length: ${jsonString.length}")
                
                val instructionType = object : TypeToken<List<InstructionData>>() {}.type
                val instructionList: List<InstructionData> = Gson().fromJson(jsonString, instructionType)
                android.util.Log.d("SeedDatabaseWorker", "Parsed ${instructionList.size} instructions")

                val database = AppDatabase.getInstance(applicationContext)
                val instructions = instructionList.map { 
                    Instruction(it.id, it.title_en, it.title_sw, it.icon_asset, it.category, it.keywords, it.description_en, it.description_sw) 
                }
                val steps = instructionList.flatMap { instruction ->
                    instruction.steps.mapIndexed { index, step ->
                        Step(
                            instruction_id = instruction.id,
                            step_number = index + 1,
                            text_en = step.text_en,
                            text_sw = step.text_sw,
                            audio_asset_en = step.audio_asset_en,
                            audio_asset_sw = step.audio_asset_sw,
                            graphic_asset = step.graphic_asset,
                            timer_seconds = step.timer_seconds
                        )
                    }
                }

                database.instructionDao().insertInstructions(instructions)
                database.instructionDao().insertSteps(steps)
                android.util.Log.d("SeedDatabaseWorker", "Database seeding completed successfully")

                Result.success()
            }
        } catch (ex: Exception) {
            android.util.Log.e("SeedDatabaseWorker", "Error seeding database", ex)
            ex.printStackTrace()
            Result.failure()
        }
    }

    data class InstructionData(
        val id: String,
        val title_en: String,
        val title_sw: String,
        val icon_asset: String,
        val category: String,
        val keywords: String,
        val description_en: String?,
        val description_sw: String?,
        val steps: List<StepData>
    )

    data class StepData(
        val text_en: String,
        val text_sw: String,
        val audio_asset_en: String?,
        val audio_asset_sw: String?,
        val graphic_asset: String?,
        val timer_seconds: Int?
    )
}
