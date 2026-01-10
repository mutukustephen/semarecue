package com.semarescue.android.di;

import com.semarescue.android.data.AppDatabase;
import com.semarescue.android.data.dao.EmergencyContactDao;
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
public final class DatabaseModule_ProvideEmergencyContactDaoFactory implements Factory<EmergencyContactDao> {
  private final Provider<AppDatabase> appDatabaseProvider;

  public DatabaseModule_ProvideEmergencyContactDaoFactory(
      Provider<AppDatabase> appDatabaseProvider) {
    this.appDatabaseProvider = appDatabaseProvider;
  }

  @Override
  public EmergencyContactDao get() {
    return provideEmergencyContactDao(appDatabaseProvider.get());
  }

  public static DatabaseModule_ProvideEmergencyContactDaoFactory create(
      Provider<AppDatabase> appDatabaseProvider) {
    return new DatabaseModule_ProvideEmergencyContactDaoFactory(appDatabaseProvider);
  }

  public static EmergencyContactDao provideEmergencyContactDao(AppDatabase appDatabase) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideEmergencyContactDao(appDatabase));
  }
}
