package ua.com.wifisolutions.scrollingpicker.picker;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ScrollingPicker extends RecyclerView {

    ScrollingPicker picker;
    public static ScrollingPicker rvHorizontalPicker;
    private PickerAdapterJava msliderAdapter;
    private ArrayList<String> data;


//    public ll(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr

    public ScrollingPicker(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context);
        rvHorizontalPicker =this;
        data = new ArrayList<>();
        data.add("Signal");
        data.add("Speed");
        data.add("Ping");
        data.add("Interfering");
        data.add("AP #");
        data.add("Best AP");
//        rvHorizontalPicker = findViewById(R.id.rv_horizontal_picker);
        msliderAdapter = new PickerAdapterJava();
        picker = rvHorizontalPicker;
        int padding =
                ScreenUtilsJava.getScreenWidth(context) / 2 - ScreenUtilsJava.dpToPx(context, 40);
        picker.setPadding(padding, 0, padding, 0);




        PickerLayoutManagerJava pickerLayoutManagerJava = new PickerLayoutManagerJava(context);
        pickerLayoutManagerJava.callback=new PickerLayoutManagerJava.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int position) {
                msliderAdapter.setSelectedItem(position);
                Log.d("selected text", data.get(position));
            }
        };
        picker.setLayoutManager(pickerLayoutManagerJava);

        msliderAdapter.setData(data);
        msliderAdapter.callback = new PickerAdapterJava.Callback() {
            @Override
            public void onItemClicked(View view) {
                picker.smoothScrollToPosition(
                        picker.getChildLayoutPosition(view)
                );
            }
        };
        picker.setAdapter(msliderAdapter);
        pickerLayoutManagerJava.smoothScrollToPosition(picker, new State(), 0);

    }

    public static ScrollingPicker getPicker()
    {
        return rvHorizontalPicker;
    }
}
