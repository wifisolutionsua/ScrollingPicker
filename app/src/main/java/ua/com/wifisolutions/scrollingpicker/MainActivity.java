package ua.com.wifisolutions.scrollingpicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import ua.com.wifisolutions.scrollingpicker.picker.PickerAdapterJava;

import static ua.com.wifisolutions.scrollingpicker.picker.initPickerJava.setPicker;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvHorizontalPicker;
    private PickerAdapterJava sliderAdapter;
    private ArrayList<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = new ArrayList<>();
        data.add("");
        data.add("Signal");
        data.add("Speed");
        data.add("Ping");
        data.add("Interfering");
        data.add("AP #");
        data.add("Best AP");
        rvHorizontalPicker = findViewById(R.id.rv_horizontal_picker);
        sliderAdapter = new PickerAdapterJava();
        setPicker(rvHorizontalPicker,sliderAdapter,getApplicationContext(),data);
        rvHorizontalPicker.setItemViewCacheSize(10);
    }
}