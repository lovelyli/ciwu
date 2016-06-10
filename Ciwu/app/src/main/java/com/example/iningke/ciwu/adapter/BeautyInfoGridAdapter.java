package com.example.iningke.ciwu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.basebean.base.BaseAppAdapter;
import com.example.iningke.ciwu.R;

/**
 * Created by iningke on 2016/6/7.
 */

public class BeautyInfoGridAdapter extends BaseAppAdapter {
    LayoutInflater inflater;
    public BeautyInfoGridAdapter(Context context){
        inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return 15;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.item_beauty_gridlist,null);
        return convertView;
    }
}
