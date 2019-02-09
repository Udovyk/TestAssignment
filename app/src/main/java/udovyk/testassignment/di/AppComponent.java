package udovyk.testassignment.di;


import android.app.Application;
import javax.inject.Singleton;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import udovyk.testassignment.TestAssignmentApp;
import udovyk.testassignment.di.module.ActivityBuilderModule;
import udovyk.testassignment.di.module.AppModule;
import udovyk.testassignment.di.module.FragmentBuilderModule;
import udovyk.testassignment.di.module.NetworkModule;

@Component(modules = {
        AppModule.class,
        NetworkModule.class,
        ActivityBuilderModule.class,
        FragmentBuilderModule.class,
        AndroidSupportInjectionModule.class})
@Singleton
public interface AppComponent extends AndroidInjector<TestAssignmentApp> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        AppComponent.Builder app(Application app);

        AppComponent build();
    }

}
