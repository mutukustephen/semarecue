package com.semarescue.android.data.repository;

import com.semarescue.android.data.dao.IncidentLogDao;
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
public final class IncidentRepository_Factory implements Factory<IncidentRepository> {
  private final Provider<IncidentLogDao> incidentLogDaoProvider;

  public IncidentRepository_Factory(Provider<IncidentLogDao> incidentLogDaoProvider) {
    this.incidentLogDaoProvider = incidentLogDaoProvider;
  }

  @Override
  public IncidentRepository get() {
    return newInstance(incidentLogDaoProvider.get());
  }

  public static IncidentRepository_Factory create(Provider<IncidentLogDao> incidentLogDaoProvider) {
    return new IncidentRepository_Factory(incidentLogDaoProvider);
  }

  public static IncidentRepository newInstance(IncidentLogDao incidentLogDao) {
    return new IncidentRepository(incidentLogDao);
  }
}
