package com.example.issuing_system;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignUpActivity extends AppCompatActivity {

    EditText signupname , signupsapid , signuppassword ;
    TextView loginRedirectText;
    Button signupbutton;
    FirebaseDatabase database;
    DatabaseReference reference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://issuing-system1-default-rtdb.firebaseio.com/");


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


                String name = signupname.getText().toString();
                String sapid = signupsapid.getText().toString();
                String password = signuppassword.getText().toString();





                if (sapid.isEmpty()||password.isEmpty()||name.isEmpty()) {
                    Toast.makeText(SignUpActivity.this, "please fill all the details", Toast.LENGTH_SHORT).show();
                }
                else {
                    reference.child("user").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.hasChild(sapid)){
                                Toast.makeText(SignUpActivity.this, "SAP Id already exist", Toast.LENGTH_SHORT).show();
                            } else {
                                reference.child("user").child(sapid).child("name").setValue(name);
                                reference.child("user").child(sapid).child("password").setValue(password);
                                Toast.makeText(SignUpActivity.this, "You have SignUp Sucessfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(SignUpActivity.this,LoginActivity.class);
                                startActivity(intent);
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });


                }




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