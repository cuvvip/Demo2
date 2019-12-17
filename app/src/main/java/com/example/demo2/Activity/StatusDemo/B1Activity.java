package com.example.demo2.Activity.StatusDemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.demo2.R;

public class B1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b1);

//        StatusBarUtil.setRootViewFitsSystemWindows(this, true);

        //设置状态栏透明
//        StatusBarUtil.setTranslucentStatus(this);
        //一般的手机的状态栏文字和图标都是白色的, 可如果你的应用也是纯白色的, 或导致状态栏文字看不清
        //所以如果你是这种情况,请使用以下代码, 设置状态使用深色文字图标风格, 否则你可以选择性注释掉这个if内容
//        if (!StatusBarUtil.setStatusBarDarkTheme(this, true)) {
//            //如果不支持设置深色风格 为了兼容总不能让状态栏白白的看不清, 于是设置一个状态栏颜色为半透明,
//            //这样半透明+白=灰, 状态栏的文字能看得清
//            StatusBarUtil.setStatusBarColor(this, 0x55000000);
//        }

//        浅绿色
//        StatusBarUtil.setStatusBarColor(this,0x3D11EE00);
//        灰色
//        StatusBarUtil.setStatusBarColor(this, Color.rgb(0,233,2));
//        安卓中的八位透明度 前两位表示透明 00 表示全部透明，FF 表示不透密， 后面的6 位表示的是rgba
//        StatusBarUtil.setStatusBarColor(this,0xFF0000FF);

        StatusBarCompat.setStatusBarColor(B1Activity.this,0xFF0000FF);
    }
}
