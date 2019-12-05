package com.example.rainwaterapp;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ControlActivity extends AppCompatActivity {

    private FloatingActionButton RL;
    FloatingActionButton RR;
    ToggleButton ON;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);



        RL = (FloatingActionButton)findViewById(R.id.floatingActionButton);
        RR = findViewById(R.id.floatingActionButton2);
        ON = findViewById(R.id.toggleButton2);

        //FirebaseDatabase database = FirebaseDatabase.getInstance();
        //FirebaseApp.initializeApp(this);
        final DatabaseReference myRef = FirebaseDatabase.getInstance().getReference().child("rotate");

        RR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.setValue("-1");
            }
        });
        RL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.setValue("1");
            }
        });
        ON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.setValue("0");
            }
        });

    }
}
