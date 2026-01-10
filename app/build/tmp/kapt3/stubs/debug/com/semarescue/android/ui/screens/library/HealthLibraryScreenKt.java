package com.semarescue.android.ui.screens.library;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u001a&\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0007\u001a\u0018\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u001a \u0010\f\u001a\u00020\u00012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007\u001a\u001e\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0014H\u0007\u001a\u0018\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0012H\u0007\u00a8\u0006\u0017"}, d2 = {"CategoryHeader", "", "category", "Lcom/semarescue/android/data/entities/HealthCategory;", "currentLanguage", "Lcom/semarescue/android/utils/LanguageManager$Language;", "HealthArticleCard", "article", "Lcom/semarescue/android/data/entities/HealthArticle;", "onClick", "Lkotlin/Function0;", "HealthArticleDetail", "HealthLibraryScreen", "onNavigateBack", "viewModel", "Lcom/semarescue/android/ui/viewmodels/InstructionViewModel;", "ListSection", "title", "", "items", "", "Section", "content", "app_debug"})
public final class HealthLibraryScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class, androidx.compose.foundation.ExperimentalFoundationApi.class})
    @androidx.compose.runtime.Composable()
    public static final void HealthLibraryScreen(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateBack, @org.jetbrains.annotations.NotNull()
    com.semarescue.android.ui.viewmodels.InstructionViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void HealthArticleCard(@org.jetbrains.annotations.NotNull()
    com.semarescue.android.data.entities.HealthArticle article, @org.jetbrains.annotations.NotNull()
    com.semarescue.android.utils.LanguageManager.Language currentLanguage, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void HealthArticleDetail(@org.jetbrains.annotations.NotNull()
    com.semarescue.android.data.entities.HealthArticle article, @org.jetbrains.annotations.NotNull()
    com.semarescue.android.utils.LanguageManager.Language currentLanguage) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void Section(@org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String content) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ListSection(@org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> items) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void CategoryHeader(@org.jetbrains.annotations.NotNull()
    com.semarescue.android.data.entities.HealthCategory category, @org.jetbrains.annotations.NotNull()
    com.semarescue.android.utils.LanguageManager.Language currentLanguage) {
    }
}