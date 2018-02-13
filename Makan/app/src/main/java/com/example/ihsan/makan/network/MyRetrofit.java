package com.example.ihsan.makan.network;

import com.example.ihsan.makan.helper.MyConstant;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by iswandisaputra on 2/13/18.
 */

public class MyRetrofit {
    private static Retrofit getRetrofit(){
        //insialisasi retrofit 2
        Retrofit r = new Retrofit.Builder()
                .baseUrl(MyConstant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return r;
    }
    public static RestApi getInstaceRetrofit(){
        return getRetrofit().create(RestApi.class);
    }



}
