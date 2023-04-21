package com.example.voiceverification;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

public class Settings extends AppCompatActivity {
    private Intent packageContext;
    Button profilesettings;
    Switch useCrowdSourcingSwitch;
    boolean crowd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        profilesettings = findViewById(R.id.settingsbutton);
        useCrowdSourcingSwitch = findViewById(R.id.UseCrowdSourcingSwitch);

        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor e = settings.edit();
        e.putBoolean("switch", useCrowdSourcingSwitch.isChecked());
        e.commit();

        Intent intent = getIntent();

        crowd = useCrowdSourcingSwitch.isChecked();

        useCrowdSourcingSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor e = settings.edit();
                e.putBoolean("switch", useCrowdSourcingSwitch.isChecked());
                e.commit();
            }
        });

        profilesettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Settings.this, ProfileSetiings.class);
                startActivity(intent1);
            }
        });
    }

}