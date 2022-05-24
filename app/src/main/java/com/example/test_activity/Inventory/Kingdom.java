package com.example.test_activity.Inventory;

import android.app.Activity;
import android.view.Gravity;

import com.example.test_activity.Managers.DialogueManager;
import com.example.test_activity.Managers.SoundPlayer;
import com.example.test_activity.R;
import com.example.test_activity.Skills.Player;

public class Kingdom {
    public static int Level = 1;
    public static int[] Requirements = {0, 0, 0, 0, 0};


    public static void getRequirements(){
        switch (Level) {
            case 1:
                Requirements = new int[]{2, 50, 0, 0, 0};
                break;
            case 2:
                Requirements = new int[]{4, 100, 0, 0, 0};
                break;
            case 3:
                Requirements = new int[]{6, 200, 50, 0, 0};
                break;
            case 4:
                Requirements = new int[]{8, 150, 100, 0, 0};
                break;
            case 5:
                Requirements = new int[]{10, 100, 200, 0, 0};
                break;
            case 6:
                Requirements = new int[]{12, 0, 0, 100, 0};
                break;
            default:
                Requirements = new int[]{0, 0, 0, 0, 0};
                break;
        }
    }

    public static void GetRewards(){
        switch (Level) {
            case 2:
                Workers.workerUnassigned = Workers.workerUnassigned + 1;
                break;
            case 3:
                Workers.workerUnassigned = Workers.workerUnassigned + 2;
                break;
            case 4:
                Workers.Modifier++;
                break;
            case 5:
                Rare.Gem = Rare.Gem + 1;
            case 6:
                Workers.workerUnassigned = Workers.workerUnassigned + 2;
                break;
            default:
                break;
        }
    }

    public static String GetRewardsText(){
        switch (Level) {
            case 1:
               return "+ 1 workers to work on your plots while your away!";
            case 2:
                return "+ 2 workers";
            case 3:
                return "Workers gain 1 more resource each time";
            case 4:
                return "+ 1 magic seed & + 1 worker";
            case 5:
                return "+ 1 Gem";
            case 6:
                return "+ 2 workers";
            default:
                return "You got all kingdom upgrades!";
        }

    }

    public static void LevelUp(Activity activity){
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

            //Play sound
            SoundPlayer levelUpSound = new SoundPlayer();
            levelUpSound.Play(activity, R.raw.kingdom_levelup, Player.isMuted);

            //Leveling up kingdom
            Level = Level + 1;
            //Giving Level Rewards
            GetRewards();
            System.out.println("Kingdom Level " + Integer.toString(Level));
            //updating to new requirements
            getRequirements();
        }
        else {
            DialogueManager.ShowMessage(activity, "You don't have the required resources", R.drawable.castle, Gravity.CENTER);
        }
    }
}
