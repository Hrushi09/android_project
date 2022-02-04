package com.example.hra;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.hra.models.Accounts;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Createaccount  extends AppCompatActivity implements View.OnClickListener{
    private TextView Createaccount;
    private EditText Username;
    private EditText Email;
    private EditText CreatePassword;
    private EditText ConfirmPassword;
    private Button Create;
    private FirebaseFirestore database;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createaccount);
        getSupportActionBar().setTitle("RentoGo");


        Createaccount = (TextView) findViewById(R.id.Createaccount);
        Username = (EditText) findViewById(R.id.username);
        Email = (EditText) findViewById(R.id.Email);
       CreatePassword = (EditText) findViewById(R.id.createpassword);
        ConfirmPassword = (EditText) findViewById(R.id.confirmpassword);
        Create = (Button)findViewById(R.id.button5);

        Create.setOnClickListener(this);
        database=FirebaseFirestore.getInstance();

    }


    public void onClick(View v) {
        switch (v.getId()){

            case R.id.button5:

                String name= Username.getText().toString();
                String email= Email.getText().toString();
                String password= CreatePassword.getText().toString();
                String cpassword = ConfirmPassword.getText().toString();

                if(name.length()==0)
                {
                    Username.requestFocus();
                    Username.setError("Required");
                }
                else if(!name.matches("[a-zA-Z ]+"))
                {
                    Username.requestFocus();
                    Username.setError("enter alphabeticals only");
                }

                else if(email.length()==0)
                {
                    Email.requestFocus();
                    Email.setError("Required");
                }
                else if(!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")){
                    Email.requestFocus();
                    Email.setError("Enter Valid Email");
                }

                else if(password.length()<8){
                    CreatePassword.requestFocus();
                    CreatePassword.setError("Minimum 8 characters");
                }
                else if(!password.equals(cpassword)){
                    ConfirmPassword.requestFocus();
                    ConfirmPassword.setError("Password did not match");
                }
                else{
                    send(name,email,password);
                }
                break;

        }
    }



    public void send(String name,String email,String password){
        SimpleDateFormat id_format = new SimpleDateFormat("yyMMddHHmmssSS");
        String id = id_format.format(new Date());
        Accounts user=new Accounts(name, password, email,id);
        database.collection("Accounts")
                .document(String.valueOf(id))
                .set(user)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void avoid) {
                        Toast.makeText(getApplicationContext(), "User Registered",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(), Userloginactivity.class);
                        startActivity(intent);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(),"Error. Try Again"+e.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });

    }
}

