package com.example.hra;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class Newpassword extends AppCompatActivity implements View.OnClickListener {

    private Button Modify;
    private EditText Code;
    private EditText NewPassword;
    private EditText ConfirmPassword;

    FirebaseFirestore database;
    String id = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newpassword);
//        getSupportActionBar().setTitle("RentoGo");

        Code = (EditText) findViewById(R.id.code);
        NewPassword = (EditText) findViewById(R.id.newpswrd);
        ConfirmPassword = (EditText) findViewById(R.id.cpswrd);
        Modify = (Button) findViewById(R.id.button8);

        Bundle bundle = getIntent().getExtras();
        id = bundle.getString("selected");
       Modify.setOnClickListener(this);
        database = FirebaseFirestore.getInstance();

    }
    @Override
    public void onClick(View v) {

        String codee = Code.getText().toString();
        String newpassword = NewPassword.getText().toString();
        String cpassword = ConfirmPassword.getText().toString();

        switch (v.getId()) {

            case R.id.button8:


                if (codee.length() == 0) {
                    Code.requestFocus();
                    Code.setError("Required");
                } else if (newpassword.length() < 8) {
                    NewPassword.requestFocus();
                    NewPassword.setError("Minimum 8 Characters");
                } else if (!newpassword.equals(cpassword)) {
                    ConfirmPassword.requestFocus();
                    ConfirmPassword.setError("Password Did Not Match");
                } else {
                    if (codee.equals("00000")) {
                        updatePassword(id, newpassword);
                    } else
                        Toast.makeText(getApplicationContext(), "Incorrect Code", Toast.LENGTH_LONG).show();
                }
                break;
        }

    }
    public void updatePassword(String id,String newP) {

        DocumentReference countDoc = database.collection("Accounts").document(id);
        countDoc.update("password",newP)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {

                        Toast.makeText(getApplicationContext(), "Password Updated",Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(getApplicationContext(), Userloginactivity.class);
                        startActivity(intent);


                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
    }

}
