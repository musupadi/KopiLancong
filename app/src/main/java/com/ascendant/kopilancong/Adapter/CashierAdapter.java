package com.ascendant.kopilancong.Adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ascendant.kopilancong.Activity.CashierActivity;
import com.ascendant.kopilancong.Method.Ascendant;
import com.ascendant.kopilancong.Model.DataModel;
import com.ascendant.kopilancong.R;
import com.ascendant.kopilancong.SharedPreferance.DB_Helper;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CashierAdapter extends RecyclerView.Adapter<CashierAdapter.HolderData> {
    private List<DataModel> mList;
    private Context ctx;
    LinearLayout Pesan;
    TextView Jumlah,Total,Totalso;
    Ascendant ascendant;
    ArrayList<String> ID_Product = new ArrayList<String>();
    DB_Helper dbHelper;
    String BaseURL;
    public CashierAdapter(Context ctx, List<DataModel> mList,LinearLayout Pesan,TextView Jumlah,TextView Total,ArrayList<String> ID_Product,String BaseURL,TextView Totalso){
        this.ctx = ctx;
        this.mList = mList;
        this.Pesan = Pesan;
        this.Jumlah = Jumlah;
        this.Total = Total;
        this.ID_Product = ID_Product;
        this.BaseURL = BaseURL;
        this.Totalso = Totalso;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View layout = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_cashier,viewGroup,false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final HolderData holderData, int posistion) {
        DataModel dm = mList.get(posistion);
        dbHelper = new DB_Helper(ctx);
        ascendant = new Ascendant();
        Glide.with(ctx)
                .load(BaseURL+dm.img_product)
                .into(holderData.Gambar);
        holderData.Nama.setText(dm.nama_product);
        holderData.Price.setText(ascendant.MagicRP(Double.parseDouble(dm.harga_product)));
        holderData.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ID_Product.add(dm.id_product);
                holderData.add.setVisibility(View.GONE);
                holderData.added.setVisibility(View.VISIBLE);
                holderData.Jumlah.setText("0");
                int Jumlahs = Integer.parseInt(holderData.Jumlah.getText().toString())+1;
                holderData.Jumlah.setText(String.valueOf(Jumlahs));
                int Totals = ID_Product.size();
                Jumlah.setText(String.valueOf(Totals+" Items"));
                int TotalNilai = Integer.parseInt(ascendant.MagicChange(Total.getText().toString()))+Integer.parseInt(ascendant.MagicChange(dm.harga_product));
                Total.setText(String.valueOf(ascendant.MagicRP(Double.parseDouble(String.valueOf(TotalNilai)))));
                Totalso.setText(String.valueOf(ascendant.MagicRP(Double.parseDouble(String.valueOf(TotalNilai)))));
                Pesan.setVisibility(View.VISIBLE);
                dbHelper.InputCashier(
                        dm.id_product,
                        dm.img_product,
                        dm.nama_product,
                        ascendant.MagicChange(dm.harga_product),
                        "1");
            }
        });
        holderData.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ID_Product.add(dm.id_product);
                int Jumlahs = Integer.parseInt(holderData.Jumlah.getText().toString())+1;
                holderData.Jumlah.setText(String.valueOf(Jumlahs));
                int Totals = ID_Product.size();
                Jumlah.setText(String.valueOf(Totals+" Items"));
                int TotalNilai = Integer.parseInt(ascendant.MagicChange(Total.getText().toString()))+Integer.parseInt(ascendant.MagicChange(dm.harga_product));
                Total.setText(String.valueOf(ascendant.MagicRP(Double.parseDouble(String.valueOf(TotalNilai)))));
                Totalso.setText(String.valueOf(ascendant.MagicRP(Double.parseDouble(String.valueOf(TotalNilai)))));
                Pesan.setVisibility(View.VISIBLE);
                dbHelper.UpdateCashier(dm.id_product,String.valueOf(Jumlahs));
//                ascendant.Message(ctx,String.valueOf(String.valueOf()));
            }
        });
        holderData.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ID_Product.remove(dm.id_product);
                int Jumlahs = Integer.parseInt(holderData.Jumlah.getText().toString())-1;
                holderData.Jumlah.setText(String.valueOf(Jumlahs));
                int Totals = ID_Product.size();
                Jumlah.setText(String.valueOf(Totals+" Items"));
                int TotalNilai = Integer.parseInt(ascendant.MagicChange(Total.getText().toString()))-Integer.parseInt(ascendant.MagicChange(dm.harga_product));
                Total.setText(String.valueOf(ascendant.MagicRP(Double.parseDouble(String.valueOf(TotalNilai)))));
                Totalso.setText(String.valueOf(ascendant.MagicRP(Double.parseDouble(String.valueOf(TotalNilai)))));
                Pesan.setVisibility(View.VISIBLE);
                dbHelper.UpdateCashier(dm.id_product,String.valueOf(Jumlahs));
                if (holderData.Jumlah.getText().toString().equals("0")){
                    holderData.add.setVisibility(View.VISIBLE);
                    holderData.added.setVisibility(View.GONE);
                    dbHelper.DeleteCashier(dm.id_product);
                    Pesan.setVisibility(View.GONE);
                }
                if (Jumlah.getText().toString().equals("0")){
                    Pesan.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class HolderData extends RecyclerView.ViewHolder{
        ImageView Gambar;
        TextView Nama,Price,Jumlah;
        LinearLayout card,add,added,plus,minus,note;
        public HolderData(View v) {
            super(v);
            Gambar = v.findViewById(R.id.ivGambar);
            Nama = v.findViewById(R.id.tvProduct);
            Price = v.findViewById(R.id.tvHarga);
            Jumlah = v.findViewById(R.id.tvJumlah);
            add= v.findViewById(R.id.linearAdd);
            added = v.findViewById(R.id.linearAdded);
            plus = v.findViewById(R.id.linearPlus);
            minus = v.findViewById(R.id.linearMinus);
            note = v.findViewById(R.id.linearNote);
            card = v.findViewById(R.id.card);
        }
    }
}