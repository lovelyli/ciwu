package com.example.iningke.ciwu.activity;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;

import com.example.basebean.base.BaseActivity;
import com.example.iningke.ciwu.R;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {
    @Bind(R.id.main_iv)
    ImageView main_iv;
    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        handler.sendEmptyMessage(0);
    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public View setLayoutView() {
        return null;
    }
    private int current_page = 0;
    private int[] pages = {R.mipmap.start_page1,R.mipmap.start_page2,R.mipmap.start_page3,R.mipmap.start_page4,R.mipmap.start_page5,R.mipmap.start_page6};
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            handler.sendEmptyMessage(0);
        }
    };
    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if (current_page<6){
                Picasso.with(MainActivity.this).load(pages[current_page]).placeholder(pages[current_page]).into(main_iv);
                handler.removeCallbacks(runnable);
                current_page++;
                handler.removeCallbacks(runnable);
                handler.postDelayed(runnable,600);
            }else {
                handler.removeCallbacks(runnable);
                gotoActivity(HomeActivity.class,null);
                finish();
            }
            return false;
        }
    });
}
