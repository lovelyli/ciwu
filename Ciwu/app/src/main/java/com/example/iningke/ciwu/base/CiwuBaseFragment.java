package com.example.iningke.ciwu.base;

import android.view.View;

import com.example.basebean.base.BaseFragment;

/**
 * Created by iningke on 2016/6/6.
 */

public abstract class CiwuBaseFragment extends BaseFragment {

    public void findViewById(View container,int layId,View view){
        view = container.findViewById(layId);
    }
    public void setOnClick(View.OnClickListener clickListener,View view){
        view.setOnClickListener(clickListener);
    }

}
