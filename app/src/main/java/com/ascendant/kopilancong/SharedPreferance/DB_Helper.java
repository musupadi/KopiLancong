package com.ascendant.kopilancong.SharedPreferance;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.ascendant.kopilancong.Model.PesananModel;

import java.util.LinkedList;
import java.util.List;

@SuppressLint("Range")
public class DB_Helper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "kopi_lancong.db";
    private static final int DATABASE_VERSION = 4;
    public static final String TABLE_NAME = "session";
    public static final String COLUMN_TOKEN = "token";
    public static final String COLUMN_LEVEL = "level";

    public static final String TABLE_CASHIER = "cashier";
    public static final String COLUMN_ID_PRODUCT = "id_product";
    public static final String COLUMN_GAMBAR = "gambar";
    public static final String COLUMN_NAMA = "nama";
    public static final String COLUMN_HARGA = "harga";
    public static final String COLUMN_JUMLAH = "jumlah";

    public static final String TABLE_URL = "base";
    public static final String COLUMN_URL = "url";
    public DB_Helper(Context context){super(
            context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME+" (" +
                COLUMN_TOKEN+" TEXT PRIMARY KEY, "+
                COLUMN_LEVEL+" TEXT NOT NULL);"
        );

        db.execSQL("CREATE TABLE "+TABLE_CASHIER+" (" +
                COLUMN_ID_PRODUCT+" TEXT PRIMARY KEY, "+
                COLUMN_GAMBAR+" TEXT NOT NULL, "+
                COLUMN_NAMA+" TEXT NOT NULL, "+
                COLUMN_HARGA+" TEXT NOT NULL, "+
                COLUMN_JUMLAH+" TEXT NOT NULL);"
        );

        db.execSQL("CREATE TABLE "+TABLE_URL+" (" +
                COLUMN_URL+" TEXT PRIMARY KEY);"
        );
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CASHIER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_URL);
        this.onCreate(db);
    }

    public void saveSession(String TOKEN,String level){
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TOKEN, TOKEN);
        values.put(COLUMN_LEVEL,level);
        db.insert(TABLE_NAME,null,values);
        db.close();
    }

    public void saveURL(String URL){
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_URL, URL);
        db.insert(TABLE_URL,null,values);
        db.close();
    }


    public List<PesananModel> Pesanan() {
        String query = "SELECT  * FROM " + TABLE_CASHIER;

        List<PesananModel> LinkedList = new LinkedList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        PesananModel pahlawan;

        if (cursor.moveToFirst()) {
            do {
                pahlawan = new PesananModel();
                pahlawan.setId_product(cursor.getString(cursor.getColumnIndex(COLUMN_ID_PRODUCT)));
                pahlawan.setGambar(cursor.getString(cursor.getColumnIndex(COLUMN_GAMBAR)));
                pahlawan.setNama(cursor.getString(cursor.getColumnIndex(COLUMN_NAMA)));
                pahlawan.setHarga(cursor.getString(cursor.getColumnIndex(COLUMN_HARGA)));
                pahlawan.setJumlah(cursor.getString(cursor.getColumnIndex(COLUMN_JUMLAH)));
                LinkedList.add(pahlawan);
            } while (cursor.moveToNext());
        }
        return LinkedList;
    }
    public void InputCashier(String ID,String Gambar,String nama,String harga,String Jumlah){
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID_PRODUCT, ID);
        values.put(COLUMN_GAMBAR, Gambar);
        values.put(COLUMN_NAMA, nama);
        values.put(COLUMN_HARGA, harga);
        values.put(COLUMN_JUMLAH,Jumlah);
        db.insert(TABLE_CASHIER,null,values);
        db.close();
    }
    public void UpdateCashier(String ID,String Jumlah){
//        String sql = "UPDATE "+TABLE_CASHIER+" SET "+COLUMN_JUMLAH+" = "+Jumlah+" WHERE "+COLUMN_ID+" = "+ID+"";
//        SQLiteDatabase.(sql);
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE "+TABLE_CASHIER+" SET "+COLUMN_JUMLAH+" = "+Jumlah+" WHERE "+COLUMN_ID_PRODUCT+" = "+ID+"");
    }
    public void DeleteCashier(String ID){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM "+TABLE_CASHIER+" WHERE "+COLUMN_ID_PRODUCT+"="+ID+"");
    }

    public void DestroyCashier(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM "+TABLE_CASHIER+"");
    }
    public Cursor checkSession(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query ="SELECT * FROM "+TABLE_NAME+"";
        Cursor cursor = db.rawQuery(query,null);
        return cursor;
    }
    public Cursor checkURL(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query ="SELECT * FROM "+TABLE_URL+"";
        Cursor cursor = db.rawQuery(query,null);
        return cursor;
    }
    public Cursor checkCashier(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query ="SELECT * FROM "+TABLE_CASHIER+"";
        Cursor cursor = db.rawQuery(query,null);
        return cursor;
    }
    public void userDestroyURL(String URL){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM "+TABLE_NAME+"");
    }
    public void userLogout(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM "+TABLE_NAME+"");
    }
}
