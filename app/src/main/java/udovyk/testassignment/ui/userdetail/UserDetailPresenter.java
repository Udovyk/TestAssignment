package udovyk.testassignment.ui.userdetail;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.arellomobile.mvp.InjectViewState;

import javax.inject.Inject;

import udovyk.testassignment.ui.base.BasePresenter;

@InjectViewState
public class UserDetailPresenter extends BasePresenter<UserDetailView> {

    @Inject
    public UserDetailPresenter() {}
    @Inject
    Context context;

    void call(String number) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + number));
        context.startActivity(intent);
    }

}
