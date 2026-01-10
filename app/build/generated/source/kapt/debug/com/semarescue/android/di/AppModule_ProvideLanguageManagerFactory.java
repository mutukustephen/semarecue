package com.semarescue.android.di;

import com.semarescue.android.utils.LanguageManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
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
public final class AppModule_ProvideLanguageManagerFactory implements Factory<LanguageManager> {
  @Override
  public LanguageManager get() {
    return provideLanguageManager();
  }

  public static AppModule_ProvideLanguageManagerFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static LanguageManager provideLanguageManager() {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideLanguageManager());
  }

  private static final class InstanceHolder {
    private static final AppModule_ProvideLanguageManagerFactory INSTANCE = new AppModule_ProvideLanguageManagerFactory();
  }
}
