package com.example.hra;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



public class Hotelslist extends AppCompatActivity   {
    private Button Details1;
    private TextView Bookings;
    private ImageView Hotel1;
    private TextView Price1;
    private TextView Hotelname1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotelslist);
//        getSupportActionBar().setTitle("RentoGo");

        Details1 = (Button) findViewById(R.id.button2);
        Bookings = (TextView) findViewById(R.id.bookings);
        Hotel1 = (ImageView) findViewById(R.id.hotel1);
        Price1 = (TextView) findViewById(R.id.price);
        Hotelname1 = (TextView) findViewById(R.id.textView4);


        Details1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( Hotelslist.this, hotel1details.class));
                finish();

            }
        });

    }
}

