package com.example.DCOD3;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.Query;

public class reselleregister extends AppCompatActivity{

    EditText fname,maill,user,pass;
    private sellers sellers;
    Button btnreg;
    long maxid=0;

    AwesomeValidation awesomeValidation;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reselleregister);

    fname = (EditText) findViewById(R.id.fname);
    maill = (EditText) findViewById(R.id.maill);
    user = (EditText) findViewById(R.id.user);
    pass = (EditText) findViewById(R.id.pass);
    btnreg = (Button)findViewById(R.id.btnreg);


    sellers = new sellers();
    database=FirebaseDatabase.getInstance();
    ref=database.getReference().child("sellers");



    //Validation method
    awesomeValidation =  new AwesomeValidation(ValidationStyle.BASIC);
    //data validation
        awesomeValidation.addValidation(this,R.id.fname, RegexTemplate.NOT_EMPTY,R.string.invalid_fname);
        awesomeValidation.addValidation(this,R.id.maill, Patterns.EMAIL_ADDRESS,R.string.invalid_email);
        awesomeValidation.addValidation(this,R.id.user, RegexTemplate.NOT_EMPTY,R.string.invalid_user);
        awesomeValidation.addValidation(this,R.id.pass, RegexTemplate.NOT_EMPTY,R.string.invalid_pass);



        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())


                    maxid=(snapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sellers.setFname(fname.getText().toString().trim());
                sellers.setMaill(maill.getText().toString().trim());
                sellers.setUser(user.getText().toString().trim());
                sellers.setPass(pass.getText().toString().trim());
                
            
                Query checkD = ref.orderByChild("user").equalTo(sellers.maill); //checkmail query, yung sellers.Maill pakicheck kung eto yung naglalaman ng value pare
                checkD.addListenerForSingleValueEvent(new ValueEventListener() {
                     @Override
                    public void onDataChange1(@NonNull DataSnapshot snapshot) {
                         if(snapshot.exists()){
                             Toast.makeText(resellerregister.this, "This Email already exist", Toast.LENGTH_LONG).show();// kung ito ay kailangan ng staryActivity palagyan na lang para magredirect ulit sa register activity
                         }
                        else{
                         ref.child(String.valueOf(maxid+1)).setValue(sellers);

                        Toast.makeText(reselleregister.this,"Save data!",Toast.LENGTH_LONG).show();

                        openLogin();

                        }
                    
                    }//onDataChange end curly brace   
                });//addListner end curly brace

               

            }
        });





    }
    public void openLogin(){
        Intent intent =  new Intent(this,resellerlogin.class);
        startActivity(intent);

    }


    }
}
