package com.example.user.newpath.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.user.newpath.R;
import com.example.user.newpath.activity.InitialPage;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Handler handle = new Handler();

        handle.postDelayed(new Runnable() {
            @Override
            public void run() {
                initialPage();
            }
        }, 3000);
    }
    private void initialPage(){
        Intent intent = new Intent(this, InitialPage.class);
        startActivity(intent);
        //Fade_in to inital page
        overridePendingTransition(R.anim.fade_in, 0);

        finish();
    }
}
