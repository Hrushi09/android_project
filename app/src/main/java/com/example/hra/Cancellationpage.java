package com.example.hra;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;



    public class Cancellationpage extends AppCompatActivity {
        private Button Continue;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_cancellationpage);
            getSupportActionBar().setTitle("RentoGo");
           


           Continue = (Button) findViewById(R.id.button3);


            Continue.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(Cancellationpage.this, Hotelslist.class);
                    startActivity(i);
                }
            });
        }
    }

