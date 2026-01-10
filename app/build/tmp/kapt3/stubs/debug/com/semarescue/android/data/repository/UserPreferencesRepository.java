package com.semarescue.android.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\f\u001a\u00020\rH\u0086@\u00a2\u0006\u0002\u0010\u000eJ\u001e\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007H\u0086@\u00a2\u0006\u0002\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t\u00a8\u0006\u0014"}, d2 = {"Lcom/semarescue/android/data/repository/UserPreferencesRepository;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "emergencyContactName", "Lkotlinx/coroutines/flow/Flow;", "", "getEmergencyContactName", "()Lkotlinx/coroutines/flow/Flow;", "emergencyContactPhone", "getEmergencyContactPhone", "clearEmergencyContact", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveEmergencyContact", "name", "phone", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "PreferencesKeys", "app_debug"})
public final class UserPreferencesRepository {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.lang.String> emergencyContactName = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.lang.String> emergencyContactPhone = null;
    
    public UserPreferencesRepository(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.String> getEmergencyContactName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.String> getEmergencyContactPhone() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveEmergencyContact(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String phone, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object clearEmergencyContact(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c2\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/semarescue/android/data/repository/UserPreferencesRepository$PreferencesKeys;", "", "()V", "EMERGENCY_CONTACT_NAME", "Landroidx/datastore/preferences/core/Preferences$Key;", "", "getEMERGENCY_CONTACT_NAME", "()Landroidx/datastore/preferences/core/Preferences$Key;", "EMERGENCY_CONTACT_PHONE", "getEMERGENCY_CONTACT_PHONE", "app_debug"})
    static final class PreferencesKeys {
        @org.jetbrains.annotations.NotNull()
        private static final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> EMERGENCY_CONTACT_NAME = null;
        @org.jetbrains.annotations.NotNull()
        private static final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> EMERGENCY_CONTACT_PHONE = null;
        @org.jetbrains.annotations.NotNull()
        public static final com.semarescue.android.data.repository.UserPreferencesRepository.PreferencesKeys INSTANCE = null;
        
        private PreferencesKeys() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> getEMERGENCY_CONTACT_NAME() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> getEMERGENCY_CONTACT_PHONE() {
            return null;
        }
    }
}