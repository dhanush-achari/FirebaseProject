package com.example.firebaseproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class InputEid2Activate extends AppCompatActivity {

    private TextView id;
    private Button display;
    DatabaseReference reffe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_eid);

        id=findViewById(R.id.eidv);
        display=findViewById(R.id.input);

        reffe= FirebaseDatabase.getInstance().getReference().child("Employees");

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idv=id.getText().toString();

                if(idv.isEmpty())
                {
                    Toast.makeText(InputEid2Activate.this, "Please Enter EID", Toast.LENGTH_SHORT).show();
                }
                reffe.addListenerForSingleValueEvent(new ValueEventListener() {
                    String idv;

                    {
                        idv = id.getText().toString();
                    }

                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if( !(dataSnapshot.hasChild(idv)))
                        {
                            Toast.makeText(InputEid2Activate.this, "Invaid EID", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Intent intent=new Intent(InputEid2Activate.this,Update.class);
                            intent.putExtra("eidv",idv);
                            startActivity(intent);


                        }




                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });




            }
        });




    }



}

