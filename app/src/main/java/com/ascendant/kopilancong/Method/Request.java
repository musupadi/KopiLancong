package com.ascendant.kopilancong.Method;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.util.Log;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ascendant.kopilancong.API.ApiRequest;
import com.ascendant.kopilancong.API.MainServer;
import com.ascendant.kopilancong.API.RetroServer;
import com.ascendant.kopilancong.Activity.CashierActivity;
import com.ascendant.kopilancong.Activity.HomeActivity;
import com.ascendant.kopilancong.Activity.LoginActivity;
import com.ascendant.kopilancong.Activity.MainActivity;
import com.ascendant.kopilancong.Activity.TransactionHistoryActivity;
import com.ascendant.kopilancong.Adapter.CashierAdapter;
import com.ascendant.kopilancong.Adapter.DetailTransactionAdapter;
import com.ascendant.kopilancong.Adapter.NoticeAdapter;
import com.ascendant.kopilancong.Adapter.TransactionAdapter;
import com.ascendant.kopilancong.Model.DataModel;
import com.ascendant.kopilancong.Model.ResponseArrayObject;
import com.ascendant.kopilancong.Model.ResponseObject;
import com.ascendant.kopilancong.R;
import com.ascendant.kopilancong.SharedPreferance.DB_Helper;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Request {
    List<DataModel> mItems = new ArrayList<>();
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mManager;
    Ascendant ascendant = new Ascendant();
    DB_Helper dbHelper;
    ArrayList<String> ID_Product = new ArrayList<String>();
    Integer TotalHarga;

    private String BaseURL(){
        String BASE_URL = "";
        Cursor cursor = dbHelper.checkURL();
        if (cursor.getCount()>0){
            while (cursor.moveToNext()){
                BASE_URL = cursor.getString(0);
            }
        }
        return  BASE_URL;
    }
    public void DetailTransactionHistory(Context ctx, RecyclerView rv,String TOKEN,String ID,TextView Tanggal,TextView TotalHarga,TextView Pembayaran,TextView Kembalian){
        rv.setHasFixedSize(true);
//        rv.setLayoutManager(new GridLayoutManager(ctx, 2));
        mManager = new LinearLayoutManager(ctx, LinearLayoutManager.VERTICAL,false);
        rv.setLayoutManager(mManager);
        ApiRequest api = RetroServer.getClient().create(ApiRequest.class);
        final Call<ResponseObject> data =api.TransactionDetail(ascendant.AUTH(TOKEN),ID);
        final LayoutAnimationController layoutAnimationController = AnimationUtils.loadLayoutAnimation(ctx, R.anim.layout_animation2);
        data.enqueue(new Callback<ResponseObject>() {
            @Override
            public void onResponse(Call<ResponseObject> call, Response<ResponseObject> response) {
                try {
                    if (response.body().getCode() == 405){
                        ascendant.LogoutMessage(ctx,"Waktu Sesi habis anda akan dialihkan Logout");
                    }else{
                        mItems=response.body().getData().getIsi();
                        mAdapter = new DetailTransactionAdapter(ctx,mItems);
                        Tanggal.setText(ascendant.MagicDateChange(response.body().getData().waktu_transaksi));
                        TotalHarga.setText(ascendant.MagicRP(Double.parseDouble(response.body().getData().total_harga)));
                        Pembayaran.setText(ascendant.MagicRP(Double.parseDouble(response.body().getData().pembayaran)));
                        Kembalian.setText(ascendant.MagicRP(Double.parseDouble(response.body().getData().kembalian)));
                        rv.setAdapter(mAdapter);
                        rv.setLayoutAnimation(layoutAnimationController);
                        rv.scheduleLayoutAnimation();
                        mAdapter.notifyDataSetChanged();
                    }
                }catch (Exception e){
                    Log.d("ZYARGA : ",e.toString());
                    ascendant.Message(ctx,"Terjadi Kesalahan Pada : "+e.toString());
                }
            }

            @Override
            public void onFailure(Call<ResponseObject> call, Throwable t) {

            }
        });
    }
    public void TransactionHistory(Context ctx, RecyclerView rv,String TOKEN){
        rv.setHasFixedSize(true);
//        rv.setLayoutManager(new GridLayoutManager(ctx, 2));
        mManager = new LinearLayoutManager(ctx, LinearLayoutManager.VERTICAL,false);
        rv.setLayoutManager(mManager);
        TotalHarga = 0;
        ApiRequest api = RetroServer.getClient().create(ApiRequest.class);
        final Call<ResponseArrayObject> data =api.TransactionList(ascendant.AUTH(TOKEN));
        final LayoutAnimationController layoutAnimationController = AnimationUtils.loadLayoutAnimation(ctx, R.anim.layout_animation2);
        data.enqueue(new Callback<ResponseArrayObject>() {
            @Override
            public void onResponse(Call<ResponseArrayObject> call, Response<ResponseArrayObject> response) {
                try {
                    if (response.body().getCode() == 405){
                        ascendant.LogoutMessage(ctx,"Waktu Sesi habis anda akan dialihkan Logout");
                    }else{
                        mItems=response.body().getData();
                        mAdapter = new TransactionAdapter(ctx,mItems);
                        rv.setAdapter(mAdapter);
                        rv.setLayoutAnimation(layoutAnimationController);
                        rv.scheduleLayoutAnimation();
                        mAdapter.notifyDataSetChanged();
                    }
                }catch (Exception e){
                    Log.d("ZYARGA : ",e.toString());
                    ascendant.Message(ctx,"Terjadi Kesalahan Pada : "+e.toString());
                }
            }

            @Override
            public void onFailure(Call<ResponseArrayObject> call, Throwable t) {
                ascendant.Message(ctx,"Koneksi Gagal harap Coba Lagi Nanti");
            }
        });
    }
    public void Cashier(Context ctx, RecyclerView rv, LinearLayout Pesan, TextView JumlahItem,TextView Total,String TOKEN,String Kategori,TextView Totals){
        rv.setHasFixedSize(true);
//        rv.setLayoutManager(new GridLayoutManager(ctx, 2));
        mManager = new LinearLayoutManager(ctx, LinearLayoutManager.VERTICAL,false);
        rv.setLayoutManager(mManager);
        TotalHarga = 0;
        ApiRequest api = RetroServer.getClient().create(ApiRequest.class);
        final Call<ResponseArrayObject> data =api.Product(ascendant.AUTH(TOKEN),Kategori);
        final LayoutAnimationController layoutAnimationController = AnimationUtils.loadLayoutAnimation(ctx, R.anim.layout_animation2);
        data.enqueue(new Callback<ResponseArrayObject>() {
            @Override
            public void onResponse(Call<ResponseArrayObject> call, Response<ResponseArrayObject> response) {
                try {
                    if (response.body().getCode() == 405){
                        ascendant.LogoutMessage(ctx,"Waktu Sesi habis anda akan dialihkan Logout");
                    }else{
                        mItems=response.body().getData();
                        mAdapter = new CashierAdapter(ctx,mItems,Pesan,JumlahItem,Total,ID_Product,ascendant.BASE_URL(),Totals);
                        rv.setAdapter(mAdapter);
                        rv.setLayoutAnimation(layoutAnimationController);
                        rv.scheduleLayoutAnimation();
                        mAdapter.notifyDataSetChanged();
                    }
                }catch (Exception e){
                    Log.d("ZYARGA : ",e.toString());
                    ascendant.Message(ctx,"Terjadi Kesalahan Pada : "+e.toString());
                }
            }

            @Override
            public void onFailure(Call<ResponseArrayObject> call, Throwable t) {
                ascendant.Message(ctx,"Koneksi Gagal harap Coba Lagi Nanti");
            }
        });
    }
    public void Pesan(Context ctx, ArrayList<String> ID_PESANAN, ArrayList<String> Jumlah, EditText JumlahPesanan,String Token){
        ApiRequest api = RetroServer.getClient().create(ApiRequest.class);
        final Call<ResponseArrayObject> data =api.Transaksi(ascendant.AUTH(Token),ID_PESANAN,Jumlah,ascendant.FilterToNumber(JumlahPesanan.getText().toString()));
        data.enqueue(new Callback<ResponseArrayObject>() {
            @Override
            public void onResponse(Call<ResponseArrayObject> call, Response<ResponseArrayObject> response) {
                try {
                    ascendant.TransactionMessage2(ctx,response.body().getMessage());
                }catch (Exception e){
                    ascendant.Message(ctx,"Terjadi Kesalahan pada : "+e.toString());
                }
            }

            @Override
            public void onFailure(Call<ResponseArrayObject> call, Throwable t) {

            }
        });
    }

    public void Notice(Context ctx, RecyclerView rv){
        mManager = new LinearLayoutManager(ctx, LinearLayoutManager.HORIZONTAL,false);
        rv.setLayoutManager(mManager);
        ApiRequest api = RetroServer.getClient().create(ApiRequest.class);
        final Call<ResponseArrayObject> data =api.AllNotice();
        final LayoutAnimationController layoutAnimationController = AnimationUtils.loadLayoutAnimation(ctx, R.anim.layout_animation2);
        data.enqueue(new Callback<ResponseArrayObject>() {
            @Override
            public void onResponse(Call<ResponseArrayObject> call, Response<ResponseArrayObject> response) {
                try {
                    if (response.body().getStatus().equals("success")){
                        mItems=response.body().getData();
                        mAdapter = new NoticeAdapter(ctx,mItems);
                        rv.setAdapter(mAdapter);
                        rv.setLayoutAnimation(layoutAnimationController);
                        rv.scheduleLayoutAnimation();
                        mAdapter.notifyDataSetChanged();
                    }else{
                        ascendant.Message(ctx,"Terjadi Kesalahan");
                    }
                }catch (Exception e){
                    Log.d("ZYARGA : ",e.toString());
                    ascendant.Message(ctx,"Terjadi Kesalahan Pada : "+e.toString());
//                    Toast.makeText(getActivity(), "Terjadi Kesaqlahan", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseArrayObject> call, Throwable t) {
                ascendant.Message(ctx,"Koneksi Gagal harap Coba Lagi Nanti");
            }
        });
    }
    public void Profil(Context ctx,String TOKEN, TextView Nama, TextView Level, ImageView Gambar){
        dbHelper = new DB_Helper(ctx);
        ApiRequest api = RetroServer.getClient().create(ApiRequest.class);
        Call<ResponseObject> data =api.Profil(TOKEN);
        data.enqueue(new Callback<ResponseObject>() {
            @Override
            public void onResponse(Call<ResponseObject> call, Response<ResponseObject> response) {
                try {
                    if (response.body().getCode() == 405){
                        ascendant.LogoutMessage(ctx,"Waktu Sesi habis anda akan dialihkan Logout");
                    }else{
                        Nama.setText(response.body().getData().getNama_user());
                        Level.setText(response.body().getData().getLevel());
                    }
                }catch (Exception e){
                    ascendant.Message(ctx,e.toString());
                }
            }

            @Override
            public void onFailure(Call<ResponseObject> call, Throwable t) {
                ascendant.Message(ctx,"Koneksi Gagal harap Coba Lagi nanti");
            }
        });
    }
    public void Login(Context ctx, String Email, String Password){
        dbHelper = new DB_Helper(ctx);
        final ProgressDialog pd = new ProgressDialog(ctx);
        pd.setMessage("Sedang Mencoba Login");
        pd.show();
        pd.setCancelable(false);
//        mManager = new LinearLayoutManager(ctx, LinearLayoutManager.VERTICAL,false);
//        rv.setLayoutManager(mManager);
        ApiRequest api = RetroServer.getClient().create(ApiRequest.class);
        Call<ResponseArrayObject> data =api.login(Email,Password);
        data.enqueue(new Callback<ResponseArrayObject>() {
            @Override
            public void onResponse(Call<ResponseArrayObject> call, Response<ResponseArrayObject> response) {
                pd.hide();
                try {
                    if (response.body().getCode() == 200){
                        dbHelper.saveSession(response.body().getAccess_token(),response.body().getLevel());
                        Intent intent = new Intent(ctx, HomeActivity.class);
                        ctx.startActivity(intent);
                    }else{
                        ascendant.Message(ctx,"Username atau Password Salah");
                    }
                }catch (Exception e){
                    Log.d("ZYARGA : ",e.toString());
                    ascendant.Message(ctx,"Terjadi Kesalahan pada : \n"+e.toString());
                }
            }

            @Override
            public void onFailure(Call<ResponseArrayObject> call, Throwable t) {
                pd.hide();
                ascendant.Message(ctx,"Koneksi Gagal !!");
            }
        });
    }
    public void BaseURL(Context ctx){
//        mManager = new LinearLayoutManager(ctx, LinearLayoutManager.VERTICAL,false);
//        rv.setLayoutManager(mManager);
        ApiRequest api = MainServer.getClient().create(ApiRequest.class);
        Call<ResponseArrayObject> data =api.BaseURL();
        data.enqueue(new Callback<ResponseArrayObject>() {
            @Override
            public void onResponse(Call<ResponseArrayObject> call, Response<ResponseArrayObject> response) {
                try {
                    dbHelper.saveURL(response.body().getIsi_setting());
                }catch (Exception e){

                }
            }

            @Override
            public void onFailure(Call<ResponseArrayObject> call, Throwable t) {
                ascendant.Message(ctx,"Koneksi Gagal !!");
            }
        });
    }
}
