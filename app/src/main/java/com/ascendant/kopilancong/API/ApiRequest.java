package com.ascendant.kopilancong.API;

import com.ascendant.kopilancong.Model.ResponseArrayObject;
import com.ascendant.kopilancong.Model.ResponseObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiRequest {
    //GET
    @GET("setting/base_url")
    Call<ResponseArrayObject> BaseURL();

    //GET
    @GET("notice/allnotice")
    Call<ResponseArrayObject> AllNotice();

    @GET("api/product")
    Call<ResponseArrayObject> Product(@Header("Authorization") String authHeader,
                                      @Query("kategori") String kategori);

    @GET("api/transaksi/list")
    Call<ResponseArrayObject> TransactionList(@Header("Authorization") String authHeader);

    @GET("api/transaksi/detail")
    Call<ResponseObject> TransactionDetail(@Header("Authorization") String authHeader,
                                              @Query("id_transaksi") String id_transaksi);

    @GET("api/user/profil")
    Call<ResponseObject> Profil(@Header("Authorization") String authHeader);

    @GET("api/transaksi/list")
    Call<ResponseArrayObject> ListTransaksi(@Header("Authorization") String authHeader);

    @GET("api/transaksi/list")
    Call<ResponseArrayObject> DetailTransaksi(@Header("Authorization") String authHeader,
                                              @Query("id_transaksi") String id_transaksi);


    //POST
    @FormUrlEncoded
    @POST("api/login")
    Call<ResponseArrayObject> login(@Field("email") String email,
                                    @Field("password") String password);

    //POST
    @FormUrlEncoded
    @POST("api/transaksi")
    Call<ResponseArrayObject> Transaksi(@Header("Authorization") String authHeader,
                                        @Field("id_product[]") ArrayList<String> id_product,
                                        @Field("quantity[]") ArrayList<String> quantity,
                                        @Field("bayar") String bayar);
}
