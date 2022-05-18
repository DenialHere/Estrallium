package com.example.test_activity.Skills;

public class Farming {

    private static int Base = 10;
    private static int Level = 1;
    private static int Experience = 0;
    private static int Max_Level = 100;

    public static void AddExp() {
        int Next_Level_Experience_Checkpoint = Base * (Level * 2);
        Experience = Experience + 1;
        if (Experience >= Next_Level_Experience_Checkpoint) {
            Level = Level + 1;
            Experience = 0;
        }

    }
    public static int getLevel() {
        return Level;
    }

    public static void setLevel(int level) {
        Level = level;
    }

    public static int getExperience() {
        return Experience;
    }

    public static void setExperience(int experience) {
        Experience = experience;
    }
    public static int getMax_Level() {
        return Max_Level;
    }

    public static void setMax_Level(int max_Level) {
        Max_Level = max_Level;
    }

}
