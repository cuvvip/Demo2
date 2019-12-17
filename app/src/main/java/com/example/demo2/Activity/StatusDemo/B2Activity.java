package com.example.demo2.Activity.StatusDemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.demo2.R;

public class B2Activity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b2);
//        StatusBarUtil.setRootViewFitsSystemWindows(this, true);
//        StatusBarUtil.setTranslucentStatus(this);
        StatusBarCompat.translucentStatusBar(B2Activity.this, true);
//        StatusBarCompat.setStatusBarColor(B2Activity.this, Color.rgb(0,233,2));
//        StatusBarUtil.setStatusBarColor(this, 0x00000000);

    }
}
