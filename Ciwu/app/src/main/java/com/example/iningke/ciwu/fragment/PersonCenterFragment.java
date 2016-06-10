package com.example.iningke.ciwu.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.basebean.base.BaseFragment;
import com.example.iningke.ciwu.R;
import com.example.iningke.ciwu.activity.FavouriteFootprintActivity;
import com.example.iningke.ciwu.activity.FeedBackActivity;


/**
 * Created by iningke on 2016/6/4.
 */

public class PersonCenterFragment extends BaseFragment implements View.OnClickListener {
    LinearLayout ll_feedback,ll_favourate,ll_footer;

    @Override
    public void initData(View view) {

    }

    @Override
    public void initView(View view) {
        ll_feedback = (LinearLayout) view.findViewById(R.id.ll_feedback);
        ll_feedback.setOnClickListener(this);
        ll_favourate = (LinearLayout) view.findViewById(R.id.ll_favourate);
        ll_favourate.setOnClickListener(this);
        ll_footer = (LinearLayout) view.findViewById(R.id.ll_footer);
        ll_footer.setOnClickListener(this);

    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_person_center;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_feedback:
                gotoActivity(FeedBackActivity.class,null);
                break;
            case R.id.ll_favourate:
                Bundle df1 = new Bundle();
                df1.putInt("setion",1);
                gotoActivity(FavouriteFootprintActivity.class,df1);
                break;
            case R.id.ll_footer:
                Bundle df2 = new Bundle();
                df2.putInt("setion",2);
                gotoActivity(FavouriteFootprintActivity.class,df2);
                break;
        }
    }
}
