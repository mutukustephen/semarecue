package com.semarescue.android.di;

import com.semarescue.android.data.dao.IncidentLogDao;
import com.semarescue.android.data.repository.IncidentRepository;
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
public final class DatabaseModule_ProvideIncidentRepositoryFactory implements Factory<IncidentRepository> {
  private final Provider<IncidentLogDao> incidentLogDaoProvider;

  public DatabaseModule_ProvideIncidentRepositoryFactory(
      Provider<IncidentLogDao> incidentLogDaoProvider) {
    this.incidentLogDaoProvider = incidentLogDaoProvider;
  }

  @Override
  public IncidentRepository get() {
    return provideIncidentRepository(incidentLogDaoProvider.get());
  }

  public static DatabaseModule_ProvideIncidentRepositoryFactory create(
      Provider<IncidentLogDao> incidentLogDaoProvider) {
    return new DatabaseModule_ProvideIncidentRepositoryFactory(incidentLogDaoProvider);
  }

  public static IncidentRepository provideIncidentRepository(IncidentLogDao incidentLogDao) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideIncidentRepository(incidentLogDao));
  }
}
