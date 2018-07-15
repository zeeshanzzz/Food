package com.example.khan.food;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.function.Consumer;

public class Sign_up extends AppCompatActivity implements View.OnClickListener, OnCompleteListener<AuthResult> {
TextInputLayout l1,l2,l3;
Button b1;
ProgressBar bar;
public final int progress=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign);
       l1=findViewById(R.id.login_mail);
        l2=findViewById(R.id.login_pass);
        l3=findViewById(R.id.Name);
        b1=findViewById(R.id.button2);
        bar=findViewById(R.id.progressBar);
        b1.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        bar.setVisibility(View.VISIBLE);

        String name=l3.getEditText().getText().toString();
        String PhnNb=l1.getEditText().getText().toString();
        String Password=l2.getEditText().getText().toString();
        Task<AuthResult> autresult= FirebaseAuth.getInstance().createUserWithEmailAndPassword(PhnNb,Password);

        autresult.addOnCompleteListener(this);
    }

    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {
        if(!task.isSuccessful()){
            bar.setVisibility(View.GONE);
            Toast.makeText(Sign_up.this,"try Again",Toast.LENGTH_LONG).show();
        }
        else {
            bar.setVisibility(View.GONE);

            Toast.makeText(Sign_up.this,"Success",Toast.LENGTH_LONG).show();
   String user=   FirebaseAuth.getInstance().getCurrentUser().getUid();
       DatabaseReference reference=FirebaseDatabase.getInstance().getReference("User").child(l3.getEditText().getText().toString()).child(user);
            reference.setValue(true).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    Toast.makeText(Sign_up.this,"Success",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(Sign_up.this,Main2Activity.class);
                    startActivity(intent);


                }
            });

        }
        String user=task.getResult().getUser().getUid();


    }
}
