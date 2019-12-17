package com.example.demo2.Activity.RecycleDemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.example.demo2.Activity.RecycleDemo.pojo.Person;
import com.example.demo2.R;

import java.util.ArrayList;
import java.util.List;

public class RecycleDemo1Activity extends AppCompatActivity {

    RecyclerView recyclerView;

    PersonRecyclerViewAdapter adapter;

    SwipeRefreshLayout swipeRefreshLayout;


    private List<Person> personList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_demo1);

        swipeRefreshLayout=findViewById(R.id.sw);

        recyclerView=findViewById(R.id.re);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(RecycleDemo1Activity.this, "点击了上拉刷新", Toast.LENGTH_SHORT).show();
                swipeRefreshLayout.setRefreshing(false);
            }
        });

//        第一次请求十个数据
        personList.addAll(AddWebData());

        adapter=new PersonRecyclerViewAdapter(RecycleDemo1Activity.this,personList);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if(isVisBottom(recyclerView)&& !adapter.getIsNowLoad()){
                    adapter.setNowLoad(true);

//                    模拟网上延迟
                    new Handler().postDelayed(new Runnable(){
                        public void run() {
                            //execute the tas

                           adapter.updateList(AddWebData(),true);
                        }
                    }, 1000);


                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });




    }

//    每次从网上请求十个数据
    public  List<Person> AddWebData(){

        List<Person> list=new ArrayList<>();
        for(int i=0;i<10;i++){

            Person person=new Person();
            person.setGood(i);
            person.setUserinformation(RandomString.getRandomString(40));
            person.setUsername(RandomString.getRandomString(10));
            list.add(person);
        }
        return list;
    }


//    判断是否到达底部
    public static boolean isVisBottom(RecyclerView recyclerView){
        LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        //屏幕中最后一个可见子项的position
        int lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition();
        //当前屏幕所看到的子项个数
        int visibleItemCount = layoutManager.getChildCount();
        //当前RecyclerView的所有子项个数
        int totalItemCount = layoutManager.getItemCount();
        //RecyclerView的滑动状态
        int state = recyclerView.getScrollState();
        if(visibleItemCount > 0 && lastVisibleItemPosition == totalItemCount - 1 && state == recyclerView.SCROLL_STATE_IDLE){
            return true;
        }else {
            return false;
        }
    }

}
