package com.example.khan.food;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signin extends AppCompatActivity implements View.OnClickListener, OnCompleteListener<AuthResult> {

    TextInputLayout l1, l2, l3;
    Button b1;
    ProgressBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        l1 = findViewById(R.id.login_mail);
        l2 = findViewById(R.id.login_pass);
        b1 = findViewById(R.id.button2);
        bar = findViewById(R.id.progressBar);
        b1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == b1) {
            bar.setVisibility(View.VISIBLE);
            String name = l1.getEditText().getText().toString();
            String pass = l2.getEditText().getText().toString();
            if (TextUtils.isEmpty(name)) {
                Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                return;
            }
            if (TextUtils.isEmpty(pass)) {
                Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                return;
            }
          else  if (pass.length() < 6) {
                l2.setError(getString(R.string.minimum_password));
            }
                Task<AuthResult> autresult = FirebaseAuth.getInstance().signInWithEmailAndPassword(name, pass);
                autresult.addOnCompleteListener(this);


            }

        }


    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {
        bar.setVisibility(View.GONE);
        if(!task.isSuccessful()){
            Toast.makeText(getApplicationContext(), "try again", Toast.LENGTH_SHORT).show();


        }
        else{

            Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(Signin.this,Main2Activity.class);
            startActivity(intent);

        }
    }
}

