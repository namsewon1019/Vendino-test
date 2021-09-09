package com.example.loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class SettingActivity extends AppCompatActivity {

    private Button MoveButton3;
    private Button MoveButton5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        Button MoveButton5 = (Button)findViewById(R.id.MoveButton5);
        MoveButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this, delete.class);
                startActivity(intent);
            }
        });

        Button MoveButton3 = (Button)findViewById(R.id.MoveButton3);
        MoveButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this, help.class);
                startActivity(intent);
            }
        });

    }
}