package com.example.bca_pocketbook;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.ArrayList;

public class Admin_Test extends AppCompatActivity {


    Button LogOutBtn;
    FirebaseAuth firebaseAuth;

    EditText editText;
    Button btn;
    Spinner sp_course,sp_semester,sp_subject;

    ArrayList<String> arrayList_course;
    ArrayAdapter<String> arrayAdapter_course;

    ArrayList<String> arrayList_sem;
    ArrayAdapter<String>arrayAdapter_semester;

    ArrayList<String> arrayList_subject,arrayList_sem1,arrayList_sem2,arrayList_sem3,arrayList_sem4,arrayList_sem5,arrayList_sem6;
    ArrayAdapter<String>arrayAdapter_subject;
    //String course[]={"select Course","BCA","BSC.IT"}; //course spinner
    //String semester[]={"select Semester","sem-1","sem-2","sem-3","sem-4","sem-5","sem-6"}; //semester spinner
    StorageReference storageReference;
    DatabaseReference databaseReference;
    String course,sem,subject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__test);

        editText=findViewById(R.id.editText);
        btn=findViewById(R.id.btnUpload);
        // Course_spinner
        sp_course=findViewById(R.id.sp_Course);
        sp_semester=findViewById(R.id.sp_Semester);
        sp_subject=findViewById(R.id.sp_Subject);

        arrayList_course=new ArrayList<>();
        arrayList_course.add("select course");
        arrayList_course.add("BCA");
        arrayList_course.add("BSC IT");
        arrayAdapter_course=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_course);
        sp_course.setAdapter(arrayAdapter_course);

        arrayList_sem=new ArrayList<>();
        arrayList_sem.add("select sem");
        arrayList_sem.add("SEM-1");
        arrayList_sem.add("SEM-2");
        arrayList_sem.add("SEM-3");
        arrayList_sem.add("SEM-4");
        arrayList_sem.add("SEM-5");
        arrayList_sem.add("SEM-6");
        arrayAdapter_semester=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_sem);
        sp_semester.setAdapter(arrayAdapter_semester);



        arrayList_subject=new ArrayList<>();
        arrayList_subject.add("select Subject");
        arrayList_subject.add("Environment Science-1");
        arrayList_subject.add("Introduction to English Language-1");
        arrayList_subject.add("Fundamental of Computer Organization ");
        arrayList_subject.add("Introduction to Programming(C Lan)");
        arrayList_subject.add("RDBMS-1");
        arrayList_subject.add("Mathematics");
        arrayAdapter_subject=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_subject);
        sp_subject.setAdapter(arrayAdapter_subject);

        arrayList_subject.add("Environment Science-2");
        arrayList_subject.add("Introduction to English Language-2");
        arrayList_subject.add("Information Technology in Business ");
        arrayList_subject.add("Web Designing");
        arrayList_subject.add("Advanced C Programming");
        arrayList_subject.add("Statistics");
        arrayAdapter_subject=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_subject);
        sp_subject.setAdapter(arrayAdapter_subject);

        arrayList_subject.add("Disaster Management");
        arrayList_subject.add("Business Communication-3");
        arrayList_subject.add("Operating System");
        arrayList_subject.add("Data and File Structure");
        arrayList_subject.add("Object Oriented Programming with C++");
        arrayList_subject.add("System Analysis and Design");
        arrayAdapter_subject=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_subject);
        sp_subject.setAdapter(arrayAdapter_subject);

        arrayList_subject.add("Nano-Materials & Nano-Technology");
        arrayList_subject.add("Business Communication-4");
        arrayList_subject.add("Advance Operating System and Intro to Linux ");
        arrayList_subject.add("Application Development Using Vb.Net");
        arrayList_subject.add("Web Application Development Using PHP");
        arrayList_subject.add("Object Oriented Analysis and Design");
        arrayAdapter_subject=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_subject);
        sp_subject.setAdapter(arrayAdapter_subject);

        arrayList_subject.add("IT Project Management");
        arrayList_subject.add("Business Communication-5");
        arrayList_subject.add("Software Engineering");
        arrayList_subject.add("Web Application Development Using Asp.Net");
        arrayList_subject.add("RDBMS Using Oracle 1");
        arrayList_subject.add("Data Communication And Networking");
        arrayAdapter_subject=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_subject);
        sp_subject.setAdapter(arrayAdapter_subject);

        arrayList_subject.add("Multimedia & Application");
        arrayList_subject.add("Business Communication-6");
        arrayList_subject.add("Network Security");
        arrayList_subject.add("Core Java");
        arrayList_subject.add("RDBMS Using Oracle-2");
        arrayList_subject.add("Project work ");
        arrayAdapter_subject=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_subject);
        sp_subject.setAdapter(arrayAdapter_subject);

