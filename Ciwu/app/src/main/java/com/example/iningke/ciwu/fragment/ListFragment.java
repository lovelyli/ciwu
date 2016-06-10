package com.example.iningke.ciwu.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;
import com.example.iningke.ciwu.R;
import com.example.iningke.ciwu.adapter.MyAdapter;
import com.example.iningke.ciwu.fragment.base.ScrollAbleFragment;
import com.example.iningke.ciwu.xlistview.XListView;
import com.example.scrollablayoutlib.ScrollableHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListFragment extends ScrollAbleFragment implements ScrollableHelper.ScrollableContainer{

    private XListView mListview;

    public static ListFragment newInstance() {
        ListFragment listFragment = new ListFragment();
        return listFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_homelist, container, false);
        mListview = (XListView) view.findViewById(R.id.listview);
        mListview.setPullLoadEnable(true);
        mListview.setPullRefreshEnable(false);
        mListview.removeHeaderView(mListview.getmHeaderView());
        //TODO  此处设置数据源
        List<String> strlist = new ArrayList<String>();
        for (int i = 0; i < new Random().nextInt(100) + 31; i++) {
            strlist.add(String.valueOf(i));
        }
        mListview.setAdapter(new MyAdapter(getActivity(), strlist));
        mListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "点击item" + position, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    @Override
    public View getScrollableView() {
        return mListview;
    }
}
