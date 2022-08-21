package com.example.bca_pocketbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class forgot_Password extends AppCompatActivity {

        private EditText editText;
        private Button button;
        private ProgressBar progressBar;
        FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot__password);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        editText=findViewById(R.id.email);
        button=findViewById(R.id.btnresetpass);
        progressBar=findViewById(R.id.processBar);

        auth=FirebaseAuth.getInstance();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetPassword();
           
            }
        });
    }

    private void resetPassword() {
        String emailText=editText.getText().toString().trim();
        if(emailText.isEmpty() ){
            editText.setError("Email is Required..!");
            editText.requestFocus();
            return;

        }
        if(!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()){
            editText.setError("Please Provide A Valid Email Address..!" );
            editText.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);
        auth.sendPasswordResetEmail(emailText).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful())
                {
                    Toast.makeText(forgot_Password.this, "Check Your Email to reset Your Password ",Toast.LENGTH_SHORT).show();

                }
                else {
                    Toast.makeText(forgot_Password.this ,"Try Again Something wrong Happend..!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
