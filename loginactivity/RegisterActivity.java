package com.example.loginactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth mFirebaseAuth;
    private DatabaseReference mDatabaseRef;
    private EditText mEtemail, mEtpwd;
    private Button mBtnregister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Vendino");

        mEtemail = findViewById(R.id.et_email);
        mEtpwd = findViewById(R.id.et_pwd);
        mBtnregister = findViewById(R.id.btn_register);

        mBtnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strEmail = mEtemail.getText().toString();
                String strpwd = mEtpwd.getText().toString();

                mFirebaseAuth.createUserWithEmailAndPassword(strEmail, strpwd).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            FirebaseUser firebaseUser = mFirebaseAuth.getCurrentUser();
                            user user = new user();
                            user.setIdToken(firebaseUser.getUid());
                            user.setEmailId(firebaseUser.getEmail());
                            user.setPassword(strpwd);

                            mDatabaseRef.child("user").child(firebaseUser.getUid()).setValue(user);
                            Toast.makeText(RegisterActivity.this,"회원가입에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(RegisterActivity.this,"회원가입에 실패하셨습니다", Toast.LENGTH_SHORT).show();
                        }


                    }
                });
            }
        });


    }
}