package com.example.firebaseproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
        String id=eid.getText().toString();



        reff= FirebaseDatabase.getInstance().getReference().child(e).child(id);
        member=new Member();

        retrive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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

                reff.updateChildren((Map<String, Object>) member);
                Toast.makeText(UpdateActivity.this, "Updated", Toast.LENGTH_SHORT).show();
            }
        });



    }
}