package com.example.iningke.ciwu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.iningke.ciwu.R;
import java.util.List;

/**
 * Created by cpoopc on 2015-02-10.
 */
public class MyAdapter extends BaseAdapter {

    private List<String> strList;
    private Context mContext;

    public MyAdapter( Context mContext,List<String> strList) {
        this.strList = strList;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return strList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(mContext).inflate(R.layout.fragment_homelist_item, null, false);
        TextView tv = (TextView) convertView.findViewById(R.id.list_item_tv);
        tv.setText("当前第"+position+"个");
        return convertView;
    }
}
