package ua.com.wifisolutions.scrollingpicker.picker;

import android.content.Context;
import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import static java.lang.Math.abs;

//class PickerLayoutManagerJava extends LinearLayoutManager {
    public class PickerLayoutManagerJava extends CustomLayoutManager {

    private RecyclerView recyclerView;
    OnItemSelectedListener callback = null;

    public PickerLayoutManagerJava(Context context) {
        super(context);
        setOrientation(RecyclerView.HORIZONTAL);
    }

    @Override
    public void onAttachedToWindow(RecyclerView view) {
        super.onAttachedToWindow(view);
        recyclerView=view;
        LinearSnapHelper lsh = new LinearSnapHelper();
        lsh.attachToRecyclerView(recyclerView);
//        LinearSnapHelper.attachToRecyclerView(recyclerView);
    }

    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        super.onLayoutChildren(recycler, state);
//        scaleDownView();
    }

    @Override
    public int scrollHorizontallyBy(int dx, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getOrientation()== RecyclerView.HORIZONTAL)
        {
            int scrolled = super.scrollHorizontallyBy(dx, recycler, state);
//            scaleDownView();
            return scrolled;
        }
        else return 0;

    }

    @Override
    public void onScrollStateChanged(int state) {
        super.onScrollStateChanged(state);
        if (state == RecyclerView.SCROLL_STATE_IDLE) {

            // Find the closest child to the recyclerView center --> this is the selected item.
            int recyclerViewCenterX = this.getRecyclerViewCenterX();
            int minDistance = recyclerView.getWidth();
            int position = -1;
            for (int i = 0; i<recyclerView.getChildCount(); i++)
            {
                View child = recyclerView.getChildAt(i);
                int childCenterX = getDecoratedLeft(child) + (getDecoratedRight(child) - getDecoratedLeft(child)) / 2;
                int newDistance = abs(childCenterX - recyclerViewCenterX);
//                newDistance = newDistance/3;
                if (newDistance < minDistance) {
                    minDistance = newDistance;
                    position = recyclerView.getChildLayoutPosition(child);
                }
            }

            callback.onItemSelected(position);
        }
    }

    private void scaleDownView() {
        int width = recyclerView.getWidth();
        if (width==0) return;
        float mid = recyclerView.getWidth() / 2.0f;
        for (int i=0; i<recyclerView.getChildCount(); i++)
        {
            // Calculating the distance of the child from the center
            View child = recyclerView.getChildAt(i);
//            getDecoratedLeft(child)+getDec
            float childMid = (getDecoratedLeft(child) + getDecoratedRight(child)) / 2.0f;
            float distanceFromCenter = abs(mid - childMid);

            Log.v("test","childmidis"+childMid);

            // The scaling formula
//            if (recyclerView.getWidth()!=0) {
                double doubled = distanceFromCenter / recyclerView.getWidth();
                float sqqo = (float) Math.sqrt(doubled);
                float scale = (float) (1 - sqqo * 0.66f);
//            scale=scale*0.5f;
//            if (i==0)
//            {
                Log.v("hjhk", scale+"scale");
                if (scale==1)
                {
                    child.setAlpha(scale);
                }
                else {
                    child.setAlpha(scale * 0.7f);
                }
//            }

                // Set scale to view
                child.setScaleX(scale);
                child.setScaleY(scale);
//            }
        }
    }

    private int getRecyclerViewCenterX()  {
        return (recyclerView.getRight() - recyclerView.getLeft()) / 2 + recyclerView.getLeft();
    }

    public interface OnItemSelectedListener {
        void onItemSelected(int position);
    }
}
