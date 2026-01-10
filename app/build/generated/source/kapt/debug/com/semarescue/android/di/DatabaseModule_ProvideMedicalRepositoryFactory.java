package com.semarescue.android.di;

import com.semarescue.android.data.dao.MedicalProfileDao;
import com.semarescue.android.data.repository.MedicalRepository;
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
public final class DatabaseModule_ProvideMedicalRepositoryFactory implements Factory<MedicalRepository> {
  private final Provider<MedicalProfileDao> medicalProfileDaoProvider;

  public DatabaseModule_ProvideMedicalRepositoryFactory(
      Provider<MedicalProfileDao> medicalProfileDaoProvider) {
    this.medicalProfileDaoProvider = medicalProfileDaoProvider;
  }

  @Override
  public MedicalRepository get() {
    return provideMedicalRepository(medicalProfileDaoProvider.get());
  }

  public static DatabaseModule_ProvideMedicalRepositoryFactory create(
      Provider<MedicalProfileDao> medicalProfileDaoProvider) {
    return new DatabaseModule_ProvideMedicalRepositoryFactory(medicalProfileDaoProvider);
  }

  public static MedicalRepository provideMedicalRepository(MedicalProfileDao medicalProfileDao) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideMedicalRepository(medicalProfileDao));
  }
}
