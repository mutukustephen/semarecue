package com.semarescue.android.ui.viewmodels;

import com.semarescue.android.data.repository.IncidentRepository;
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
public final class IncidentViewModel_Factory implements Factory<IncidentViewModel> {
  private final Provider<IncidentRepository> repositoryProvider;

  private final Provider<LanguageManager> languageManagerProvider;

  public IncidentViewModel_Factory(Provider<IncidentRepository> repositoryProvider,
      Provider<LanguageManager> languageManagerProvider) {
    this.repositoryProvider = repositoryProvider;
    this.languageManagerProvider = languageManagerProvider;
  }

  @Override
  public IncidentViewModel get() {
    return newInstance(repositoryProvider.get(), languageManagerProvider.get());
  }

  public static IncidentViewModel_Factory create(Provider<IncidentRepository> repositoryProvider,
      Provider<LanguageManager> languageManagerProvider) {
    return new IncidentViewModel_Factory(repositoryProvider, languageManagerProvider);
  }

  public static IncidentViewModel newInstance(IncidentRepository repository,
      LanguageManager languageManager) {
    return new IncidentViewModel(repository, languageManager);
  }
}
