package com.example.DCOD3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener {

    Button res,cus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        res=(Button)findViewById(R.id.button_res);
        cus=(Button)findViewById(R.id.button_cus);
        res.setOnClickListener(this);


        cus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "COMING SOON!", Toast.LENGTH_SHORT).show();
            }
        });



    }
    @Override

    public void onClick(View v) {
            switch (v.getId()){

                case R.id.button_res:
                    startActivity(new Intent(this,resellerlogin.class));
                    break;

            }

    }

}