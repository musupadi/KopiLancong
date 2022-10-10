package com.ascendant.kopilancong.Method;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ascendant.kopilancong.Activity.CashierActivity;
import com.ascendant.kopilancong.Activity.LoginActivity;
import com.ascendant.kopilancong.R;
import com.ascendant.kopilancong.SharedPreferance.DB_Helper;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class Ascendant {
    public String AUTH(String auth){
        String authHeader = "Bearer "+auth;
        return authHeader;
    }
    public String MagicChange(String magic){
        String MAGIC1 = magic.replace("Rp ","");
        String MAGIC2 = MAGIC1.replace(",","");
        return MAGIC2.replace(".","");
    }
    public String MagicRP(double nilai){
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        BigDecimal bd1 = new BigDecimal(nilai).setScale(0, RoundingMode.HALF_UP);
        String MAGIC1 = formatRupiah.format(bd1).replace("Rp","Rp ");
        String MAGIC2 = MAGIC1.replace("000,00","000");
        return MAGIC2;
    }
    public String BASE_URL(){
        String URL = "http://kasir.desabanjarwaru.id/";
        return URL;
    }
    public String FilterToNumber(String text){
        String replaces = text.replace(",","");
        String replaces1 = replaces.replace(".","");
        return replaces1;
    }
    public String FilterTextToJava(String text){
        String replaces = text.replace("</p>\\r\\n<ol>\\r\\n<li>","");
        String replace1 = replaces.replace("<p>","");
        String replace2 = replace1.replace("</p>","");
        String replace3 = replace2.replace("<span style=\"color: #ff6600;\">","");
        String replace4 = replace3.replace("</span>","");
        String replace5 = replace4.replace("<strong>","");
        String replace6 = replace5.replace("</strong>","");
        String replace7 = replace6.replace("<ol>","");
        String replace8 = replace7.replace("</ol>","");
        String replace9 = replace8.replace("<li>","");
        String replace10 = replace9.replace("</li>","");
        String replace11 = replace10.replace("<ul>","");
        String replace12 = replace11.replace("</ul>","");
        String replace13 = replace12.replace("\\n\\n","\\n");
        String replace14 = replace13.replace("<div>","");
        String replace15 = replace14.replace("</div>","");
        String replace16 = replace15.replace("<p>1.","");
        String replace17 = replace16.replace("<p style=\\\"text-align: left;\\\">","");
        String replace18 = replace17.replace("<em>","");
        String replace19 = replace18.replace("</em>","");
        String replace20 = replace19.replace("&nbsp","");
        return replace20;
    }
    public String MagicDateChange(String dates){
        String result = "";
        String year = dates.substring(0,4);
        String month = dates.substring(5,7);
        String day = dates.substring(8,10);

        String MONTH = "Januari";
        if (month.equals("01") || month.equals("1")){
            MONTH = "Januari";
        }else if (month.equals("02") || month.equals("2")){
            MONTH = "Februari";
        }else if (month.equals("03") || month.equals("3")){
            MONTH = "Maret";
        }else if (month.equals("04") || month.equals("4")){
            MONTH = "April";
        }else if (month.equals("05") || month.equals("5")){
            MONTH = "Mei";
        }else if (month.equals("06") || month.equals("6")){
            MONTH = "Juni";
        }else if (month.equals("07") || month.equals("7")){
            MONTH = "Juli";
        }else if (month.equals("08") || month.equals("8")){
            MONTH = "Agustus";
        }else if (month.equals("09") || month.equals("9")){
            MONTH = "September";
        }else if (month.equals("10")){
            MONTH = "Oktober";
        }else if (month.equals("11")){
            MONTH = "November";
        }else if (month.equals("12")){
            MONTH = "Desember";
        }
        result = day+" "+MONTH+" "+year;
        return result;

    }
    public String SmallDescription(String description){
        String Des = description;
        if (description.length() >= 100){
            Des = description.substring(0,100)+"...";
        }
        return Des;
    }
    public String ExtraSmallText(String description){
        String Des = description;
        if (description.length() >= 15){
            Des = description.substring(0,15)+"...";
        }
        return Des;
    }
    public String SmallText(String description){
        String Des = description;
        if (description.length() >= 50){
            Des = description.substring(0,50)+"...";
        }
        return Des;
    }
    public void Message(Context ctx, String Message){
        TextView Pesan;
        Button KonfirmasiPesan;
        Dialog pesan = new Dialog(ctx);
        pesan.setContentView(R.layout.dialog_message);
        pesan.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        pesan.getWindow().setBackgroundDrawableResource(R.drawable.button_corner_white);
        Pesan = pesan.findViewById(R.id.tvPesan);
        KonfirmasiPesan = pesan.findViewById(R.id.btnKonfirmasi);
        Pesan.setText(Message);
        pesan.show();
        KonfirmasiPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                pesan.hide();
            }
        });
    }
    public void LogoutMessage(Context ctx, String Message) {
        DB_Helper dbHelper = new DB_Helper(ctx);
        TextView Pesan;
        Button KonfirmasiPesan;
        Dialog pesan = new Dialog(ctx);
        pesan.setContentView(R.layout.dialog_message);
        pesan.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        pesan.getWindow().setBackgroundDrawableResource(R.drawable.button_corner_white);
        Pesan = pesan.findViewById(R.id.tvPesan);
        KonfirmasiPesan = pesan.findViewById(R.id.btnKonfirmasi);
        Pesan.setText(Message);
        pesan.show();
        KonfirmasiPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                dbHelper.userLogout();
                Intent intent = new Intent(ctx, LoginActivity.class);
                ctx.startActivity(intent);
            }
        });
    }
    public void TransactionMessage2(Context ctx, String Message){
        TextView Pesan;
        Button KonfirmasiPesan;
        Dialog pesan = new Dialog(ctx);
        pesan.setContentView(R.layout.dialog_message);
        pesan.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        pesan.getWindow().setBackgroundDrawableResource(R.drawable.button_corner_white);
        Pesan = pesan.findViewById(R.id.tvPesan);
        KonfirmasiPesan = pesan.findViewById(R.id.btnKonfirmasi);
        Pesan.setText(Message);
        pesan.show();
        KonfirmasiPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                Intent intent = new Intent(ctx, CashierActivity.class);
                ctx.startActivity(intent);
            }
        });
    }
    public void TransactionMessage(Context ctx, ArrayList<String> ID_PESANAN, ArrayList<String> Jumlah, EditText JumlahPesanan, String Token,String Message){
        Request request = new Request();
        TextView Pesan;
        Button KonfirmasiPesan;
        Dialog pesan = new Dialog(ctx);
        pesan.setContentView(R.layout.dialog_message);
        pesan.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        pesan.getWindow().setBackgroundDrawableResource(R.drawable.button_corner_white);
        Pesan = pesan.findViewById(R.id.tvPesan);
        KonfirmasiPesan = pesan.findViewById(R.id.btnKonfirmasi);
        Pesan.setText(Message);
        pesan.show();
        KonfirmasiPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                request.Pesan(ctx,ID_PESANAN,Jumlah,JumlahPesanan,Token);
            }
        });
    }
}
