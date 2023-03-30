package com.example.issuing_system;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CricketActivity extends AppCompatActivity {

    ImageView backb;
    String s1;
    Spinner sp;

    TextView value,sname;

    Button confirm;
    int count = 0;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cricket);

        value = findViewById(R.id.value);
        backb = findViewById(R.id.back_arrow);
        sname = findViewById(R.id.sname);
        sp = findViewById(R.id.spinner);
        confirm = findViewById(R.id.button1);

        backb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CricketActivity.this,Home_Activity.class);
                startActivity(intent);
            }
        });

        ArrayAdapter ar = ArrayAdapter.createFromResource(this,R.array.cricket, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        sp.setAdapter(ar);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                s1=parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count == 0) {
                    Toast.makeText(CricketActivity.this, "Please select the Quantity", Toast.LENGTH_SHORT).show();
                }
                else  {
                    enterTheData ();
                    Intent intent = new Intent(CricketActivity.this,Issued_Receipt.class);
                    startActivity(intent);
                }





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
    private void enterTheData() {
        String sName = sname.getText().toString();
        String quantity = value.getText().toString() ;
        String equipment = s1;
    }
}