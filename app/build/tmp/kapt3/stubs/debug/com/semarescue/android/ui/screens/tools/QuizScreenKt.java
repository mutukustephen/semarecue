package com.semarescue.android.ui.screens.tools;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\u001a$\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001a \u0010\u0007\u001a\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007\u001a&\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0007\u001a\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010\u00a8\u0006\u0011"}, d2 = {"CategorySelectionList", "", "currentLanguage", "Lcom/semarescue/android/utils/LanguageManager$Language;", "onCategorySelected", "Lkotlin/Function1;", "Lcom/semarescue/android/ui/screens/tools/QuizCategory;", "QuizScreen", "onNavigateBack", "Lkotlin/Function0;", "viewModel", "Lcom/semarescue/android/ui/viewmodels/InstructionViewModel;", "QuizSession", "category", "onQuizCompleted", "getQuizCategories", "", "app_debug"})
public final class QuizScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void QuizScreen(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateBack, @org.jetbrains.annotations.NotNull()
    com.semarescue.android.ui.viewmodels.InstructionViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void CategorySelectionList(@org.jetbrains.annotations.NotNull()
    com.semarescue.android.utils.LanguageManager.Language currentLanguage, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.semarescue.android.ui.screens.tools.QuizCategory, kotlin.Unit> onCategorySelected) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void QuizSession(@org.jetbrains.annotations.NotNull()
    com.semarescue.android.ui.screens.tools.QuizCategory category, @org.jetbrains.annotations.NotNull()
    com.semarescue.android.utils.LanguageManager.Language currentLanguage, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onQuizCompleted) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.util.List<com.semarescue.android.ui.screens.tools.QuizCategory> getQuizCategories() {
        return null;
    }
}