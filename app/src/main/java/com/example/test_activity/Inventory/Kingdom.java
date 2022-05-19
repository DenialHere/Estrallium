package com.example.test_activity.Inventory;

import com.example.test_activity.Skills.Player;

public class Kingdom {
    public static int Level = 1;
    public static int[] Requirements = {0, 0, 0, 0, 0};


    public static void getRequirements(){
        switch (Level) {
            case 1:
                Requirements = new int[]{3, 100, 0, 0, 0};
                break;
            case 2:
                Requirements = new int[]{5, 250, 0, 0, 0};
                break;
            case 3:
                Requirements = new int[]{7, 300, 150, 0, 0};
                break;
            case 4:
                Requirements = new int[]{9, 200, 400, 0, 0};
                break;
        }
    }

    public static void GetRewards(){
        switch (Level) {
            case 2:
                Workers.AmmountOfWorkers = Workers.AmmountOfWorkers + 2;
                break;
            case 3:
                Workers.AmmountOfWorkers = Workers.AmmountOfWorkers + 2;
                break;
            case 4:
                Workers.Modifier++;
                break;
            case 5:
                Workers.AmmountOfWorkers = Workers.AmmountOfWorkers + 2;
                Rare.Magic_Seeds = Rare.Magic_Seeds + 1;
                System.out.println(Integer.toString(Rare.Magic_Seeds));
                break;
        }
    }

    public static String GetRewardsText(){
        switch (Level) {
            case 1:
               return "+ 2 workers to work on your plots while your away!";
            case 2:
                return "+ 2 workers";
            case 3:
                return "Workers gain 1 more resource each time";
            case 4:
                return "+ 1 magic seed & + 1 worker";
            default:
                return "";
        }

    }

    public static void LevelUp(){
        //Updating requirements
        getRequirements();

        //Checking if player meets the requirements
        if (Player.Level >= Requirements[0]
            && Inventory.Log_Quantity >= Requirements[1]
            && Inventory.Stone_Quantity >= Requirements[2])
        {
            //Removing resources from player
            Inventory.Log_Quantity = Inventory.Log_Quantity - Requirements[1];
            Inventory.Stone_Quantity = Inventory.getStone_Quantity() - Requirements[2];

            //Leveling up kingdom
            Level = Level + 1;
            //Giving Level Rewards
            GetRewards();
            System.out.println("Kingdom Level " + Integer.toString(Level));
            //updating to new requirements
            getRequirements();
        }
        else {
            System.out.println("You don't meet the requirements");
        }
    }
}
