package com.semarescue.android.di

import android.content.Context
import androidx.room.Room
import com.semarescue.android.data.AppDatabase
import com.semarescue.android.data.dao.InstructionDao
import com.semarescue.android.data.repository.InstructionRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    
    @Provides
    @Singleton
    fun provideAppDatabase(
        @ApplicationContext context: Context
    ): AppDatabase {
        return AppDatabase.getInstance(context)
    }
    
    @Provides
    @Singleton
    fun provideInstructionDao(database: AppDatabase): InstructionDao {
        return database.instructionDao()
    }

    @Provides
    @Singleton
    fun provideEmergencyContactDao(appDatabase: AppDatabase): com.semarescue.android.data.dao.EmergencyContactDao {
        return appDatabase.emergencyContactDao()
    }

    @Provides
    @Singleton
    fun provideMedicalProfileDao(appDatabase: AppDatabase): com.semarescue.android.data.dao.MedicalProfileDao {
        return appDatabase.medicalProfileDao()
    }

    @Provides
    @Singleton
    fun provideIncidentLogDao(appDatabase: AppDatabase): com.semarescue.android.data.dao.IncidentLogDao {
        return appDatabase.incidentLogDao()
    }
    
    @Provides
    @Singleton
    fun provideInstructionRepository(instructionDao: InstructionDao): InstructionRepository {
        return InstructionRepository(instructionDao)
    }

    @Provides
    @Singleton
    fun provideMedicalRepository(medicalProfileDao: com.semarescue.android.data.dao.MedicalProfileDao): com.semarescue.android.data.repository.MedicalRepository {
        return com.semarescue.android.data.repository.MedicalRepository(medicalProfileDao)
    }

    @Provides
    @Singleton
    fun provideIncidentRepository(incidentLogDao: com.semarescue.android.data.dao.IncidentLogDao): com.semarescue.android.data.repository.IncidentRepository {
        return com.semarescue.android.data.repository.IncidentRepository(incidentLogDao)
    }
}
