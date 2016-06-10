package com.example.iningke.ciwu.activity;

import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.basebean.base.BaseActivity;
import com.example.iningke.ciwu.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by iningke on 2016/6/4.
 */

public class LoginActivity extends BaseActivity {
    private View contentView;
    protected int activityCloseEnterAnimation;

    protected int activityCloseExitAnimation;
    @Override
    public void initData() {
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        TypedArray activityStyle = getTheme().obtainStyledAttributes(new int[] {android.R.attr.windowAnimationStyle});

        int windowAnimationStyleResId = activityStyle.getResourceId(0, 0);

        activityStyle.recycle();

        activityStyle = getTheme().obtainStyledAttributes(windowAnimationStyleResId, new int[] {activityCloseEnterAnimation, activityCloseExitAnimation});

        activityCloseEnterAnimation = activityStyle.getResourceId(0, 0);

        activityCloseExitAnimation = activityStyle.getResourceId(1, 0);

        activityStyle.recycle();
    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public View setLayoutView() {
        contentView = LayoutInflater.from(this).inflate(R.layout.activity_login,null);
        return contentView;
    }

    @OnClick({R.id.login_close,R.id.login_taobao})
    public void onButtonClick(View view){
        switch (view.getId()){
            case R.id.login_taobao:
                finish();
                break;
            case R.id.login_close:
                finish();
                break;
        }
    }

    /**
     * 设置消失动画
     */
    public void gotoFinish(){
        //初始化渐变动画
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.login_anim_enter);
        //设置动画监听器
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                //当监听到动画结束时，开始跳转到MainActivity中去
                LoginActivity.this.finish();
            }
        });

        //开始播放动画
        contentView.startAnimation(animation);
    }
}
