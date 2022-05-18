package com.example.test_activity.Activities;

public class Kingdom {

    static int Kingdom_Level = 1;

    public static void LevelUpKingdom(){

        Kingdom_Level = Kingdom_Level + 1;
        Workers.workerUnassigned = Workers.workerUnassigned + 3;

    }
}
