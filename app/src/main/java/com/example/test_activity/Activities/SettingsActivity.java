package com.example.test_activity.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test_activity.R;
import com.example.test_activity.Skills.Player;
import com.example.test_activity.Tasks;

public class SettingsActivity extends AppCompatActivity {
    CheckBox muteSounds, muteMusic, hidePlayerLevel, hideSkillLevel;

    @Override
    public void onBackPressed() {
        Tasks.IsEnabled = true;
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        muteSounds = findViewById(R.id.checkBoxSounds);
        muteMusic = findViewById(R.id.checkBoxMusic);
        hidePlayerLevel = findViewById(R.id.checkBoxPlayer);
        hideSkillLevel = findViewById(R.id.checkBoxSoundsSkill);

        if (Player.SoundIsMuted == true){
            muteSounds.toggle();
        }
        if (Player.MusicIsMuted == true){
            muteMusic.toggle();
        }
        if (Player.HidePlayerLevelMessages == true){
            hidePlayerLevel.toggle();
        }
        if (Player.HideSkillLevelMessages == true){
            hideSkillLevel.toggle();
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

        hideSkillLevel.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if (isChecked)
                {
                    Player.HideSkillLevelMessages = false;
                }
                else {
                    Player.HideSkillLevelMessages = true;
                }

            }
        });

    }

    public void BackButton(View view){
        finish();
    }


}