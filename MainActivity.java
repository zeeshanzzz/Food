package com.example.khan.food;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.sign);
        b2=findViewById(R.id.login);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==b1){
            Intent intent=new Intent(MainActivity.this,Sign_up.class);
            startActivity(intent);
        }
        else if(v==b2){

            Intent intent=new Intent(MainActivity.this,Signin.class);
            startActivity(intent);

        }

    }
}
