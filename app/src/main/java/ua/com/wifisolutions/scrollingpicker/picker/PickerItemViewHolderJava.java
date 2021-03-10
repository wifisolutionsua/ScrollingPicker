package ua.com.wifisolutions.scrollingpicker.picker;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ua.com.wifisolutions.scrollingpicker.R;

class PickerItemViewHolderJava extends RecyclerView.ViewHolder {
    TextView tvItem;
    ImageView tvBG;
    public PickerItemViewHolderJava(@NonNull View itemView) {

        super(itemView);
        tvItem = itemView.findViewById(R.id.tv_item);
//        tvBG = itemView.findViewById(R.id.imageView);
    }

    public TextView getTvItem()
    {
        return  tvItem;
    }
    public ImageView getImageView()
    {
        return  tvBG;
    }

}
