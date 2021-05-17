package com.app2u.app2udemo.commons.view.uicomponents;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatImageView;

import com.app2u.app2udemo.R;

public class ProcessToolbar extends LinearLayout {
    private LinearLayout backButton;
    private AppCompatImageView backButtonImage;

    public ProcessToolbar(Context context) {
        super(context);
        this.init();
    }


    public ProcessToolbar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.init();
    }

    public ProcessToolbar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ProcessToolbar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.init();
    }

    private void init(){
        inflate(this.getContext(), R.layout.top_bar, this);
        this.backButton = this.findViewById(R.id.back_buton_process_activity);
        this.backButtonImage = this.findViewById(R.id.icon_top_icon_back);
    }

    public LinearLayout getBackButton(){
        return backButton;
    }

}
