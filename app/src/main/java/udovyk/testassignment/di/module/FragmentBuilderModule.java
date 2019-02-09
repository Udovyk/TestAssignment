package udovyk.testassignment.di.module;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import udovyk.testassignment.ui.userdetail.UserDetailFragment;
import udovyk.testassignment.ui.userslist.UsersListFragment;

@Module
public abstract class FragmentBuilderModule {

    @ContributesAndroidInjector
    abstract UsersListFragment bindUsersListFragment();

    @ContributesAndroidInjector
    abstract UserDetailFragment bindUserDetailFragment();


}
