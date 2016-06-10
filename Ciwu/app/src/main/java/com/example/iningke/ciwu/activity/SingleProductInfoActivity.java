package com.example.iningke.ciwu.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.basebean.base.BaseActivity;
import com.example.iningke.ciwu.R;
import com.example.iningke.ciwu.adapter.MyHeadPicAdapter;
import com.example.iningke.ciwu.adapter.SingleInfoGridAdapter;
import com.example.iningke.ciwu.adapter.SingleInfoRecyclerAdapter;
import com.example.iningke.ciwu.impl.ScrollViewListener;
import com.example.iningke.ciwu.view.ObservableScrollView;
import com.example.iningke.ciwu.view.WrapHeightGridView;
import com.lsjwzh.widget.recyclerviewpager.RecyclerViewPager;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SingleProductInfoActivity extends BaseActivity implements ScrollViewListener {
    @Bind(R.id.rl_title_item_container)
    RelativeLayout title_container;
    @Bind(R.id.single_info_viewpager)
    ViewPager info_pager;
    @Bind(R.id.submit_iv)
    ImageView submit_iv;
    @Bind(R.id.back_iv)
    ImageView back_iv;
    @Bind(R.id.recycler_viewpager)
    RecyclerViewPager mRecyclerView;
    @Bind(R.id.single_info_gride)
    WrapHeightGridView gridView;
    @Bind(R.id.single_info_scrollview)
    ObservableScrollView scrollingView;
    @Bind(R.id.title_text)
    TextView title_text;

    private int pagerHeight;
    private int titleHeight;
    @Override
    public void initData() {

        info_pager.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                pagerHeight = info_pager.getHeight();
            }
        });
        title_container.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                titleHeight = title_container.getHeight();
            }
        });

        scrollingView.setScrollViewListener(this);

        //相关单品的列表
        gridView.setAdapter(new SingleInfoGridAdapter(this));
        //信息的轮播图
        info_pager.setAdapter(new MyHeadPicAdapter(this));
        //相关合集的画廊列表
        LinearLayoutManager layout = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        mRecyclerView.setLayoutManager(layout);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(new SingleInfoRecyclerAdapter(this));
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int scrollState) {
//                updateState(scrollState);
            }
            @Override
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
////                mPositionText.setText("First: " + mRecyclerViewPager.getFirstVisiblePosition());
//                int childCount = mRecyclerView.getChildCount();
//                int width = mRecyclerView.getChildAt(0).getWidth();
//                int padding = (mRecyclerView.getWidth() - width) / 2;
////                mCountText.setText("Count: " + childCount);
//
//                for (int j = 0; j < childCount; j++) {
//                    View v = recyclerView.getChildAt(j);
//                    //往左 从 padding 到 -(v.getWidth()-padding) 的过程中，由大到小
//                    float rate = 0;
//                    ;
//                    if (v.getLeft() <= padding) {
//                        if (v.getLeft() >= padding - v.getWidth()) {
//                            rate = (padding - v.getLeft()) * 1f / v.getWidth();
//                        } else {
//                            rate = 1;
//                        }
//                        v.setScaleY(1 - rate * 0.1f);
//                        v.setScaleX(1 - rate * 0.1f);
//
//                    } else {
//                        //往右 从 padding 到 recyclerView.getWidth()-padding 的过程中，由大到小
//                        if (v.getLeft() <= recyclerView.getWidth() - padding) {
//                            rate = (recyclerView.getWidth() - padding - v.getLeft()) * 1f / v.getWidth();
//                        }
//                        v.setScaleY(0.9f + rate * 0.1f);
//                        v.setScaleX(0.9f + rate * 0.1f);
//                    }
//                }
            }
        });
        mRecyclerView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
//                if (mRecyclerView.getChildCount() < 3) {
//                    if (mRecyclerView.getChildAt(1) != null) {
//                        if (mRecyclerView.getCurrentPosition() == 0) {
//                            View v1 = mRecyclerView.getChildAt(1);
//                            v1.setScaleY(0.9f);
//                            v1.setScaleX(0.9f);
//                        } else {
//                            View v1 = mRecyclerView.getChildAt(0);
//                            v1.setScaleY(0.9f);
//                            v1.setScaleX(0.9f);
//                        }
//                    }
//                } else {
//                    if (mRecyclerView.getChildAt(0) != null) {
//                        View v0 = mRecyclerView.getChildAt(0);
//                        v0.setScaleY(0.9f);
//                        v0.setScaleX(0.9f);
//                    }
//                    if (mRecyclerView.getChildAt(2) != null) {
//                        View v2 = mRecyclerView.getChildAt(2);
//                        v2.setScaleY(0.9f);
//                        v2.setScaleX(0.9f);
//                    }
//                }
            }
        });

    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        submit_iv.setVisibility(View.VISIBLE);
        Picasso.with(this).load(R.drawable.icon_share).into(submit_iv);
        Picasso.with(this).load(R.drawable.icon_back).into(back_iv);

    }
    @OnClick({R.id.rl_back})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.rl_back:
                finish();
                break;
        }
    }


    /**
     * ObservableScrollView的监听器
     * @param scrollView
     * @param x
     * @param y
     * @param oldx
     * @param oldy
     */
    @Override
    public void onScrollChanged(ScrollView scrollView, int x, int y, int oldx, int oldy) {
        if (title_text==null||title_container==null){
            return;
        }
        if (titleHeight!=0&&pagerHeight!=0){
            if (y<=pagerHeight-titleHeight){
                //TODO 隐藏
                title_text.setVisibility(View.GONE);
                title_container.setBackgroundColor(getResources().getColor(R.color.transparent));
            }else {
                //TODO 显示
                title_text.setVisibility(View.VISIBLE);
                title_container.setBackgroundColor(getResources().getColor(R.color.white));
            }
        }
    }


    @Override
    public int setLayoutId() {
        return R.layout.activity_single_product_info;
    }

    @Override
    public View setLayoutView() {
        return null;
    }


}
