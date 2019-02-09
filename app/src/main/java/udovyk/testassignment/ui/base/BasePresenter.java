package udovyk.testassignment.ui.base;

import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.MvpView;
import javax.inject.Inject;
import io.reactivex.disposables.CompositeDisposable;
import udovyk.testassignment.network.ApiManager;

public class BasePresenter<T extends MvpView> extends MvpPresenter<T> {

    protected CompositeDisposable disposable = new CompositeDisposable();

    @Inject
    public ApiManager apiManager;

    @Override
    public void onDestroy() {
        super.onDestroy();
        disposable.dispose();
    }
}
