package com.example.iningke.ciwu.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.RadioGroup;

import com.example.iningke.ciwu.R;
import com.example.iningke.ciwu.adapter.MyHeadPicAdapter;
import com.example.iningke.ciwu.fragment.base.BasePagerFragment;
import com.example.iningke.ciwu.utils.FixedSpeedScroller;
import com.example.scrollablayoutlib.OnLayoutScrollListener;
import com.example.scrollablayoutlib.ScrollableLayout;
import java.lang.reflect.Field;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;



public class PagerHeaderFragment extends BasePagerFragment {

    private PtrClassicFrameLayout mPtrFrame;
    private ScrollableLayout mScrollLayout;
    private RadioGroup radioGroup;
    private int currentposition = 0 ;
    private ViewPager vpImage;
    private OnLayoutScrollListener listener;
    public void setListener(OnLayoutScrollListener listener){
        this.listener = listener;
    }
    public interface OnScrollChangeListener{
        void onscroll(int cy,int maxy);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View layout = inflater.inflate(R.layout.fragment_pagerheader, container, false);

// 头部图片集
        vpImage = (ViewPager) layout.findViewById(R.id.imagepager);
        vpImage.setAdapter(new MyHeadPicAdapter(getActivity()));
        // ScrollableLayout
        mScrollLayout = (ScrollableLayout) layout.findViewById(R.id.scrollableLayout);
        mScrollLayout.setOnScrollListener(listener);

        ViewPager viewPager = (ViewPager) layout.findViewById(R.id.viewpager);

        TabLayout tabLayout = (TabLayout) layout.findViewById(R.id.item_home_tablelayout);
        initFragmentPager(viewPager,tabLayout,mScrollLayout);

        radioGroup = (RadioGroup) layout.findViewById(R.id.radiogroup);
        radioGroup.check(R.id.vp_page1);
        vpImage.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                checkPosition(position);
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        //修改viewpag的切换速度
        try {
            Field mField = ViewPager.class.getDeclaredField("mScroller");
            mField.setAccessible(true);
            FixedSpeedScroller mScroller = new FixedSpeedScroller(vpImage.getContext(),new AccelerateInterpolator());
            mField.set(vpImage, mScroller);
            mScroller.setmDuration(400);
        } catch (Exception e) {
            e.printStackTrace();
        }
        handler.sendEmptyMessage(1);
        setupPullToRefresh(layout);
        return layout;
    }

    public void checkPosition(int position){
        currentposition = position;
        switch (position){
            case 0:
                radioGroup.check(R.id.vp_page1);
                break;
            case 1:
                radioGroup.check(R.id.vp_page2);
                break;
            case 2:
                radioGroup.check(R.id.vp_page3);
                break;
            case 3:
                radioGroup.check(R.id.vp_page4);
                break;
        }
    }

    public void updateLunbo(){
        if (currentposition==4){
            currentposition = 0;
        }else {
            currentposition++;
        }
        try {
            vpImage.setCurrentItem(currentposition);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    updateLunbo();
                    handler.removeCallbacks(runnable);
                    handler.postDelayed(runnable,2800);
                    break;
            }
            return false;
        }
    });
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            handler.sendEmptyMessage(1);
        }
    };



    private void setupPullToRefresh(View layout) {
        mPtrFrame = (PtrClassicFrameLayout) layout.findViewById(R.id.rotate_header_web_view_frame);
        mPtrFrame.setLastUpdateTimeRelateObject(this);
        mPtrFrame.setPtrHandler(new PtrHandler() {
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return mScrollLayout.canPtr();
//                return PtrDefaultHandler.checkContentCanBePulledDown(frame, mScrollLayout, header);
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                //TODO 列表的下拉刷新
                mPtrFrame.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mPtrFrame.refreshComplete();
                    }
                }, 1000);
            }
        });

        // the following are default settings
        mPtrFrame.setResistance(1.7f);
        mPtrFrame.setRatioOfHeaderHeightToRefresh(1.2f);
        mPtrFrame.setDurationToClose(200);
        mPtrFrame.setDurationToCloseHeader(1000);
        // default is false
        mPtrFrame.setPullToRefresh(false);
        // default is true
        mPtrFrame.setKeepHeaderWhenRefresh(true);
//        mPtrFrame.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                mPtrFrame.autoRefresh();
//            }
//        }, 100);
    }
    public void setTTHeight(int height){
        if (mScrollLayout!=null){
            mScrollLayout.setTTHeight(height);
        }
    }
}
