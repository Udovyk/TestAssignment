package udovyk.testassignment.ui.userslist.paging;

import android.arch.paging.PagedListAdapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import udovyk.testassignment.R;
import udovyk.testassignment.network.model.ResultsItem;

public class ItemAdapter extends PagedListAdapter<ResultsItem, ItemAdapter.ItemViewHolder> {


    public ItemAdapter() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        ResultsItem item = getItem(position);

        if (item != null) {
            String name = item.name.first + " " + item.name.last;
            holder.textView.setText(name);
            Glide.with(holder.itemView.getContext())
                    .load(item.picture.medium)
                    .into(holder.imageView);
        }else{

        }
    }

    private static DiffUtil.ItemCallback<ResultsItem> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<ResultsItem>() {
                @Override
                public boolean areItemsTheSame(ResultsItem oldItem, ResultsItem newItem) {
                    return oldItem.id == newItem.id;
                }

                @Override
                public boolean areContentsTheSame(ResultsItem oldItem, ResultsItem newItem) {
                    return oldItem.equals(newItem);
                }
            };

    class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView imageView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tvName);
            imageView = itemView.findViewById(R.id.imAvatar);
        }
    }
}
