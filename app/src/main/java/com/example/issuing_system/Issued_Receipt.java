package com.example.issuing_system;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Issued_Receipt extends AppCompatActivity {

    TextView t1,t2,t3,t4,t5,t7,t8,t9,t10,t11;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issued_receipt);

        t1 = findViewById(R.id.textView3);
        t2 = findViewById(R.id.textView4);
        t3 = findViewById(R.id.textView5);
        t4 = findViewById(R.id.textView6);
        t5 = findViewById(R.id.textView7);
        t7 = findViewById(R.id.textView9);
        t8 = findViewById(R.id.textView10);
        t9 = findViewById(R.id.textView11);
        t10 = findViewById(R.id.textView12);
        t11 = findViewById(R.id.textView13);


        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance().format(calendar.getTime());

        t11.setText(currentDate);

        String category = getIntent().getStringExtra("keyname");
        t8.setText(category);

        String quantity = getIntent().getStringExtra("keyquantity");
        t10.setText(quantity);

        String equipment = getIntent().getStringExtra("keyeq");
        t9.setText(equipment);

    }
}