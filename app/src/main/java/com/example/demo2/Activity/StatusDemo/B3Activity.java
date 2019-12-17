package com.example.demo2.Activity.StatusDemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.os.Bundle;

import com.example.demo2.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class B3Activity extends AppCompatActivity {


    private AppBarLayout mAppBarLayout;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b3);


        mAppBarLayout=findViewById(R.id.appbar);
        mCollapsingToolbarLayout=findViewById(R.id.co);
        mToolbar=findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mCollapsingToolbarLayout.setTitle(" ");
//        这个是设置 隐藏后 状态栏的颜色
        StatusBarCompat.setStatusBarColorForCollapsingToolbar(B3Activity.this, mAppBarLayout, mCollapsingToolbarLayout, mToolbar, Color.TRANSPARENT);

//        这是隐藏展开时状态栏有阴影
        StatusBarCompat.translucentStatusBar(B3Activity.this, true);
    }
}
