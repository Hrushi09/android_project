package com.example.hotelapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;



public class cancellationpage extends AppCompatActivity {
    private Button Continue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cancellationpage);
        getSupportActionBar().setTitle("RentoGo");


        Continue = (Button) findViewById(R.id.button3);


        Continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( com.example.hra.cancellationpage.this, MainActivity.class));
                finish();
            }
        });
    }
}

