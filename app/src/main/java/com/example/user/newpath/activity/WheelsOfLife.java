package com.example.user.newpath.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.user.newpath.R;
import com.example.user.newpath.helper.Preferences;

public class WheelsOfLife extends AppCompatActivity {
    private Button btn_start_wheels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wheels_of_life);

        btn_start_wheels = (Button) findViewById(R.id.btn_start_wheels);

        btn_start_wheels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startWheels();
            }
        });
    }
    public void startWheels(){
        Intent intent = new Intent(this, RangeWheesLife.class);
        startActivity(intent);
    }
}
