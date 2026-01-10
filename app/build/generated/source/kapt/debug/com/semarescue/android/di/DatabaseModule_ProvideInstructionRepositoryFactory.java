package com.semarescue.android.di;

import com.semarescue.android.data.dao.InstructionDao;
import com.semarescue.android.data.repository.InstructionRepository;
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
public final class DatabaseModule_ProvideInstructionRepositoryFactory implements Factory<InstructionRepository> {
  private final Provider<InstructionDao> instructionDaoProvider;

  public DatabaseModule_ProvideInstructionRepositoryFactory(
      Provider<InstructionDao> instructionDaoProvider) {
    this.instructionDaoProvider = instructionDaoProvider;
  }

  @Override
  public InstructionRepository get() {
    return provideInstructionRepository(instructionDaoProvider.get());
  }

  public static DatabaseModule_ProvideInstructionRepositoryFactory create(
      Provider<InstructionDao> instructionDaoProvider) {
    return new DatabaseModule_ProvideInstructionRepositoryFactory(instructionDaoProvider);
  }

  public static InstructionRepository provideInstructionRepository(InstructionDao instructionDao) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideInstructionRepository(instructionDao));
  }
}
