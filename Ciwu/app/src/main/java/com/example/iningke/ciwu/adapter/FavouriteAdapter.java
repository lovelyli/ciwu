package com.example.iningke.ciwu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.basebean.base.BaseAppAdapter;
import com.example.iningke.ciwu.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by iningke on 2016/6/6.
 */

public class FavouriteAdapter extends BaseAppAdapter {
    Context context;
    public FavouriteAdapter(Context context){
        this.context = context;

    }

    @Override
    public int getCount() {
        return 20;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder ;
        if (convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_favourate,null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        return convertView;
    }
    public class ViewHolder{
        public ViewHolder(View view){
            ButterKnife.bind(view);
        }
    }
}
