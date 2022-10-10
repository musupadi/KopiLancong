package com.ascendant.kopilancong.Activity;


import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ascendant.kopilancong.Adapter.StrukAdapter;
import com.ascendant.kopilancong.Method.Ascendant;
import com.ascendant.kopilancong.Method.Request;
import com.ascendant.kopilancong.Model.DataModel;
import com.ascendant.kopilancong.R;
import com.ascendant.kopilancong.SharedPreferance.DB_Helper;

import java.util.ArrayList;
import java.util.List;

public class PesananActivity extends AppCompatActivity {
    LinearLayout Back;
    RecyclerView recyclerView;
    Ascendant ascendant = new Ascendant();
    Request request = new Request();
    LinearLayout Pesan;
    TextView Total,PPN;
    DB_Helper dbHelper;
    List<DataModel> mItems = new ArrayList<>();
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesanan);
        dbHelper = new DB_Helper(this);

        InnerClass();
        PPN = findViewById(R.id.tvPPN);
        Total = findViewById(R.id.tvTotal);
        recyclerView = findViewById(R.id.recycler);
        Total.setText("0");
//        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        StrukAdapter Adapter = new StrukAdapter(dbHelper.Pesanan(),this,Total);
        recyclerView.setAdapter(Adapter);
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
}