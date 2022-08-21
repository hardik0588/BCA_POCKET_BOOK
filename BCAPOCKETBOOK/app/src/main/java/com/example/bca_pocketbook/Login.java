package com.example.bca_pocketbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    Button createAccountBtn,loginBtn;
    TextView forgotPass;

    FirebaseAuth firebaseAuth;
    TextInputEditText loginemail1,loginpass1;
    TextInputLayout loginemail,loginpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        firebaseAuth=FirebaseAuth.getInstance();
        loginemail1=(TextInputEditText) findViewById(R.id.loginEmail1);
        loginemail=(TextInputLayout)findViewById(R.id.loginEmail);
        forgotPass=(TextView)findViewById(R.id.ForgotPass);
       loginpass1=(TextInputEditText)findViewById(R.id.loginPassword1);
        loginpass=(TextInputLayout)findViewById(R.id.loginPassword);
        loginBtn=findViewById(R.id.btnLogin);
        createAccountBtn=findViewById(R.id.createAcc);
        FirebaseUser user=firebaseAuth.getCurrentUser();
        if(user!=null){

            startActivity(new Intent(getApplicationContext(),Student_Main.class));
            finish();
        }

        firebaseAuth.signOut();
        createAccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Register.class));
                finish();
            }
        });


        forgotPass.setOnClickListener(v -> {
           startActivity(new Intent(getApplicationContext(),forgot_Password.class));

        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (loginemail1.getText().toString().equals("admin") && loginpass1.getText().toString().equals("admin"))
                {
                   startActivity(new Intent(getApplicationContext(), MainActivity.class));
                   finish();
                }
                else if (loginemail1.getText().toString().isEmpty()) {

                    loginemail1.setError("Email is Missing");
                    return;
                }
                else if (loginpass1.getText().toString().isEmpty()) {
                    loginpass1.setError("Password is Missing");
                    return;

                }
                else {

                        firebaseAuth.signInWithEmailAndPassword(loginemail1.getText().toString().trim(),loginpass1.getText().toString().trim()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                if(firebaseAuth.getCurrentUser().isEmailVerified()) {
                                    Toast.makeText(Login.this, "login successfully...", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(getApplicationContext(), Student_Main.class));
                                    finish();

                                }
                                else {
                                    Toast.makeText(Login.this, "Please verify your email id", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Login.this, "something went wrong...", Toast.LENGTH_SHORT).show();
                            }
                        });

                   /* firebaseAuth.signInWithEmailAndPassword(username.getText().toString(), password.getText().toString())
                            .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            startActivity(new Intent(getApplicationContext(),Student_Main.class));
                            finish();
                           *//* if(firebaseAuth.getCurrentUser().isEmailVerified()){
                            startActivity(new Intent(getApplicationContext(), Student_Main.class));
                            finish();
                            }
                            else {
                                Toast.makeText(Login.this,"Please Varify your Email First",Toast.LENGTH_SHORT);
                            }*//*
                        }
                    })
                    .addOnFailureListener(new OnFailureListener()
                    {
                        @Override
                        public void onFailure(@NonNull Exception e)
                        {
                            Toast.makeText(Login.this, "Invalid Login ID or Password.!", Toast.LENGTH_SHORT).show();
                        }
                    });*/
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user=firebaseAuth.getCurrentUser();
        if(user!=null){

            startActivity(new Intent(getApplicationContext(),Student_Main.class));
            finish();
        }
    }
}
