package com.example.firetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    FirebaseDatabase database;
    DatabaseReference myRef;
    List<Listdata> list;
    RecyclerView recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerview = (RecyclerView) findViewById(R.id.rview);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("busstops");
        int i=1;




            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    list = new ArrayList<>();

                    for(DataSnapshot dataSnapshot1 :dataSnapshot.getChildren()){

                        Stopdetails stopdetails = dataSnapshot1.getValue(Stopdetails.class);
                        Listdata listdata = new Listdata();
                        String name=stopdetails.getName();
                         long count=stopdetails.getCount();
                        listdata.setName(name);
                         listdata.setCount(count);

                        list.add(listdata);


                    }

                    RecyclerviewAdapter recycler = new RecyclerviewAdapter(list);
                    RecyclerView.LayoutManager layoutmanager = new LinearLayoutManager(MainActivity.this);
                    recyclerview.setLayoutManager(layoutmanager);
                    recyclerview.setItemAnimator( new DefaultItemAnimator());
                    recyclerview.setAdapter(recycler);

                }

                @Override
                public void onCancelled(DatabaseError error) {

                }
            });










    }
}
