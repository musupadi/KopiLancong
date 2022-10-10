package com.ascendant.kopilancong.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ascendant.kopilancong.Activity.DetailTransactionHistoryActivity;
import com.ascendant.kopilancong.Method.Ascendant;
import com.ascendant.kopilancong.Model.DataModel;
import com.ascendant.kopilancong.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.HolderData> {
    private List<DataModel> mList;
    private Context ctx;
    Ascendant ascendant;
    public TransactionAdapter(Context ctx, List<DataModel> mList){
        this.ctx = ctx;
        this.mList = mList;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View layout = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_transaction,viewGroup,false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final HolderData holderData, int posistion) {
        DataModel dm = mList.get(posistion);
        ascendant = new Ascendant();
        holderData.Tanggal.setText(ascendant.MagicDateChange(dm.waktu_transaksi));
        holderData.TotalHarga.setText(ascendant.MagicRP(Double.parseDouble(dm.total_harga)));
        holderData.Pembayaran.setText(ascendant.MagicRP(Double.parseDouble(dm.pembayaran)));
        holderData.Kembalian.setText(ascendant.MagicRP(Double.parseDouble(dm.kembalian)));
        holderData.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ctx, DetailTransactionHistoryActivity.class);
                i.putExtra("ID", dm.id_transaksi);
                ctx.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class HolderData extends RecyclerView.ViewHolder{
        ImageView Gambar;
        TextView Tanggal,TotalHarga,Pembayaran,Kembalian;
        LinearLayout card;
        public HolderData(View v) {
            super(v);
            Gambar = v.findViewById(R.id.ivGambar);
            Tanggal = v.findViewById(R.id.tvTanggal);
            TotalHarga = v.findViewById(R.id.tvTotalHarga);
            Pembayaran = v.findViewById(R.id.tvPembayaran);
            Kembalian = v.findViewById(R.id.tvKembalian);
            card = v.findViewById(R.id.card);
        }
    }
}