package udovyk.testassignment.ui.userslist;

import android.arch.lifecycle.LiveData;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PageKeyedDataSource;
import android.arch.paging.PagedList;
import com.arellomobile.mvp.InjectViewState;
import javax.inject.Inject;
import udovyk.testassignment.network.model.ResultsItem;
import udovyk.testassignment.ui.base.BasePresenter;
import udovyk.testassignment.ui.userslist.paging.ItemDataSource;
import udovyk.testassignment.ui.userslist.paging.ItemDataSourceFactory;

@InjectViewState
public class UsersListPresenter extends BasePresenter<UsersListView> {

    LiveData<PagedList<ResultsItem>> itemPagedList;
    LiveData<PageKeyedDataSource<Integer, ResultsItem>> liveDataSource;

    @Inject
    public UsersListPresenter() {

    }

    void test() {
        ItemDataSourceFactory itemDataSourceFactory = new ItemDataSourceFactory(apiManager);
        liveDataSource = itemDataSourceFactory.getItemLiveDataSource();
        PagedList.Config pagedListConfig =
                (new PagedList.Config.Builder())
                        .setEnablePlaceholders(false)
                        .setPageSize(ItemDataSource.PAGE_SIZE).build();
        itemPagedList = (new LivePagedListBuilder(itemDataSourceFactory, pagedListConfig))
                .build();
    }

}
