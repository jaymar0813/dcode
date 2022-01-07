package com.example.DCOD3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class seller extends AppCompatActivity {
    Button addpro,inventory,payout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller);

        addpro=(Button) findViewById(R.id.addpro);
        inventory=(Button) findViewById(R.id.inventory);
        payout=(Button) findViewById(R.id.payout);

        addpro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAddp();
            }
        });


        inventory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(seller.this,"MAMAYA NA TO HAHAHA!TUTULOG MUNA!",Toast.LENGTH_LONG).show();
            }
        });

        payout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(seller.this,"NOT YET IN SERVICE!",Toast.LENGTH_LONG).show();
            }
        });

    }

    public void openAddp(){

        Intent intent =  new Intent(this, addProduct.class);
        startActivity(intent);

    }


}