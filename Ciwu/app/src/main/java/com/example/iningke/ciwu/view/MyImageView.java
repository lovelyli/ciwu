package com.example.iningke.ciwu.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by iningke on 2016/6/6.
 */

public class MyImageView extends ImageView {

    public MyImageView(Context context) {
        super(context);
    }

    public MyImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            int width = MeasureSpec.getSize(widthMeasureSpec);
            int diw = drawable.getIntrinsicWidth();
            if (diw > 0) {
                int height = width * drawable.getIntrinsicHeight() / diw;
                setMeasuredDimension(width, height);
            }
            else {
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            }
        }
        else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }
}
