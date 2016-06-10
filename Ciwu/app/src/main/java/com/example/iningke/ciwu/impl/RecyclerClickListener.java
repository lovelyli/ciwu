package com.example.iningke.ciwu.impl;

import android.view.View;

/**
 * Created by iningke on 2016/6/8.
 */

public interface RecyclerClickListener {
    /**
     * Item 普通点击
     */

    public void onItemClick(View view, int postion);

/**
 * Item 内部View点击
 */

    public void onItemSubViewClick(View view, int postion);
}
