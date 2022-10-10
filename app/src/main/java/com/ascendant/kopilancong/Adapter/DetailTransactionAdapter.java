package com.ascendant.kopilancong.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ascendant.kopilancong.Method.Ascendant;
import com.ascendant.kopilancong.Model.DataModel;
import com.ascendant.kopilancong.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class DetailTransactionAdapter extends RecyclerView.Adapter<DetailTransactionAdapter.HolderData> {
    private List<DataModel> mList;
    private Context ctx;
    Ascendant ascendant;
    public DetailTransactionAdapter(Context ctx, List<DataModel> mList){
        this.ctx = ctx;
        this.mList = mList;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View layout = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_detail_transaction,viewGroup,false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final HolderData holderData, int posistion) {
        DataModel dm = mList.get(posistion);
        ascendant = new Ascendant();
        Glide.with(ctx)
                .load(dm.img_product)
                .into(holderData.Gambar);
        holderData.Nama.setText(ascendant.MagicDateChange(dm.nama_product));
        holderData.Price.setText(ascendant.MagicRP(Double.parseDouble(dm.harga_product)));
        holderData.Jumlah.setText(dm.quantity);
        holderData.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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
        LinearLayout card;
        public HolderData(View v) {
            super(v);
            Gambar = v.findViewById(R.id.ivGambar);
            Nama = v.findViewById(R.id.tvProduct);
            Price = v.findViewById(R.id.tvHarga);
            Jumlah = v.findViewById(R.id.tvQuantity);
            card = v.findViewById(R.id.card);
        }
    }
}