/*
        sp_semester.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==1)
                    arrayAdapter_subject=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_sem1);
                if(position==2)
                    arrayAdapter_subject=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_sem2);
                 if (position==3)
                    arrayAdapter_subject=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_sem3);
                if (position==4)
                    arrayAdapter_subject=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_sem4);
                if (position==5)
                    arrayAdapter_subject=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_sem5);
                 if (position==6)
                    arrayAdapter_subject=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_sem6);

                sp_subject.setAdapter(arrayAdapter_subject);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
*/

        // arrayAdapter_subject=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_subject);
        //sp_subject.setAdapter(arrayAdapter_subject);


        sp_course.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==1)
                {
                    sp_semester.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            if (position==1)
                            {
                                sp_subject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                        if(position==1) {
                                            course = "BCA";
                                            sem = "SEM-1";
                                            subject = "Environment Science-1";
                                        }
                                        else if(position==2){
                                            course = "BCA";
                                            sem = "SEM-1";
                                            subject = "Introduction to English Language-1";
                                        }else if(position==3){
                                            course = "BCA";
                                            sem = "SEM-1";
                                            subject = "Fundamental of Computer Organization";
                                        }else if(position==4){
                                            course = "BCA";
                                            sem = "SEM-1";
                                            subject = "Introduction to Programming(C Lan)";
                                        }else if(position==5){
                                            course = "BCA";
                                            sem = "SEM-1";
                                            subject = "RDBMS-1";
                                        }
                                        else if(position==6){
                                            course = "BCA";
                                            sem = "SEM-1";
                                            subject = "Mathematics";
                                        }

                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> parent) {

                                    }
                                });


                            }
                            else if(position==2)
                            {
                                course="BCA";
                                sem="SEM-2";
                            }
                            else if(position==3)
                            {
                                course="BCA";
                                sem="SEM-3";

                            }
                            else if(position==4)
                            {
                                course="BCA";
                                sem="SEM-4";

                            }
                            else if(position==5)
                            {
                                course="BCA";
                                sem="SEM-5";

                            }
                            else if(position==6)
                            {
                                course="BCA";
                                sem="SEM-6";
                            }
                            else
                            {
                                Toast.makeText(Admin_Test.this, "please select sem", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }
                else if(position==2)
                {

                }
                else {
                    Toast.makeText(Admin_Test.this, "please select course", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        storageReference= FirebaseStorage.getInstance().getReference();
        databaseReference= FirebaseDatabase.getInstance().getReference("MyPDF");
        btn.setEnabled(false);
        firebaseAuth=FirebaseAuth.getInstance();

        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectPDF();
            }
        });

        LogOutBtn=findViewById(R.id.btnLogOut);
        LogOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(), Register.class));
                firebaseAuth.signOut();
                finish();

            }
        });



    }
    private void selectPDF() {

        Intent intent=new Intent();
        intent.setType("application/pdf");
        intent.setAction(intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"PDF FILE SELECT"),12);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==12 && resultCode==RESULT_OK && data!=null && data.getData()!=null)
        {
            btn.setEnabled(true);
            editText.setText(data.getDataString()
                    .substring(data.getDataString().lastIndexOf("/")+1));

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(!course.isEmpty() && !sem.isEmpty()) {
                        uploadPDFFileFirebase(data.getData(), course, sem,subject);
                    }

                }
            });

        }


    }

    private void uploadPDFFileFirebase(Uri data,String c,String s,String sub) {

        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("File is Loading...");
        progressDialog.show();

        StorageReference reference=storageReference.child("upload"+System.currentTimeMillis()+".pdf");

        reference.putFile(data)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                        Task<Uri> uriTask=taskSnapshot.getStorage().getDownloadUrl();
                        while (!uriTask.isComplete());
                        Uri uri=uriTask.getResult();

                        putPDF putPDF=new putPDF(editText.getText().toString(),uri.toString());
                        databaseReference.child(c).child(s).child(sub).child(databaseReference.push().getKey()).setValue(putPDF);
                        Toast.makeText(Admin_Test.this, "file upload.", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();

                    }
                }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {

                double progress=(100.0*snapshot.getBytesTransferred())/snapshot.getTotalByteCount();
                progressDialog.setMessage("file upload..." +(int)progress+ "%");

            }
        });

    }
}