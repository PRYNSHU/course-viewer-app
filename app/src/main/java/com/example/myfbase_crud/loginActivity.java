package com.example.myfbase_crud;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class loginActivity extends AppCompatActivity {
    private EditText username , pass;
    private Button btnlogin;
    private TextView loginTV;
    private ProgressBar pgbar;
    private FirebaseAuth mauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        pass = findViewById(R.id.pass);
        btnlogin = findViewById(R.id.btnlogin);
        pgbar = findViewById(R.id.pgbar);
        loginTV = findViewById(R.id.registerTV);
        mauth = FirebaseAuth.getInstance();

        loginTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(loginActivity.this , registrationActivity.class);
                startActivity(i);
            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pgbar.setVisibility(View.VISIBLE);
                String user = username.getText().toString();
                String Password = pass.getText().toString();

                if(user.equals("") || Password.equals("")){
                    pgbar.setVisibility(View.GONE);
                    Toast.makeText(loginActivity.this, "enter the credentials", Toast.LENGTH_SHORT).show();
                }else{
                    mauth.signInWithEmailAndPassword(user , Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                pgbar.setVisibility(View.GONE);
                                Toast.makeText(loginActivity.this, "login successfull", Toast.LENGTH_SHORT).show();
                                Intent i1 = new Intent(loginActivity.this , MainActivity.class);
                                startActivity(i1);
                                finish();
                            }else{
                                pgbar.setVisibility(View.GONE);
                                Toast.makeText(loginActivity.this, "failed to login", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

    }

    //show that when user again open the app, automatically shift to mainactivity
//    @Override
//    protected void onStart() {
//        super.onStart();
//        // in on start method checking if
//        // the user is already sign in.
//        FirebaseUser user = mauth.getCurrentUser();
//        if (user != null) {
//            // if the user is not null then we are
//            // opening a main activity on below line.
//            Intent i = new Intent(this, MainActivity.class);
//            startActivity(i);
//            this.finish();
//        }
//    }
}