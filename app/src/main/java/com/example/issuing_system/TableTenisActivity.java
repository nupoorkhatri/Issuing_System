package com.example.issuing_system;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class TableTenisActivity extends AppCompatActivity {

    ImageView backb;

    Spinner sp;

    TextView value,sname;

    Button confirm;
    int count = 0;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_tenis);

        value = (TextView) findViewById(R.id.value);
        backb = findViewById(R.id.back_arrow);
        sname = findViewById(R.id.sname);
        sp = findViewById(R.id.spinner);
        confirm = findViewById(R.id.button1);

        backb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TableTenisActivity.this,Home_Activity.class);
                startActivity(intent);
            }
        });

        ArrayAdapter ar = ArrayAdapter.createFromResource(this,R.array.table_tennis, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        sp.setAdapter(ar);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(TableTenisActivity.this,Issued_Receipt.class);
                startActivity(intent);

            }
        });

    }

    public void increment (View v){
        if(count >= 3 ) count = 3;
        else count++;
        value.setText(""+ count);
    }

    public void decrement (View v){
        if (count <= 0) count = 0;
        else count--;
        value.setText(""+ count);

    }
}