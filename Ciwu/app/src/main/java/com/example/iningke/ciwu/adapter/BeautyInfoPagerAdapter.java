package com.example.iningke.ciwu.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.iningke.ciwu.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class BeautyInfoPagerAdapter extends PagerAdapter {

    List<ImageView> imageViews = new ArrayList<ImageView>();

    public BeautyInfoPagerAdapter(Context context) {
        //TODO   此处添加轮播图片
        for (int i = 0; i < 4; i++) {
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            Picasso.with(context).load(R.drawable.test_beaty).into(imageView);
//            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageView.setAdjustViewBounds(true);
            final int index = i;
            imageView.setOnClickListener(new View.OnClickListener() {
                //TODO   此处添加轮播图的点击跳转
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "im android " + index, Toast.LENGTH_SHORT).show();
                }
            });
            imageViews.add(imageView);
        }
    }

    @Override
    public int getCount() {
        //TODO
        return 4;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(imageViews.get(position), 0);
        return imageViews.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(imageViews.get(position));
    }
}