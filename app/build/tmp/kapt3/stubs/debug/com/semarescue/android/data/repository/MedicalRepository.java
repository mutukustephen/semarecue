package com.semarescue.android.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0086@\u00a2\u0006\u0002\u0010\u000bJ\u0016\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0086@\u00a2\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/semarescue/android/data/repository/MedicalRepository;", "", "medicalProfileDao", "Lcom/semarescue/android/data/dao/MedicalProfileDao;", "(Lcom/semarescue/android/data/dao/MedicalProfileDao;)V", "getMedicalProfile", "Lkotlinx/coroutines/flow/Flow;", "Lcom/semarescue/android/data/entities/MedicalProfile;", "saveMedicalProfile", "", "profile", "(Lcom/semarescue/android/data/entities/MedicalProfile;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateMedicalProfile", "app_debug"})
public final class MedicalRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.semarescue.android.data.dao.MedicalProfileDao medicalProfileDao = null;
    
    @javax.inject.Inject()
    public MedicalRepository(@org.jetbrains.annotations.NotNull()
    com.semarescue.android.data.dao.MedicalProfileDao medicalProfileDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.semarescue.android.data.entities.MedicalProfile> getMedicalProfile() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveMedicalProfile(@org.jetbrains.annotations.NotNull()
    com.semarescue.android.data.entities.MedicalProfile profile, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateMedicalProfile(@org.jetbrains.annotations.NotNull()
    com.semarescue.android.data.entities.MedicalProfile profile, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}