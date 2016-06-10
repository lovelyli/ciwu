package com.example.iningke.ciwu.activity;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import com.example.basebean.base.BaseActivity;
import com.example.basebean.base.utils.LogUtils;
import com.example.iningke.ciwu.R;
import com.example.iningke.ciwu.presenter.CiwuHomePre;
import com.example.iningke.ciwu.utils.ViewUtils;
import com.example.scrollablayoutlib.OnLayoutScrollListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends BaseActivity implements ViewTreeObserver.OnGlobalLayoutListener, OnLayoutScrollListener{
    private CiwuHomePre ciwuHomePre;
    private boolean isShowing = true;//底部导航栏是否显示的标示
    private List<View> pages = new ArrayList<>();
    @Bind(R.id.title_home_zhanwei)
    RelativeLayout zhanweicontainer;
    @Bind(R.id.title_home_searchimage)
    ImageView searchimage;
    @Bind(R.id.title_home_searchcontainer)
    LinearLayout searchcontainer;
    @Bind(R.id.radiogroup)
    RadioGroup radioGroup;
    @Bind(R.id.sy_page1)
    LinearLayout sy_page1;
    @Bind(R.id.sy_page2)
    LinearLayout sy_page2;
    @Bind(R.id.sy_page3)
    LinearLayout sy_page3;
    @Bind(R.id.sy_page4)
    LinearLayout sy_page4;
    @Bind(R.id.sy_page5)
    LinearLayout sy_page5;



    @Override
    public void initData() {
        pages.add(sy_page1);
        pages.add(sy_page2);
        pages.add(sy_page3);
        pages.add(sy_page4);
        pages.add(sy_page5);
        ciwuHomePre = CiwuHomePre.getInstance(CiwuHomePre.class);
        ciwuHomePre.changeTab(R.id.sy_page1,pages);
        ciwuHomePre.initFragments(getSupportFragmentManager(),R.id.fragment_container,this);
        //首页相关初始化
        zhanweicontainer.getViewTreeObserver().addOnGlobalLayoutListener(this);
        setContainerTransparent(true);
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
    }

    @OnClick({R.id.sy_page1,R.id.sy_page2,R.id.sy_page3,R.id.sy_page4,R.id.sy_page5})
    public void onClick(View view){
        ciwuHomePre.changeTab(view.getId(),pages);
        zhanweicontainer.setVisibility(View.GONE);
        switch (view.getId()){
            case R.id.sy_page1:
                zhanweicontainer.setVisibility(View.VISIBLE);
                ciwuHomePre.setFragmentShow(getSupportFragmentManager(),0);
                break;
            case R.id.sy_page2:
                ciwuHomePre.setFragmentShow(getSupportFragmentManager(),1);
                break;
            case R.id.sy_page3:

                break;
            case R.id.sy_page4:
                ciwuHomePre.setFragmentShow(getSupportFragmentManager(),3);
                break;
            case R.id.sy_page5:
                //TODO
                ciwuHomePre.setFragmentShow(getSupportFragmentManager(),4);
                break;
        }
    }
    @OnClick({R.id.title_home_searchimage,R.id.title_home_searchcontainer})
    public void onButtonClick(View view){

    }
    /**
     * 首页搜索框高度设置
     */
    @Override
    public void onGlobalLayout() {
        if (zhanweicontainer!=null)
            ciwuHomePre.setTTHeight(zhanweicontainer.getHeight());
    }


    /**
     *  设置标题搜索栏显示和隐藏
     */
    public void setContainerTransparent(boolean flag){
        if (zhanweicontainer==null)
            return;
        ViewUtils.setViewVisbleVG(searchcontainer,!flag);
        ViewUtils.setViewVisbleVG(searchimage,flag);
    }
    /**
     * 首页父布局滑动监听
     */
    @Override
    public void onScroll(int currentY, int maxY) {
        if (currentY>=maxY){
            setContainerTransparent(false);
//            if (ciwuHomePre!=null){
//                ciwuHomePre.showGroup(radioGroup,isShowing);
//                isShowing = true;
//            }
        }else {
            setContainerTransparent(true);
//            if (ciwuHomePre!=null){
//                ciwuHomePre.clossGroup(radioGroup,isShowing);
//                isShowing = false;
//            }
        }
    }

    @Override
    public void onUpDown(boolean flag) {
//        if (flag){
//            //向下
//            if (ciwuHomePre!=null){
//                ciwuHomePre.showGroup(radioGroup,isShowing);
//                isShowing = true;
//            }
//            LogUtils.e("向下");
//        }else {
//            //向上
//            if (ciwuHomePre!=null){
//                ciwuHomePre.clossGroup(radioGroup,isShowing);
//                isShowing = false;
//            }
//            LogUtils.e("向上");
//
//        }
    }
    @Override
    public int setLayoutId() {
        return R.layout.activity_ciwu_home;
    }

    @Override
    public View setLayoutView() {
        return null;
    }

}
