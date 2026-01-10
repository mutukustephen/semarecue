package com.semarescue.android.ui.viewmodels;

import com.semarescue.android.data.repository.MedicalRepository;
import com.semarescue.android.utils.LanguageManager;
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
public final class MedicalViewModel_Factory implements Factory<MedicalViewModel> {
  private final Provider<MedicalRepository> repositoryProvider;

  private final Provider<LanguageManager> languageManagerProvider;

  public MedicalViewModel_Factory(Provider<MedicalRepository> repositoryProvider,
      Provider<LanguageManager> languageManagerProvider) {
    this.repositoryProvider = repositoryProvider;
    this.languageManagerProvider = languageManagerProvider;
  }

  @Override
  public MedicalViewModel get() {
    return newInstance(repositoryProvider.get(), languageManagerProvider.get());
  }

  public static MedicalViewModel_Factory create(Provider<MedicalRepository> repositoryProvider,
      Provider<LanguageManager> languageManagerProvider) {
    return new MedicalViewModel_Factory(repositoryProvider, languageManagerProvider);
  }

  public static MedicalViewModel newInstance(MedicalRepository repository,
      LanguageManager languageManager) {
    return new MedicalViewModel(repository, languageManager);
  }
}
