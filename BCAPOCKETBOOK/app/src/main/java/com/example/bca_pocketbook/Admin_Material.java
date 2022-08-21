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

public class Admin_Material extends AppCompatActivity {

    Button LogOutBtn;
    FirebaseAuth firebaseAuth;

    EditText editText;
    Button btn;
    Spinner sp_course,sp_semester,sp_subject;

    ArrayList<String> arrayList_course;
    ArrayAdapter<String> arrayAdapter_course;

    ArrayList<String> arrayList_sem;
    ArrayAdapter<String>arrayAdapter_semester;

    ArrayList<String> arrayList_subject1,arrayList_subject2,arrayList_subject3,arrayList_subject4,arrayList_subject5,arrayList_subject6;
    ArrayAdapter<String>arrayAdapter_subject;

    ArrayList<String>arrayList_sub1,arrayList_sub2,arrayList_sub3,arrayList_sub4,arrayList_sub5,arrayList_sub6;
    ArrayAdapter<String>arrayAdapter_sub;


    //String course[]={"select Course","BCA","BSC.IT"}; //course spinner
    //String semester[]={"select Semester","sem-1","sem-2","sem-3","sem-4","sem-5","sem-6"}; //semester spinner
    StorageReference storageReference;
    DatabaseReference databaseReference;
    String course,sem,subject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__material);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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



    arrayList_subject1=new ArrayList<>();
        arrayList_subject1.add("Select Your Subject");
        arrayList_subject1.add("Environment Science-1");
        arrayList_subject1.add("Introduction to English Language-1");
        arrayList_subject1.add("Fundamental of Computer Organization ");
        arrayList_subject1.add("Introduction to Programming(C Lan)");
        arrayList_subject1.add("RDBMS-1");
        arrayList_subject1.add("Mathematics");
    arrayAdapter_subject=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_subject1);
        sp_subject.setAdapter(arrayAdapter_subject);

        arrayList_subject2=new ArrayList<>();
        arrayList_subject2.add("Select Your Subject");
        arrayList_subject2.add("Environment Science-2");
        arrayList_subject2.add("Introduction to English Language-2");
        arrayList_subject2.add("Information Technology in Business ");
        arrayList_subject2.add("Web Designing");
        arrayList_subject2.add("Advanced C Programming");
        arrayList_subject2.add("Statistics");
    arrayAdapter_subject=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_subject2);
        sp_subject.setAdapter(arrayAdapter_subject);

        arrayList_subject3=new ArrayList<>();
        arrayList_subject3.add("Select Your Subject");
        arrayList_subject3.add("Disaster Management");
        arrayList_subject3.add("Business Communication-3");
        arrayList_subject3.add("Operating System");
        arrayList_subject3.add("Data and File Structure");
        arrayList_subject3.add("Object Oriented Programming with C++");
        arrayList_subject3.add("System Analysis and Design");
    arrayAdapter_subject=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_subject3);
        sp_subject.setAdapter(arrayAdapter_subject);

        arrayList_subject4=new ArrayList<>();
        arrayList_subject4.add("Select Your Subject");
        arrayList_subject4.add("Nano-Materials & Nano-Technology");
        arrayList_subject4.add("Business Communication-4");
        arrayList_subject4.add("Advance Operating System and Intro to Linux ");
        arrayList_subject4.add("Application Development Using Vb.Net");
        arrayList_subject4.add("Web Application Development Using PHP");
        arrayList_subject4.add("Object Oriented Analysis and Design");
    arrayAdapter_subject=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_subject4);
        sp_subject.setAdapter(arrayAdapter_subject);

        arrayList_subject5=new ArrayList<>();
        arrayList_subject5.add("Select Your Subject");
        arrayList_subject5.add("IT Project Management");
        arrayList_subject5.add("Business Communication-5");
        arrayList_subject5.add("Software Engineering");
        arrayList_subject5.add("Web Application Development Using Asp.Net");
        arrayList_subject5.add("RDBMS Using Oracle 1");
        arrayList_subject5.add("Data Communication And Networking");
    arrayAdapter_subject=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_subject5);
        sp_subject.setAdapter(arrayAdapter_subject);

        arrayList_subject6=new ArrayList<>();
        arrayList_subject6.add("Select Your Subject");
        arrayList_subject6.add("Multimedia & Application");
        arrayList_subject6.add("Business Communication-6");
        arrayList_subject6.add("Network Security");
        arrayList_subject6.add("Core Java");
        arrayList_subject6.add("RDBMS Using Oracle-2");
        arrayList_subject6.add("Project work ");
    arrayAdapter_subject=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_subject6);
        sp_subject.setAdapter(arrayAdapter_subject);

        arrayList_sub1=new ArrayList<>();
        arrayList_sub1.add("Select Your Subject");
        arrayList_sub1.add("Environmental Science - I");
        arrayList_sub1.add("Business Communication - I ");
        arrayList_sub1.add("Fundamental of IT");
        arrayList_sub1.add("Introduction of C Language ");
        arrayList_sub1.add("Open Office");
        arrayList_sub1.add("Computer Oriented Mathematics");
        arrayAdapter_sub=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_sub1);
        sp_subject.setAdapter(arrayAdapter_sub);

        arrayList_sub2=new ArrayList<>();
        arrayList_sub2.add("Select Your Subject");
        arrayList_sub2.add("Environmental Science – II ");
        arrayList_sub2.add("Business Communication- II");
        arrayList_sub2.add("Principles of Digital Electronics");
        arrayList_sub2.add("Advanced C Programming");
        arrayList_sub2.add("Internet and Web Technology");
        arrayList_sub2.add("Network Management & Information Security ");
        arrayAdapter_sub=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_sub2);
        sp_subject.setAdapter(arrayAdapter_sub);

        arrayList_sub3=new ArrayList<>();
        arrayList_sub3.add("Select Your Subject");
        arrayList_sub3.add("Disaster Management");
        arrayList_sub3.add("English");
        arrayList_sub3.add("DATA AND FILE STRUCTURE USING C");
        arrayList_sub3.add("PROGRAMMING IN C++");
        arrayList_sub3.add("SYSTEM ANALYSIS AND DESIGN");
        arrayList_sub3.add("OPERATING SYSTEM-I ");
        arrayAdapter_sub=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_sub3);
        sp_subject.setAdapter(arrayAdapter_sub);

        arrayList_sub4=new ArrayList<>();
        arrayList_sub4.add("Select Your Subject");
        arrayList_sub4.add("NANOMATERIALS & NANOTECHNOLOGY");
        arrayList_sub4.add("ENGLISH");
        arrayList_sub4.add("WINDOW PROGRAMMING USING VB.NET");
        arrayList_sub4.add("DATABASE CONCEPT AND TOOLS ");
        arrayList_sub4.add("COMPUTER NETWORK");
        arrayList_sub4.add("OPERATING SYSTEM-II ");
        arrayAdapter_sub=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_sub4);
        sp_subject.setAdapter(arrayAdapter_sub);

        arrayList_sub5=new ArrayList<>();
        arrayList_sub5.add("Select Your Subject");
        arrayList_sub5.add("IT PROJECT MANAGEMENT");
        arrayList_sub5.add("ENGLISH");
        arrayList_sub5.add("WEB PROGRAMMING-I Using PHP ");
        arrayList_sub5.add("ADVANCE DATABASE CONCEPT AND TOOLS");
        arrayList_sub5.add("SOFTWARE ENGINEERING ");
        arrayList_sub5.add("MANAGEMENT INFORMATION SYSTEM ");
        arrayAdapter_sub=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_sub5);
        sp_subject.setAdapter(arrayAdapter_sub);

        arrayList_sub6=new ArrayList<>();
        arrayList_sub6.add("Select Your Subject");
        arrayList_sub6.add("IT PROJECT MANAGEMENT");
        arrayList_sub6.add("ENGLISH ");
        arrayList_sub6.add("WEB PROGRAMMING-II Using ASP.NET");
        arrayList_sub6.add("OOP USING JAVA");
        arrayList_sub6.add("DATA WARE HOUSE AND DATA MINING");
        arrayList_sub6.add("MINI PROJECT");
        arrayAdapter_sub=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_sub6);
        sp_subject.setAdapter(arrayAdapter_sub);

        sp_course.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==1)
                {
                    sp_semester.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            if(position==1) {
                                arrayAdapter_subject = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_subject1);
                                sp_subject.setAdapter(arrayAdapter_subject);
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
                            if(position==2) {
                                arrayAdapter_subject = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_subject2);
                                sp_subject.setAdapter(arrayAdapter_subject);

                                sp_subject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
                                    {
                                        if(position==1) {
                                            course = "BCA";
                                            sem = "SEM-2";
                                            subject = "Environment Science-2";
                                        }
                                        else if(position==2){
                                            course = "BCA";
                                            sem = "SEM-2";
                                            subject = "Introduction to English Language-2";
                                        }else if(position==3){
                                            course = "BCA";
                                            sem = "SEM-2";
                                            subject = "Information Technology in Business";
                                        }else if(position==4){
                                            course = "BCA";
                                            sem = "SEM-3";
                                            subject = "Web Designing";
                                        }else if(position==5){
                                            course = "BCA";
                                            sem = "SEM-2";
                                            subject = "Advanced C Programming";
                                        }
                                        else if(position==6){
                                            course = "BCA";
                                            sem = "SEM-2";
                                            subject = "Statistics";
                                        }

                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> parent) {

                                    }
                                });

                            }
                            if (position==3)
                            {
                                arrayAdapter_subject = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_subject3);
                                sp_subject.setAdapter(arrayAdapter_subject);
                                sp_subject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
                                    {
                                        if(position==1) {
                                            course = "BCA";
                                            sem = "SEM-3";
                                            subject = "Disaster Management";
                                        }
                                        else if(position==2){
                                            course = "BCA";
                                            sem = "SEM-3";
                                            subject = "Business Communication-3";
                                        }else if(position==3){
                                            course = "BCA";
                                            sem = "SEM-3";
                                            subject = "Operating System";
                                        }else if(position==4){
                                            course = "BCA";
                                            sem = "SEM-3";
                                            subject = "Data and File Structure";
                                        }else if(position==5){
                                            course = "BCA";
                                            sem = "SEM-3";
                                            subject = "Object Oriented Programming with C++";
                                        }
                                        else if(position==6){
                                            course = "BCA";
                                            sem = "SEM-3";
                                            subject = "System Analysis and Design";
                                        }
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> parent) {

                                    }
                                });

                            }
                            if (position==4) {
                                arrayAdapter_subject = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_subject4);
                                sp_subject.setAdapter(arrayAdapter_subject);
                                sp_subject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
                                    {
                                        if(position==1) {
                                            course = "BCA";
                                            sem = "SEM-4";
                                            subject = "Nano-Materials & Nano-Technology";
                                        }
                                        else if(position==2){
                                            course = "BCA";
                                            sem = "SEM-4";
                                            subject = "Business Communication-4";
                                        }else if(position==3){
                                            course = "BCA";
                                            sem = "SEM-4";
                                            subject = "Advance Operating System and Intro to Linux ";
                                        }else if(position==4){
                                            course = "BCA";
                                            sem = "SEM-4";
                                            subject = "Application Development Using Vb.Net";
                                        }else if(position==5){
                                            course = "BCA";
                                            sem = "SEM-4";
                                            subject = "Web Application Development Using PHP";
                                        }
                                        else if(position==6){
                                            course = "BCA";
                                            sem = "SEM-4";
                                            subject ="Object Oriented Analysis and Design";
                                        }
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> parent) {

                                    }
                                });
                            }
                            if (position==5) {
                                arrayAdapter_subject = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_subject5);
                                sp_subject.setAdapter(arrayAdapter_subject);
                                sp_subject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
                                    {
                                        if(position==1) {
                                            course = "BCA";
                                            sem = "SEM-5";
                                            subject = "IT Project Management";
                                        }
                                        else if(position==2){
                                            course = "BCA";
                                            sem = "SEM-5";
                                            subject = "Business Communication-5";
                                        }else if(position==3){
                                            course = "BCA";
                                            sem = "SEM-5";
                                            subject = "Software Engineering";
                                        }else if(position==4){
                                            course = "BCA";
                                            sem = "SEM-5";
                                            subject = "Web Application Development Using Asp.Net";
                                        }else if(position==5){
                                            course = "BCA";
                                            sem = "SEM-5";
                                            subject = "RDBMS Using Oracle 1";
                                        }
                                        else if(position==6){
                                            course = "BCA";
                                            sem = "SEM-5";
                                            subject ="Data Communication And Networking";
                                        }
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> parent) {

                                    }
                                });

                            }
                            if (position==6) {
                                arrayAdapter_subject = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_subject6);
                                sp_subject.setAdapter(arrayAdapter_subject);
                                sp_subject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
                                    {
                                        if(position==1) {
                                            course = "BCA";
                                            sem = "SEM-6";
                                            subject = "Multimedia & Application";
                                        }
                                        else if(position==2){
                                            course = "BCA";
                                            sem = "SEM-6";
                                            subject = "Business Communication-6";
                                        }else if(position==3){
                                            course = "BCA";
                                            sem = "SEM-6";
                                            subject = "Network Security";
                                        }else if(position==4){
                                            course = "BCA";
                                            sem = "SEM-6";
                                            subject = "Core Java";
                                        }else if(position==5){
                                            course = "BCA";
                                            sem = "SEM-6";
                                            subject = "RDBMS Using Oracle-2";
                                        }
                                        else if(position==6){
                                            course = "BCA";
                                            sem = "SEM-6";
                                            subject ="Project work ";
                                        }



                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> parent) {

                                    }
                                });

                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });

                }
                else if(position==2)
                {


                    sp_semester.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            if (position == 1) {
                                arrayAdapter_sub = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_sub1);
                                sp_subject.setAdapter(arrayAdapter_sub);
                                sp_subject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                        if (position == 1) {
                                            course = "BSC-IT";
                                            sem = "SEM-1";
                                            subject = "Environmental Science - I ";
                                        } else if (position == 2) {
                                            course = "BSC-IT";
                                            sem = "SEM-1";
                                            subject = "Business Communication - I ";
                                        } else if (position == 3) {
                                            course = "BSC-IT";
                                            sem = "SEM-1";
                                            subject = "Fundamental of IT ";
                                        } else if (position == 4) {
                                            course = "BSC-IT";
                                            sem = "SEM-1";
                                            subject = "Introduction of C Language";
                                        } else if (position == 5) {
                                            course = "BSC-IT";
                                            sem = "SEM-1";
                                            subject = "Open Office";
                                        } else if (position == 6) {
                                            course = "BSC-IT";
                                            sem = "SEM-1";
                                            subject = "Computer Oriented Mathematics";
                                        }


                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> parent) {

                                    }
                                });
                            }
                            if (position == 2) {
                                arrayAdapter_sub = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_sub2);
                                sp_subject.setAdapter(arrayAdapter_sub);

                                sp_subject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                        if (position == 1) {
                                            course = "BSC-IT";
                                            sem = "SEM-2";
                                            subject = "Environmental Science – II ";
                                        } else if (position == 2) {
                                            course = "BSC-IT";
                                            sem = "SEM-2";
                                            subject = "Business Communication- II ";
                                        } else if (position == 3) {
                                            course = "BSC-IT";
                                            sem = "SEM-2";
                                            subject = "Principles of Digital Electronics";
                                        } else if (position == 4) {
                                            course = "BSC-IT";
                                            sem = "SEM-3";
                                            subject = "Advanced C Programming";
                                        } else if (position == 5) {
                                            course = "BSC-IT";
                                            sem = "SEM-2";
                                            subject = "Internet and Web Technology";
                                        } else if (position == 6) {
                                            course = "BSC-IT";
                                            sem = "SEM-2";
                                            subject = "Network Management & Information Security";
                                        }

                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> parent) {

                                    }
                                });

                            }
                            if (position == 3) {
                                arrayAdapter_sub = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_sub3);
                                sp_subject.setAdapter(arrayAdapter_sub);
                                sp_subject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                        if (position == 1) {
                                            course = "BSC-IT";
                                            sem = "SEM-3";
                                            subject = "Disaster Management";
                                        } else if (position == 2) {
                                            course = "BSC-IT";
                                            sem = "SEM-3";
                                            subject = "English";
                                        } else if (position == 3) {
                                            course = "BSC-IT";
                                            sem = "SEM-3";
                                            subject = "Data and File Structure using C";
                                        } else if (position == 4) {
                                            course = "BSC-IT";
                                            sem = "SEM-3";
                                            subject = "Programming in c++";
                                        } else if (position == 5) {
                                            course = "BSC-IT";
                                            sem = "SEM-3";
                                            subject = "System Analysis And Design";
                                        } else if (position == 6) {
                                            course = "BSC-IT";
                                            sem = "SEM-3";
                                            subject = "Operating System-I";
                                        }
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> parent) {

                                    }
                                });

                            }
                            if (position == 4) {
                                arrayAdapter_sub = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_sub4);
                                sp_subject.setAdapter(arrayAdapter_sub);
                                sp_subject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                        if (position == 1) {
                                            course = "BSC-IT";
                                            sem = "SEM-4";
                                            subject = "NANOMATERIALS & NANOTECHNOLOGY";
                                        } else if (position == 2) {
                                            course = "BSC-IT";
                                            sem = "SEM-4";
                                            subject = "ENGLISH";
                                        } else if (position == 3) {
                                            course = "BSC-IT";
                                            sem = "SEM-4";
                                            subject = "WINDOW PROGRAMMING USING VB.NET";
                                        } else if (position == 4) {
                                            course = "BSC-IT";
                                            sem = "SEM-4";
                                            subject = "DATABASE CONCEPT AND TOOLS ";
                                        } else if (position == 5) {
                                            course = "BSC-IT";
                                            sem = "SEM-4";
                                            subject = "COMPUTER NETWORK";
                                        } else if (position == 6) {
                                            course = "BSC-IT";
                                            sem = "SEM-4";
                                            subject = "OPERATING SYSTEM-II ";
                                        }
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> parent) {

                                    }
                                });
                            }
                            if (position == 5) {
                                arrayAdapter_sub = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_sub5);
                                sp_subject.setAdapter(arrayAdapter_sub);
                                sp_subject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                        if (position == 1) {
                                            course = "BSC-IT";
                                            sem = "SEM-5";
                                            subject = "IT PROJECT MANAGEMENT";
                                        } else if (position ==2) {
                                            course = "BSC-IT";
                                            sem = "SEM-5";
                                            subject = "ENGLISH ";
                                        } else if (position == 3) {
                                            course = "BSC-IT";
                                            sem = "SEM-5";
                                            subject = "WEB PROGRAMMING-I Using PHP";
                                        } else if (position == 4) {
                                            course = "BSC-IT";
                                            sem = "SEM-5";
                                            subject = "ADVANCE DATABASE CONCEPT AND TOOLS ";
                                        } else if (position == 5) {
                                            course = "BSC-IT";
                                            sem = "SEM-5";
                                            subject = "SOFTWARE ENGINEERING ";
                                        } else if (position == 6) {
                                            course = "BSC-IT";
                                            sem = "SEM-5";
                                            subject = "MANAGEMENT INFORMATION SYSTEM ";
                                        }
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> parent) {

                                    }
                                });

                            }
                            if (position == 6) {
                                arrayAdapter_sub = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_sub6);
                                sp_subject.setAdapter(arrayAdapter_sub);
                                sp_subject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                        if (position == 1) {
                                            course = "BSC-IT";
                                            sem = "SEM-6";
                                            subject = "Multimedia & Application";
                                        } else if (position == 2) {
                                            course = "BSC-IT";
                                            sem = "SEM-6";
                                            subject = "Business Communication-6";
                                        } else if (position == 3) {
                                            course = "BSC-IT";
                                            sem = "SEM-6";
                                            subject = "Network Security";
                                        } else if (position == 4) {
                                            course = "BSC-IT";
                                            sem = "SEM-6";
                                            subject = "Core Java";
                                        } else if (position == 5) {
                                            course = "BSC-IT";
                                            sem = "SEM-6";
                                            subject = "RDBMS Using Oracle-2";
                                        } else if (position == 6) {
                                            course = "BSC-IT";
                                            sem = "SEM-6";
                                            subject = "Project work ";
                                        }


                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> parent) {

                                    }
                                });

                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });

