package com.example.hra;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Bookings extends AppCompatActivity {

    RelativeLayout r1, r2, r3, r4, r5;
    Button cancel1, cancel2, cancel3, cancel4, cancel5;
TextView no;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookings);
        getSupportActionBar().setTitle("RentoGo");
        

        r1 = findViewById(R.id.r1);
        r2 = findViewById(R.id.r2);
        r3 = findViewById(R.id.r3);
        r4 = findViewById(R.id.r4);
        r5 = findViewById(R.id.r5);
        cancel1 = findViewById(R.id.cancel1);
        cancel2 = findViewById(R.id.cancel2);
        cancel3 = findViewById(R.id.cancel3);
        cancel4 = findViewById(R.id.cancel4);
        cancel5 = findViewById(R.id.cancel5);
        no = findViewById(R.id.no);

        SharedPreferences sh = getSharedPreferences("hotel", MODE_PRIVATE);
        String s1 = sh.getString("h1", "");
        String s2 = sh.getString("h2", "");
        String s3 = sh.getString("h3", "");
        String s4 = sh.getString("h4", "");
        String s5 = sh.getString("h5", "");

        if (!s1.equals("")) {
            r1.setVisibility(View.VISIBLE);
            no.setVisibility(View.GONE);
        }
        if (!s2.equals("")) {
            r2.setVisibility(View.VISIBLE);
            no.setVisibility(View.GONE);
        }
        if (!s3.equals("")) {
            r3.setVisibility(View.VISIBLE);
            no.setVisibility(View.GONE);
        }
        if (!s4.equals("")) {
            r4.setVisibility(View.VISIBLE);
            no.setVisibility(View.GONE);
        }
        if (!s5.equals("")) {
            r5.setVisibility(View.VISIBLE);
            no.setVisibility(View.GONE);
        }

        cancel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r1.setVisibility(View.GONE);
                SharedPreferences.Editor editor = sh.edit();
                editor.remove("h1");
                editor.commit();
                startActivity(new Intent(Bookings.this, Cancellationpage.class));
            }
        });
        cancel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r2.setVisibility(View.GONE);
                SharedPreferences.Editor editor = sh.edit();
                editor.remove("h2");
                editor.commit();
                startActivity(new Intent(Bookings.this, Cancellationpage.class));

            }
        });
        cancel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r3.setVisibility(View.GONE);
                SharedPreferences.Editor editor = sh.edit();
                editor.remove("h3");
                editor.commit();
                startActivity(new Intent(Bookings.this, Cancellationpage.class));
            }
        });
        cancel4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r4.setVisibility(View.GONE);
                SharedPreferences.Editor editor = sh.edit();
                editor.remove("h4");
                editor.commit();
                startActivity(new Intent(Bookings.this, Cancellationpage.class));
            }
        });
        cancel5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r5.setVisibility(View.GONE);
                SharedPreferences.Editor editor = sh.edit();
                editor.remove("h5");
                editor.commit();
                startActivity(new Intent(Bookings.this, Cancellationpage.class));
            }
        });
    }
}
