package com.ascendant.kopilancong.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ascendant.kopilancong.Method.Ascendant;
import com.ascendant.kopilancong.Model.DataModel;
import com.ascendant.kopilancong.Model.PesananModel;
import com.ascendant.kopilancong.R;
import com.ascendant.kopilancong.SharedPreferance.DB_Helper;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class StrukAdapter extends RecyclerView.Adapter<StrukAdapter.ViewHolder> {
    private List<PesananModel> mPahlawanList;
    private Context mContext;
    Ascendant ascendant = new Ascendant();
    TextView Total,PPN;
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView nama,harga;

        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            nama= (TextView) v.findViewById(R.id.tvNama);
            harga = (TextView) v.findViewById(R.id.tvHarga);
        }
    }



    // Provide a suitable constructor (depends on the kind of dataset)
    public StrukAdapter(List<PesananModel> myDataset, Context context,TextView Total) {
        mPahlawanList = myDataset;
        mContext = context;
        this.Total = Total;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public StrukAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.list_struk, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        final PesananModel pahlawan = mPahlawanList.get(position);
        Integer Totals = Integer.parseInt(pahlawan.getJumlah())*Integer.parseInt(pahlawan.getHarga());
        Total.setText(ascendant.MagicRP(Double.parseDouble(String.valueOf(Totals+Integer.parseInt(ascendant.MagicChange(Total.getText().toString()))))));

        holder.nama.setText(pahlawan.getNama());
        holder.harga.setText(ascendant.MagicRP(Double.parseDouble(pahlawan.getHarga()))+" (x"+pahlawan.getJumlah()+")");
//        if (Integer.parseInt(pahlawan.getJumlah())<2){
//            holder.harga.setText(ascendant.MagicRP(Double.parseDouble(pahlawan.getHarga())));
//        }else{
//            holder.harga.setText(ascendant.MagicRP(Double.parseDouble(pahlawan.getHarga()))+" (x"+pahlawan.getJumlah()+")");
//        }

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mPahlawanList.size();
    }



}