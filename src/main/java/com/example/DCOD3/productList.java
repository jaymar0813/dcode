package com.example.DCOD3;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class productList extends AppCompatActivity {

    ListView listView;
    ArrayList<String> myArrayList = new ArrayList<>();
    DatabaseReference ref;
    FirebaseDatabase database;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        ArrayAdapter<String > myArrayAdapter = new ArrayAdapter<String>(productList.this, android.R.layout.simple_list_item_1,myArrayList);

        listView=(ListView)findViewById(R.id.plist);
        listView.setAdapter(myArrayAdapter);


        ref= FirebaseDatabase.getInstance().getReference();
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                String value = snapshot.getValue(String.class);
                myArrayList.add(value);
                myArrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                myArrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {


            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}