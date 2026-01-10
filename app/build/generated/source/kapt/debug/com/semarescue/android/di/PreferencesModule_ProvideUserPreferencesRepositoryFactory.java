package com.semarescue.android.di;

import android.content.Context;
import com.semarescue.android.data.repository.UserPreferencesRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class PreferencesModule_ProvideUserPreferencesRepositoryFactory implements Factory<UserPreferencesRepository> {
  private final Provider<Context> contextProvider;

  public PreferencesModule_ProvideUserPreferencesRepositoryFactory(
      Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public UserPreferencesRepository get() {
    return provideUserPreferencesRepository(contextProvider.get());
  }

  public static PreferencesModule_ProvideUserPreferencesRepositoryFactory create(
      Provider<Context> contextProvider) {
    return new PreferencesModule_ProvideUserPreferencesRepositoryFactory(contextProvider);
  }

  public static UserPreferencesRepository provideUserPreferencesRepository(Context context) {
    return Preconditions.checkNotNullFromProvides(PreferencesModule.INSTANCE.provideUserPreferencesRepository(context));
  }
}
