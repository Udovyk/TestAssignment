package udovyk.testassignment.ui.userslist.paging;

import android.arch.paging.PageKeyedDataSource;
import android.support.annotation.NonNull;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;
import udovyk.testassignment.network.ApiManager;
import udovyk.testassignment.network.ApiService;
import udovyk.testassignment.network.model.ResultsItem;
import udovyk.testassignment.network.model.UserResponse;

public class ItemDataSource extends PageKeyedDataSource<Integer, ResultsItem> {

    private CompositeDisposable disposable = new CompositeDisposable();


    ApiManager apiManager;

    public static final int PAGE_SIZE = 20;

    public static final int FIRST_PAGE = 1;


    @Inject
    public ItemDataSource(ApiManager apiManager) {
        this.apiManager = apiManager;
    }



    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, ResultsItem> callback) {

        disposable.add(apiManager.getUsers(FIRST_PAGE, PAGE_SIZE)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(responseResponse ->
                        {
                            if (responseResponse.body() != null) {
                                callback.onResult(responseResponse.body().results, null, FIRST_PAGE + 1);
                            }
                        },
                        Throwable::printStackTrace
                ));

    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, ResultsItem> callback) {

        disposable.add(apiManager.getUsers(FIRST_PAGE, PAGE_SIZE)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(responseResponse ->
                        {
                            if (responseResponse.body() != null) {
                                Integer adjacentKey = (params.key > 1) ? params.key - 1 : null;

                                callback.onResult(responseResponse.body().results, adjacentKey);
                            }
                        },
                        Throwable::printStackTrace
                ));

    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, ResultsItem> callback) {

        disposable.add(apiManager.getUsers(FIRST_PAGE, PAGE_SIZE)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(responseResponse ->
                        {
                            if (responseResponse.body() != null) {
                                //todo Integer key = response.body().has_more ? params.key + 1 : null;
                                Integer key = params.key + 1;

                                callback.onResult(responseResponse.body().results, key);
                            }
                        },
                        Throwable::printStackTrace
                ));
    }
}
