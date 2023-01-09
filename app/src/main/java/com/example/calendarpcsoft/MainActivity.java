package com.example.calendarpcsoft;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.CompoundButton;

import com.google.android.material.switchmaterial.SwitchMaterial;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize the Switch
        SwitchMaterial themeSwitch = findViewById(R.id.themeSwitch);

        //switch theme when user wishes
        themeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    compoundButton.setText(getResources().getString(R.string.dark_theme));
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    compoundButton.setText(getResources().getString(R.string.light_theme));
                }
            }
        });


        //is night mode is on by Default
        int currentNightMode = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        boolean nightMode = currentNightMode == Configuration.UI_MODE_NIGHT_YES;
        themeSwitch.setChecked(nightMode);

        if (nightMode) {
            themeSwitch.setText(getResources().getString(R.string.dark_theme));
        }
    }
}