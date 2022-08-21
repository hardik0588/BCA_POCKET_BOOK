package com.example.bca_pocketbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.Navigation;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
/*private DrawerLayout drawerLayout;
private ActionBarDrawerToggle toggle;
private NavigationView navigationView;*/
androidx.appcompat.widget.Toolbar toolbar;

    FirebaseAuth firebaseAuth;

    public CardView cardMaterial,cardHomework,cardOldPaper,cardJournal,cardSyllabus,cardNotice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      /*  getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/

       /* setSupportActionBar(toolbar);*/
       /* drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
       navigationView=findViewById(R.id.navigationview);*/
        toolbar=findViewById(R.id.toolbarr);


      /*  toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();*/

        cardMaterial = (CardView) findViewById(R.id.cardMaterial);
        cardHomework = (CardView) findViewById(R.id.cardHomework);
        cardOldPaper = (CardView) findViewById(R.id.cardOldPaper);
        cardJournal = (CardView) findViewById(R.id.cardJournal);
        cardSyllabus = (CardView) findViewById(R.id.cardSyllabus);
        cardNotice = (CardView) findViewById(R.id.cardNotice);


        cardMaterial.setOnClickListener(this);
        cardHomework.setOnClickListener(this);
        cardOldPaper.setOnClickListener(this);
        cardJournal.setOnClickListener(this);
        cardSyllabus.setOnClickListener(this);
        cardNotice.setOnClickListener(this);
    }
  /*  @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(toggle.onOptionsItemSelected(item)){
            return true;
        }
            return super.onOptionsItemSelected(item);
    }*/



    @Override
    public void onClick(View v) {

        Intent i;
        switch (v.getId()){

            case R.id.cardMaterial:
                i=new Intent(this,Admin_Material.class);
                startActivity(i);
                break;
            case R.id.cardHomework:
                i=new Intent(this,Admin_Homework.class);
                startActivity(i);
                break;
            case R.id.cardNotice:
                i=new Intent(this, Admin_Notice.class);
                startActivity(i);
                break;
            case R.id.cardSyllabus:
                i=new Intent(this,Admin_Syllabus.class);
                startActivity(i);
                break;
            case R.id.cardOldPaper:
                i=new Intent(this,Admin_OldPaper.class);
                startActivity(i);
                break;
            case R.id.cardJournal:
                i=new Intent(this, Admin_Journal.class);
                startActivity(i);
                break;


        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.admin_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {

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
}
