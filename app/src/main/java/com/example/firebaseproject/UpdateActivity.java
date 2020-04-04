package com.example.firebaseproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class UpdateActivity extends AppCompatActivity {

    private EditText eid,name,address,email,number,project,dept;

    private Button update,retrive;
    DatabaseReference reff;
    Member member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_info);
        eid=findViewById(R.id.eid22);
        name=findViewById(R.id.name22);
        address=findViewById(R.id.address22);
        email=findViewById(R.id.email22);
        number=findViewById(R.id.number22);
        project=findViewById(R.id.project22);
        dept=findViewById(R.id.dept22);
        retrive=findViewById(R.id.ret);

        update=findViewById(R.id.add);
        String e="Employees";






        reff= FirebaseDatabase.getInstance().getReference().child(e);
        member=new Member();

        retrive.setOnClickListener(new View.OnClickListener() {
            String ide=eid.getText().toString();
            @Override
            public void onClick(View v) {


                reff.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        if(dataSnapshot.hasChild(ide))
                        {
                            String addresse = dataSnapshot.child(ide).child("address").getValue().toString();
                            String depte = dataSnapshot.child(ide).child("dept").getValue().toString();
                            String eide = dataSnapshot.child(ide).child("eid").getValue().toString();
                            String emaile  = dataSnapshot.child(ide).child("email").getValue().toString();
                            String namee = dataSnapshot.child(ide).child("name").getValue().toString();
                            String numbere = dataSnapshot.child(ide).child("number").getValue().toString();
                            String projecte = dataSnapshot.child(ide).child("project").getValue().toString();

                            name.setText(namee);
                            dept.setText(depte);
                            eid.setText(eide);
                            email.setText(emaile);
                            address.setText(addresse);
                            project.setText(projecte);
                            number.setText(numbere);


                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edie=eid.getText().toString();
                String namee=name.getText().toString();
                String adde=address.getText().toString();
                String emaile=email.getText().toString();
                String numbere=number.getText().toString();
                String proe=project.getText().toString();
                String depte=dept.getText().toString();

                member.setEid(edie);
                member.setName(namee);
                member.setAddress(adde);
                member.setEmail(emaile);
                member.setNumber(numbere);
                member.setProject(proe);
                member.setDept(depte);

                reff.child(edie).setValue(member);
                Toast.makeText(UpdateActivity.this, "Updated", Toast.LENGTH_SHORT).show();
            }
        });



    }
}
