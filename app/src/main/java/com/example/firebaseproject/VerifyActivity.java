package com.example.firebaseproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class VerifyActivity extends AppCompatActivity {
    private EditText email;
    private EditText pass;
    private Button proceed;
//nan
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);

        email=findViewById(R.id.email1);
        pass = findViewById(R.id.pass2);
        proceed=findViewById(R.id.proceed2);

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt_email = email.getText().toString();
                String txt_password=pass.getText().toString();

                if(TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_password)){
                    Toast.makeText(VerifyActivity.this, "Empty credentials", Toast.LENGTH_SHORT).show();

                }
                else if(txt_password.length()<6){
                    Toast.makeText(VerifyActivity.this, "Password too short", Toast.LENGTH_SHORT).show();
                }
                else{
                    verify(txt_email,txt_password);
                }
            }
        });
    }

    private void verify(String email, String password) {
        String aemail="admin";
        String apass="password";
        if(email.equals(aemail) && password.equals(apass)){
            Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(VerifyActivity.this,AddInfo.class));
        }
        else{
            Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
        }

    }
}
