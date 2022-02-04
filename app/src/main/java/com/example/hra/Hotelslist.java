package com.example.hra;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



public class Hotelslist extends AppCompatActivity {
    private Button Details1;
    private Button Details2;
    private Button Details3;
    private Button Details4;
    private Button Details5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotelslist);
        getSupportActionBar().setTitle("RentoGo");


        Details1 = (Button) findViewById(R.id.details1);
        Details2 = (Button) findViewById(R.id.details2);
        Details3 = (Button) findViewById(R.id.details3);
        Details4 = (Button) findViewById(R.id.details4);
        Details5 = (Button) findViewById(R.id.details5);

        Details1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Hotelslist.this, Hotel1details.class);
                startActivity(i);

            }
        });
        Details2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Hotelslist.this, Hotel2details.class);
                startActivity(i);
            }
        });
        Details3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Hotelslist.this, Hotel3details.class);
                startActivity(i);
            }
        });
        Details4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Hotelslist.this, Hotel4details.class);
                startActivity(i);
            }
        });
        Details5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Hotelslist.this, Hotel5details.class);
                startActivity(i);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.item1:
                Intent i1=new Intent(getApplicationContext(), Bookings.class);
                startActivity(i1);
                break;
            case R.id.item2:
                Intent logout_intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(logout_intent);
                break;
            case R.id.item3:
                ApplicationInfo api = getApplicationContext().getApplicationInfo();
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "CHECK out this cool application");
                intent.putExtra(Intent.EXTRA_TEXT,"we are sharing information about our hotel Tajj Banjara. for more details please visit our app RENTOGO and make your reservation ");
                startActivity(Intent.createChooser(intent, "shareVia"));
                break;
        }
        return true;
    }
}