package com.semarescue.android.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&\u00a8\u0006\f"}, d2 = {"Lcom/semarescue/android/data/AppDatabase;", "Landroidx/room/RoomDatabase;", "()V", "emergencyContactDao", "Lcom/semarescue/android/data/dao/EmergencyContactDao;", "incidentLogDao", "Lcom/semarescue/android/data/dao/IncidentLogDao;", "instructionDao", "Lcom/semarescue/android/data/dao/InstructionDao;", "medicalProfileDao", "Lcom/semarescue/android/data/dao/MedicalProfileDao;", "Companion", "app_debug"})
@androidx.room.Database(entities = {com.semarescue.android.data.entities.Instruction.class, com.semarescue.android.data.entities.Step.class, com.semarescue.android.data.entities.EmergencyContact.class, com.semarescue.android.data.entities.MedicalProfile.class, com.semarescue.android.data.entities.IncidentLog.class}, version = 5, exportSchema = false)
public abstract class AppDatabase extends androidx.room.RoomDatabase {
    @kotlin.jvm.Volatile()
    @org.jetbrains.annotations.Nullable()
    private static volatile com.semarescue.android.data.AppDatabase instance;
    @org.jetbrains.annotations.NotNull()
    public static final com.semarescue.android.data.AppDatabase.Companion Companion = null;
    
    public AppDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.semarescue.android.data.dao.InstructionDao instructionDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.semarescue.android.data.dao.EmergencyContactDao emergencyContactDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.semarescue.android.data.dao.MedicalProfileDao medicalProfileDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.semarescue.android.data.dao.IncidentLogDao incidentLogDao();
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/semarescue/android/data/AppDatabase$Companion;", "", "()V", "instance", "Lcom/semarescue/android/data/AppDatabase;", "buildDatabase", "context", "Landroid/content/Context;", "getInstance", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.semarescue.android.data.AppDatabase getInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        private final com.semarescue.android.data.AppDatabase buildDatabase(android.content.Context context) {
            return null;
        }
    }
}