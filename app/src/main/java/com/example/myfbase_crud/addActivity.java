package com.example.myfbase_crud;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class addActivity extends AppCompatActivity {

    private EditText coursename , courseprice , imglink , courselink , coursedesp , coursesuitefor;
    private Button btnaddcourse;
    private ProgressBar pgbar;
    private FirebaseDatabase fbasedata; //variable created
    private DatabaseReference dataRef; //variable created
    private String courseID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud);

        coursename = findViewById(R.id.coursename);
        courseprice = findViewById(R.id.courseprice);
        coursesuitefor = findViewById(R.id.coursesuitedfor);
        courselink = findViewById(R.id.courselink);
        coursedesp = findViewById(R.id.coursedesp);
        imglink = findViewById(R.id.imglink);
        btnaddcourse = findViewById(R.id.btnaddcourse);
        pgbar = findViewById(R.id.pgbar);

        fbasedata = FirebaseDatabase.getInstance(); //getInstance() -> entry point to access fb-db.
        dataRef = FirebaseDatabase.getInstance().getReference("development"); //getReference -> help to read and write the fb db.

        btnaddcourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pgbar.setVisibility(View.VISIBLE);
                String courseName = coursename.getText().toString();
                String coursePrice = courseprice.getText().toString();
                String courseLink = courselink.getText().toString();
                String imgLink = imglink.getText().toString();
                String courseDesp = coursedesp.getText().toString();
                String coursesuite = coursesuitefor.getText().toString();
                String courseID = courseName;

                courseModal coursemodal = new courseModal(courseName , courseDesp , coursePrice , coursesuite , imgLink , courseLink ,courseID);

                dataRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        pgbar.setVisibility(View.GONE);
                        //add data to firebase
                        dataRef.setValue(coursemodal);
//                        dataRef.setValue("good morning"); //not a good thing
                        Toast.makeText(addActivity.this, "course Added", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(addActivity.this , MainActivity.class));
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        pgbar.setVisibility(View.GONE);
                        Toast.makeText(addActivity.this, "failed to add", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }
}