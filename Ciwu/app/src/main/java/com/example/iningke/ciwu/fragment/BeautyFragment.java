package com.example.iningke.ciwu.fragment;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.TextView;

import com.example.basebean.base.BaseFragment;
import com.example.iningke.ciwu.R;
import com.example.iningke.ciwu.activity.BeautyInfoActivity;
import com.example.iningke.ciwu.adapter.BeautyAdapter;
import com.example.iningke.ciwu.impl.RecyclerClickListener;
import com.example.iningke.ciwu.utils.SpacesItemDecoration;

/**
 * Created by iningke on 2016/6/8.
 */

public class BeautyFragment extends BaseFragment implements RecyclerClickListener {
    RecyclerView recyclerView;
    TextView title;
    @Override
    public void initData(View view) {
        title.setText("美搭");

        //设置layoutManager
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        //设置adapter
        BeautyAdapter adapter=new BeautyAdapter();
        adapter.setListener(this);
        recyclerView.setAdapter(adapter);
        //设置item之间的间隔
        SpacesItemDecoration decoration=new SpacesItemDecoration(16);
        recyclerView.addItemDecoration(decoration);


    }

    @Override
    public void initView(View view) {
        recyclerView= (RecyclerView) view.findViewById(R.id.recycler);
        title = (TextView) view.findViewById(R.id.title_tv);
    }

    @Override
    public int setLayoutId() {
        return R.layout.fragment_beauty;
    }

    @Override
    public void onItemClick(View view, int postion) {
        gotoActivity(BeautyInfoActivity.class,null);
    }

    @Override
    public void onItemSubViewClick(View view, int postion) {

    }
}
