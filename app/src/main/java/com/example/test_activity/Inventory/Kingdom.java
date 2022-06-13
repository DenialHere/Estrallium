package com.example.test_activity.Inventory;

import android.app.Activity;
import android.view.Gravity;

import com.example.test_activity.Managers.DialogueManager;
import com.example.test_activity.Managers.SoundPlayer;
import com.example.test_activity.R;
import com.example.test_activity.Skills.Player;

public class Kingdom {
    public static int Level = 1;     // LV W  S  FI L  WH
    public static int[] Requirements = {0, 0, 0, 0, 0, 0};
    public static double Favour = 0;


    public static void getRequirements(){
        switch (Level) {
            case 1:
                Requirements = new int[]{2, 50, 0, 0, 0, 0};
                break;
            case 2:
                Requirements = new int[]{4, 100, 0, 0, 0, 0};
                break;
            case 3:
                Requirements = new int[]{6, 200, 50, 0, 0, 0};
                break;
            case 4:
                Requirements = new int[]{8, 150, 100, 0, 0, 0};
                break;
            case 5:
                Requirements = new int[]{10, 100, 200, 0, 0, 0};
                break;
            case 6:
                Requirements = new int[]{12, 0, 0, 100, 0, 0};
                break;
            case 7:
                Requirements = new int[]{15, 300, 300, 300, 0, 0};
                break;
            case 8:
                Requirements = new int[]{20, 200, 200, 400, 1, 0};
                break;
            case 9:
                Requirements = new int[]{23, 500, 100, 200, 2, 10};
                break;
            case 10:
                Requirements = new int[]{23, 0, 500, 800, 3, 30};
                break;
            default:
                Requirements = new int[]{0, 0, 0, 0, 0, 0, 0};
                break;
        }
    }

    public static void GetRewards(){
        switch (Level) {
            case 2:
                Inventory.Gold = Inventory.Gold + 50;
                break;
            case 3:
                Workers.workerUnassigned = Workers.workerUnassigned + 3;
                Inventory.Gold = Inventory.Gold + 75;
                break;
            case 4:
                Workers.Modifier++;
                break;
            case 5:
                Rare.Magic_Seeds++;
                Workers.workerUnassigned++;
                break;
            case 6:
                Rare.Gem++;
                Inventory.Gold = Inventory.Gold + 100;
                break;
            case 7:
                Workers.workerUnassigned = Workers.workerUnassigned + 2;
                Shop.LogBuyPrice--;
                break;
            case 8:
                Rare.Gem++;
                Rare.Magic_Seeds++;
                Inventory.Gold = Inventory.Gold + 150;
                break;
            case 9:
                Rare.RainbowFish++;
                Workers.workerUnassigned = Workers.workerUnassigned + 2;
                Inventory.Gold = Inventory.Gold + 150;
                break;
            case 10:
                Workers.workerUnassigned = Workers.workerUnassigned + 3;
                Shop.LogSellPrice++;
                break;
            case 11:
                Workers.Modifier++;
                Workers.workerUnassigned = Workers.workerUnassigned + 1;
                Inventory.Gold = Inventory.Gold + 500;
                break;
            default:
                break;
        }
    }

    public static String GetRewardsText(){
        switch (Level) {
            case 1:
               return "50 gold";
            case 2:
                return "+ 3 workers + 75 gold";
            case 3:
                return "Workers gain 1 more resource each time";
            case 4:
                return "+ 1 magic seed & + 1 worker";
            case 5:
                return "+ 1 Gem & 100 gold";
            case 6:
                return "+ 2 workers & wood cost less in the shop";
            case 7:
                return "+ 1 Magic seed & + 1 Gem + 150 gold";
            case 8:
                return "+ 1 Rainbow fish & + 1 worker + 200 gold";
            case 9:
                return "+ 3 Worker & wood sells for more in the shop";
            case 10:
                return "Workers gain 1 more resource each time & + 500 gold & + 1 worker";
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
            && Inventory.Stone_Quantity >= Requirements[2]
            && Inventory.Fish_Quantity >= Requirements[3]
            && Refinery.Lumber >= Requirements[4]
            && Inventory.Wheat_Quantity >= Requirements[5]
        )
        {
            //Removing resources from player
            Inventory.Log_Quantity = Inventory.Log_Quantity - Requirements[1];
            Inventory.Stone_Quantity = Inventory.getStone_Quantity() - Requirements[2];
            Inventory.Fish_Quantity = Inventory.Fish_Quantity - Requirements[3];
            Refinery.Lumber = Refinery.Lumber - Requirements[4];
            Inventory.Wheat_Quantity = Inventory.Wheat_Quantity - Requirements[5];

            //Play sound
            SoundPlayer levelUpSound = new SoundPlayer();
            levelUpSound.Play(activity, R.raw.kingdom_levelup, Player.SoundIsMuted);

            //Leveling up kingdom
            Level = Level + 1;
            //Giving Level Rewards
            GetRewards();
            //updating to new requirements
            getRequirements();
        }
        else {
            DialogueManager.ShowMessage(activity, "You don't have the required resources or level", R.drawable.castle, Gravity.CENTER);
        }
    }
}
