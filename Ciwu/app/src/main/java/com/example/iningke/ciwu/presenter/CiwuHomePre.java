package com.example.iningke.ciwu.presenter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.basebean.base.BaseFragment;
import com.example.basebean.base.BasePre;
import com.example.iningke.ciwu.fragment.BeautyFragment;
import com.example.iningke.ciwu.fragment.PagerHeaderFragment;
import com.example.iningke.ciwu.fragment.PersonCenterFragment;
import com.example.iningke.ciwu.fragment.SingleProductFragment;
import com.example.scrollablayoutlib.OnLayoutScrollListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iningke on 2016/6/4.
 */

public class CiwuHomePre extends BasePre{
    private List<Fragment> fragmentList = new ArrayList<>();

    /**
     * 初始化fragment
     * @param fm
     * @param layId
     * @param listener
     */
    public void initFragments(FragmentManager fm, int layId,OnLayoutScrollListener listener){
        fragmentList.add(new PagerHeaderFragment());
        fragmentList.add(new SingleProductFragment());
        fragmentList.add(new PagerHeaderFragment());
        fragmentList.add(new BeautyFragment());
        fragmentList.add(new PersonCenterFragment());
        for (int i = 0 ; i <fragmentList.size();i++){
            Fragment fragment = fragmentList.get(i);
            fm.beginTransaction().add(layId,fragment).commit();
            if (fragment instanceof PagerHeaderFragment){
                ((PagerHeaderFragment) fragment).setListener(listener);
            }
            if (fragment instanceof SingleProductFragment){
                ((SingleProductFragment) fragment).setListener(listener);
            }
        }
        setFragmentShow(fm,0);
    }

    /**
     * 使某一个fragment显示
     * @param fm
     * @param position
     */
    public void setFragmentShow(FragmentManager fm,int position){
        for (int i = 0 ; i <fragmentList.size();i++){
            if (i==position){
                fm.beginTransaction().show(fragmentList.get(i)).commit();
            }else {
                fm.beginTransaction().hide(fragmentList.get(i)).commit();
            }
        }
    }


    /**
     * 设置搜索栏的高度
     */
    public void setTTHeight(int ttheight){
        if (fragmentList==null)
            return;
        for (int i = 0 ; i <fragmentList.size();i++){
            Fragment fragment = fragmentList.get(i);
            if (fragment instanceof PagerHeaderFragment){
                ((PagerHeaderFragment) fragment).setTTHeight(ttheight);
            }
        }
    }

    /**
     * 底部导航栏的动画
     */
    public void showGroup(RadioGroup radioGroup,boolean isShowing){
        if (isShowing)
            return;
        TranslateAnimation animation = new TranslateAnimation(0,0,0,radioGroup.getHeight());
        animation.setDuration(400);
        animation.setFillAfter(true);
        radioGroup.setAnimation(animation);
        radioGroup.startAnimation(animation);
    }
    public void clossGroup(RadioGroup radioGroup,boolean isShowing){
        if (isShowing){
            TranslateAnimation animation = new TranslateAnimation(0,0,radioGroup.getHeight(),0);
            animation.setDuration(400);
            animation.setFillAfter(true);
            radioGroup.setAnimation(animation);
            radioGroup.startAnimation(animation);
        }
    }
    /**
     * 底部选项卡切换
     */
    public void changeTab(int id, List<View> views){
        if (views==null)
            return;
        for (int i = 0 ; i < views.size() ; i++){
            View view = views.get(i);
            if (id==view.getId()){
                view.setSelected(true);
            }else {
                view.setSelected(false);
            }
        }
    }
}
