package com.ascendant.kopilancong.Activity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.ascendant.kopilancong.Method.Ascendant;
import com.ascendant.kopilancong.Method.Request;
import com.ascendant.kopilancong.R;

public class LoginActivity extends AppCompatActivity {
    EditText Email,Password;
    Button Login;
    Ascendant ascendant = new Ascendant();
    Request request = new Request();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Email = findViewById(R.id.etEmail);
        Password = findViewById(R.id.etPassword);
        Login = findViewById(R.id.btnLogin);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Checker();
            }
        });
    }
    private void Checker(){
        if (Email.equals("") || Email.getText().toString().isEmpty()){
            ascendant.Message(LoginActivity.this,"Email Cannot be Empty");
        }else if (Password.equals("") || Password.getText().toString().isEmpty()){
            ascendant.Message(LoginActivity.this,"Password Cannot be Empty");
        }else{
            request.Login(LoginActivity.this,Email.getText().toString(),Password.getText().toString());
        }
    }
}