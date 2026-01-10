package com.semarescue.android.ui.viewmodels;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0015\u001a\u00020\u0011R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/semarescue/android/ui/viewmodels/IncidentViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/semarescue/android/data/repository/IncidentRepository;", "languageManager", "Lcom/semarescue/android/utils/LanguageManager;", "(Lcom/semarescue/android/data/repository/IncidentRepository;Lcom/semarescue/android/utils/LanguageManager;)V", "currentLanguage", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/semarescue/android/utils/LanguageManager$Language;", "getCurrentLanguage", "()Lkotlinx/coroutines/flow/StateFlow;", "logs", "", "Lcom/semarescue/android/data/entities/IncidentLog;", "getLogs", "addLog", "", "description", "", "category", "clearLogs", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class IncidentViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.semarescue.android.data.repository.IncidentRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.semarescue.android.utils.LanguageManager languageManager = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.semarescue.android.utils.LanguageManager.Language> currentLanguage = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.semarescue.android.data.entities.IncidentLog>> logs = null;
    
    @javax.inject.Inject()
    public IncidentViewModel(@org.jetbrains.annotations.NotNull()
    com.semarescue.android.data.repository.IncidentRepository repository, @org.jetbrains.annotations.NotNull()
    com.semarescue.android.utils.LanguageManager languageManager) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.semarescue.android.utils.LanguageManager.Language> getCurrentLanguage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.semarescue.android.data.entities.IncidentLog>> getLogs() {
        return null;
    }
    
    public final void addLog(@org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.NotNull()
    java.lang.String category) {
    }
    
    public final void clearLogs() {
    }
}