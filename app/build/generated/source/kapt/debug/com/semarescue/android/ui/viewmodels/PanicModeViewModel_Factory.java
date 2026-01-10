package com.semarescue.android.ui.viewmodels;

import com.semarescue.android.data.repository.EmergencyContactRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class PanicModeViewModel_Factory implements Factory<PanicModeViewModel> {
  private final Provider<EmergencyContactRepository> emergencyContactRepositoryProvider;

  public PanicModeViewModel_Factory(
      Provider<EmergencyContactRepository> emergencyContactRepositoryProvider) {
    this.emergencyContactRepositoryProvider = emergencyContactRepositoryProvider;
  }

  @Override
  public PanicModeViewModel get() {
    return newInstance(emergencyContactRepositoryProvider.get());
  }

  public static PanicModeViewModel_Factory create(
      Provider<EmergencyContactRepository> emergencyContactRepositoryProvider) {
    return new PanicModeViewModel_Factory(emergencyContactRepositoryProvider);
  }

  public static PanicModeViewModel newInstance(
      EmergencyContactRepository emergencyContactRepository) {
    return new PanicModeViewModel(emergencyContactRepository);
  }
}
