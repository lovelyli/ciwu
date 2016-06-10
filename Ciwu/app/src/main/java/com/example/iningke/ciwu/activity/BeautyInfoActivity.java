package com.example.iningke.ciwu.activity;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.basebean.base.BaseActivity;
import com.example.iningke.ciwu.R;
import com.example.iningke.ciwu.adapter.BeautyInfoGridAdapter;
import com.example.iningke.ciwu.adapter.BeautyInfoPagerAdapter;
import com.example.iningke.ciwu.view.WrapHeightGridView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class BeautyInfoActivity extends BaseActivity {
    @Bind(R.id.activity_beauty_info_pager)
    ViewPager viewPager;
    @Bind(R.id.activity_beauty_info_gridview)
    WrapHeightGridView gridView;
    @Override
    public void initData() {
        //信息的轮播图
        viewPager.setAdapter(new BeautyInfoPagerAdapter(this));
        //相关美搭的列表
        gridView.setAdapter(new BeautyInfoGridAdapter(this));

    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_beauty_info;
    }

    @Override
    public View setLayoutView() {
        return null;
    }
}
