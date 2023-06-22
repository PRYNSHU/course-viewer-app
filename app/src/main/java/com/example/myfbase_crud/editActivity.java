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

public class editActivity extends AppCompatActivity {

//    private EditText coursename , courseprice , imglink , courselink , coursedesp , coursesuitefor;
//    private Button btnupdate , btndelete;
//    private ProgressBar pgbar;
//    private FirebaseDatabase fbasedata;
//    private DatabaseReference dataRef;
//    private String courseID;
//    private courseModal coursemodal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

//        coursename = findViewById(R.id.coursename);
//        courseprice = findViewById(R.id.courseprice);
//        coursesuitefor = findViewById(R.id.coursesuitedfor);
//        courselink = findViewById(R.id.courselink);
//        coursedesp = findViewById(R.id.coursedesp);
//        imglink = findViewById(R.id.imglink);
//        btnupdate = findViewById(R.id.btnUpdate);
//        btndelete = findViewById(R.id.btnDelete);
//        pgbar = findViewById(R.id.pgbar);
//
//        fbasedata = FirebaseDatabase.getInstance();
//
//        coursemodal = getIntent().getParcelableExtra("courses");
//        if(coursemodal!=null){
//            //here course details will be pre written in the edit section
//            coursename.setText(coursemodal.getCoursename());
//            courseprice.setText(coursemodal.getCourseprice());
//            coursedesp.setText(coursemodal.getCoursedesp());
//            courselink.setText(coursemodal.getCourselink());
//            imglink.setText(coursemodal.getImglink());
//            coursesuitefor.setText(coursemodal.getCoursesuite());
//            courseID = coursemodal.getCourseID();
//        }
//        dataRef = FirebaseDatabase.getInstance().getReference("Courses").child(courseID);
//
//        btnupdate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                pgbar.setVisibility(View.VISIBLE);
//                String courseName = coursename.getText().toString();
//                String coursePrice = courseprice.getText().toString();
//                String courseLink = courselink.getText().toString();
//                String imgLink = imglink.getText().toString();
//                String courseDesp = coursedesp.getText().toString();
//                String coursesuite = coursesuitefor.getText().toString();
//
//                //another approach to add data to DB (by map)
//                Map<String , Object> map = new HashMap<>();
//                map.put("coursename", courseName);
//                map.put("coursedesp", courseDesp);
//                map.put("courseprice", coursePrice);
//                map.put("courselink", courseLink);
//                map.put("coursesuite", coursesuite);
//                map.put("imglink", imgLink);
//                map.put("courseID" , courseID);
//
//                dataRef.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        pgbar.setVisibility(View.GONE);
//                        dataRef.updateChildren(map);
//                        Toast.makeText(editActivity.this, "course Updated", Toast.LENGTH_SHORT).show();
//                        startActivity(new Intent(editActivity.this , MainActivity.class));
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//                        Toast.makeText(editActivity.this, "Failed to Update", Toast.LENGTH_SHORT).show();
//                    }
//                });
//            }
//
//
//        });

        //delete section later

    }
}