package com.example.voiceverification;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileSetiings extends AppCompatActivity {
    Button button1;
    Button buttonFAQ;
    Button buttonHelp;
    private Intent packageContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_setiings);

        button1 = findViewById(R.id.button7);
        Intent intent = getIntent();
        buttonFAQ = findViewById(R.id.buttonfaq);
        buttonHelp = findViewById(R.id.buttonhelp);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(ProfileSetiings.this, LogOut.class);
                startActivity(intent1);
            }
        });

        buttonFAQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(ProfileSetiings.this, FAQ.class);
                startActivity(intent1);
            }
        });

        buttonHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(ProfileSetiings.this, HelpActivity.class);
                startActivity(intent1);
            }
        });
    }

}