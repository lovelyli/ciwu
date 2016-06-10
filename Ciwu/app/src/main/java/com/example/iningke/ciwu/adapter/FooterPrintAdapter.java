package com.example.iningke.ciwu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.basebean.base.BaseAppAdapter;
import com.example.iningke.ciwu.R;

/**
 * Created by iningke on 2016/6/7.
 */

public class FooterPrintAdapter extends BaseAppAdapter {
    private final Context context;

    public FooterPrintAdapter(Context context){
        this.context = context;
    }
    @Override
    public int getCount() {
        return 15;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.item_footer,null);
        return convertView;
    }
}
