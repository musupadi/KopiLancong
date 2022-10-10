package com.ascendant.kopilancong.Activity;


import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ascendant.kopilancong.Adapter.StrukAdapter;
import com.ascendant.kopilancong.Method.Ascendant;
import com.ascendant.kopilancong.Method.NumberTextWatcher;
import com.ascendant.kopilancong.Method.Request;
import com.ascendant.kopilancong.R;
import com.ascendant.kopilancong.SharedPreferance.DB_Helper;

import java.util.ArrayList;

public class CashierActivity extends AppCompatActivity {
    LinearLayout Back;
    RecyclerView rv,recyclerView;
    Ascendant ascendant = new Ascendant();
    Request request = new Request();
    LinearLayout Pesan;
    TextView Total,Jumlah,Totals,PPN;
    DB_Helper dbHelper;
    Button Konfirmasi;
    Dialog dialog;
    String TOKEN,NAMA,LEVEL;
    EditText JumlahBayar;
    ArrayList<String> ID_PESANAN = new ArrayList<String>();
    ArrayList<String> JUMLAH_PESANAN = new ArrayList<String>();

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cashier);
        dbHelper = new DB_Helper(this);
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_struk);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.button_corner_white);
        recyclerView = dialog.findViewById(R.id.recycler);
        Totals  = dialog.findViewById(R.id.tvTotal);
        PPN = dialog.findViewById(R.id.tvPPN);
        JumlahBayar = dialog.findViewById(R.id.etJumlahBayar);
        Konfirmasi = dialog.findViewById(R.id.btnKonfirmasi);
        Cursor cursor = dbHelper.checkSession();
        if (cursor.getCount()>0){
            while (cursor.moveToNext()){
                TOKEN = cursor.getString(0);
                LEVEL = cursor.getString(1);
            }
        }
        dbHelper.DestroyCashier();
        InnerClass();
        rv = findViewById(R.id.recycler);
        Total = findViewById(R.id.tvTotal);
        Jumlah = findViewById(R.id.tvJumlahItem);
        Pesan = findViewById(R.id.linearPesan);
        Pesan.setVisibility(View.GONE);
        rv.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View view, int i, int i1, int i2, int i3) {
                Pesan.setVisibility(View.GONE);
            }
        });
        request.Cashier(CashierActivity.this,rv,Pesan,Jumlah,Total,TOKEN,"",Totals);
        Pesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Totals.setText("0");
                recyclerView.setLayoutManager(new LinearLayoutManager(CashierActivity.this));
                StrukAdapter Adapter = new StrukAdapter(dbHelper.Pesanan(),CashierActivity.this,Totals);
                recyclerView.setAdapter(Adapter);
                dialog.show();
                Konfirmasi.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Cursor cursors = dbHelper.checkCashier();
                        if (cursors.getCount()>0){
                            while (cursors.moveToNext()){
                                ID_PESANAN.add(cursors.getString(0));
                                JUMLAH_PESANAN.add(cursors.getString(4));
                            }
                        }else{

                        }
                        try {
                            int hitungan = Integer.parseInt(ascendant.MagicChange(Totals.getText().toString()));
                            if (Integer.parseInt(ascendant.MagicChange(JumlahBayar.getText().toString()))-hitungan>0){
                                dialog.hide();
                                ascendant.TransactionMessage(CashierActivity.this,ID_PESANAN,JUMLAH_PESANAN,JumlahBayar,TOKEN,"Kembali : "+ascendant.MagicRP(Double.parseDouble(String.valueOf(Integer.parseInt(ascendant.MagicChange(JumlahBayar.getText().toString()))-hitungan))));
                            }else if (Integer.parseInt(ascendant.MagicChange(JumlahBayar.getText().toString()))-hitungan==0){
                                dialog.hide();
                                ascendant.TransactionMessage(CashierActivity.this,ID_PESANAN,JUMLAH_PESANAN,JumlahBayar,TOKEN,"Jumlah bayar Pas");
                            }else if (Integer.parseInt(ascendant.MagicChange(JumlahBayar.getText().toString()))-hitungan<0){
                                dialog.hide();
                                ascendant.Message(CashierActivity.this,"Jumlah Bayar Kurang");
                            }else{
                                dialog.hide();
                                ascendant.Message(CashierActivity.this,"Harap Isi Jumlah Bayar !!");
                            }
                        }catch (Exception e){
                            dialog.hide();
                            ascendant.Message(CashierActivity.this,"Harap Isi Jumlah Bayar !!");
                        }
//
                    }
                });
            }
        });
        JumlahBayar.addTextChangedListener(new NumberTextWatcher(JumlahBayar));

    }
    private void InnerClass(){
        Back = findViewById(R.id.linearBack);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(CashierActivity.this,HomeActivity.class);
        startActivity(intent);
    }
}