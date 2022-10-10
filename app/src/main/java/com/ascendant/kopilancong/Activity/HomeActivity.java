package com.ascendant.kopilancong.Activity;


import android.Manifest;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.ascendant.kopilancong.Activity.ui.HomeFragment;
import com.ascendant.kopilancong.Activity.ui.ManagementFragment;
import com.ascendant.kopilancong.Activity.ui.ProfileFragment;
import com.ascendant.kopilancong.Method.Ascendant;
import com.ascendant.kopilancong.Method.Request;
import com.ascendant.kopilancong.R;
import com.ascendant.kopilancong.SharedPreferance.DB_Helper;

public class HomeActivity extends AppCompatActivity {
    LinearLayout LHome, LManagment, LProfile;
    ImageView Home, Management, Profile;
    TextView tvHome,tvManagement,tvProfile;
    Fragment fragment;
    private String[] galleryPermissions =
            {Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.ACCESS_COARSE_LOCATION};
    Request request = new Request();
    Ascendant ascendant= new Ascendant();
    DB_Helper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        try {
            Declaration();
            OnClick();
            Home();
        }catch (Exception e){
            ascendant.Message(this,"Terjadi Kesalahan pada : \n"+e.toString());
        }
    }

    private void OnClick(){
        LHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Home();
            }
        });
        LManagment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Management();
            }
        });
        LProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Profile();
            }
        });
    }
    private void Default(){
        LHome.setBackgroundResource(R.drawable.btn_rounded_white);
        LManagment.setBackgroundResource(R.drawable.btn_rounded_white);
        LProfile.setBackgroundResource(R.drawable.btn_rounded_white);
        Home.setImageResource(R.drawable.home);
        Management.setImageResource(R.drawable.management);
        Profile.setImageResource(R.drawable.profile);
        tvHome.setTextColor(Color.rgb(128,90,70));
        tvManagement.setTextColor(Color.rgb(128,90,70));
        tvProfile.setTextColor(Color.rgb(128,90,70));
    }
    private void Home(){
        Default();
        LHome.setBackgroundResource(R.drawable.btn_rounded_primary);
        Home.setImageResource(R.drawable.home_active);
        tvHome.setTextColor(Color.rgb(255,255,255));
        fragment = new HomeFragment();
        ChangeFragment(fragment);
    }
    private void Management(){
        Default();
        LManagment.setBackgroundResource(R.drawable.btn_rounded_primary);
        Management.setImageResource(R.drawable.management_active);
        tvManagement.setTextColor(Color.rgb(255,255,255));
        fragment = new ManagementFragment();
        ChangeFragment(fragment);
    }
    private void Profile(){
        Default();
        LProfile.setBackgroundResource(R.drawable.btn_rounded_primary);
        Profile.setImageResource(R.drawable.profile_active);
        tvProfile.setTextColor(Color.rgb(255,255,255));
        fragment = new ProfileFragment();
        ChangeFragment(fragment);
    }
    private void Declaration(){
        LHome = findViewById(R.id.linearHome);
        LManagment = findViewById(R.id.linearManagement);
        LProfile = findViewById(R.id.linearProfile);
        Home = findViewById(R.id.ivHome);
        Management = findViewById(R.id.ivManagement);
        Profile = findViewById(R.id.ivProfile);
        tvHome = findViewById(R.id.tvHome);
        tvManagement = findViewById(R.id.tvManmagement);
        tvProfile = findViewById(R.id.tvProfile);
    }
    private void ChangeFragment(Fragment fragment){
        if(fragment != null){
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(R.id.Container,fragment);
            ft.commit();
        }
    }
}