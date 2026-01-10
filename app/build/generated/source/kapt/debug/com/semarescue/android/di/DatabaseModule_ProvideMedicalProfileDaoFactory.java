package com.semarescue.android.di;

import com.semarescue.android.data.AppDatabase;
import com.semarescue.android.data.dao.MedicalProfileDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class DatabaseModule_ProvideMedicalProfileDaoFactory implements Factory<MedicalProfileDao> {
  private final Provider<AppDatabase> appDatabaseProvider;

  public DatabaseModule_ProvideMedicalProfileDaoFactory(Provider<AppDatabase> appDatabaseProvider) {
    this.appDatabaseProvider = appDatabaseProvider;
  }

  @Override
  public MedicalProfileDao get() {
    return provideMedicalProfileDao(appDatabaseProvider.get());
  }

  public static DatabaseModule_ProvideMedicalProfileDaoFactory create(
      Provider<AppDatabase> appDatabaseProvider) {
    return new DatabaseModule_ProvideMedicalProfileDaoFactory(appDatabaseProvider);
  }

  public static MedicalProfileDao provideMedicalProfileDao(AppDatabase appDatabase) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideMedicalProfileDao(appDatabase));
  }
}
