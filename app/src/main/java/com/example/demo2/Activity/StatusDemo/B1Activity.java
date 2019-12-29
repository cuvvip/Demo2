package com.example.demo2.Activity.StatusDemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;

import com.example.demo2.R;

public class B1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b1);

        SeekBar seekBar=findViewById(R.id.seekBar);
        StatusBarCompat.setStatusBarColor(B1Activity.this,0xFF00DDFF);

//     设置透明度
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                StatusBarCompat.setStatusBarColor(B1Activity.this,0x00DDFF,progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
