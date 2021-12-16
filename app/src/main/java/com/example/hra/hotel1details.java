package com.example.hra;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hotelapp.thankyou;

public class hotel1details extends AppCompatActivity {
    private Button Reserve;
    private Button cancel;
    private TextView Hotelplaza;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel1details);
        getSupportActionBar().setTitle("RentoGo");

        Hotelplaza = (TextView) findViewById(R.id.hotelplaza);
        Reserve = (Button) findViewById(R.id.reserve);
        cancel = (Button) findViewById(R.id.button7);


        Reserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( hotel1details.this, thankyou.class));
                finish();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( hotel1details.this, com.example.hra.cancellationpage.class));
                finish();
            }
        });
    }
}

