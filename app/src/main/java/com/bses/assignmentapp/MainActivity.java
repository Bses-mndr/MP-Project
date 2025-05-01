package com.bses.assignmentapp;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText email, password;
    private Button loginbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.Email);
        password = findViewById(R.id.Pass);
        loginbtn = findViewById(R.id.loginBtn);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validation()){
                    Toast.makeText(MainActivity.this,"Validation Success",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private  boolean validation(){
        String vemail = email.getText().toString();
        String vpass = password.getText().toString();

        if(vemail.isEmpty()|| vpass.isEmpty()){
            Toast.makeText(this, "Fill all the fields.", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(vpass.length() < 6){
            Toast.makeText(this, "The password needs to be longer than 6 characters.", Toast.LENGTH_SHORT).show();
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(vemail).matches()){
            Toast.makeText(this, "Email is invalid.", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}