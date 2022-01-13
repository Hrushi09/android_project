package com.example.hra;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;



import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class ResetPassword extends AppCompatActivity implements View.OnClickListener {


    private EditText Username;
    private Button Next;

    FirebaseFirestore database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resetpassword);
//        getSupportActionBar().setTitle("RentoGo");

        Username = (EditText) findViewById(R.id.username);
        Next = (Button) findViewById(R.id.next);
       Next.setOnClickListener(this);
        database=FirebaseFirestore.getInstance();

    }
    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.next:

                String email= Username.getText().toString();

                if(email.length()==0)
                {
                    Username.requestFocus();
                    Username.setError("Required");
                }
                else if(!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")){
                    Username.requestFocus();
                    Username.setError("Enter a valid email");
                }
                else {
                    Toast.makeText(getApplicationContext(),"Processing",Toast.LENGTH_LONG).show();
                    get_user(email);
                }
                break;
        }

    }


    private void get_user(String email) {

        database.collection("Accounts")
                .whereEqualTo("email",email)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            if(task.getResult().getDocuments().size()>0){
                                for(DocumentSnapshot doc:task.getResult()){
                                    Accounts user=doc.toObject(Accounts.class);
                                    Intent intent_password=new Intent(getApplicationContext(), Newpassword.class);
                                    intent_password.putExtra("selected", user.getCreatePassword());
                                    startActivity(intent_password);
                                }
                            }
                            else
                                Toast.makeText(getApplicationContext(),"User Not Found",Toast.LENGTH_LONG).show();
                        }
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
