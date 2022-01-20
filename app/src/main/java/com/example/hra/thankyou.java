package com.example.hra;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class thankyou extends AppCompatActivity {
    private Button Quit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thankyou);
//        getSupportActionBar().setTitle("RentoGo");


       Quit = (Button) findViewById(R.id.button4);


        Quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( thankyou.this, MainActivity.class));
                finish();
            }
        });
    }
}

