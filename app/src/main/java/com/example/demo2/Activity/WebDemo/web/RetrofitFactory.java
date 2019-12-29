package com.example.demo2.Activity.WebDemo.web;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitFactory {

    private  static volatile  Retrofit retrofit=null;

    private static final String BaseUrl="http://192.168.42.230:8080/ssm05_war/";

    public  static synchronized Retrofit getInstance(){
        if(retrofit==null){

            OkHttpClient client = new OkHttpClient().newBuilder()
                    .readTimeout(2000, TimeUnit.SECONDS)//设置读取超时时间
                    .connectTimeout(2000, TimeUnit.SECONDS)//设置请求超时时间
                    .writeTimeout(2000,TimeUnit.SECONDS)//设置写入超时时间
                    .addInterceptor(new LogInterceptor())//添加打印拦截器
                    .retryOnConnectionFailure(true)//设置出现错误进行重新连接。
                    .build();

            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd HH:mm:ss")
                    .serializeNulls()
                    .setPrettyPrinting()
                    .disableHtmlEscaping()
                    .create();

            Retrofit retrofit = new Retrofit.Builder()
                    .client(client)
                    .baseUrl(BaseUrl)
                    //添加GSON解析：返回数据转换成GSON类型
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    //添加Rxjava支持
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
            return retrofit;
        }

      return retrofit;
    }
}
