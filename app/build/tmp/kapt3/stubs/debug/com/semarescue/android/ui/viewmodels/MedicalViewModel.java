package com.semarescue.android.ui.viewmodels;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J6\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001aR\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/semarescue/android/ui/viewmodels/MedicalViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/semarescue/android/data/repository/MedicalRepository;", "languageManager", "Lcom/semarescue/android/utils/LanguageManager;", "(Lcom/semarescue/android/data/repository/MedicalRepository;Lcom/semarescue/android/utils/LanguageManager;)V", "_medicalProfile", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/semarescue/android/data/entities/MedicalProfile;", "currentLanguage", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/semarescue/android/utils/LanguageManager$Language;", "getCurrentLanguage", "()Lkotlinx/coroutines/flow/StateFlow;", "medicalProfile", "getMedicalProfile", "saveProfile", "", "name", "", "bloodType", "allergies", "medications", "emergencyNotes", "isOrganDonor", "", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class MedicalViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.semarescue.android.data.repository.MedicalRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.semarescue.android.utils.LanguageManager languageManager = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.semarescue.android.data.entities.MedicalProfile> _medicalProfile = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.semarescue.android.data.entities.MedicalProfile> medicalProfile = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.semarescue.android.utils.LanguageManager.Language> currentLanguage = null;
    
    @javax.inject.Inject()
    public MedicalViewModel(@org.jetbrains.annotations.NotNull()
    com.semarescue.android.data.repository.MedicalRepository repository, @org.jetbrains.annotations.NotNull()
    com.semarescue.android.utils.LanguageManager languageManager) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.semarescue.android.data.entities.MedicalProfile> getMedicalProfile() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.semarescue.android.utils.LanguageManager.Language> getCurrentLanguage() {
        return null;
    }
    
    public final void saveProfile(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String bloodType, @org.jetbrains.annotations.NotNull()
    java.lang.String allergies, @org.jetbrains.annotations.NotNull()
    java.lang.String medications, @org.jetbrains.annotations.NotNull()
    java.lang.String emergencyNotes, boolean isOrganDonor) {
    }
}