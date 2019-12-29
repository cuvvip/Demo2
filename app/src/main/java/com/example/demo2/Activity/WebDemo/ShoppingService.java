package com.example.demo2.Activity.WebDemo;



import android.util.Log;
import android.widget.Toast;

import com.example.demo2.Web.use.RetrofitFactory;

import java.io.IOException;
import java.util.List;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShoppingService {

    private ShoppingApi shoppingApi;

    private ShoppingService(){
        shoppingApi= RetrofitFactory.getInstance().create(ShoppingApi.class);
    }

    public static ShoppingService getInstance(){
        return ShoppingServiceHolder.S_INSTANCE;
    }

    private static class ShoppingServiceHolder {
        private static final ShoppingService S_INSTANCE = new ShoppingService();
    }

    public Observable<WebShopping> getShoppingInfo() {
        return shoppingApi.kk();
    }

    public String TAG="ShoppingService";
    public  void getSg(){
        Call<ResponseBody> call=shoppingApi.k1();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {

                    Log.d(TAG,response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

                Log.d(TAG,"失败了");
            }
        });
    }
}
