package com.example.baseapp;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * Created by iningke on 2016/6/1.
 */
public abstract class BaseActivity extends FragmentActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutId());
        initView();
        initData();
    }
    /**
     * 加载数据
     * @return
     */
    public abstract void initData();
    /**
     * 初始化师徒
     * @return
     */
    public abstract void initView();

    /**
     * 设置布局id
     * @return
     */
    public abstract int setLayoutId();


}
