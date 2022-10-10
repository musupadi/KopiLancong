package com.ascendant.kopilancong.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;

import com.ascendant.kopilancong.Method.Request;
import com.ascendant.kopilancong.R;
import com.ascendant.kopilancong.SharedPreferance.DB_Helper;

public class MainActivity extends AppCompatActivity {
    String TOKEN,NAMA,LEVEL;
    DB_Helper db_helper;
    Request request = new Request();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db_helper = new DB_Helper(this);
        request.BaseURL(this);
        final Handler handler = new Handler();
        Cursor cursor = db_helper.checkSession();
        if (cursor.getCount()>0){
            handler.postDelayed(new Runnable() {
                public void run() {
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                }
            }, 0000);
        }else{
            handler.postDelayed(new Runnable() {
                public void run() {
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }, 3000); //3000 L = 3 detik
        }
    }
}