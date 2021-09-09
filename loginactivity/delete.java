package com.example.loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class delete extends AppCompatActivity {

    private Button deleteButton;
    private FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        Button deleteButton = (Button)findViewById(R.id.deleteButton);
        mFirebaseAuth = FirebaseAuth.getInstance();
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFirebaseAuth.getCurrentUser().delete();
                Intent intent = new Intent(delete.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}