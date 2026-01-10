package com.semarescue.android.data.repository;

import com.semarescue.android.data.dao.EmergencyContactDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class EmergencyContactRepository_Factory implements Factory<EmergencyContactRepository> {
  private final Provider<EmergencyContactDao> emergencyContactDaoProvider;

  public EmergencyContactRepository_Factory(
      Provider<EmergencyContactDao> emergencyContactDaoProvider) {
    this.emergencyContactDaoProvider = emergencyContactDaoProvider;
  }

  @Override
  public EmergencyContactRepository get() {
    return newInstance(emergencyContactDaoProvider.get());
  }

  public static EmergencyContactRepository_Factory create(
      Provider<EmergencyContactDao> emergencyContactDaoProvider) {
    return new EmergencyContactRepository_Factory(emergencyContactDaoProvider);
  }

  public static EmergencyContactRepository newInstance(EmergencyContactDao emergencyContactDao) {
    return new EmergencyContactRepository(emergencyContactDao);
  }
}
