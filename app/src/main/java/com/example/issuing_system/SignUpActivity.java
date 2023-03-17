package com.example.issuing_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {

    EditText signupname , signupsapid , signuppassword ;
    TextView loginRedirectText;
    Button signupbutton;
    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signupname = findViewById(R.id.signupname);
        signupsapid = findViewById(R.id.signupsapid);
        signuppassword = findViewById(R.id.signuppassword);
        loginRedirectText = findViewById(R.id.loginRedirectText);
        signupbutton = findViewById(R.id.signupbutton);

        signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database = FirebaseDatabase.getInstance();
                reference = database.getReference();

                String name = signupname.getText().toString();
                String sapid = signupsapid.getText().toString();
                String password = signuppassword.getText().toString();

                HelperClass helperClass = new HelperClass(name ,sapid,password);
                reference.child("user").child(sapid).setValue(helperClass);

                Toast.makeText(SignUpActivity.this, "You have SignUp Sucessfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SignUpActivity.this,LoginActivity.class);
                startActivity(intent);


            }
        });

        loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}