/*

    // arrayAdapter_subject=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_subject);
    //sp_subject.setAdapter(arrayAdapter_subject);


        sp_course.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if(position==0)
            {
                sp_semester.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if (position==0)
                        {
                            sp_subject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                    if(position==0) {
                                        course = "BCA";
                                        sem = "SEM-1";
                                        subject = "Environment Science-1";
                                    }
                                    else if(position==1){
                                        course = "BCA";
                                        sem = "SEM-1";
                                        subject = "Introduction to English Language-1";
                                    }else if(position==2){
                                        course = "BCA";
                                        sem = "SEM-1";
                                        subject = "Fundamental of Computer Organization";
                                    }else if(position==3){
                                        course = "BCA";
                                        sem = "SEM-1";
                                        subject = "Introduction to Programming(C Lan)";
                                    }else if(position==4){
                                        course = "BCA";
                                        sem = "SEM-1";
                                        subject = "RDBMS-1";
                                    }
                                    else if(position==5){
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
                        else if(position==1)
                        {

                            sp_subject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                    if(position==0) {
                                        course = "BCA";
                                        sem = "SEM-2";
                                        subject = "Environment Science-2";
                                    }
                                    else if(position==1){
                                        course = "BCA";
                                        sem = "SEM-2";
                                        subject = "Introduction to English Language-2";
                                    }else if(position==2){
                                        course = "BCA";
                                        sem = "SEM-2";
                                        subject = "Information Technology in Business";
                                    }else if(position==3){
                                        course = "BCA";
                                        sem = "SEM-3";
                                        subject = "Web Designing";
                                    }else if(position==4){
                                        course = "BCA";
                                        sem = "SEM-2";
                                        subject = "Advanced C Programming";
                                    }
                                    else if(position==5){
                                        course = "BCA";
                                        sem = "SEM-2";
                                        subject = "Statistics";
                                    }

                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });
                        }
                        else if(position==2)
                        {
                            sp_subject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                    if(position==0) {
                                        course = "BCA";
                                        sem = "SEM-3";
                                        subject = "Disaster Management";
                                    }
                                    else if(position==1){
                                        course = "BCA";
                                        sem = "SEM-3";
                                        subject = "Business Communication-3";
                                    }else if(position==2){
                                        course = "BCA";
                                        sem = "SEM-3";
                                        subject = "Operating System";
                                    }else if(position==3){
                                        course = "BCA";
                                        sem = "SEM-3";
                                        subject = "Data and File Structure";
                                    }else if(position==4){
                                        course = "BCA";
                                        sem = "SEM-3";
                                        subject = "Object Oriented Programming with C++";
                                    }
                                    else if(position==5){
                                        course = "BCA";
                                        sem = "SEM-3";
                                        subject = "System Analysis and Design";
                                    }

                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });

                        }
                        else if(position==3)
                        {
                            sp_subject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                    if(position==0) {
                                        course = "BCA";
                                        sem = "SEM-4";
                                        subject = "Nano-Materials & Nano-Technology";
                                    }
                                    else if(position==1){
                                        course = "BCA";
                                        sem = "SEM-4";
                                        subject = "Business Communication-4";
                                    }else if(position==2){
                                        course = "BCA";
                                        sem = "SEM-4";
                                        subject = "Advance Operating System and Intro to Linux ";
                                    }else if(position==3){
                                        course = "BCA";
                                        sem = "SEM-4";
                                        subject = "Application Development Using Vb.Net";
                                    }else if(position==4){
                                        course = "BCA";
                                        sem = "SEM-4";
                                        subject = "Web Application Development Using PHP";
                                    }
                                    else if(position==5){
                                        course = "BCA";
                                        sem = "SEM-4";
                                        subject ="Object Oriented Analysis and Design";
                                    }

                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });

                        }
                        else if(position==4)
                        {

                            sp_subject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                    if(position==0) {
                                        course = "BCA";
                                        sem = "SEM-5";
                                        subject = "IT Project Management";
                                    }
                                    else if(position==1){
                                        course = "BCA";
                                        sem = "SEM-5";
                                        subject = "Business Communication-5";
                                    }else if(position==2){
                                        course = "BCA";
                                        sem = "SEM-5";
                                        subject = "Software Engineering";
                                    }else if(position==3){
                                        course = "BCA";
                                        sem = "SEM-5";
                                        subject = "Web Application Development Using Asp.Net";
                                    }else if(position==4){
                                        course = "BCA";
                                        sem = "SEM-5";
                                        subject = "RDBMS Using Oracle 1";
                                    }
                                    else if(position==5){
                                        course = "BCA";
                                        sem = "SEM-5";
                                        subject ="Data Communication And Networking";
                                    }

                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });

                        }
                        else if(position==5)
                        {
                            sp_subject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                    if(position==0) {
                                        course = "BCA";
                                        sem = "SEM-6";
                                        subject = "Multimedia & Application";
                                    }
                                    else if(position==1){
                                        course = "BCA";
                                        sem = "SEM-6";
                                        subject = "Business Communication-6";
                                    }else if(position==2){
                                        course = "BCA";
                                        sem = "SEM-6";
                                        subject = "Network Security";
                                    }else if(position==3){
                                        course = "BCA";
                                        sem = "SEM-6";
                                        subject = "Core Java";
                                    }else if(position==4){
                                        course = "BCA";
                                        sem = "SEM-6";
                                        subject = "RDBMS Using Oracle-2";
                                    }
                                    else if(position==5){
                                        course = "BCA";
                                        sem = "SEM-6";
                                        subject ="Project work ";
                                    }

                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });
                        }
                        else
                        {
                            Toast.makeText(Admin_Material.this, "please select sem", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }
            else if(position==1)
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
                                        course = "BSC-IT";
                                        sem = "SEM-1";
                                        subject = "Environment Science-1";
                                    }
                                    else if(position==2){
                                        course = "BSC-IT";
                                        sem = "SEM-1";
                                        subject = "Introduction to English Language-1";
                                    }else if(position==3){
                                        course = "BSC-IT";
                                        sem = "SEM-1";
                                        subject = "Fundamental of Computer Organization";
                                    }else if(position==4){
                                        course = "BSC-IT";
                                        sem = "SEM-1";
                                        subject = "Introduction to Programming(C Lan)";
                                    }else if(position==5){
                                        course = "BSC-IT";
                                        sem = "SEM-1";
                                        subject = "RDBMS-1";
                                    }
                                    else if(position==6){
                                        course = "BSC-IT";
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

                            sp_subject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                    if(position==1) {
                                        course = "BSC-IT";
                                        sem = "SEM-2";
                                        subject = "Environment Science-2";
                                    }
                                    else if(position==2){
                                        course = "BSC-IT";
                                        sem = "SEM-2";
                                        subject = "Introduction to English Language-2";
                                    }else if(position==3){
                                        course = "BSC-IT";
                                        sem = "SEM-2";
                                        subject = "Information Technology in Business";
                                    }else if(position==4){
                                        course = "BSC-IT";
                                        sem = "SEM-3";
                                        subject = "Web Designing";
                                    }else if(position==5){
                                        course = "BSC-IT";
                                        sem = "SEM-2";
                                        subject = "Advanced C Programming";
                                    }
                                    else if(position==6){
                                        course = "BSC-IT";
                                        sem = "SEM-2";
                                        subject = "Statistics";
                                    }

                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });
                        }
                        else if(position==3)
                        {
                            course="BSC-IT";
                            sem="SEM-3";

                        }
                        else if(position==4)
                        {
                            course="BSC-IT";
                            sem="SEM-4";

                        }
                        else if(position==5)
                        {
                            course="BSC-IT";
                            sem="SEM-5";

                        }
                        else if(position==6)
                        {
                            course="BSC-IT";
                            sem="SEM-6";
                        }
                        else
                        {
                            Toast.makeText(Admin_Material.this, "please select sem", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }
            else {
                Toast.makeText(Admin_Material.this, "please select course", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    });

*/


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

    private void uploadPDFFileFirebase(Uri data, String c, String s, String sub) {

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
                        databaseReference.child("material").child(c).child(s).child(sub).child(databaseReference.push().getKey()).setValue(putPDF);
                        Toast.makeText(Admin_Material.this, "file upload.", Toast.LENGTH_SHORT).show();
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