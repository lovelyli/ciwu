package com.example.iningke.ciwu.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.example.basebean.base.BaseFragment;
import com.example.basebean.base.utils.PopoupUtils;
import com.example.iningke.ciwu.R;
import com.example.iningke.ciwu.adapter.SinglePagerAdapter;
import com.example.iningke.ciwu.utils.ScreenUtils;
import com.example.iningke.ciwu.utils.ViewUtils;
import com.example.scrollablayoutlib.OnLayoutScrollListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by iningke on 2016/6/7.
 */

public class SingleProductFragment extends BaseFragment implements View.OnClickListener {
    private String[] mTitle=new String[]{"最新","生活","吃货","穿搭","鞋包","爱美","饰品","礼物","数码","动漫","运动","母婴","读书"};
    ImageView iv_sort;
    RelativeLayout rl_submit;
    ViewPager viewPager;
    TabLayout tabLayout;
    RelativeLayout singel_title_container;
    private OnLayoutScrollListener listener;

    public void setListener(OnLayoutScrollListener listener) {
        this.listener = listener;
    }

    @Override
    public void initData(View view) {
        Picasso.with(getActivity()).load(R.drawable.icon_sort).into(iv_sort);
        iv_sort.setVisibility(View.VISIBLE);
        initTabAndFragment();
    }

    @Override
    public void initView(View view) {
        iv_sort = (ImageView) view.findViewById(R.id.submit_iv);
        rl_submit = (RelativeLayout) view.findViewById(R.id.rl_submit);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        tabLayout = (TabLayout) view.findViewById(R.id.item_home_tablelayout);
        singel_title_container = (RelativeLayout) view.findViewById(R.id.singel_title_container);
    }

    @Override
    public int setLayoutId() {
        return R.layout.fragment_singleproduct;
    }

    @Override
    public void addListener() {
        super.addListener();
        rl_submit.setOnClickListener(this);
    }

    public void initTabAndFragment(){
        final ArrayList<Fragment> fragmentList = new ArrayList<>();
        List<String> titleList = new ArrayList<>();
        for (int i = 0 ; i < mTitle.length;i++){
            titleList.add(mTitle[i]);
            SinglePListFragment fragment = new SinglePListFragment();
            fragment.setListener(listener);
            fragmentList.add(fragment);
        }
        viewPager.setAdapter(new SinglePagerAdapter(getChildFragmentManager(), fragmentList, titleList));
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        tabLayout.setupWithViewPager(viewPager);
        //TODO 此处设置选项卡的点击事件
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.setCurrentItem(0);
    }
    PopupWindow popupWindow;
    RadioGroup group;
    LinearLayout ll_normal,ll_low2h,ll_h2low;
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rl_submit:
                if(popupWindow==null){
                    popupWindow = PopoupUtils.initPop(getActivity(), R.layout.item_single_pop, 0, 0);
                    View view = popupWindow.getContentView();
                    group = (RadioGroup) view.findViewById(R.id.item_single_pop_group);
                    view.findViewById(R.id.item_single_pop_container).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (popupWindow!=null&&popupWindow.isShowing()){
                                popupWindow.dismiss();
                            }
                        }
                    });
                    ll_normal = (LinearLayout) view.findViewById(R.id.item_single_pop_normal);
                    ll_normal.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            changeTab(R.id.item_single_pop_normal);
//                            if (popupWindow!=null&&popupWindow.isShowing()){
//                                popupWindow.dismiss();
//                            }
                        }
                    });
                    ll_h2low = (LinearLayout) view.findViewById(R.id.item_single_pop_h2low);
                    ll_h2low.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            changeTab(R.id.item_single_pop_h2low);
//                            if (popupWindow!=null&&popupWindow.isShowing()){
//                                popupWindow.dismiss();
//                            }
                        }
                    });
                    ll_low2h = (LinearLayout) view.findViewById(R.id.item_single_pop_low2h);
                    ll_low2h.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            changeTab(R.id.item_single_pop_low2h);
//                            if (popupWindow!=null&&popupWindow.isShowing()){
//                                popupWindow.dismiss();
//                            }
                        }
                    });
                }
                showPP();
                break;
        }
    }
    public void showPP(){
        if (popupWindow.isShowing()){
            popupWindow.dismiss();
        }else {
            popupWindow.showAsDropDown(singel_title_container,0, 0);
        }
    }
    /**
     * 底部选项卡切换
     */
    public void changeTab(int id){
        ll_normal.setSelected(id==ll_normal.getId()?true:false);
        ll_low2h.setSelected(id==ll_low2h.getId()?true:false);
        ll_h2low.setSelected(id==ll_h2low.getId()?true:false);
    }
}
