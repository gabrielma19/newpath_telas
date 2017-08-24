package com.example.user.newpath.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.user.newpath.R;

public class LoginPage extends AppCompatActivity {
    Button btn_login;
    TextView txt_singup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        btn_login = (Button) findViewById(R.id.btn_login);
        txt_singup = (TextView) findViewById(R.id.txt_singup);

        txt_singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                singUpStart();
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wheelsLife();
            }
        });
    }


    public void  wheelsLife(){
        Intent intent = new Intent(LoginPage.this, WheelsOfLife.class);
        startActivity(intent);
    }
    public void singUpStart() {
        Intent intent = new Intent(LoginPage.this, RegisterEmail.class);
        startActivity(intent);
    }


}
