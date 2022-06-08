package com.example.test_activity.Skills;

import android.app.Activity;
import android.view.Gravity;

import com.example.test_activity.Managers.DialogueManager;
import com.example.test_activity.Managers.SoundPlayer;
import com.example.test_activity.R;

public class Farming {

    public static int Level = 1;
    public static int Experience = 0;
    public static double ExperienceLeft = 5;
    public static boolean IsFarming = false;
    public static int Modifier = 1;
    public static String NAME = "Farming";
    public static int Time = 30000;

    public static void AddExperience(Activity activity)
    {
        Experience = Experience + Modifier + 4;

        if (ExperienceLeft - Experience <= 0.999)
        {
            LevelUp(activity);
        }

    }

    private static void LevelUp(Activity activity)
    {
        Level = Level + 1;
        ExperienceLeft = ExperienceLeft + CalculateExperienceMultiplier(Level);
        Experience = 0;
        SoundPlayer levelUpSound = new SoundPlayer();
        levelUpSound.Play(activity, R.raw.level_up_sound, Player.SoundIsMuted);
        DialogueManager.Show(activity, NAME, R.drawable.grain, Level, Gravity.BOTTOM, DialogueManager.LEVELUP);
    }


    private static double CalculateExperienceMultiplier(int level) {
        if (level < 10) {
            return 1.25;
        } else if (level < 20) {
            return 1.2;
        } else if (level < 30) {
            return 1.1;
        } else if (level < 40) {
            return 1.05;
        } else if (level < 50) {
            return 1.04;
        } else if (level < 60) {
            return 1.04;
        } else if (level < 70) {
            return 1.03;
        } else if (level < 80) {
            return 1.02;
        } else {
            return 1.1;
        }
    }


}
