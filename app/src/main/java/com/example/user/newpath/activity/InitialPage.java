package com.example.user.newpath.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.user.newpath.R;

public class InitialPage extends AppCompatActivity {
    Button btn_singUp;
    Button btn_loginFacebook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_page);

        btn_loginFacebook = (Button) findViewById(R.id.btn_loginFacebook);
        btn_singUp = (Button) findViewById(R.id.btn_singUp);

        btn_loginFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                singUp();
            }
        });

        btn_singUp.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                singUp();
            }
        });
    }
    private void singUp(){
        Intent intent = new Intent(this, LoginPage.class);
        startActivity(intent);
    }
}
