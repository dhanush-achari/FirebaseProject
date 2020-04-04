package com.example.firebaseproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class Update extends AppCompatActivity {

    private EditText eid,name,address,email,number,project,dept;

    private Button add;
    DatabaseReference reff;
    Member member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_info);
        eid=findViewById(R.id.eid1);
        name=findViewById(R.id.name1);
        address=findViewById(R.id.address1);
        email=findViewById(R.id.email1);
        number=findViewById(R.id.number1);
        project=findViewById(R.id.project1);
        dept=findViewById(R.id.dept1);

        add=findViewById(R.id.add);
        String e="Employees";
       Intent intent=getIntent();
       String employeeid=intent.getStringExtra("eidv");




        reff= FirebaseDatabase.getInstance().getReference().child(e).child(employeeid);
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String namev=dataSnapshot.child("name").getValue().toString();
                String addv=dataSnapshot.child("address").getValue().toString();
                String prov=dataSnapshot.child("project").getValue().toString();
                String deptv=dataSnapshot.child("dept").getValue().toString();
                String emailv=dataSnapshot.child("email").getValue().toString();
                String numberv=dataSnapshot.child("number").getValue().toString();
                String eidv=dataSnapshot.child("eid").getValue().toString();
                eid.setText(eidv);
                project.setText(prov);
                address.setText(addv);
                name.setText(namev);
                project.setText(prov);
                email.setText(emailv);
                number.setText(numberv);
                dept.setText(deptv);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        member=new Member();

        add.setOnClickListener(new View.OnClickListener() {
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

                reff.setValue(member);
                Toast.makeText(Update.this, "Updated", Toast.LENGTH_SHORT).show();
            }
        });



    }
}
