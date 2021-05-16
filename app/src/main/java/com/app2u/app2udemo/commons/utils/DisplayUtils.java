package com.app2u.app2udemo.commons.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;

import com.app2u.app2udemo.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;

public class DisplayUtils {
    public static int dpToPx(int value, Context context) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, context.getResources().getDisplayMetrics());
    }

    public static void setImageCachedFromUrl(ImageView imageView, String url, Context applicationContext) {
        RequestOptions requestOptions = new RequestOptions();
        if (!TextUtils.isEmpty(url)) {
            Glide.with(applicationContext)
                    .load(url)
                    .apply(requestOptions)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .placeholder(R.drawable.place_holder)
                    .into(imageView);
        }
    }

    //adjust the height of view in percent of screen. If adjustWith == true it adjust also width in percent of screen
    public static void adjustViewInPercentScreenSize(double percent, Context context, View view, boolean adjustWitdth) {
        if (context != null) {
            android.view.Display display = ((android.view.WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
            view.getLayoutParams().height = (int) (display.getHeight() * percent);
            ;
            if (adjustWitdth) view.getLayoutParams().width = (int) (display.getHeight() * percent);
            ;
            view.requestLayout();
        }
    }

    public static int getPercentScreenSize(double percent, Context context) {
        android.view.Display display = ((android.view.WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        return (int) (display.getHeight() * percent);
    }
}
