package com.example.issuing_system;

import static com.example.issuing_system.R.id.nav_about_us;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class Home_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case nav_about_us:
                Intent intent = new Intent(this,AboutUsActivity.class);
                startActivity(intent);

                return true;
            case R.id.nav_Logout:
                Intent intent1 = new Intent(this,LoginActivity.class);
                startActivity(intent1);
                Toast.makeText(this, "Successfully Logout", Toast.LENGTH_SHORT).show();
                return true;
        }

        return super.onOptionsItemSelected(item);
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