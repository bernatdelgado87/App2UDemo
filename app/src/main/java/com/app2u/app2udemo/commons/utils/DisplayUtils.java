package com.app2u.app2udemo.commons.utils;

import android.content.Context;
import android.util.TypedValue;

public class DisplayUtils {
    public static int dpToPx(int value, Context context) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, context.getResources().getDisplayMetrics());
    }
}
