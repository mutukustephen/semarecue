package com.semarescue.android.ui.viewmodels;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\fJ\b\u0010\u0011\u001a\u00020\u000fH\u0014J\u0016\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0018R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\t\u00a8\u0006\u001a"}, d2 = {"Lcom/semarescue/android/ui/viewmodels/PanicModeViewModel;", "Landroidx/lifecycle/ViewModel;", "emergencyContactRepository", "Lcom/semarescue/android/data/repository/EmergencyContactRepository;", "(Lcom/semarescue/android/data/repository/EmergencyContactRepository;)V", "currentLanguage", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/semarescue/android/utils/LanguageManager$Language;", "getCurrentLanguage", "()Lkotlinx/coroutines/flow/StateFlow;", "emergencyContacts", "", "Lcom/semarescue/android/data/entities/EmergencyContact;", "getEmergencyContacts", "deleteEmergencyContact", "", "contact", "onCleared", "saveEmergencyContact", "name", "", "phone", "sendSos", "context", "Landroid/content/Context;", "toggleStrobe", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class PanicModeViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.semarescue.android.data.repository.EmergencyContactRepository emergencyContactRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.semarescue.android.utils.LanguageManager.Language> currentLanguage = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.semarescue.android.data.entities.EmergencyContact>> emergencyContacts = null;
    
    @javax.inject.Inject()
    public PanicModeViewModel(@org.jetbrains.annotations.NotNull()
    com.semarescue.android.data.repository.EmergencyContactRepository emergencyContactRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.semarescue.android.utils.LanguageManager.Language> getCurrentLanguage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.semarescue.android.data.entities.EmergencyContact>> getEmergencyContacts() {
        return null;
    }
    
    public final void saveEmergencyContact(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String phone) {
    }
    
    public final void deleteEmergencyContact(@org.jetbrains.annotations.NotNull()
    com.semarescue.android.data.entities.EmergencyContact contact) {
    }
    
    public final void sendSos(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    public final void toggleStrobe(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
}