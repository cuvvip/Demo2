package com.example.demo2.Activity.WebDemo;



import com.example.demo2.Web.use.RetrofitFactory;

import io.reactivex.Observable;

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

    public Observable<Shopping> getShoppingInfo() {
        return shoppingApi.kk();
    }
}
