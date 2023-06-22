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

public class registrationActivity extends AppCompatActivity {

    private EditText username , pass , cnfpass;
    private TextView loginTV;
    private ProgressBar pgbar;
    private Button btnreg;
    private FirebaseAuth mauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        username = findViewById(R.id.username);
        pass = findViewById(R.id.pass);
        cnfpass = findViewById(R.id.cnfpass);
        loginTV = findViewById(R.id.loginTV);
        pgbar = findViewById(R.id.pgbar);
        btnreg = findViewById(R.id.btnRegister);

        mauth = FirebaseAuth.getInstance();

        //intents
        Intent i = new Intent(registrationActivity.this , loginActivity.class);

        loginTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);
            }
        });

        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pgbar.setVisibility(View.VISIBLE);
                String user = username.getText().toString();
                String Password = pass.getText().toString();
                String CnfPassword = cnfpass.getText().toString();

                if(!Password.equals(CnfPassword)){
                    Toast.makeText(registrationActivity.this, "password doesn't match", Toast.LENGTH_SHORT).show();

                } else if (user.equals("") || Password.equals("")) {
                    Toast.makeText(registrationActivity.this, "Enter the credentials", Toast.LENGTH_SHORT).show();

                }else {
                    //firebase work
                    mauth.createUserWithEmailAndPassword(user , Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                pgbar.setVisibility(View.GONE);
                                Toast.makeText(registrationActivity.this, "successfully registered", Toast.LENGTH_SHORT).show();
                                startActivity(i);
                                finish(); // to closed the register activity
                            }else{
                                pgbar.setVisibility(View.GONE);
                                Toast.makeText(registrationActivity.this, "failed to registered", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });


                }

            }
        });

    }
}