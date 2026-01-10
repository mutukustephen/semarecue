package com.semarescue.android.di;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0004H\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bH\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004H\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0010H\u0007J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u0004H\u0007J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0016H\u0007\u00a8\u0006\u001a"}, d2 = {"Lcom/semarescue/android/di/DatabaseModule;", "", "()V", "provideAppDatabase", "Lcom/semarescue/android/data/AppDatabase;", "context", "Landroid/content/Context;", "provideEmergencyContactDao", "Lcom/semarescue/android/data/dao/EmergencyContactDao;", "appDatabase", "provideIncidentLogDao", "Lcom/semarescue/android/data/dao/IncidentLogDao;", "provideIncidentRepository", "Lcom/semarescue/android/data/repository/IncidentRepository;", "incidentLogDao", "provideInstructionDao", "Lcom/semarescue/android/data/dao/InstructionDao;", "database", "provideInstructionRepository", "Lcom/semarescue/android/data/repository/InstructionRepository;", "instructionDao", "provideMedicalProfileDao", "Lcom/semarescue/android/data/dao/MedicalProfileDao;", "provideMedicalRepository", "Lcom/semarescue/android/data/repository/MedicalRepository;", "medicalProfileDao", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class DatabaseModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.semarescue.android.di.DatabaseModule INSTANCE = null;
    
    private DatabaseModule() {
        super();
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.semarescue.android.data.AppDatabase provideAppDatabase(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.semarescue.android.data.dao.InstructionDao provideInstructionDao(@org.jetbrains.annotations.NotNull()
    com.semarescue.android.data.AppDatabase database) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.semarescue.android.data.dao.EmergencyContactDao provideEmergencyContactDao(@org.jetbrains.annotations.NotNull()
    com.semarescue.android.data.AppDatabase appDatabase) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.semarescue.android.data.dao.MedicalProfileDao provideMedicalProfileDao(@org.jetbrains.annotations.NotNull()
    com.semarescue.android.data.AppDatabase appDatabase) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.semarescue.android.data.dao.IncidentLogDao provideIncidentLogDao(@org.jetbrains.annotations.NotNull()
    com.semarescue.android.data.AppDatabase appDatabase) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.semarescue.android.data.repository.InstructionRepository provideInstructionRepository(@org.jetbrains.annotations.NotNull()
    com.semarescue.android.data.dao.InstructionDao instructionDao) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.semarescue.android.data.repository.MedicalRepository provideMedicalRepository(@org.jetbrains.annotations.NotNull()
    com.semarescue.android.data.dao.MedicalProfileDao medicalProfileDao) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.semarescue.android.data.repository.IncidentRepository provideIncidentRepository(@org.jetbrains.annotations.NotNull()
    com.semarescue.android.data.dao.IncidentLogDao incidentLogDao) {
        return null;
    }
}