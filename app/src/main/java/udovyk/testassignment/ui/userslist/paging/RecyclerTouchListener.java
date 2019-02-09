package udovyk.testassignment.ui.userslist.paging;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class RecyclerTouchListener extends GestureDetector.SimpleOnGestureListener implements RecyclerView.OnItemTouchListener {

    private Context context;

    public RecyclerTouchListener(Context context) {
        this.context = context;

    }

    private GestureDetector gestureDetector = new GestureDetector(context, this);
    public ClickListener listener = null;
    private RecyclerView rv = null;

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        View child = rv.findChildViewUnder(e.getX(), e.getY());
        if (child != null && listener != null && rv != null) {
            listener.onLongPress(rv.getChildAdapterPosition(child), child);
        }
    }

    @Override
    public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
        View child = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
        if (child != null && listener != null && gestureDetector.onTouchEvent(motionEvent)) {
            listener.onPress(recyclerView.getChildAdapterPosition(child), child);
        }

        return false;
    }

    @Override
    public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean b) {

    }

    public interface ClickListener {
        void onPress(int position, View view);

        void onLongPress(int position, View view);
    }
}
