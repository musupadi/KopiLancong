package com.ascendant.kopilancong.Activity;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.ascendant.kopilancong.Method.Ascendant;
import com.ascendant.kopilancong.Method.Request;
import com.ascendant.kopilancong.R;
import com.ascendant.kopilancong.SharedPreferance.DB_Helper;

public class DetailTransactionHistoryActivity extends AppCompatActivity {
    LinearLayout Back;
    RecyclerView rv,recyclerView;
    Ascendant ascendant = new Ascendant();
    Request request = new Request();
    DB_Helper dbHelper;
    String TOKEN,NAMA,LEVEL,ID;
    TextView Tanggal,TotalHarga,Pembayaran,Kembalian;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_transaction_history);
        dbHelper = new DB_Helper(this);
        Cursor cursor = dbHelper.checkSession();
        if (cursor.getCount()>0){
            while (cursor.moveToNext()){
                TOKEN = cursor.getString(0);
                LEVEL = cursor.getString(1);
            }
        }
        InnerClass();
        rv = findViewById(R.id.recycler);
        Intent intent = getIntent();
        ID = intent.getExtras().getString("ID");
        request.DetailTransactionHistory(DetailTransactionHistoryActivity.this,rv,TOKEN,ID,Tanggal,TotalHarga,Pembayaran,Kembalian);
    }
    private void InnerClass(){
        Back = findViewById(R.id.linearBack);
        Tanggal = findViewById(R.id.tvTanggal);
        TotalHarga = findViewById(R.id.tvTotalHarga);
        Pembayaran = findViewById(R.id.tvPembayaran);
        Kembalian = findViewById(R.id.tvKembalian);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}