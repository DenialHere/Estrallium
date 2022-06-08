package com.example.test_activity.Activities;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test_activity.R;
import com.example.test_activity.Skills.Player;

public class SettingsActivity extends AppCompatActivity {
    CheckBox muteSounds, muteMusic, hidePlayerLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        muteSounds = findViewById(R.id.checkBoxSounds);
        muteMusic = findViewById(R.id.checkBoxMusic);
        hidePlayerLevel = findViewById(R.id.checkBoxPlayer);

        if (Player.SoundIsMuted == true){
            muteSounds.toggle();
        }
        if (Player.MusicIsMuted == true){
            muteMusic.toggle();
        }
        if (Player.HidePlayerLevelMessages == true){
            hidePlayerLevel.toggle();
        }

        muteSounds.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if (isChecked)
                {
                    Player.SoundIsMuted = false;
                }
                else {
                    Player.SoundIsMuted = true;
                }

            }
        });

        muteMusic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if (isChecked)
                {
                    Player.MusicIsMuted = false;
                }
                else {
                    Player.MusicIsMuted = true;
                }

            }
        });

        hidePlayerLevel.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if (isChecked)
                {
                    Player.HidePlayerLevelMessages = false;
                }
                else {
                    Player.HidePlayerLevelMessages = true;
                }

            }
        });

    }




}