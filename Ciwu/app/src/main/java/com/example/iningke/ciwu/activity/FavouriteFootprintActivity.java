package com.example.iningke.ciwu.activity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.example.basebean.base.BaseActivity;
import com.example.basebean.base.utils.UIUtils;
import com.example.iningke.ciwu.R;
import com.example.iningke.ciwu.adapter.FooterPrintAdapter;
import com.example.iningke.ciwu.adapter.FavouriteAdapter;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FavouriteFootprintActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {
    @Bind(R.id.ll_favourite_footprint)
    LinearLayout container;
    @Bind(R.id.tab_group)
    RadioGroup group;
    @Bind(R.id.left_favourite)
    RadioButton left_button;
    @Bind(R.id.right_footer)
    RadioButton right_button;
    @Bind(R.id.ff_gridview)
    GridView gridView;
    @Bind(R.id.ff_swiplistview)
    SwipeMenuListView listView;
    @Bind(R.id.submit_iv)
    ImageView submit_iv;


    @Override
    public void initData() {
        Picasso.with(this).load(R.drawable.icon_delete_red).into(submit_iv);
        Bundle data = getActivityData();
        if (data!=null){
            int setion = data.getInt("setion");
            if (setion==2){
                group.check(right_button.getId());
            }
        }
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        group.check(left_button.getId());
        group.setOnCheckedChangeListener(this);
        gridView.setAdapter(new FavouriteAdapter(this));
        initListView();
    }




    @Override
    public int setLayoutId() {
        return R.layout.activity_favourite_footprint;
    }

    @Override
    public View setLayoutView() {
        return null;
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (checkedId==left_button.getId()){
            dataChange(true);
            submit_iv.setVisibility(View.INVISIBLE);
            UIUtils.showToastSafe("喜欢");
        }else {
            dataChange(false);
            submit_iv.setVisibility(View.VISIBLE);
            UIUtils.showToastSafe("足迹");
        }
    }
    @OnClick({R.id.rl_back,R.id.rl_submit})
    public void OnClick(View v){
        switch (v.getId()){
            case R.id.rl_back:
                finish();
                break;
            case R.id.rl_submit:
//                showDialog();
                break;
        }
    }
    public void dataChange(boolean flag){
        gridView.setVisibility(flag?View.VISIBLE:View.GONE);
        listView.setVisibility(!flag?View.VISIBLE:View.GONE);
    }



    private void initListView() {
        listView.setAdapter(new FooterPrintAdapter(this));
        listView.setMenuCreator(creator);
        listView.setSwipeDirection(SwipeMenuListView.DIRECTION_LEFT);
        listView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                UIUtils.showToastSafe("onMenuItemClick:"+position+" index:"+index);
                // false : close the menu; true : not close the menu
                return false;
            }
        });

        listView.setOnScrollListener(new AbsListView.OnScrollListener(){
            public void onScroll(AbsListView view, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount) {

            }
            public void onScrollStateChanged(AbsListView view,
                                             int scrollState) {

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                UIUtils.showToastSafe("onItemClick:"+position);
            }
        });
    }

    SwipeMenuCreator creator = new SwipeMenuCreator() {

        @Override
        public void create(SwipeMenu menu) {
            SwipeMenuItem deleteItem = new SwipeMenuItem(getApplicationContext());
            deleteItem.setWidth(dp2px(60));
            deleteItem.setBackground(new ColorDrawable(Color.rgb(255, 33, 0)));
            deleteItem.setTitleSize(14);
            deleteItem.setTitleColor(Color.WHITE);
            deleteItem.setTitle("删除");
            menu.addMenuItem(deleteItem);
        }
    };
    public int dp2px(float dp) {
        final float scale = this.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }


}
