package com.example.iningke.ciwu.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.iningke.ciwu.R;
import com.example.iningke.ciwu.impl.RecyclerClickListener;

import java.util.Random;

/**
 * Created by iningke on 2016/6/8.
 */

public class BeautyAdapter extends RecyclerView.Adapter<BeautyAdapter.MasonryView>{
    private String re = "案例看世界的垃圾速度来看案件数量肯定就安老师看见的拉升阶段来看氨基酸离开的贾老师看见的拉丝机打了卡时间离开多久爱死了京东拉开手机打了卡就是镂空大师爱上的骄傲镂空设计的拉开见识到了看见爱上了登记卡老师看见的来看数据的来看爱就是了打开加上了快递加上了空间打了卡时间打了卡时间领导看见爱上了空间打算离开就打了卡时间领导看见爱上了看打算离开家的凉开水";
    private RecyclerClickListener listener;
    public void setListener(RecyclerClickListener listener){
        this.listener = listener;
    }
    @Override
    public MasonryView onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_beauty, viewGroup, false);
        return new MasonryView(view);
    }

    @Override
    public void onBindViewHolder(MasonryView masonryView, int position) {
        String str = re.substring(0, (int) (Math.random()*25));
        masonryView.textView.setText(str);
        masonryView.container.setTag(position);
        masonryView.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(v, (Integer) v.getTag());
            }
        });
    }

    @Override
    public int getItemCount() {

        return 15;
    }



    public static class MasonryView extends  RecyclerView.ViewHolder{
        LinearLayout container;
        ImageView imageView;
        TextView textView;


        public MasonryView(View itemView){
            super(itemView);
            imageView= (ImageView) itemView.findViewById(R.id.item_beauty_imag );
            textView= (TextView) itemView.findViewById(R.id.item_beauty_title);
            container = (LinearLayout) itemView;
        }

    }

}
