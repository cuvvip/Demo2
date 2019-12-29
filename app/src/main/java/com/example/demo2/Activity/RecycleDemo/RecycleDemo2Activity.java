package com.example.demo2.Activity.RecycleDemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.example.demo2.Activity.RecycleDemo.pojo.Person;
import com.example.demo2.R;

import java.util.ArrayList;
import java.util.List;

public class RecycleDemo2Activity extends AppCompatActivity {



    SwipeRefreshLayout swipeRefreshLayout;
    RecyclerView recyclerView;
    PersonRecyclerViewAdapter adapter;

    int nowposition=0;
    int lastposition=10;
    boolean hasmore=true;

    List<Person> AllData=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_demo2);

        swipeRefreshLayout=findViewById(R.id.sw);
        recyclerView=findViewById(R.id.re);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(RecycleDemo2Activity.this, "点击了上拉刷新", Toast.LENGTH_SHORT).show();
                swipeRefreshLayout.setRefreshing(false);
            }
        });



//        模拟网上请求，大概两秒请求所有的数据
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                AllData=AddWebData();

                adapter=new PersonRecyclerViewAdapter(RecycleDemo2Activity.this,newData());
                recyclerView.setLayoutManager(new LinearLayoutManager(RecycleDemo2Activity.this));
                recyclerView.setAdapter(adapter);

                recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                    @Override
                    public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                        super.onScrollStateChanged(recyclerView, newState);

                        if(isVisBottom(recyclerView)&&!adapter.getIsNowLoad()){
                            adapter.setNowLoad(true);
                            List<Person> people=newData();

                            adapter.updateList(people,hasmore);


                        }
                    }
                });
            }
        },2000);
        List<Person> list=AddWebData();
    }

    public List<Person> AddWebData(){
        List<Person> list=new ArrayList<>();
        for(int i=0;i<47;i++){

            Person person=new Person();
            person.setGood(i+1);
            person.setUserinformation(RandomString.getRandomString(40));
            person.setUsername(RandomString.getRandomString(10));
            list.add(person);
        }
        return list;
    }


    public List<Person> newData(){
        List<Person> people=new ArrayList<>();
        int  i=0;
        if(nowposition>=AllData.size()){
            hasmore=false;
            return null;
        }
        for(i=nowposition;i<lastposition&& i<AllData.size();i++){
            people.add(AllData.get(i));
        }
        nowposition=i;
        lastposition=i+10;
//        已经全部加载完毕了
        Log.d("nowposition",String.valueOf(nowposition));
        Log.d("lastposition",String.valueOf(lastposition));

        return  people;
    }

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
