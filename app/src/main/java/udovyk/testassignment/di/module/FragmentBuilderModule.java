package udovyk.testassignment.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;
import retrofit2.Retrofit;
import udovyk.testassignment.network.ApiManager;
import udovyk.testassignment.network.ApiService;
import udovyk.testassignment.ui.userdetail.UserDetailFragment;
import udovyk.testassignment.ui.userslist.UsersListFragment;
import udovyk.testassignment.ui.userslist.paging.ItemDataSourceFactory;

@Module
public abstract class FragmentBuilderModule {

    @ContributesAndroidInjector
    abstract UsersListFragment bindUsersListFragment();

    @ContributesAndroidInjector
    abstract UserDetailFragment bindUserDetailFragment();


}
