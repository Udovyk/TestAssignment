package udovyk.testassignment.ui.userdetail;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import butterknife.BindView;
import udovyk.testassignment.R;
import udovyk.testassignment.network.model.ResultsItem;
import udovyk.testassignment.ui.base.BaseFragment;

public class UserDetailFragment extends BaseFragment implements UserDetailView {

    public static String RESULT_ITEM = "resultsItem";
    public static String TAG = UserDetailFragment.class.getSimpleName();

    @BindView(R.id.imDetailAvatar)
    ImageView imageAvatar;

    @BindView(R.id.tvDetailName)
    TextView tvName;

    @BindView(R.id.tvGender)
    TextView tvGender;

    @BindView(R.id.tvDate)
    TextView tvDate;

    @BindView(R.id.tvPhone)
    TextView tvPhone;



    public static UserDetailFragment newInstance(ResultsItem resultsItem) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(RESULT_ITEM, resultsItem);
        UserDetailFragment fragment = new UserDetailFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    ResultsItem resultsItem = null;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
            resultsItem = getArguments().getParcelable(RESULT_ITEM);
        initUi();
    }

    void initUi() {
        if (resultsItem != null) {
            RequestOptions requestOptions = new RequestOptions().circleCrop();

            Glide.with(this)
                    .load(resultsItem.picture.medium)
                    .apply(requestOptions)
                    .into(imageAvatar);

            String name = resultsItem.name.first + " " + resultsItem.name.last;
            tvName.setText(name);

            tvGender.setText(resultsItem.gender);

            String originDate = resultsItem.dob.date;
            String newDate = originDate.substring(0,10);
            tvDate.setText(newDate);

            tvPhone.setText(resultsItem.phone);

        }
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_user_detail;
    }
}
