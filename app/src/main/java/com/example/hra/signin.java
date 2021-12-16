package com.example.hra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.hotelapp.hotelslist;

import org.w3c.dom.Text;

public class signin  extends AppCompatActivity{
    private Button login;
    private EditText Username;
    private EditText Password;
    private ImageButton Google;
    private TextView ForgotPassword;
    private TextView OrSigninwith;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);

        login = (Button) findViewById(R.id.loginbtn);
        Username = (EditText) findViewById(R.id.username);
        Password= (EditText) findViewById(R.id.password);
        Google = (ImageButton) findViewById(R.id.google);
        ForgotPassword = (TextView) findViewById(R.id.forgotpassword);
        OrSigninwith = (TextView) findViewById(R.id.signinwith);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( signin.this, hotelslist.class));
                finish();
            }
        });
        ForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( signin.this, com.example.hra.ResetPassword.class));
                finish();
            }
        });
    }
}