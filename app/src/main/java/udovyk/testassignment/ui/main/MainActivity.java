package udovyk.testassignment.ui.main;

import android.arch.lifecycle.Observer;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import udovyk.testassignment.R;
import udovyk.testassignment.network.model.ResultsItem;
import udovyk.testassignment.ui.base.BaseActivity;

public class MainActivity extends BaseActivity implements MainView {

    @BindView(R.id.textView)
    TextView textView;

    @Inject
    @InjectPresenter
    MainPresenter presenter;

    @ProvidePresenter
    MainPresenter providePresenter() { return presenter; }

    private Observer<List<ResultsItem>> observer = new Observer<List<ResultsItem>>() {
        @Override
        public void onChanged(@Nullable List<ResultsItem> resultsItems) {
            if (resultsItems != null) textView.setText(resultsItems.get(0).gender);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter.mutableLiveData.observe(this, observer);



        presenter.test();

    }
}
