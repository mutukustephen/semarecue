package com.semarescue.android;

import android.app.Activity;
import android.app.Service;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.semarescue.android.data.AppDatabase;
import com.semarescue.android.data.dao.EmergencyContactDao;
import com.semarescue.android.data.dao.IncidentLogDao;
import com.semarescue.android.data.dao.InstructionDao;
import com.semarescue.android.data.dao.MedicalProfileDao;
import com.semarescue.android.data.repository.EmergencyContactRepository;
import com.semarescue.android.data.repository.IncidentRepository;
import com.semarescue.android.data.repository.InstructionRepository;
import com.semarescue.android.data.repository.MedicalRepository;
import com.semarescue.android.di.AppModule_ProvideLanguageManagerFactory;
import com.semarescue.android.di.DatabaseModule_ProvideAppDatabaseFactory;
import com.semarescue.android.di.DatabaseModule_ProvideEmergencyContactDaoFactory;
import com.semarescue.android.di.DatabaseModule_ProvideIncidentLogDaoFactory;
import com.semarescue.android.di.DatabaseModule_ProvideIncidentRepositoryFactory;
import com.semarescue.android.di.DatabaseModule_ProvideInstructionDaoFactory;
import com.semarescue.android.di.DatabaseModule_ProvideInstructionRepositoryFactory;
import com.semarescue.android.di.DatabaseModule_ProvideMedicalProfileDaoFactory;
import com.semarescue.android.di.DatabaseModule_ProvideMedicalRepositoryFactory;
import com.semarescue.android.ui.viewmodels.IncidentViewModel;
import com.semarescue.android.ui.viewmodels.IncidentViewModel_HiltModules_KeyModule_ProvideFactory;
import com.semarescue.android.ui.viewmodels.InstructionViewModel;
import com.semarescue.android.ui.viewmodels.InstructionViewModel_HiltModules_KeyModule_ProvideFactory;
import com.semarescue.android.ui.viewmodels.MedicalViewModel;
import com.semarescue.android.ui.viewmodels.MedicalViewModel_HiltModules_KeyModule_ProvideFactory;
import com.semarescue.android.ui.viewmodels.PanicModeViewModel;
import com.semarescue.android.ui.viewmodels.PanicModeViewModel_HiltModules_KeyModule_ProvideFactory;
import com.semarescue.android.utils.LanguageManager;
import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.ViewModelLifecycle;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories_InternalFactoryFactory_Factory;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory;
import dagger.hilt.android.internal.managers.SavedStateHandleHolder;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideContextFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.MapBuilder;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dagger.internal.SetBuilder;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

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
public final class DaggerSemaRescueApp_HiltComponents_SingletonC {
  private DaggerSemaRescueApp_HiltComponents_SingletonC() {
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private ApplicationContextModule applicationContextModule;

    private Builder() {
    }

    public Builder applicationContextModule(ApplicationContextModule applicationContextModule) {
      this.applicationContextModule = Preconditions.checkNotNull(applicationContextModule);
      return this;
    }

    public SemaRescueApp_HiltComponents.SingletonC build() {
      Preconditions.checkBuilderRequirement(applicationContextModule, ApplicationContextModule.class);
      return new SingletonCImpl(applicationContextModule);
    }
  }

  private static final class ActivityRetainedCBuilder implements SemaRescueApp_HiltComponents.ActivityRetainedC.Builder {
    private final SingletonCImpl singletonCImpl;

    private SavedStateHandleHolder savedStateHandleHolder;

    private ActivityRetainedCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ActivityRetainedCBuilder savedStateHandleHolder(
        SavedStateHandleHolder savedStateHandleHolder) {
      this.savedStateHandleHolder = Preconditions.checkNotNull(savedStateHandleHolder);
      return this;
    }

    @Override
    public SemaRescueApp_HiltComponents.ActivityRetainedC build() {
      Preconditions.checkBuilderRequirement(savedStateHandleHolder, SavedStateHandleHolder.class);
      return new ActivityRetainedCImpl(singletonCImpl, savedStateHandleHolder);
    }
  }

  private static final class ActivityCBuilder implements SemaRescueApp_HiltComponents.ActivityC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private Activity activity;

    private ActivityCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ActivityCBuilder activity(Activity activity) {
      this.activity = Preconditions.checkNotNull(activity);
      return this;
    }

