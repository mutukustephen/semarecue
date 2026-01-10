package com.semarescue.android.ui.screens.panic;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a8\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007\u001aB\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013\u001aV\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0007\u001a.\u0010\u001a\u001a\u00020\u00012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u001eH\u0007\u0082\u0002\u0007\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u001f"}, d2 = {"EmergencyContactDialog", "", "currentLanguage", "Lcom/semarescue/android/utils/LanguageManager$Language;", "onDismiss", "Lkotlin/Function0;", "onSave", "Lkotlin/Function2;", "", "GradientButton", "text", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "gradient", "Landroidx/compose/ui/graphics/Brush;", "textColor", "Landroidx/compose/ui/graphics/Color;", "onClick", "GradientButton-42QJj7c", "(Ljava/lang/String;Landroidx/compose/ui/graphics/vector/ImageVector;Landroidx/compose/ui/graphics/Brush;JLkotlin/jvm/functions/Function0;)V", "PanicActionCard", "number", "subtitle", "onLongClick", "isHighlight", "", "PanicModeScreen", "onNavigateBack", "onNavigateToMedicalID", "viewModel", "Lcom/semarescue/android/ui/viewmodels/PanicModeViewModel;", "app_debug"})
public final class PanicModeScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void PanicModeScreen(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateBack, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateToMedicalID, @org.jetbrains.annotations.NotNull()
    com.semarescue.android.ui.viewmodels.PanicModeViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void PanicActionCard(@org.jetbrains.annotations.NotNull()
    java.lang.String number, @org.jetbrains.annotations.NotNull()
    java.lang.String text, @org.jetbrains.annotations.NotNull()
    java.lang.String subtitle, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.graphics.vector.ImageVector icon, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<kotlin.Unit> onLongClick, boolean isHighlight) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void EmergencyContactDialog(@org.jetbrains.annotations.NotNull()
    com.semarescue.android.utils.LanguageManager.Language currentLanguage, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDismiss, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.String, kotlin.Unit> onSave) {
    }
}