package udovyk.testassignment.ui.userslist.paging;

import android.arch.lifecycle.MutableLiveData;
import android.arch.paging.DataSource;
import android.arch.paging.PageKeyedDataSource;
import javax.inject.Inject;

import udovyk.testassignment.network.ApiManager;
import udovyk.testassignment.network.model.ResultsItem;

public class ItemDataSourceFactory extends DataSource.Factory {

    private MutableLiveData<PageKeyedDataSource<Integer, ResultsItem>> itemLiveDataSource = new MutableLiveData<>();
    private ApiManager apiManager;

    @Inject
    public ItemDataSourceFactory(ApiManager apiManager) {
        this.apiManager = apiManager;
    }


    @Override
    public DataSource<Integer, ResultsItem> create() {
        ItemDataSource itemDataSource = new ItemDataSource(apiManager);

        itemLiveDataSource.postValue(itemDataSource);

        return itemDataSource;
    }


    public MutableLiveData<PageKeyedDataSource<Integer, ResultsItem>> getItemLiveDataSource() {
        return itemLiveDataSource;
    }
}
