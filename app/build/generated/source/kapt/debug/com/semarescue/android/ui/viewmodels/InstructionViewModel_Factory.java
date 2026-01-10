package com.semarescue.android.ui.viewmodels;

import com.semarescue.android.data.repository.InstructionRepository;
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
public final class InstructionViewModel_Factory implements Factory<InstructionViewModel> {
  private final Provider<InstructionRepository> repositoryProvider;

  public InstructionViewModel_Factory(Provider<InstructionRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public InstructionViewModel get() {
    return newInstance(repositoryProvider.get());
  }

  public static InstructionViewModel_Factory create(
      Provider<InstructionRepository> repositoryProvider) {
    return new InstructionViewModel_Factory(repositoryProvider);
  }

  public static InstructionViewModel newInstance(InstructionRepository repository) {
    return new InstructionViewModel(repository);
  }
}
