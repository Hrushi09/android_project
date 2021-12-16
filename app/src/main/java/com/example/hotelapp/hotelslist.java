package com.example.hotelapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hra.R;

public class hotelslist  extends AppCompatActivity {
    private Button Details1;
    private TextView Bookings;
    private ImageView Hotel1;
    private TextView Price1;
    private TextView Hotelname1;

    private Button Details2;
    private ImageView Hotel2;
    private TextView Price2;
    private TextView Hotelname2;

    private Button Details3;
    private ImageView Hotel3;
    private TextView Price3;
    private TextView Hotelname3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotelslist);
        getSupportActionBar().setTitle("RentoGo");

        Details1 = (Button) findViewById(R.id.button2);
        Bookings = (TextView) findViewById(R.id.bookings);
        Hotel1 = (ImageView) findViewById(R.id.hotel1);
        Price1 = (TextView) findViewById(R.id.price);
        Hotelname1 = (TextView) findViewById(R.id.textView4);





        Details1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( hotelslist.this, hotel1details.class));
                finish();


            }
        });

    }
}

