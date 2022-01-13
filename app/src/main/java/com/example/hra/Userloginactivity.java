package com.example.hra;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import java.net.URI;


public class Userloginactivity extends AppCompatActivity implements View.OnClickListener {
    private Button login;
    private EditText Username;
    private EditText Password;
    private TextView ForgotPassword;
    private ImageButton Google;
    private GoogleSignInClient mGoogleSignInClient;
    private  String TAG = "Userloginactivity";
    private int RC_SIGN_IN = 1;
    private Button btnSignOut;

    FirebaseAuth mAuth;
    FirebaseFirestore database;

    int login_flag=0;
  SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
//        getSupportActionBar().setTitle("RentoGo");

        login = (Button) findViewById(R.id.loginbtn);
        Username = (EditText) findViewById(R.id.username);
        Password = (EditText) findViewById(R.id.password);
        ForgotPassword = (TextView) findViewById(R.id.forgotpassword);
       Google = (ImageButton) findViewById(R.id.googlebtn);
        btnSignOut = findViewById(R.id.signoutggl);

        mAuth = FirebaseAuth.getInstance();
        database=FirebaseFirestore.getInstance();

        ForgotPassword.setOnClickListener(this);
        login.setOnClickListener(this);
        sharedPreferences = getSharedPreferences("user_details", MODE_PRIVATE);
        if (sharedPreferences.contains("username") && sharedPreferences.contains("password")) {
        }

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        Google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });

        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mGoogleSignInClient.signOut();
                Toast.makeText(Userloginactivity.this,"You are Logged Out",Toast.LENGTH_SHORT).show();
                btnSignOut.setVisibility(View.INVISIBLE);
            }
        });
    }
    private void signIn(){
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.loginbtn:

                String email = Username.getText().toString();
                String password = Password.getText().toString();

                if (email.length() == 0) {
                    Username.requestFocus();
                    Username.setError("Required");
                } else if (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
                    Username.requestFocus();
                    Username.setError("enter a valid email");
                } else if (password.length() == 0) {
                    Password.requestFocus();
                    Password.setError("Required");
                } else {
                    Toast.makeText(getApplicationContext(), "Please Wait", Toast.LENGTH_LONG).show();
                    get_user(email, password);
                }
                break;

            case R.id.forgotpassword:
                Intent intent_password = new Intent(getApplicationContext(), ResetPassword.class);
                startActivity(intent_password);
                break;
        }
    }

    public void get_user(String username,String passwordtxt) {

        database.collection("Accounts")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (DocumentSnapshot document : task.getResult()) {
                                Accounts user = document.toObject(Accounts.class);
                                if (username.equals(user.getEmail()) && passwordtxt.equals(user.getCreatePassword())) {
                                    login_flag = 1;
                                    SharedPreferences.Editor editor = sharedPreferences.edit();
                                    editor.putString("username", username);
                                    editor.putString("password", passwordtxt);

                                    editor.commit();

                                    Intent intent = new Intent(Userloginactivity.this, Hotelslist.class);
                                    Userloginactivity.this.startActivity(intent);
                                    break;
                                }
                            }

                            if (login_flag == 0) {
                                Toast.makeText(getApplicationContext(), "Invalid Details", Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RC_SIGN_IN){
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            Intent i = new Intent(Userloginactivity.this,Hotelslist.class);
            startActivity(i);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask){
        try{

            GoogleSignInAccount acc = completedTask.getResult(ApiException.class);
            Toast.makeText(Userloginactivity.this,"1Signed In Successfully",Toast.LENGTH_SHORT).show();

            FirebaseGoogleAuth(acc);


        }
        catch (ApiException e){
            Toast.makeText(Userloginactivity.this,"3Sign In Failed",Toast.LENGTH_SHORT).show();
            FirebaseGoogleAuth(null);
        }
    }

    private void FirebaseGoogleAuth(GoogleSignInAccount acct) {
        //check if the account is null
        if (acct != null) {
            AuthCredential authCredential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
            mAuth.signInWithCredential(authCredential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(Userloginactivity.this, "2Successful", Toast.LENGTH_SHORT).show();
                        FirebaseUser user = mAuth.getCurrentUser();
                        if(user != null){

                        }
                        updateUI(user);



                    }else {
                        Toast.makeText(Userloginactivity.this, "Failed", Toast.LENGTH_SHORT).show();
                        updateUI(null);
                    }
                }
            });
        }
        else{
            Toast.makeText(Userloginactivity.this, "acc failed", Toast.LENGTH_SHORT).show();
        }
    }
    private void updateUI(FirebaseUser fUser){
        btnSignOut.setVisibility(View.VISIBLE);
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(getApplicationContext());
        if(account !=  null){
            String personName = account.getDisplayName();
            String personGivenName = account.getGivenName();
            String personFamilyName = account.getFamilyName();
            String personEmail = account.getEmail();
            String personId = account.getId();


            Toast.makeText(Userloginactivity.this,personName + personEmail ,Toast.LENGTH_SHORT).show();
        }

    }
}

