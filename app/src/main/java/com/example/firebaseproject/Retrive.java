package com.example.firebaseproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Retrive extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Member> member;
    private UserAdapter userAdapter;
    DatabaseReference dRef;
    String employeeid;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrive);
        recyclerView=findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Intent intent=getIntent();
        employeeid=intent.getStringExtra("eidv");

        member =new ArrayList<Member>();
        dRef= FirebaseDatabase.getInstance().getReference().child("Employees").child(employeeid);
        dRef.addListenerForSingleValueEvent(valueEventListener);
    }
    ValueEventListener valueEventListener=new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
                Member mem=dataSnapshot.getValue(Member.class);
                member.add(mem);
            }
            userAdapter= new UserAdapter(Retrive.this,member);
            recyclerView.setAdapter(userAdapter);
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    };
}
