package ua.com.wifisolutions.scrollingpicker.picker;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.WindowManager;

import static android.content.Context.WINDOW_SERVICE;

class ScreenUtilsJava {

    public static int dpToPx(Context context, int value) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, (float) value, context.getResources().getDisplayMetrics());
    }

    public static int getScreenWidth(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(dm);
        }
        return  dm.widthPixels;
    }

}
