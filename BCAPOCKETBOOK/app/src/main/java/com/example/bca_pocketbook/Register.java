package com.example.bca_pocketbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PatternMatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {

    Button registerUserBtn,gotoLogin;
    private FirebaseAuth fAuth;
    DatabaseReference studentDbRef;
    TextInputEditText registerPassword1,registerConPass1,registerEmail1,registerFirstName1,registerLastName1,registerMobileNumber1;
    TextInputLayout registerPassword,registerConPass,registerEmail,registerFirstName,registerLastName,registerMobileNumber;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerFirstName=(TextInputLayout) findViewById(R.id.registerFirstName);
        registerFirstName1=(TextInputEditText)findViewById(R.id.registerFirstName1);
        registerLastName=(TextInputLayout) findViewById(R.id.registerLastName);
        registerLastName1=(TextInputEditText) findViewById(R.id.registerLastName1);
        registerMobileNumber=(TextInputLayout) findViewById(R.id.registerMoblieNumber);
        registerMobileNumber1=(TextInputEditText)findViewById(R.id.registerMoblieNumber1);
        registerEmail1=(TextInputEditText)findViewById(R.id.registerEmail1);
        registerEmail=(TextInputLayout) findViewById(R.id.registerEmail);
        registerPassword1=(TextInputEditText) findViewById(R.id.registerPassword1);
        registerPassword=(TextInputLayout)findViewById(R.id.registerPassword);
        registerConPass=(TextInputLayout)findViewById(R.id.registerconpass);
        registerConPass1=(TextInputEditText)findViewById(R.id.registerconpass1);
        registerConPass=(TextInputLayout) findViewById(R.id.registerconpass);
        registerUserBtn=findViewById(R.id.register);
        gotoLogin=findViewById(R.id.gotoLogin);


        fAuth= FirebaseAuth.getInstance();
        studentDbRef= FirebaseDatabase.getInstance().getReference().child("Student");
        // studentDbRef= FirebaseDatabase.getInstance().getReference().child("stud");


        gotoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Register.this, Login.class);
                startActivity(intent);
                finish();

            }
        });

        registerUserBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                String mobileNumber=registerMobileNumber1.getText().toString();
                String FirstName=registerFirstName1.getText().toString();
                String LastName=registerLastName1.getText().toString();
                String email=registerEmail1.getText().toString();
                String password=registerPassword1.getText().toString();
                String confPass =registerConPass1.getText().toString();

                if(FirstName.isEmpty()){
                    registerFirstName.setError("First Name is Required");
                    return;

                }
                else if(LastName.isEmpty()){
                    registerLastName1.setError("Last Name is Required");
                    return;

                }
                else if(mobileNumber.length()<10){
                    registerMobileNumber1.setError("Moblie Number must be 10 Digits");
                    return;
                }
                else if(mobileNumber.isEmpty()){

                    registerMobileNumber1.setError("Moblie Number is Required");
                    return;

                }

                else if(email.isEmpty()){
                    registerEmail1.setError("Email is Required");
                    return;

                }
                else if(password.length()<6 || password.length()>10)
                {
                    registerPassword1.setError("Password Must between 6 to 10");
                    return;
                }
                else if(password.isEmpty()){
                    registerPassword1.setError("Password is Required");
                    return;


                }
                else if(confPass.isEmpty()){
                    registerConPass1.setError("Conform Password is Required");
                    return;

                }
                else if(!password.equals(confPass))
                {
                    registerConPass1.setError("Password Do Not Match");
                    return;

                }
                else {
                    if(!FirstName.isEmpty() && !LastName.isEmpty() && !mobileNumber.isEmpty() && !email.isEmpty() && !password.isEmpty() && !confPass.isEmpty() && mobileNumber.length()>=10 && password.length()>=6) {

                        fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful())
                                {
                                    FirebaseUser user=fAuth.getCurrentUser();
                                   user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if(task.isComplete())
                                            {
                                                Toast.makeText(Register.this, "please check your email Id and verify your email", Toast.LENGTH_LONG).show();
                                                insertStudentData();
                                                startActivity(new Intent(getApplicationContext(),Login.class));
                                                finish();
                                            }
                                            else {
                                                Toast.makeText(Register.this, "some thing want wrong...", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    }).addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Toast.makeText(Register.this, "Email is not send..", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                }
                                else {
                                    Toast.makeText(Register.this, "some thing want wrong...", Toast.LENGTH_SHORT).show();
                                }

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Register.this, "some thing want wrong...", Toast.LENGTH_SHORT).show();
                            }
                        });




                       /* fAuth.createUserWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {

                                Toast.makeText(Register.this, "Data Validation", Toast.LENGTH_SHORT).show();
                                insertStudentData();
                              *//*  startActivity(new Intent(getApplicationContext(),Student_Main.class));
                                finish();*//*
                               *//* BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(Register.this);
                                bottomSheetDialog.setContentView(R.layout.email_varification);
                                bottomSheetDialog.setCanceledOnTouchOutside(false);
                              EditText email=bottomSheetDialog.findViewById(R.id.et_email);
                              Button varification=bottomSheetDialog.findViewById(R.id.btn_varification);
                              varification.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      fAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                          @Override
                                          public void onComplete(@NonNull Task<Void> task) {
                                             Toast.makeText(Register.this,"Please Check Your E-mail for Varification",Toast.LENGTH_SHORT);
                                             registerFirstName.setText("");
                                             registerLastName.setText("");
                                             registerMobileNumber.setText("");
                                             registerEmail.setText("");
                                             registerPassword.setText("");
                                             Intent i=new Intent(Register.this,Login.class);
                                             startActivity(i);
                                             finish();
                                          }
                                      });
                                  }
                              });
                             bottomSheetDialog.show();*//*
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                            }
                        });*/
                    }
                    else {
                        Toast.makeText(Register.this, "please fullfill all detail", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

    }
    private void insertStudentData(){
        String firstName=registerFirstName1.getText().toString();
        String lastName=registerLastName1.getText().toString();
        String mobileNumber=registerMobileNumber1.getText().toString();
        String email=registerEmail1.getText().toString();
        String pass=registerPassword1.getText().toString();
        /* String conpass=registerConPass.getText().toString();*/

        student student =new student(firstName,lastName,mobileNumber,email,pass);
        studentDbRef.push().setValue(student);
        Toast.makeText(Register.this,"Data Success Fully Added ",Toast.LENGTH_SHORT).show();

       /* Toast.makeText(Register.this,"Data Sucess Fully Added ",Toast.LENGTH_SHORT).show();
 stud stud=new stud(FirstName,lastName,mobileNumber,email,pass,conpass);
        studDbRef.push().setValue(stud);
*/


    }
}