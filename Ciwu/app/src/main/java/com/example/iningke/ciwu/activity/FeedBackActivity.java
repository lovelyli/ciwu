package com.example.iningke.ciwu.activity;

import android.view.View;

import com.example.basebean.base.BaseActivity;
import com.example.basebean.base.utils.UIUtils;
import com.example.iningke.ciwu.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class FeedBackActivity extends BaseActivity {


    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_feed_back;
    }

    @Override
    public View setLayoutView() {
        return null;
    }
    @OnClick({R.id.rl_back,R.id.rl_submit})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.rl_back:
                finish();
                break;
            case R.id.rl_submit:
                UIUtils.showToastSafe(getString(R.string.commit_sucess));
                finish();
                break;
        }
    }
}
