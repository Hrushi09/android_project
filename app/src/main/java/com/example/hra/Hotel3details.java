package com.example.hra;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;

public class Hotel3details extends AppCompatActivity {
    private Button Reserve3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel3details);
        getSupportActionBar().setTitle("RentoGo");
       
        Reserve3 = (Button) findViewById(R.id.reserve3);

        Reserve3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences("hotel", MODE_PRIVATE).edit();
                editor.putString("h3", "h33");
                editor.commit();
                startActivity(new Intent( Hotel3details.this, thankyou.class));
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

