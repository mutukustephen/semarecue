package com.semarescue.android.ui.screens.medical;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u00b8\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\b\u001a\u00020\u00032\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\n\u001a\u00020\u00032\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\f\u001a\u00020\u00032\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0007\u001a \u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0007\u001a \u0010\u0018\u001a\u00020\u00012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0007\u001a\u001a\u0010\u001d\u001a\u00020\u00012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007\u00a8\u0006 "}, d2 = {"EditMedicalProfile", "", "name", "", "onNameChange", "Lkotlin/Function1;", "bloodType", "onBloodTypeChange", "allergies", "onAllergiesChange", "medications", "onMedicationsChange", "emergencyNotes", "onEmergencyNotesChange", "isOrganDonor", "", "onOrganDonorChange", "currentLanguage", "Lcom/semarescue/android/utils/LanguageManager$Language;", "InfoSection", "title", "content", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "MedicalIDScreen", "onNavigateBack", "Lkotlin/Function0;", "viewModel", "Lcom/semarescue/android/ui/viewmodels/MedicalViewModel;", "ViewMedicalProfile", "profile", "Lcom/semarescue/android/data/entities/MedicalProfile;", "app_debug"})
public final class MedicalIDScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void MedicalIDScreen(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateBack, @org.jetbrains.annotations.NotNull()
    com.semarescue.android.ui.viewmodels.MedicalViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ViewMedicalProfile(@org.jetbrains.annotations.Nullable()
    com.semarescue.android.data.entities.MedicalProfile profile, @org.jetbrains.annotations.NotNull()
    com.semarescue.android.utils.LanguageManager.Language currentLanguage) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void InfoSection(@org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String content, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.graphics.vector.ImageVector icon) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void EditMedicalProfile(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onNameChange, @org.jetbrains.annotations.NotNull()
    java.lang.String bloodType, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onBloodTypeChange, @org.jetbrains.annotations.NotNull()
    java.lang.String allergies, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onAllergiesChange, @org.jetbrains.annotations.NotNull()
    java.lang.String medications, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onMedicationsChange, @org.jetbrains.annotations.NotNull()
    java.lang.String emergencyNotes, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onEmergencyNotesChange, boolean isOrganDonor, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> onOrganDonorChange, @org.jetbrains.annotations.NotNull()
    com.semarescue.android.utils.LanguageManager.Language currentLanguage) {
    }
}