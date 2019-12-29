package com.example.demo2.Activity.StatusDemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.demo2.R;

public class B2Activity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b2);

//        隐藏状态栏
        StatusBarCompat.translucentStatusBar(B2Activity.this, true);

    }
}
