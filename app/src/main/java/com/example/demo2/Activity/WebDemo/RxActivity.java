package com.example.demo2.Activity.WebDemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.demo2.Activity.WebDemo.web.ShopService;
import com.example.demo2.R;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

/**
 *   ReActivity
 */

public class RxActivity extends AppCompatActivity implements View.OnClickListener{

    private Button b1,b2,b3,b4,b5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3=findViewById(R.id.b3);
        b3.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent=null;
        switch (v.getId()){

            case R.id.b1:

                ShopService.getShoppingInfo(new Observer<WebShopping>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(WebShopping webShopping) {

                        Toast.makeText(RxActivity.this, webShopping.toString(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Throwable e) {

                        Toast.makeText(RxActivity.this, "错误", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete() {

                    }
                });



                break;
            case R.id.b2:

                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        ShoppingService.getInstance().getSg();
                    }
                }).start();
                break;
            case R.id.b3:

                break;
        }
    }


}
