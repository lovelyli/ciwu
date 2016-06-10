package com.example.baseapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/**
 * Created by iningke on 2016/6/1.
 */
public abstract class BaseFragment extends Fragment {
    public View view = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view!=null){
            ViewGroup parent = null;
            ViewParent v =  view.getParent();
            if(v instanceof ViewGroup){
                parent = (ViewGroup) v;
            }
            if (null != parent) {
                parent.removeView(view);
            }
        }else {
            view = inflater.inflate(setLayoutId(),null);
            initView(view);
            initData(view);
        }
        return view;

    }

    /**
     * 加载数据
     * @return
     */
    public abstract void initData(View view);
    /**
     * 初始化师徒
     * @return
     */
    public abstract void initView(View view);

    /**
     * 设置布局id
     * @return
     */
    public abstract int setLayoutId();

    
}
