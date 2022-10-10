package com.ascendant.kopilancong.Activity.ui;

import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.ascendant.kopilancong.Activity.CashierActivity;
import com.ascendant.kopilancong.Activity.TransactionHistoryActivity;
import com.ascendant.kopilancong.Method.Ascendant;
import com.ascendant.kopilancong.Method.Request;
import com.ascendant.kopilancong.R;
import com.ascendant.kopilancong.SharedPreferance.DB_Helper;
import com.bumptech.glide.Glide;

public class HomeFragment extends Fragment {
    ImageView Profile;
    TextView Nama,Levels,ProfitToday;
    RelativeLayout Loading;
    ScrollView Available;
    Ascendant ascendant = new Ascendant();
    Request request = new Request();
    DB_Helper dbHelper;
    String TOKEN,NAMA,LEVEL;
    RecyclerView recyclerView;

    LinearLayout Cashier,Transaction;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dbHelper = new DB_Helper(getActivity());
        Cursor cursor = dbHelper.checkSession();
        if (cursor.getCount()>0){
            while (cursor.moveToNext()){
                TOKEN = cursor.getString(0);
                LEVEL = cursor.getString(1);
            }
        }
        //Menu
        Cashier = view.findViewById(R.id.linearCashier);

        Transaction = view.findViewById(R.id.linearTransaction);
        ProfitToday = view.findViewById(R.id.tvProfitToday);
        Nama= view.findViewById(R.id.tvNama);
        Levels = view.findViewById(R.id.tvLevel);
        Loading = view.findViewById(R.id.linearLoading);
        Available = view.findViewById(R.id.scrollAvailable);
        Profile = view.findViewById(R.id.ivProfile);
        recyclerView = view.findViewById(R.id.recycler);
        request.Profil(getActivity(),ascendant.AUTH(TOKEN),Nama,Levels,Profile);
        Loading.setVisibility(View.GONE);
        final LayoutAnimationController layoutAnimationController = AnimationUtils.loadLayoutAnimation(getActivity(), R.anim.layout_animation2);
        Nama.setAnimation(layoutAnimationController.getAnimation());
        Levels.setAnimation(layoutAnimationController.getAnimation());
        final LayoutAnimationController layoutAnimationController2 = AnimationUtils.loadLayoutAnimation(getActivity(), R.anim.layout_animation3);
        ProfitToday.setAnimation(layoutAnimationController2.getAnimation());
        Cashier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CashierActivity.class);
                startActivity(intent);
            }
        });
        Transaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), TransactionHistoryActivity.class);
                startActivity(intent);
            }
        });
    }
}