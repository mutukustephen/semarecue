package com.semarescue.android.ui.screens.guide;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007\u001a0\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0007\u00a8\u0006\u0012"}, d2 = {"GuideDetailScreen", "", "instructionId", "", "onNavigateBack", "Lkotlin/Function0;", "viewModel", "Lcom/semarescue/android/ui/viewmodels/InstructionViewModel;", "StepCard", "step", "Lcom/semarescue/android/data/entities/Step;", "stepNumber", "", "currentLanguage", "Lcom/semarescue/android/utils/LanguageManager$Language;", "isActive", "", "isCompleted", "app_debug"})
public final class GuideDetailScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void GuideDetailScreen(@org.jetbrains.annotations.NotNull()
    java.lang.String instructionId, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateBack, @org.jetbrains.annotations.NotNull()
    com.semarescue.android.ui.viewmodels.InstructionViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void StepCard(@org.jetbrains.annotations.NotNull()
    com.semarescue.android.data.entities.Step step, int stepNumber, @org.jetbrains.annotations.NotNull()
    com.semarescue.android.utils.LanguageManager.Language currentLanguage, boolean isActive, boolean isCompleted) {
    }
}