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
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    EditText loginsapid , loginpassword;
    Button loginbutton;
    TextView signupredirect;

    DatabaseReference reference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://issuing-system1-default-rtdb.firebaseio.com/");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginsapid = findViewById(R.id.loginsapid);
        loginpassword =findViewById(R.id.loginpassword);
        loginbutton =findViewById(R.id.loginbutton);
        signupredirect = findViewById(R.id.signupredirectText);

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userSAPId = loginsapid.getText().toString();
                String userPassword = loginpassword.getText().toString();
                if (!validSapId()|!validPassword()) {
                    Toast.makeText(LoginActivity.this, "Please enter SAP Id and Password", Toast.LENGTH_SHORT).show();


                } else {
//                    checkuser();
                    reference.child("user").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.hasChild(userSAPId)){
                                String getPassword = snapshot.child(userSAPId).child("password").getValue(String.class);
                                if (getPassword.equals(userPassword)){
                                    Toast.makeText(LoginActivity.this, "Successfully Login", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(LoginActivity.this,Home_Activity.class);
                                    startActivity(intent);
                                }
                                else {
                                    Toast.makeText(LoginActivity.this, "Wrong Password", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }

            }
        });

        signupredirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
    public boolean validSapId () {
        String val = loginsapid.getText().toString();
        if (val.isEmpty()) {
            loginsapid.setError("username cannot be empty");
            return false;

        }else {
            loginsapid.setError(null);
            return true;
        }
    }

    public boolean validPassword () {
        String val = loginpassword.getText().toString();
        if (val.isEmpty()) {
            loginpassword.setError("password cannot be empty");
            return false;

        }else {
            loginpassword.setError(null);
            return true;
        }
    }

//    public void checkuser () {
//        String userSAPId = loginsapid.getText().toString().trim();
//        String userPassword = loginpassword.getText().toString().trim();
//
//        DatabaseReference reference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://issuing-system1-default-rtdb.firebaseio.com/");
//        Query checkUserDatabase = reference.orderByChild("user").equalTo(userSAPId);
//
//        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                if (snapshot.exists()){
//                    loginsapid.setError(null);
//                    String passwordFromDb = snapshot.child(userSAPId).child("password").getValue(String.class);
//
//                    if(!Objects.equals(passwordFromDb,userPassword)){
//                        loginsapid.setError(null);
//                        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
//                        startActivity(intent);
//                    }else {
//                        loginpassword.setError("Invalid Creadential");
//                        loginpassword.requestFocus();
//                    }
//                }else {
//                    loginsapid.setError("user does not exist");
//                    loginsapid.requestFocus();
//
//                }
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//    }

}