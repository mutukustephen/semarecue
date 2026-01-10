package com.semarescue.android.ui.screens.guide;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a4\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007\u001a&\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007\u00a8\u0006\u000f"}, d2 = {"GuideListScreen", "", "onNavigateBack", "Lkotlin/Function0;", "onGuideClick", "Lkotlin/Function1;", "", "viewModel", "Lcom/semarescue/android/ui/viewmodels/InstructionViewModel;", "InstructionCard", "instruction", "Lcom/semarescue/android/data/entities/Instruction;", "currentLanguage", "Lcom/semarescue/android/utils/LanguageManager$Language;", "onClick", "app_debug"})
public final class GuideListScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void GuideListScreen(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateBack, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onGuideClick, @org.jetbrains.annotations.NotNull()
    com.semarescue.android.ui.viewmodels.InstructionViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void InstructionCard(@org.jetbrains.annotations.NotNull()
    com.semarescue.android.data.entities.Instruction instruction, @org.jetbrains.annotations.NotNull()
    com.semarescue.android.utils.LanguageManager.Language currentLanguage, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
}