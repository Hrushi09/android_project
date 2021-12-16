package com.example.hra;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Createaccount  extends AppCompatActivity {
    private TextView Createaccount;
    private EditText Username;
    private EditText Email;
    private EditText CreatePassword;
    private EditText ConfirmPassword;
    private Button Create;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createaccount);
        getSupportActionBar().setTitle("RentoGo");

        Createaccount = (TextView) findViewById(R.id.Createaccount);
        Username = (EditText) findViewById(R.id.username);
        Email = (EditText) findViewById(R.id.Email);
       CreatePassword = (EditText) findViewById(R.id.createpassword);
        ConfirmPassword = (EditText) findViewById(R.id.confirmpassword);
        Create = (Button)findViewById(R.id.button5);




       Create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( Createaccount.this, signin.class));
                finish();


            }
        });

    }
}

