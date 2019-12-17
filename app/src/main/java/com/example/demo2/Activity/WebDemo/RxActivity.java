package com.example.demo2.Activity.WebDemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.demo2.R;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;


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

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        ShoppingService.getInstance().getShoppingInfo()
                                .observeOn(AndroidSchedulers.mainThread())

                                .subscribe(new Observer<Shopping>() {
                                    @Override
                                    public void onSubscribe(Disposable d) {

                                    }

                                    @Override
                                    public void onNext(Shopping shopping) {

                                        Toast.makeText(RxActivity.this, shopping.toString(), Toast.LENGTH_SHORT).show();
                                    }

                                    @Override
                                    public void onError(Throwable e) {

                                        Toast.makeText(RxActivity.this, "对不起", Toast.LENGTH_SHORT).show();
                                    }

                                    @Override
                                    public void onComplete() {

                                    }
                                });
                    }
                }).start();


                break;
            case R.id.b2:

                break;
            case R.id.b3:

                break;
        }
    }


}
