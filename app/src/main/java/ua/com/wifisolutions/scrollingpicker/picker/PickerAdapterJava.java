package ua.com.wifisolutions.scrollingpicker.picker;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ua.com.wifisolutions.scrollingpicker.R;

public class PickerAdapterJava extends RecyclerView.Adapter<PickerItemViewHolderJava> {

    Callback callback = null;
    Integer selectedItem = -1;
    Context ctx = null;
    private  View.OnClickListener clickListener =  new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            callback.onItemClicked(view);
        }
    };
    private ArrayList<String> data = new ArrayList<>();

    @NonNull
    @Override
    public PickerItemViewHolderJava onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context ctx = parent.getContext();

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_view_picker_item, parent, false);

        itemView.setOnClickListener(clickListener);
        return new PickerItemViewHolderJava(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PickerItemViewHolderJava holder, int position) {
        holder.tvItem.setText(data.get(position));
        holder.itemView.requestLayout();
        if (selectedItem==position)
        {
//            holder.tvBG.setColorFilter(Color.rgb( 255, 255, 255));
//            holder.tvBG.setAlpha(0.6f);
//            holder.tvBG.animate()
//                    .alpha(1.0f)
//                    .setDuration(100)
//                    .setListener(null);

//            holder.tvBG.setAlpha(1f);
//            holder.tvItem.setTypeface(holder.tvItem.getTypeface(), Typeface.BOLD);
            holder.tvItem.setTypeface(null, Typeface.BOLD);

            selectedItem = -1;
        }
        else
        {
//            holder.tvBG.setColorFilter(Color.rgb( 255, 255, 255));
//            holder.tvBG.setAlpha(0.6f);
            holder.tvItem.setTypeface(null, Typeface.NORMAL);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setSelectedItem(Integer position)
    {
        selectedItem = position;
        notifyDataSetChanged();
    }

    public void setData(ArrayList<String> data)
    {
        this.data.clear();
        this.data.addAll(data);
//        this.
        notifyDataSetChanged();
    }

    public void setZero()
    {
        notifyItemChanged(0);
    }

    public interface Callback
    {
        void onItemClicked(View view);
//        on
    }
}
