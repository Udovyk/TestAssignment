package udovyk.testassignment.di.module;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import udovyk.testassignment.ui.main.MainActivity;

@Module
public abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    abstract MainActivity bindMainActivity();
}
