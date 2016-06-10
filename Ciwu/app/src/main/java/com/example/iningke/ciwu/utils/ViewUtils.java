package com.example.iningke.ciwu.utils;

import android.content.Context;
import android.view.View;

/**
 * Created by iningke on 2016/6/4.
 */

public class ViewUtils {
    public static void setViewVisbleVG(View view,boolean flag){
        view.setVisibility(flag?View.VISIBLE:View.GONE);
    }
    public static void setViewVisbleVI(View view,boolean flag){
        view.setVisibility(flag?View.VISIBLE:View.INVISIBLE);
    }




    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
