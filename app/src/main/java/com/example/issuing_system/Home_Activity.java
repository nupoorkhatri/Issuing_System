package com.example.issuing_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Home_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void cricket(View view) {
        Intent intent = new Intent(this,CricketActivity.class);
        startActivity(intent);
    }

    public void football(View view) {
        Intent intent = new Intent(this,FootBallActivity.class);
        startActivity(intent);

    }

    public void badminton(View view) {
        Intent intent = new Intent(this,BadmintonActivity.class);
        startActivity(intent);
    }

    public void vollyball(View view) {
        Intent intent = new Intent(this,VollyBallActivity.class);
        startActivity(intent);
    }

    public void longtenis(View view) {
        Intent intent = new Intent(this,LongTenisActivity.class);
        startActivity(intent);
    }

    public void tableTenis(View view) {
        Intent intent = new Intent(this,TableTenisActivity.class);
        startActivity(intent);
    }
}