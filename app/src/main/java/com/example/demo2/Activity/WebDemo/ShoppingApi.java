package com.example.demo2.Activity.WebDemo;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;


//这里是retrofit+rxjava 的接口

public interface ShoppingApi {


    //上传单张图片
    @POST("/sample")
    Observable<Object> imageUpload(@Part() MultipartBody.Part img);

    //上传多张图片
    @Multipart
    @POST("/more")
    Observable<Object> imagesUpload(@Part() List<MultipartBody.Part> imgs);

    @POST("/ssm05_war/SelectShopping")
    Observable<WebShopping> kk();

    @POST("/ssm05_war/SelectShopping")
    Call<ResponseBody> k1();



}

