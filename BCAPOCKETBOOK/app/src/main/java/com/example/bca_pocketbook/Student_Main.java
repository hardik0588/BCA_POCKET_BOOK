package com.example.bca_pocketbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.provider.DocumentsProvider;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

import org.w3c.dom.Document;

import java.net.URL;

public class Student_Main extends AppCompatActivity implements View.OnClickListener {
    TextView textView;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase database;
    FirebaseStorage storage;
    private DatabaseReference userRef;


    public CardView cardMaterial, cardHomework, cardOldPaper, cardJournal, cardSyllabus, cardNotice;
//    private DrawerLayout drawerLayout;
//    private ActionBarDrawerToggle toggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__main);


//        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout1);
//        NavigationView navigationView = findViewById(R.id.navigationview1);
        firebaseAuth=FirebaseAuth.getInstance();
        textView = findViewById(R.id.tvName);

       /* setSupportActionBar(toolbar);*/
        /*toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();*/


//        navigationView.setCheckedItem(R.id.home_icon);
//
//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            Fragment fragment;
         /*   @Override

            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               switch (item.getItemId())
               {
                   case R.id.home_icon:
                       fragment=new homefragment();
                       break;
                   case R.id.logout_icon:
                       logout();
                        break;
               }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragement_container,fragment).commit();
               drawerLayout.closeDrawer(GravityCompat.START);
                return false;
            }

            private void logout() {
                startActivity(new Intent(getApplicationContext(), Register.class));
                firebaseAuth.signOut();
                finish();
            }

        });*/


      cardMaterial = (CardView) findViewById(R.id.cardMaterial);
        cardOldPaper = (CardView) findViewById(R.id.cardOldPaper);
        cardSyllabus = (CardView) findViewById(R.id.cardSyllabus);
        cardHomework = (CardView) findViewById(R.id.cardHomework);
        cardJournal = (CardView) findViewById(R.id.cardJournal);
        cardNotice = (CardView) findViewById(R.id.cardNotice);

        cardMaterial.setOnClickListener(this);
        cardHomework.setOnClickListener(this);
        cardOldPaper.setOnClickListener(this);
        cardJournal.setOnClickListener(this);
        cardNotice.setOnClickListener(this);
        cardSyllabus.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()){

            case R.id.cardMaterial:
                i=new Intent(this,Student_material_1.class);
                startActivity(i);
                break;
            case R.id.cardHomework:
                i=new Intent(this,student_homework_1.class);
                startActivity(i);
                break;
            case R.id.cardNotice:
                i=new Intent(this, student_notice_1.class);
                startActivity(i);
                break;
            case R.id.cardSyllabus:
                i=new Intent(this,student_syllabus_1.class);
                startActivity(i);
                break;
            case R.id.cardOldPaper:
                i=new Intent(this,student_oldPaper_1.class);
                startActivity(i);
                break;
            case R.id.cardJournal:
                i=new Intent(this, student_journal_1.class);
                startActivity(i);
                break;


        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

 @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.home_icon:
                return true;
            case R.id.rateUs:
                Uri uri= Uri.parse("http:play.google.com/store/apps/details?id="+getApplicationContext().getPackageName());
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                try {
                    startActivity(intent);
                }
                catch (Exception e){
                    Toast.makeText(this,"Unable to open"+e.getMessage() ,Toast.LENGTH_SHORT).show();
                }
                return true;
               /* Intent intent=new Intent(this,rating.class);
                startActivity(intent);
                return true;*/
            case R.id.share:
                try{
                Intent i=new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_SUBJECT,"BCA Pocket Book");
                i.putExtra(Intent.EXTRA_TEXT,"https://play.google.com/store/apps/details?id="+getApplicationContext().getPackageName());
                startActivity(Intent.createChooser(i,"Share with"));
                }
                catch (Exception e)
                {
                    Toast.makeText(this,"Unable to Share this App",Toast.LENGTH_SHORT).show();
                }
                return true;
            case R.id.logout_icon:
                logout();
                return true;

            default:
                return super.onOptionsItemSelected(item);


        }
    }



    private void logout() {
        startActivity(new Intent(getApplicationContext(), Register.class));
        firebaseAuth.signOut();
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user=firebaseAuth.getCurrentUser();
        if(user==null)
        {
            Intent i=new Intent(Student_Main.this,Login.class);
            startActivity(i);
            finish();
        }

    }
}