package com.example.hotelapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hra.R;

public class ResetPassword extends AppCompatActivity {

    private EditText Username;
    private EditText CreatePassword;
    private EditText ConfirmPassword;
    private TextView ResetPassword;
    private Button Reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resetpassword);

       Reset = (Button) findViewById(R.id.button6);
        Username = (EditText) findViewById(R.id.username2);
        CreatePassword= (EditText) findViewById(R.id.createpassword2);
        ConfirmPassword = (EditText) findViewById(R.id.confirmpassword2);
        ResetPassword = (TextView) findViewById(R.id.textView5);

        Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( ResetPassword.this, signin.class));
                finish();
            }
        });

    }
}
