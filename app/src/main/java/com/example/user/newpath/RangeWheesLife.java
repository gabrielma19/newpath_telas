package com.example.user.newpath;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RangeWheesLife extends AppCompatActivity {
    Button btn_next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_range_whees_life);

        btn_next = (Button) findViewById(R.id.btn_next);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextPageWheels();
            }
        });
    }
    public void nextPageWheels(){
        Intent intent = new Intent(this, RangeWheelsLife_Two.class);
        startActivity(intent);
    }
}
