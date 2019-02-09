package udovyk.testassignment.ui.main;

import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.arellomobile.mvp.InjectViewState;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import udovyk.testassignment.network.model.ResultsItem;
import udovyk.testassignment.ui.base.BasePresenter;

@InjectViewState
public class MainPresenter extends BasePresenter<MainView> {

    MutableLiveData<List<ResultsItem>> mutableLiveData = new MutableLiveData<>();

    @Inject
    public MainPresenter() {

    }

    void test() {
        disposable.add(apiManager.getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(responseResponse ->
                        {
                           if (responseResponse.body() != null) mutableLiveData.postValue(responseResponse.body().results);
                        },
                        Throwable::printStackTrace
                ));


    }
}
