package com.ascendant.kopilancong.API;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;

import com.ascendant.kopilancong.Activity.HomeActivity;
import com.ascendant.kopilancong.Activity.MainActivity;
import com.ascendant.kopilancong.SharedPreferance.DB_Helper;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroServer {
    private static Retrofit retrofit;
    private static final String base_url = "https://kasir.desabanjarwaru.id/";


    public static Retrofit getClient(){
        if(retrofit==null){
            OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            clientBuilder.addInterceptor(loggingInterceptor);
            retrofit = new Retrofit.Builder()
                    .baseUrl(base_url)
                    .client(clientBuilder.build())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
