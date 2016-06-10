package com.example.iningke.ciwu.fragment;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.basebean.base.BaseFragment;
import com.example.iningke.ciwu.R;
import com.example.iningke.ciwu.activity.SingleProductInfoActivity;
import com.example.iningke.ciwu.adapter.SinglePListAdapter;
import com.example.scrollablayoutlib.OnLayoutScrollListener;

/**
 * Created by iningke on 2016/6/7.
 */

public class SinglePListFragment extends BaseFragment implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener {
    GridView listView;
    OnLayoutScrollListener listener;

    public void setListener(OnLayoutScrollListener listener) {
        this.listener = listener;
    }

    @Override
    public void initData(View view) {
        listView.setAdapter(new SinglePListAdapter(getActivity()));
    }

    @Override
    public void initView(View view) {
        listView = (GridView) view.findViewById(R.id.ff_gridview);
        listView.setOnScrollListener(this);
        listView.setOnItemClickListener(this);
    }

    @Override
    public int setLayoutId() {
        return R.layout.fragment_singlelist;
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }
    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
//        if (listener!=null){
//            if (view.getScrollY()<0){
//                //向下
//                listener.onUpDown(false);
//            }else {
//                //向上
//                listener.onUpDown(true);
//            }
//        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        gotoActivity(SingleProductInfoActivity.class,null);
    }
}
