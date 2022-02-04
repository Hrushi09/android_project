package com.example.hra;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;


import com.example.hra.models.Accounts;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class ResetPassword extends AppCompatActivity  {


    private EditText Username;
    private Button Next;
    private String email;

    FirebaseFirestore database;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resetpassword);
        getSupportActionBar().setTitle("RentoGo");


        Username = (EditText) findViewById(R.id.username);
        Next = (Button) findViewById(R.id.next);
//       Next.setOnClickListener(this);
        database=FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();

        Next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                validateData();
            }
        });
    }
    private void validateData(){
        email = Username.getText().toString();
        if(email.isEmpty()){
            Username.setError("required");
        }
        else{
            forgetPass();
        }
    }
    private void forgetPass(){
        mAuth.sendPasswordResetEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(ResetPassword.this,"check your email to reset your password",Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(ResetPassword.this,Userloginactivity.class);
                            startActivity(i);

                        }else{
                            Toast.makeText(ResetPassword.this,"try again",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

}