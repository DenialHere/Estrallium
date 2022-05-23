package com.example.test_activity.Skills;

public class Player {
    public static int Level  = 1;
    public static int Experience = 0;
    private static double ExperienceLeft = 50;
    public static int Modifier = 1;

    public static void AddExperience()
    {
        Experience = Experience + Modifier;

        if (ExperienceLeft - Experience <= 0.999)
        {
            LevelUp();
        }

    }

        private static void LevelUp()
        {
            Level = Level + 1;
            System.out.println("Level up! You are now" + Level);
            ExperienceLeft = ExperienceLeft + CalculateExperienceMultiplier(Level);
            Experience = 0;
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


