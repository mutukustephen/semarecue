package com.semarescue.android.di;

import com.semarescue.android.data.AppDatabase;
import com.semarescue.android.data.dao.IncidentLogDao;
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
public final class DatabaseModule_ProvideIncidentLogDaoFactory implements Factory<IncidentLogDao> {
  private final Provider<AppDatabase> appDatabaseProvider;

  public DatabaseModule_ProvideIncidentLogDaoFactory(Provider<AppDatabase> appDatabaseProvider) {
    this.appDatabaseProvider = appDatabaseProvider;
  }

  @Override
  public IncidentLogDao get() {
    return provideIncidentLogDao(appDatabaseProvider.get());
  }

  public static DatabaseModule_ProvideIncidentLogDaoFactory create(
      Provider<AppDatabase> appDatabaseProvider) {
    return new DatabaseModule_ProvideIncidentLogDaoFactory(appDatabaseProvider);
  }

  public static IncidentLogDao provideIncidentLogDao(AppDatabase appDatabase) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideIncidentLogDao(appDatabase));
  }
}
