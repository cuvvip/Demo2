package com.example.demo2.Activity.RecycleDemo;

import android.content.Context;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo2.Activity.RecycleDemo.pojo.Person;
import com.example.demo2.R;


import java.util.List;

//这个是 查看自己动态  的适配器
public class PersonRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    private List<Person> dynamics;

    private LayoutInflater layoutInflater;

    private int normalType = 0;     // 第一种ViewType，正常的item

    private int footType = 1;       // 第二种ViewType，底部的提示View

    private boolean hasMore = true;   // 变量，是否有更多数据


    private boolean IsNowLoad=false; //数据是否正在加载

    public boolean getIsNowLoad() {
        return IsNowLoad;
    }

    public void setNowLoad(boolean nowLoad) {
        IsNowLoad = nowLoad;
    }

    public PersonRecyclerViewAdapter(Context context){
        this.context = context;
    }

    private MyItemClickListener mItemClickListener;

    @Override
    public int getItemViewType(int position) {
        if (position == getItemCount() - 1) {
            return footType;
        } else {
            return normalType;
        }
    }

    public PersonRecyclerViewAdapter(Context context, List<Person> list){
        this.context=context;
        this.dynamics=list;
        layoutInflater=LayoutInflater.from(context);
        hasMore=true;
    }


    // 自定义方法，获取列表中数据源的最后一个位置，比getItemCount少1，因为不计上footView
    public int getRealLastPosition() {
        return dynamics.size();
    }
    //    初始化item布局
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if(viewType==normalType){
            View view=layoutInflater.inflate(R.layout.recycle_item,parent,false);

           MyViewHolder myViewHolder=new MyViewHolder(view,mItemClickListener);
            return myViewHolder;
        }else {
            View view=layoutInflater.inflate(R.layout.footlayout,parent,false);
            FootViewHolder footViewHolder=new FootViewHolder(view);
            return footViewHolder;
        }

    }

    //    处理每一个item 的地方,绑定数据
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if(holder instanceof MyViewHolder){
            MyViewHolder myViewHolder=(MyViewHolder)holder;
           myViewHolder.good.setText(String.valueOf(dynamics.get(position).getGood()));
           myViewHolder.userinformation.setText(dynamics.get(position).getUserinformation());
           myViewHolder.username.setText(dynamics.get(position).getUsername());

        }else {
            FootViewHolder footViewHolder=(FootViewHolder)holder;

            Log.d("RecycleView",String.valueOf(hasMore));
            if(hasMore==true){
                if(dynamics.size()>0){
                    footViewHolder.tips.setText("正在加载更多");
                }
            }else {
                if(dynamics.size()>0){
                    footViewHolder.tips.setText("没有过多数据");
                }
            }
        }
    }


    // 暴露接口，更新数据源，并修改hasMore的值，如果有增加数据，hasMore为true，否则为false
    public void updateList(List<Person> newDatas,boolean hasMore) {
        // 在原有的数据之上增加新数据
        if (newDatas != null) {
            dynamics.addAll(newDatas);
        }
        this.hasMore=hasMore;
        notifyDataSetChanged();
        //        刷新了数据，表示已经不再正在加载了
        this.IsNowLoad=false;
    }


    //    显示数量，因为我的布局文件就是三个，所以我返回san
    @Override
    public int getItemCount() {
        return dynamics.size()+1;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{

        private TextView username,userinformation,good;

        private MyItemClickListener mListener;

        public MyViewHolder(@NonNull View itemView, MyItemClickListener myItemClickListener) {
            super(itemView);

            userinformation=itemView.findViewById(R.id.userinformation);
            username=itemView.findViewById(R.id.usename);
            good=itemView.findViewById(R.id.good);
            this.mListener = myItemClickListener;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if (mListener != null) {
                mListener.onItemClick(v, getAdapterPosition());
            }
        }
    }


    public class FootViewHolder extends RecyclerView.ViewHolder{


        ProgressBar progressBar;
        TextView tips;
        public FootViewHolder(@NonNull View itemView) {
            super(itemView);
            tips=itemView.findViewById(R.id.tips);
            progressBar=itemView.findViewById(R.id.progressBar2);
        }

    }
    public interface MyItemClickListener {
        void onItemClick(View view, int position);
    }
    public void setItemClickListener(MyItemClickListener myItemClickListener) {
        this.mItemClickListener = myItemClickListener;
    }
}