    @Override
    public SemaRescueApp_HiltComponents.ActivityC build() {
      Preconditions.checkBuilderRequirement(activity, Activity.class);
      return new ActivityCImpl(singletonCImpl, activityRetainedCImpl, activity);
    }
  }

  private static final class FragmentCBuilder implements SemaRescueApp_HiltComponents.FragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private Fragment fragment;

    private FragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public FragmentCBuilder fragment(Fragment fragment) {
      this.fragment = Preconditions.checkNotNull(fragment);
      return this;
    }

    @Override
    public SemaRescueApp_HiltComponents.FragmentC build() {
      Preconditions.checkBuilderRequirement(fragment, Fragment.class);
      return new FragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragment);
    }
  }

  private static final class ViewWithFragmentCBuilder implements SemaRescueApp_HiltComponents.ViewWithFragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private View view;

    private ViewWithFragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;
    }

    @Override
    public ViewWithFragmentCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public SemaRescueApp_HiltComponents.ViewWithFragmentC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewWithFragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl, view);
    }
  }

  private static final class ViewCBuilder implements SemaRescueApp_HiltComponents.ViewC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private View view;

    private ViewCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public ViewCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public SemaRescueApp_HiltComponents.ViewC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, view);
    }
  }

  private static final class ViewModelCBuilder implements SemaRescueApp_HiltComponents.ViewModelC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private SavedStateHandle savedStateHandle;

    private ViewModelLifecycle viewModelLifecycle;

    private ViewModelCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ViewModelCBuilder savedStateHandle(SavedStateHandle handle) {
      this.savedStateHandle = Preconditions.checkNotNull(handle);
      return this;
    }

    @Override
    public ViewModelCBuilder viewModelLifecycle(ViewModelLifecycle viewModelLifecycle) {
      this.viewModelLifecycle = Preconditions.checkNotNull(viewModelLifecycle);
      return this;
    }

    @Override
    public SemaRescueApp_HiltComponents.ViewModelC build() {
      Preconditions.checkBuilderRequirement(savedStateHandle, SavedStateHandle.class);
      Preconditions.checkBuilderRequirement(viewModelLifecycle, ViewModelLifecycle.class);
      return new ViewModelCImpl(singletonCImpl, activityRetainedCImpl, savedStateHandle, viewModelLifecycle);
    }
  }

  private static final class ServiceCBuilder implements SemaRescueApp_HiltComponents.ServiceC.Builder {
    private final SingletonCImpl singletonCImpl;

    private Service service;

    private ServiceCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ServiceCBuilder service(Service service) {
      this.service = Preconditions.checkNotNull(service);
      return this;
    }

    @Override
    public SemaRescueApp_HiltComponents.ServiceC build() {
      Preconditions.checkBuilderRequirement(service, Service.class);
      return new ServiceCImpl(singletonCImpl, service);
    }
  }

  private static final class ViewWithFragmentCImpl extends SemaRescueApp_HiltComponents.ViewWithFragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private final ViewWithFragmentCImpl viewWithFragmentCImpl = this;

    private ViewWithFragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;


    }
  }

  private static final class FragmentCImpl extends SemaRescueApp_HiltComponents.FragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl = this;

    private FragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        Fragment fragmentParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return activityCImpl.getHiltInternalFactoryFactory();
    }

    @Override
    public ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
      return new ViewWithFragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl);
    }
  }

  private static final class ViewCImpl extends SemaRescueApp_HiltComponents.ViewC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final ViewCImpl viewCImpl = this;

    private ViewCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }
  }

  private static final class ActivityCImpl extends SemaRescueApp_HiltComponents.ActivityC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl = this;

    private ActivityCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, Activity activityParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;


    }

    @Override
    public void injectMainActivity(MainActivity mainActivity) {
    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return DefaultViewModelFactories_InternalFactoryFactory_Factory.newInstance(getViewModelKeys(), new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl));
    }

    @Override
    public Set<String> getViewModelKeys() {
      return SetBuilder.<String>newSetBuilder(4).add(IncidentViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(InstructionViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(MedicalViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(PanicModeViewModel_HiltModules_KeyModule_ProvideFactory.provide()).build();
    }

    @Override
    public ViewModelComponentBuilder getViewModelComponentBuilder() {
      return new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public FragmentComponentBuilder fragmentComponentBuilder() {
      return new FragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @Override
    public ViewComponentBuilder viewComponentBuilder() {
      return new ViewCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }
  }

  private static final class ViewModelCImpl extends SemaRescueApp_HiltComponents.ViewModelC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ViewModelCImpl viewModelCImpl = this;

    private Provider<IncidentViewModel> incidentViewModelProvider;

    private Provider<InstructionViewModel> instructionViewModelProvider;

    private Provider<MedicalViewModel> medicalViewModelProvider;

    private Provider<PanicModeViewModel> panicModeViewModelProvider;

    private ViewModelCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, SavedStateHandle savedStateHandleParam,
        ViewModelLifecycle viewModelLifecycleParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;

      initialize(savedStateHandleParam, viewModelLifecycleParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandle savedStateHandleParam,
        final ViewModelLifecycle viewModelLifecycleParam) {
      this.incidentViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 0);
      this.instructionViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 1);
      this.medicalViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 2);
      this.panicModeViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 3);
    }

    @Override
    public Map<String, javax.inject.Provider<ViewModel>> getHiltViewModelMap() {
      return MapBuilder.<String, javax.inject.Provider<ViewModel>>newMapBuilder(4).put("com.semarescue.android.ui.viewmodels.IncidentViewModel", ((Provider) incidentViewModelProvider)).put("com.semarescue.android.ui.viewmodels.InstructionViewModel", ((Provider) instructionViewModelProvider)).put("com.semarescue.android.ui.viewmodels.MedicalViewModel", ((Provider) medicalViewModelProvider)).put("com.semarescue.android.ui.viewmodels.PanicModeViewModel", ((Provider) panicModeViewModelProvider)).build();
    }

    @Override
    public Map<String, Object> getHiltViewModelAssistedMap() {
      return Collections.<String, Object>emptyMap();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final ViewModelCImpl viewModelCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          ViewModelCImpl viewModelCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.viewModelCImpl = viewModelCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // com.semarescue.android.ui.viewmodels.IncidentViewModel 
          return (T) new IncidentViewModel(singletonCImpl.provideIncidentRepositoryProvider.get(), singletonCImpl.provideLanguageManagerProvider.get());

          case 1: // com.semarescue.android.ui.viewmodels.InstructionViewModel 
          return (T) new InstructionViewModel(singletonCImpl.provideInstructionRepositoryProvider.get());

          case 2: // com.semarescue.android.ui.viewmodels.MedicalViewModel 
          return (T) new MedicalViewModel(singletonCImpl.provideMedicalRepositoryProvider.get(), singletonCImpl.provideLanguageManagerProvider.get());

          case 3: // com.semarescue.android.ui.viewmodels.PanicModeViewModel 
          return (T) new PanicModeViewModel(singletonCImpl.emergencyContactRepositoryProvider.get());

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ActivityRetainedCImpl extends SemaRescueApp_HiltComponents.ActivityRetainedC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl = this;

    private Provider<ActivityRetainedLifecycle> provideActivityRetainedLifecycleProvider;

    private ActivityRetainedCImpl(SingletonCImpl singletonCImpl,
        SavedStateHandleHolder savedStateHandleHolderParam) {
      this.singletonCImpl = singletonCImpl;

      initialize(savedStateHandleHolderParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandleHolder savedStateHandleHolderParam) {
      this.provideActivityRetainedLifecycleProvider = DoubleCheck.provider(new SwitchingProvider<ActivityRetainedLifecycle>(singletonCImpl, activityRetainedCImpl, 0));
    }

    @Override
    public ActivityComponentBuilder activityComponentBuilder() {
      return new ActivityCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public ActivityRetainedLifecycle getActivityRetainedLifecycle() {
      return provideActivityRetainedLifecycleProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // dagger.hilt.android.ActivityRetainedLifecycle 
          return (T) ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory.provideActivityRetainedLifecycle();

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ServiceCImpl extends SemaRescueApp_HiltComponents.ServiceC {
    private final SingletonCImpl singletonCImpl;

    private final ServiceCImpl serviceCImpl = this;

    private ServiceCImpl(SingletonCImpl singletonCImpl, Service serviceParam) {
      this.singletonCImpl = singletonCImpl;


    }
  }

  private static final class SingletonCImpl extends SemaRescueApp_HiltComponents.SingletonC {
    private final ApplicationContextModule applicationContextModule;

    private final SingletonCImpl singletonCImpl = this;

    private Provider<AppDatabase> provideAppDatabaseProvider;

    private Provider<IncidentLogDao> provideIncidentLogDaoProvider;

    private Provider<IncidentRepository> provideIncidentRepositoryProvider;

    private Provider<LanguageManager> provideLanguageManagerProvider;

    private Provider<InstructionDao> provideInstructionDaoProvider;

    private Provider<InstructionRepository> provideInstructionRepositoryProvider;

    private Provider<MedicalProfileDao> provideMedicalProfileDaoProvider;

    private Provider<MedicalRepository> provideMedicalRepositoryProvider;

    private Provider<EmergencyContactDao> provideEmergencyContactDaoProvider;

    private Provider<EmergencyContactRepository> emergencyContactRepositoryProvider;

    private SingletonCImpl(ApplicationContextModule applicationContextModuleParam) {
      this.applicationContextModule = applicationContextModuleParam;
      initialize(applicationContextModuleParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final ApplicationContextModule applicationContextModuleParam) {
      this.provideAppDatabaseProvider = DoubleCheck.provider(new SwitchingProvider<AppDatabase>(singletonCImpl, 2));
      this.provideIncidentLogDaoProvider = DoubleCheck.provider(new SwitchingProvider<IncidentLogDao>(singletonCImpl, 1));
      this.provideIncidentRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<IncidentRepository>(singletonCImpl, 0));
      this.provideLanguageManagerProvider = DoubleCheck.provider(new SwitchingProvider<LanguageManager>(singletonCImpl, 3));
      this.provideInstructionDaoProvider = DoubleCheck.provider(new SwitchingProvider<InstructionDao>(singletonCImpl, 5));
      this.provideInstructionRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<InstructionRepository>(singletonCImpl, 4));
      this.provideMedicalProfileDaoProvider = DoubleCheck.provider(new SwitchingProvider<MedicalProfileDao>(singletonCImpl, 7));
      this.provideMedicalRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<MedicalRepository>(singletonCImpl, 6));
      this.provideEmergencyContactDaoProvider = DoubleCheck.provider(new SwitchingProvider<EmergencyContactDao>(singletonCImpl, 9));
      this.emergencyContactRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<EmergencyContactRepository>(singletonCImpl, 8));
    }

    @Override
    public void injectSemaRescueApp(SemaRescueApp semaRescueApp) {
    }

    @Override
    public Set<Boolean> getDisableFragmentGetContextFix() {
      return Collections.<Boolean>emptySet();
    }

    @Override
    public ActivityRetainedComponentBuilder retainedComponentBuilder() {
      return new ActivityRetainedCBuilder(singletonCImpl);
    }

    @Override
    public ServiceComponentBuilder serviceComponentBuilder() {
      return new ServiceCBuilder(singletonCImpl);
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // com.semarescue.android.data.repository.IncidentRepository 
          return (T) DatabaseModule_ProvideIncidentRepositoryFactory.provideIncidentRepository(singletonCImpl.provideIncidentLogDaoProvider.get());

          case 1: // com.semarescue.android.data.dao.IncidentLogDao 
          return (T) DatabaseModule_ProvideIncidentLogDaoFactory.provideIncidentLogDao(singletonCImpl.provideAppDatabaseProvider.get());

          case 2: // com.semarescue.android.data.AppDatabase 
          return (T) DatabaseModule_ProvideAppDatabaseFactory.provideAppDatabase(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 3: // com.semarescue.android.utils.LanguageManager 
          return (T) AppModule_ProvideLanguageManagerFactory.provideLanguageManager();

          case 4: // com.semarescue.android.data.repository.InstructionRepository 
          return (T) DatabaseModule_ProvideInstructionRepositoryFactory.provideInstructionRepository(singletonCImpl.provideInstructionDaoProvider.get());

          case 5: // com.semarescue.android.data.dao.InstructionDao 
          return (T) DatabaseModule_ProvideInstructionDaoFactory.provideInstructionDao(singletonCImpl.provideAppDatabaseProvider.get());

          case 6: // com.semarescue.android.data.repository.MedicalRepository 
          return (T) DatabaseModule_ProvideMedicalRepositoryFactory.provideMedicalRepository(singletonCImpl.provideMedicalProfileDaoProvider.get());

          case 7: // com.semarescue.android.data.dao.MedicalProfileDao 
          return (T) DatabaseModule_ProvideMedicalProfileDaoFactory.provideMedicalProfileDao(singletonCImpl.provideAppDatabaseProvider.get());

          case 8: // com.semarescue.android.data.repository.EmergencyContactRepository 
          return (T) new EmergencyContactRepository(singletonCImpl.provideEmergencyContactDaoProvider.get());

          case 9: // com.semarescue.android.data.dao.EmergencyContactDao 
          return (T) DatabaseModule_ProvideEmergencyContactDaoFactory.provideEmergencyContactDao(singletonCImpl.provideAppDatabaseProvider.get());

          default: throw new AssertionError(id);
        }
      }
    }
  }
}
