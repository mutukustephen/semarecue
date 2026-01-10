package com.semarescue.android.data.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\bJ\u0014\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000b0\nH\'J\u0016\u0010\f\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\b\u00a8\u0006\r"}, d2 = {"Lcom/semarescue/android/data/dao/EmergencyContactDao;", "", "deleteAll", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteContact", "contact", "Lcom/semarescue/android/data/entities/EmergencyContact;", "(Lcom/semarescue/android/data/entities/EmergencyContact;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllContacts", "Lkotlinx/coroutines/flow/Flow;", "", "insertContact", "app_debug"})
@androidx.room.Dao()
public abstract interface EmergencyContactDao {
    
    @androidx.room.Query(value = "SELECT * FROM emergency_contacts ORDER BY name ASC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.semarescue.android.data.entities.EmergencyContact>> getAllContacts();
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertContact(@org.jetbrains.annotations.NotNull()
    com.semarescue.android.data.entities.EmergencyContact contact, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteContact(@org.jetbrains.annotations.NotNull()
    com.semarescue.android.data.entities.EmergencyContact contact, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM emergency_contacts")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteAll(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}