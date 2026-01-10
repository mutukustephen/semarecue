package com.semarescue.android.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.semarescue.android.data.dao.InstructionDao
import com.semarescue.android.data.dao.EmergencyContactDao
import com.semarescue.android.data.entities.EmergencyContact
import com.semarescue.android.data.entities.Instruction
import com.semarescue.android.data.entities.Step
import com.semarescue.android.workers.SeedDatabaseWorker

@Database(entities = [Instruction::class, Step::class, EmergencyContact::class, com.semarescue.android.data.entities.MedicalProfile::class, com.semarescue.android.data.entities.IncidentLog::class], version = 5, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun instructionDao(): InstructionDao
    abstract fun emergencyContactDao(): EmergencyContactDao
    abstract fun medicalProfileDao(): com.semarescue.android.data.dao.MedicalProfileDao
    abstract fun incidentLogDao(): com.semarescue.android.data.dao.IncidentLogDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, "semarescue-db")
                .addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        android.util.Log.d("AppDatabase", "onCreate called - scheduling SeedDatabaseWorker")
                        val request = OneTimeWorkRequestBuilder<SeedDatabaseWorker>().build()
                        WorkManager.getInstance(context).enqueue(request)
                    }
                    override fun onOpen(db: SupportSQLiteDatabase) {
                        super.onOpen(db)
                        android.util.Log.d("AppDatabase", "onOpen called")
                    }
                })
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}
