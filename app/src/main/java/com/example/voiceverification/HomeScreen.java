package com.example.voiceverification;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeScreen extends AppCompatActivity {
    SearchView searchView;
    Button categoryOne;
    Button categoryTwo;
    Button categoryThree;
    Button categoryFour;
    private Intent packageContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);
        Button categoryOne = findViewById(R.id.button);
        Button categoryTwo = findViewById(R.id.button2);
        Button categoryThree = findViewById(R.id.button3);
        Button categoryFour = findViewById(R.id.button4);
        categoryOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(HomeScreen.this, AssistantActivity.class);
                startActivity(intent1);
            }
        });
        categoryTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(HomeScreen.this, AssistantActivity.class);
                startActivity(intent2);
            }
        });
        categoryThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(HomeScreen.this, AssistantActivity.class);
                startActivity(intent3);
            }
        });
        categoryFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(HomeScreen.this, AssistantActivity.class);
                startActivity(intent4);
            }
        });
        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentSearch = new Intent(HomeScreen.this, AssistantActivity.class);
                startActivity(intentSearch);
            }
        });


    }
}
