package com.semarescue.android.ui.viewmodels;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\t2\u0006\u0010\u0014\u001a\u00020\u0007J\u001a\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\n0\t2\u0006\u0010\u0017\u001a\u00020\u0007J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fJ\u0006\u0010\u001b\u001a\u00020\u0019J\u000e\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u0007R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\r\u00a8\u0006\u001e"}, d2 = {"Lcom/semarescue/android/ui/viewmodels/InstructionViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/semarescue/android/data/repository/InstructionRepository;", "(Lcom/semarescue/android/data/repository/InstructionRepository;)V", "_searchQuery", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "allInstructions", "Lkotlinx/coroutines/flow/StateFlow;", "", "Lcom/semarescue/android/data/entities/Instruction;", "getAllInstructions", "()Lkotlinx/coroutines/flow/StateFlow;", "currentLanguage", "Lcom/semarescue/android/utils/LanguageManager$Language;", "getCurrentLanguage", "searchQuery", "getSearchQuery", "getInstructionById", "id", "getStepsForInstruction", "Lcom/semarescue/android/data/entities/Step;", "instructionId", "setLanguage", "", "language", "toggleLanguage", "updateSearchQuery", "query", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class InstructionViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.semarescue.android.data.repository.InstructionRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _searchQuery = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> searchQuery = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.semarescue.android.utils.LanguageManager.Language> currentLanguage = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.semarescue.android.data.entities.Instruction>> allInstructions = null;
    
    @javax.inject.Inject()
    public InstructionViewModel(@org.jetbrains.annotations.NotNull()
    com.semarescue.android.data.repository.InstructionRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getSearchQuery() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.semarescue.android.utils.LanguageManager.Language> getCurrentLanguage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.semarescue.android.data.entities.Instruction>> getAllInstructions() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.semarescue.android.data.entities.Instruction> getInstructionById(@org.jetbrains.annotations.NotNull()
    java.lang.String id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.semarescue.android.data.entities.Step>> getStepsForInstruction(@org.jetbrains.annotations.NotNull()
    java.lang.String instructionId) {
        return null;
    }
    
    public final void updateSearchQuery(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
    }
    
    public final void toggleLanguage() {
    }
    
    public final void setLanguage(@org.jetbrains.annotations.NotNull()
    com.semarescue.android.utils.LanguageManager.Language language) {
    }
}