package com.example.iningke.ciwu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.iningke.ciwu.R;
import com.example.iningke.ciwu.holder.SimpleInfoHolder;

/**
 * Created by iningke on 2016/6/8.
 */

public class SingleInfoRecyclerAdapter extends RecyclerView.Adapter<SimpleInfoHolder> {

    Context context;
    public SingleInfoRecyclerAdapter(Context context){
        this.context = context;
    }

    @Override
    public SimpleInfoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_imagview,null);
        SimpleInfoHolder holder = new SimpleInfoHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(SimpleInfoHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
