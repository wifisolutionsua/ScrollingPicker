package ua.com.wifisolutions.scrollingpicker.picker;

import android.content.Context;
import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class initPickerJava {
    public static void setPicker(final RecyclerView rvHorizontalPicker, final PickerAdapterJava sliderAdapter, Context context, final ArrayList<String> data)
    {
        int padding =
            ScreenUtilsJava.getScreenWidth(context) / 2 - ScreenUtilsJava.dpToPx(context, 40);
        rvHorizontalPicker.setPadding(padding, 0, padding, 0);




        PickerLayoutManagerJava pickerLayoutManagerJava = new PickerLayoutManagerJava(context);
        pickerLayoutManagerJava.callback=new PickerLayoutManagerJava.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int position) {
                sliderAdapter.setSelectedItem(position);
                Log.d("selected text", data.get(position));
            }
        };
        rvHorizontalPicker.setLayoutManager(pickerLayoutManagerJava);

        sliderAdapter.setData(data);
        sliderAdapter.callback = new PickerAdapterJava.Callback() {
            @Override
            public void onItemClicked(View view) {
                rvHorizontalPicker.smoothScrollToPosition(
                        rvHorizontalPicker.getChildLayoutPosition(view)
                );
            }
        };
        rvHorizontalPicker.setAdapter(sliderAdapter);
//        sliderAdapter.setSelectedItem(1);
//        sliderAdapter.notifyItemChanged(0);
        pickerLayoutManagerJava.smoothScrollToPosition(rvHorizontalPicker, new RecyclerView.State(), 0);

    }
}
