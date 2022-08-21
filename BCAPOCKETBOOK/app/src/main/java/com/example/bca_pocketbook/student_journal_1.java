package com.example.bca_pocketbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class student_journal_1 extends AppCompatActivity {

    ArrayList<String> arrayList_course;
    ArrayAdapter<String> arrayAdapter_course;
    Button btn;

    ArrayList<String> arrayList_sem;
    ArrayAdapter<String>arrayAdapter_semester;

    ArrayList<String> arrayList_subject1,arrayList_subject2,arrayList_subject3,arrayList_subject4,arrayList_subject5,arrayList_subject6;
    ArrayAdapter<String>arrayAdapter_subject;

    ArrayList<String>arrayList_sub1,arrayList_sub2,arrayList_sub3,arrayList_sub4,arrayList_sub5,arrayList_sub6;
    ArrayAdapter<String>arrayAdapter_sub;
    Spinner sp_course,sp_semester,sp_subject;
    String course,sem,subject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_journal_1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btn=findViewById(R.id.btnRetrieve);
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
        arrayList_subject1.add("Introduction to Programming(C Lan)");
        arrayList_subject1.add("RDBMS-1");
        arrayAdapter_subject=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_subject1);
        sp_subject.setAdapter(arrayAdapter_subject);

        arrayList_subject2=new ArrayList<>();
        arrayList_subject2.add("Web Designing");
        arrayList_subject2.add("Advanced C Programming");
        arrayAdapter_subject=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_subject2);
        sp_subject.setAdapter(arrayAdapter_subject);

        arrayList_subject3=new ArrayList<>();
        arrayList_subject3.add("Data and File Structure");
        arrayList_subject3.add("Object Oriented Programming with C++");
        arrayAdapter_subject=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_subject3);
        sp_subject.setAdapter(arrayAdapter_subject);

        arrayList_subject4=new ArrayList<>();
        arrayList_subject4.add("Advance Operating System and Intro to Linux ");
        arrayList_subject4.add("Application Development Using Vb.Net");
        arrayAdapter_subject=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_subject4);
        sp_subject.setAdapter(arrayAdapter_subject);

        arrayList_subject5=new ArrayList<>();
        arrayList_subject5.add("Web Application Development Using Asp.Net");
        arrayList_subject5.add("RDBMS Using Oracle 1");
        arrayAdapter_subject=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_subject5);
        sp_subject.setAdapter(arrayAdapter_subject);

        arrayList_subject6=new ArrayList<>();
        arrayList_subject6.add("Core Java");
        arrayList_subject6.add("RDBMS Using Oracle-2");
        arrayAdapter_subject=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_subject6);
        sp_subject.setAdapter(arrayAdapter_subject);

        arrayList_sub1=new ArrayList<>();
        arrayList_sub1.add("Introduction of C Language ");
        arrayList_sub1.add("Open Office");
        arrayAdapter_sub=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_sub1);
        sp_subject.setAdapter(arrayAdapter_sub);

        arrayList_sub2=new ArrayList<>();
        arrayList_sub2.add("Advanced C Programming");
        arrayList_sub2.add("Internet and Web Technology");
        arrayAdapter_sub=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_sub2);
        sp_subject.setAdapter(arrayAdapter_sub);

        arrayList_sub3=new ArrayList<>();
        arrayList_sub3.add("DATA AND FILE STRUCTURE USING C");
        arrayList_sub3.add("PROGRAMMING IN C++");
        arrayAdapter_sub=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_sub3);
        sp_subject.setAdapter(arrayAdapter_sub);

        arrayList_sub4=new ArrayList<>();
        arrayList_sub4.add("WINDOW PROGRAMMING USING VB.NET");
        arrayList_sub4.add("DATABASE CONCEPT AND TOOLS ");
        arrayAdapter_sub=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_sub4);
        sp_subject.setAdapter(arrayAdapter_sub);

        arrayList_sub5=new ArrayList<>();
        arrayList_sub5.add("WEB PROGRAMMING-I Using PHP ");
        arrayList_sub5.add("ADVANCE DATABASE CONCEPT AND TOOLS");
        arrayAdapter_sub=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_sub5);
        sp_subject.setAdapter(arrayAdapter_sub);

        arrayList_sub6=new ArrayList<>();
        arrayList_sub6.add("WEB PROGRAMMING-II Using ASP.NET");
        arrayList_sub6.add("OOP USING JAVA");
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
                                        if(position==0) {
                                            course = "BCA";
                                            sem = "SEM-1";
                                            subject = "Introduction to Programming(C Lan)";
                                        }
                                        else if(position==1){
                                            course = "BCA";
                                            sem = "SEM-1";
                                            subject = "RDBMS-1";
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
                                        if(position==0) {
                                            course = "BCA";
                                            sem = "SEM-3";
                                            subject = "Web Designing";
                                        }
                                        else if(position==1){
                                            course = "BCA";
                                            sem = "SEM-2";
                                            subject = "Advanced C Programming";
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
                                        if(position==0) {
                                            course = "BCA";
                                            sem = "SEM-3";
                                            subject = "Data and File Structure";
                                        }
                                        else if(position==1){
                                            course = "BCA";
                                            sem = "SEM-3";
                                            subject = "Object Oriented Programming with C++";
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
                                        if(position==0) {
                                            course = "BCA";
                                            sem = "SEM-4";
                                            subject = "Application Development Using Vb.Net";
                                        }
                                        else if(position==1){
                                            course = "BCA";
                                            sem = "SEM-4";
                                            subject = "Web Application Development Using PHP";
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
                                        if(position==0) {
                                            course = "BCA";
                                            sem = "SEM-5";
                                            subject = "Web Application Development Using Asp.Net";
                                        }
                                        else if(position==1){
                                            course = "BCA";
                                            sem = "SEM-5";
                                            subject = "RDBMS Using Oracle 1";
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
                                        if(position==0) {
                                            course = "BCA";
                                            sem = "SEM-6";
                                            subject = "Core Java";
                                        }
                                        else if(position==1){
                                            course = "BCA";
                                            sem = "SEM-6";
                                            subject = "RDBMS Using Oracle-2";
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
                                        if (position == 0) {
                                            course = "BSC-IT";
                                            sem = "SEM-1";
                                            subject = "Introduction of C Language";
                                        } else if (position == 1) {
                                            course = "BSC-IT";
                                            sem = "SEM-1";
                                            subject = "Open Office";
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
                                        if (position == 0) {
                                            course = "BSC-IT";
                                            sem = "SEM-3";
                                            subject = "Advanced C Programming";
                                        } else if (position == 1) {
                                            course = "BSC-IT";
                                            sem = "SEM-2";
                                            subject = "Internet and Web Technology";
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
                                        if (position == 0) {
                                            course = "BSC-IT";
                                            sem = "SEM-3";
                                            subject = "Programming in c++";
                                        } else if (position == 1) {
                                            course = "BSC-IT";
                                            sem = "SEM-3";
                                            subject = "System Analysis And Design";
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
                                        if (position == 0) {
                                            course = "BSC-IT";
                                            sem = "SEM-4";
                                            subject = "DATABASE CONCEPT AND TOOLS ";
                                        } else if (position == 1) {
                                            course = "BSC-IT";
                                            sem = "SEM-4";
                                            subject = "COMPUTER NETWORK";
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
                                        if (position == 0) {
                                            course = "BSC-IT";
                                            sem = "SEM-5";
                                            subject = "ADVANCE DATABASE CONCEPT AND TOOLS ";
                                        } else if (position == 1) {
                                            course = "BSC-IT";
                                            sem = "SEM-5";
                                            subject = "SOFTWARE ENGINEERING ";
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
                                        if (position == 0) {
                                            course = "BSC-IT";
                                            sem = "SEM-6";
                                            subject = "Core Java";
                                        } else if (position == 1) {
                                            course = "BSC-IT";
                                            sem = "SEM-6";
                                            subject = "RDBMS Using Oracle-2";
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
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(student_journal_1.this, student_journal_2.class);
                i.putExtra("c",course);
                i.putExtra("sem",sem);
                i.putExtra("s",subject);
                startActivity(i);

                Toast.makeText(student_journal_1.this,course+"__"+sem+"__"+subject, Toast.LENGTH_SHORT).show();

            }
        });
    }
}