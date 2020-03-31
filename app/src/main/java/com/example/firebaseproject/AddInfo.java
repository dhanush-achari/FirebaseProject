package com.example.firebaseproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddInfo extends AppCompatActivity {
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
        String id=eid.getText().toString();



        reff= FirebaseDatabase.getInstance().getReference().child(e);
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

                reff.child(edie).setValue(member);
                Toast.makeText(AddInfo.this, "Employee added", Toast.LENGTH_SHORT).show();
            }
        });



    }
}
