package com.example.bca_pocketbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class student_syllabus_2 extends AppCompatActivity {


    ListView listview;
    DatabaseReference databaseReference;
    String course,sem,subject;

    @NonNull
    @Override
    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        return super.getDefaultViewModelProviderFactory();
    }
    List<putPDF> uploadPDF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_syllabus_2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        course=getIntent().getExtras().getString("c");
        sem=getIntent().getExtras().getString("sem");
        subject=getIntent().getExtras().getString("s");
        Toast.makeText(this,course+"____"+sem+"_____"+subject, Toast.LENGTH_SHORT).show();

        listview=(ListView)findViewById(R.id.mylistview);
        uploadPDF=new ArrayList<>();
        retrievePDFFiles(course,sem,subject);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                putPDF putPDF=uploadPDF.get(position);
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setType("application/pdf");
                intent.setData(Uri.parse(putPDF.getUrl()));
                startActivity(intent);
            }
        });

    }

    private void retrievePDFFiles(String course,String sem,String subject) {
        databaseReference= FirebaseDatabase.getInstance().getReference("MyPDF").child("Syllabus").child(course).child(sem).child(subject);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds:snapshot.getChildren())
                {
                    putPDF putPDF=ds.getValue(com.example.bca_pocketbook.putPDF.class);
                    uploadPDF.add(putPDF);

                }
                String[] uploadsName=new String[uploadPDF.size()];
                for (int i=0;i<uploadsName.length;i++)
                {
                    uploadsName[i]=uploadPDF.get(i).getName();
                }
                ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,uploadsName)
                {
               /* @NonNull
                @Override
                public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                    View view=super.getView(position, convertView, parent);
                    TextView textView=(TextView)view.findViewById(R.id.text1);
                    textView.setTextColor(Color.BLACK);
                    textView.setTextSize(20);
                    return view;
                }*/
                };
                listview.setAdapter(arrayAdapter);
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}