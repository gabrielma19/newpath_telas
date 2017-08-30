package com.example.user.newpath.activity;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.user.newpath.R;
import com.example.user.newpath.fragment.DashboardUser;
import com.example.user.newpath.fragment.UserProfile;

public class ResultWheelsOfLife extends AppCompatActivity {
    private Button btnFinalizar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_wheels_of_life);
        btnFinalizar = (Button) findViewById(R.id.btnFinalizar);
        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startDashboard();
            }
        });
    }
    public void startDashboard() {
        Intent intent = new Intent(ResultWheelsOfLife.this, UserProfile.class);
        startActivity(intent);
    }
}
