package com.example.iningke.ciwu.fragment.base;/**
 * Created by cpoopc on 2015/9/15.
 */

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.iningke.ciwu.adapter.MyFragmentPagerAdapter;
import com.example.iningke.ciwu.fragment.ListFragment;
import com.example.scrollablayoutlib.ScrollableLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * User: cpoopc
 * Date: 2015-09-15
 * Time: 10:31
 * Ver.: 0.1
 */
public abstract class BasePagerFragment extends Fragment{
    private String[] mTitle=new String[]{"最新","生活","吃货","穿搭","鞋包","爱美","饰品","礼物","数码","动漫","运动","母婴","读书"};
//    public void initFragmentPager(ViewPager viewPager, PagerSlidingTabStrip pagerSlidingTabStrip, final ScrollableLayout mScrollLayout) {
//        //TODO 此处设置标题和列表加载
//        final ArrayList<ScrollAbleFragment> fragmentList = new ArrayList<>();
//        List<String> titleList = new ArrayList<>();
//        for (int i = 0 ; i < mTitle.length;i++){
//            titleList.add(mTitle[i]);
//            fragmentList.add(ListFragment.newInstance());
//        }
//        viewPager.setAdapter(new MyFragmentPagerAdapter(getChildFragmentManager(), fragmentList, titleList));
//        mScrollLayout.getHelper().setCurrentScrollableContainer(fragmentList.get(0));
//        pagerSlidingTabStrip.setViewPager(viewPager);
//        pagerSlidingTabStrip.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int i, float v, int i2) {
//
//            }
//
//            @Override
//            public void onPageSelected(int i) {
//                Log.e("onPageSelected", "page:" + i);
//                /** 标注当前页面 **/
//                mScrollLayout.getHelper().setCurrentScrollableContainer(fragmentList.get(i));
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int i) {
//
//            }
//        });
//        viewPager.setCurrentItem(0);
//    }
    public void initFragmentPager(ViewPager viewPager, TabLayout tabLayout, final ScrollableLayout mScrollLayout) {
        //TODO 此处设置标题和列表加载
        final ArrayList<ScrollAbleFragment> fragmentList = new ArrayList<>();
        List<String> titleList = new ArrayList<>();
        for (int i = 0 ; i < mTitle.length;i++){
            titleList.add(mTitle[i]);
            fragmentList.add(ListFragment.newInstance());
        }
        viewPager.setOffscreenPageLimit(12);
        viewPager.setAdapter(new MyFragmentPagerAdapter(getChildFragmentManager(), fragmentList, titleList));
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mScrollLayout.getHelper().setCurrentScrollableContainer(fragmentList.get(position));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mScrollLayout.getHelper().setCurrentScrollableContainer(fragmentList.get(0));

        tabLayout.setupWithViewPager(viewPager);
        //TODO 此处设置选项卡的点击事件
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
//                UIUtils.showToastSafe(tab.getText());
//                LogUtils.e(tab.getText().toString());
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










}
