package com.example.test_activity.Skills;

import android.app.Activity;
import android.view.Gravity;

import com.example.test_activity.Managers.DialogueManager;
import com.example.test_activity.Managers.SoundPlayer;
import com.example.test_activity.R;

public class Player {
    public static int Level  = 1;
    public static int Experience = 0;
    private static double ExperienceLeft = 40;
    public static int Modifier = 1;
    public static String NAME = "You";
    public static int CurrentPlot = 1;

    //TODO: FIND A BETTER SPOT TO PUT THIS
    public static boolean isMuted = false;

    public static void AddExperience(Activity activity)
    {
        Experience = Experience + Modifier;

        if (ExperienceLeft - Experience <= 0.999)
        {
            LevelUp(activity);
        }

    }

        private static void LevelUp(Activity activity)
        {
            SoundPlayer levelUpSound = new SoundPlayer();
            levelUpSound.Play(activity, R.raw.player_level_up, Player.isMuted);
            Level = Level + 1;
            ExperienceLeft = ExperienceLeft + CalculateExperienceMultiplier(Level);
            Experience = 0;
            DialogueManager.Show(activity, Player.NAME, R.drawable.player, Level, Gravity.BOTTOM, DialogueManager.LEVELUP);
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


