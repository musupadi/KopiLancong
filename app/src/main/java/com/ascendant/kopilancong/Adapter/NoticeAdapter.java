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

import com.ascendant.kopilancong.Method.Ascendant;
import com.ascendant.kopilancong.Model.DataModel;
import com.ascendant.kopilancong.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.HolderData> {
    private List<DataModel> mList;
    private Context ctx;
    Ascendant ascendant;
    public NoticeAdapter (Context ctx, List<DataModel> mList){
        this.ctx = ctx;
        this.mList = mList;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View layout = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_notice,viewGroup,false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final HolderData holderData, int posistion) {
        DataModel dm = mList.get(posistion);
        ascendant = new Ascendant();
        Glide.with(ctx)
                .load(ascendant.BASE_URL()+"img/notice/"+dm.image_notice)
                .into(holderData.Gambar);
        holderData.Tanggal.setText(ascendant.MagicDateChange(dm.tanggal_notice));
        holderData.Kategori.setText(ascendant.ExtraSmallText(dm.title_notice));
        holderData.Berita.setText(ascendant.FilterTextToJava(ascendant.SmallDescription(dm.notice)));
        holderData.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent goInput = new Intent(ctx, NewsActivity.class);
//                goInput.putExtra("JUDUL",dm.getJudul_berita());
//                goInput.putExtra("KATEGORI",dm.getKategori_berita());
//                goInput.putExtra("TGL_UPLOAD",dm.getCreated_at());
//                goInput.putExtra("COVER",dm.getCover_berita());
//                goInput.putExtra("ISI_BERITA",dm.getIsi_berita());
//                ctx.startActivities(new Intent[]{goInput});
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class HolderData extends RecyclerView.ViewHolder{
        ImageView Gambar;
        TextView Tanggal,Kategori,Berita;
        LinearLayout card;
        public HolderData(View v) {
            super(v);
            Gambar = v.findViewById(R.id.ivGambar);
            Tanggal = v.findViewById(R.id.tvTanggal);
            Kategori = v.findViewById(R.id.tvCategory);
            Berita = v.findViewById(R.id.tvBerita);
            card = v.findViewById(R.id.card);
        }
    }
}