package com.example.demo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.demo2.Activity.RecycleDemo.RecycleDemo1Activity;
import com.example.demo2.Activity.RecycleDemo.RecycleDemo2Activity;
import com.example.demo2.Activity.StatusDemo.B1Activity;
import com.example.demo2.Activity.StatusDemo.B2Activity;
import com.example.demo2.Activity.StatusDemo.B3Activity;
import com.example.demo2.Activity.WebDemo.RxActivity;
import com.example.demo2.Web.utils.ApiConfig;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button b1,b2,b3,b4,b5,b6,b7,b8,b9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3=findViewById(R.id.b3);
        b4=findViewById(R.id.b4);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this::onClick);
        b5=findViewById(R.id.b5);
        b5.setOnClickListener(this::onClick);
        b6=findViewById(R.id.b6);
        b6=findViewById(R.id.b6);
        b6.setOnClickListener(this::onClick);


        ApiConfig build = new ApiConfig.Builder()
                .setBaseUrl("http://192.168.42.230:8080/ssm05_war/")//BaseUrl，这个地方加入后项目中默认使用该url
                .setInvalidateToken(0)//Token失效码
                .setSucceedCode(200)//成功返回码
                .setFilter("com.mp5a5.quit.broadcastFilter")//失效广播Filter设置
                //.setDefaultTimeout(2000)//响应时间，可以不设置，默认为2000毫秒
                //.setHeads(headMap)//动态添加的header，也可以在其他地方通过ApiConfig.setHeads()设置
                //.setOpenHttps(true)//开启HTTPS验证
                //.setSslSocketConfigure(sslSocketConfigure)//HTTPS认证配置
                .build();
        build.init(this);

    }

//    这里是每个demo 的跳转
    @Override
    public void onClick(View v) {
        Intent intent=null;
        switch (v.getId()){

            case R.id.b1:
                intent=new Intent(MainActivity.this, B1Activity.class);
                startActivity(intent);
                break;
            case R.id.b2:
                intent=new Intent(MainActivity.this, B2Activity.class);
                startActivity(intent);
                break;
            case R.id.b3:
                intent=new Intent(MainActivity.this, B3Activity.class);
                startActivity(intent);
                break;
            case R.id.b4:
                intent=new Intent(MainActivity.this, RxActivity.class);
                startActivity(intent);
                break;
            case R.id.b5:
                intent=new Intent(MainActivity.this, RecycleDemo1Activity.class);
                startActivity(intent);
                break;
            case R.id.b6:
                intent=new Intent(MainActivity.this, RecycleDemo2Activity.class);
                startActivity(intent);
                break;
        }
    }
}
