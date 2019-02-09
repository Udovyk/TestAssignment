package udovyk.testassignment;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import udovyk.testassignment.di.DaggerAppComponent;

public class TestAssignmentApp extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent
                .builder()
                .app(this)
                .build();
    }
}
