package com.app2u.app2udemo.commons.view.uicomponents;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;

import com.app2u.app2udemo.R;
import com.app2u.app2udemo.commons.utils.DisplayUtils;

public class ButtonWithImageAndText extends LinearLayout {
    private static final int DEFAULT_COLOR = 0;
    private static final int FONT = R.font.montserrat;
    private static final int TEXT_COLOR = R.color.black;
    private static final int TEXT_SIZE = 12;
    private static final int MAX_ICON_WIDTH = 30;
    private static final int MAX_CERCLE_WIDTH = 55;
    private static final int TEXT_VIEW_TOP_MARGIN = 3;

    public ButtonWithImageAndText(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.buttonTextBottomAttributes);
        if (attributes != null) {
            Drawable image = attributes.getDrawable(R.styleable.buttonTextBottomAttributes_top_image);
            int color = attributes.getColor(R.styleable.buttonTextBottomAttributes_color, DEFAULT_COLOR);
            String text = attributes.getString(R.styleable.buttonTextBottomAttributes_bottom_text);
            draw(text, image, color);
        }
    }

    private void draw(String text, Drawable image, int color) {
        setGravity(Gravity.CENTER);
        setOrientation(VERTICAL);
        setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        TextView textViewButton = generateTextView(text);
        LinearLayout cercleButton = generateCercleButton(color, image);

        this.addView(cercleButton);
        if (textViewButton != null) {
            this.addView(textViewButton);
        }
    }

    private LinearLayout generateCercleButton(int color, Drawable image) {
        LinearLayout cercleButton = new LinearLayout(getContext());
        ImageView imageIcon = generateImageView(image);
        //wait until imageView has height and width attributes (drawed)
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                getViewTreeObserver().removeOnGlobalLayoutListener(this);
                cercleButton.getLayoutParams().height = DisplayUtils.dpToPx(color != DEFAULT_COLOR ? MAX_CERCLE_WIDTH : MAX_ICON_WIDTH, getContext());
                cercleButton.getLayoutParams().width = DisplayUtils.dpToPx(color != DEFAULT_COLOR ? MAX_CERCLE_WIDTH : MAX_ICON_WIDTH, getContext());
                cercleButton.requestLayout();
            }
        });
        cercleButton.setGravity(Gravity.CENTER);
        if (color != DEFAULT_COLOR) {
            GradientDrawable backGroundShape = generateBackgroundShape(color);
            cercleButton.setBackground(backGroundShape);
        }
        cercleButton.addView(imageIcon);
        return cercleButton;
    }

    private GradientDrawable generateBackgroundShape(int color) {
        GradientDrawable shape = new GradientDrawable();
        shape.setShape(GradientDrawable.OVAL);
        shape.setColor(color);
        return shape;
    }

    private TextView generateTextView(String text) {
        TextView textView = null;
        if (!TextUtils.isEmpty(text)) {
            textView = new TextView(getContext());
            LinearLayout.LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            params.setMargins(0, DisplayUtils.dpToPx(TEXT_VIEW_TOP_MARGIN, getContext()), 0, 0);
            textView.setLayoutParams(params);
            textView.setTextColor(getContext().getResources().getColor(R.color.black));
            textView.setText(text);
            textView.setGravity(Gravity.CENTER);
            textView.setTypeface(ResourcesCompat.getFont(getContext(), FONT));
            textView.setTextColor(getResources().getColor(TEXT_COLOR));
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, TEXT_SIZE);
        }
        return textView;
    }

    private ImageView generateImageView(Drawable image) {
        ImageView imageView = new ImageView(getContext());
        imageView.setImageDrawable(image);
        //wait until imageView has height and width attributes (drawed)
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                getViewTreeObserver().removeOnGlobalLayoutListener(this);
                imageView.getLayoutParams().height = DisplayUtils.dpToPx(MAX_ICON_WIDTH, getContext());
                imageView.getLayoutParams().width = DisplayUtils.dpToPx(MAX_ICON_WIDTH, getContext());
                imageView.requestLayout();
            }
        });
        return imageView;
    }
}
