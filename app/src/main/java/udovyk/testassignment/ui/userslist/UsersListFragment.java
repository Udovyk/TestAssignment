package udovyk.testassignment.ui.userslist;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import javax.inject.Inject;
import butterknife.BindView;
import udovyk.testassignment.R;
import udovyk.testassignment.network.model.ResultsItem;
import udovyk.testassignment.ui.base.BaseFragment;
import udovyk.testassignment.ui.userslist.paging.ItemAdapter;
import udovyk.testassignment.ui.userslist.paging.RecyclerTouchListener;

public class UsersListFragment extends BaseFragment implements UsersListView {

    @BindView(R.id.rvUsers)
    RecyclerView rvUsers;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @Inject
    @InjectPresenter
    UsersListPresenter presenter;

    @ProvidePresenter
    UsersListPresenter providePresenter() { return presenter; }

    ItemAdapter adapter = new ItemAdapter();

    RecyclerTouchListener touchListener = new RecyclerTouchListener(getActivity());

    public static UsersListFragment newInstance() {
        UsersListFragment fragment = new UsersListFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRecyclerView();

        presenter.getUsers();
        presenter.progressLiveData.observe(this, bool -> onProgress(bool));
        presenter.itemPagedList.observe(this, items -> adapter.submitList(items));
        rvUsers.setAdapter(adapter);
        rvUsers.addOnItemTouchListener(touchListener);

        touchListener.listener = new RecyclerTouchListener.ClickListener() {
            @Override
            public void onPress(int position, View view) {
                ResultsItem userClicked = adapter.getCurrentList().get(position);
                presenter.showDetails(getFragmentManager(), userClicked);
            }

            @Override
            public void onLongPress(int position, View view) {

            }
        };

    }

    public void onProgress(Boolean b) {
        progressBar.setVisibility(b ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_users_list;
    }

    private void initRecyclerView() {
        rvUsers.setHasFixedSize(true);
    }
}
