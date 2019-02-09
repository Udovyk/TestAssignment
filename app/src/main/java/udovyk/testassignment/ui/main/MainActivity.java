package udovyk.testassignment.ui.main;

import android.os.Bundle;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import javax.inject.Inject;
import udovyk.testassignment.R;
import udovyk.testassignment.ui.base.BaseActivity;
import udovyk.testassignment.ui.userslist.UsersListFragment;

public class MainActivity extends BaseActivity implements MainView {

    @Inject
    @InjectPresenter
    MainPresenter presenter;

    @ProvidePresenter
    MainPresenter providePresenter() { return presenter; }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initScreen();
    }

    private void initScreen() {
        getSupportFragmentManager().beginTransaction().replace(R.id.con, UsersListFragment.newInstance()).commit();
    }
}
