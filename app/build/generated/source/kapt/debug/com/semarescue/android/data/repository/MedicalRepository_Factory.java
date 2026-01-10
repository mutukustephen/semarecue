package com.semarescue.android.data.repository;

import com.semarescue.android.data.dao.MedicalProfileDao;
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
public final class MedicalRepository_Factory implements Factory<MedicalRepository> {
  private final Provider<MedicalProfileDao> medicalProfileDaoProvider;

  public MedicalRepository_Factory(Provider<MedicalProfileDao> medicalProfileDaoProvider) {
    this.medicalProfileDaoProvider = medicalProfileDaoProvider;
  }

  @Override
  public MedicalRepository get() {
    return newInstance(medicalProfileDaoProvider.get());
  }

  public static MedicalRepository_Factory create(
      Provider<MedicalProfileDao> medicalProfileDaoProvider) {
    return new MedicalRepository_Factory(medicalProfileDaoProvider);
  }

  public static MedicalRepository newInstance(MedicalProfileDao medicalProfileDao) {
    return new MedicalRepository(medicalProfileDao);
  }
}
