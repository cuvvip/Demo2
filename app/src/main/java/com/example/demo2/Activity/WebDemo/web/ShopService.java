package com.example.demo2.Activity.WebDemo.web;

import android.os.AsyncTask;

import com.example.demo2.Activity.WebDemo.ShoppingApi;
import com.example.demo2.Activity.WebDemo.WebShopping;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class ShopService {





    public static void getShoppingInfo(Observer<WebShopping> observer) {

        new AsyncTask<Object,Integer,Object>(){

            @Override
            protected Object doInBackground(Object... objects) {
                return null;
            }

            @Override
            protected void onPostExecute(Object o) {
                super.onPostExecute(o);
                RetrofitFactory.getInstance()
                        .create(ShoppingApi.class)
                        .kk()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(observer);

            }
        }.execute();
    }
}
