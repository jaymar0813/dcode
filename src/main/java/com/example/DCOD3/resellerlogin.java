package com.example.DCOD3;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class resellerlogin extends AppCompatActivity implements View.OnClickListener{

    private TextView register;
    EditText user,pass;
    Button login;

    DatabaseReference myRef;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resellerlogin);
        user = findViewById(R.id.username);
        pass = findViewById(R.id.password);

        login = findViewById(R.id.btnlogin);
        login.setOnClickListener(this);
        register = findViewById(R.id.textView_signup);
        register.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.textView_signup:
                startActivity(new Intent(this, reselleregister.class));
                break;
            case R.id.btnlogin:
                loginUser();
                break;

        }
    }

    public void loginUser(){
        String email1 = user.getText().toString();
        String password1 = pass.getText().toString();

        if (TextUtils.isEmpty(email1)){
            user.setError("Username cannot be empty");
            user.requestFocus();
        }else if (TextUtils.isEmpty(password1)){
            pass.setError("Password cannot be empty");
           pass.requestFocus();
        }else{


            System.out.println(email1+password1);
            myRef = FirebaseDatabase.getInstance().getReference("sellers");
            Query checkUser = myRef.orderByChild("user").equalTo(email1);
            checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if(snapshot.exists()){
                        for(DataSnapshot ds : snapshot.getChildren()) {
                            String key = ds.getKey();

                       String passwordFromDB = String.valueOf(snapshot.child(key).child("pass").getValue());
                            if (passwordFromDB.equals(password1)) {
                                Toast.makeText(resellerlogin.this, "Successfully Log in!", Toast.LENGTH_LONG).show();
                                startActivity(new Intent(resellerlogin.this, seller.class));

                            } else {
                                Toast.makeText(resellerlogin.this, "Incorrect Username or Password!", Toast.LENGTH_LONG).show();
                            }
                        }
                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
            /* myRef.child("reseller").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.hasChild(email)) {

                        String getPassword = snapshot.child("email").child("password").getValue();

                        System.out.println (getPassword);
                      if (getPassword.equals(password)) {
                            Toast.makeText(resellerlogin.this, "Successfully Log in!", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(resellerlogin.this, MainActivity.class));

                        } else {
                            Toast.makeText(resellerlogin.this, "Incorrect Password or Email!", Toast.LENGTH_LONG).show();
                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });*/
        }
    }

}