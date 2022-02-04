package com.example.hra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    private Button Sign;
    private Button Createaccount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("RentoGo");

        Sign =(Button) findViewById(R.id.signtxt);
        Createaccount = (Button) findViewById(R.id.Createaccount);

        Sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Userloginactivity.class);
                startActivity(i);


            }
        });
        Createaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Createaccount.class);
                startActivity(i);


            }
        });
    }
}