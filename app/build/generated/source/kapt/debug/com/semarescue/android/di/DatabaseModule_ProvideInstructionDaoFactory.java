package com.semarescue.android.di;

import com.semarescue.android.data.AppDatabase;
import com.semarescue.android.data.dao.InstructionDao;
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
public final class DatabaseModule_ProvideInstructionDaoFactory implements Factory<InstructionDao> {
  private final Provider<AppDatabase> databaseProvider;

  public DatabaseModule_ProvideInstructionDaoFactory(Provider<AppDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public InstructionDao get() {
    return provideInstructionDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvideInstructionDaoFactory create(
      Provider<AppDatabase> databaseProvider) {
    return new DatabaseModule_ProvideInstructionDaoFactory(databaseProvider);
  }

  public static InstructionDao provideInstructionDao(AppDatabase database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideInstructionDao(database));
  }
}
