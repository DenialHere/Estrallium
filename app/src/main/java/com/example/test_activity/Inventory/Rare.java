package com.example.test_activity.Inventory;

import android.app.Activity;
import android.view.Gravity;

import com.example.test_activity.Managers.DialogueManager;
import com.example.test_activity.Managers.SoundPlayer;
import com.example.test_activity.R;
import com.example.test_activity.Skills.Player;
import com.example.test_activity.Skills.Woodcutting;

import java.util.Random;

public class Rare {

    public static int Base_Rare_Drop_Chance = 48;
    public static int Magic_Seeds = 0;
    public static int Gem = 0;
    public static int RainbowFish = 0;
    public static int Giant_Wheat_Seeds = 0;


    public static void checkForRareDrop(int plot, Activity activity) {
        Random rand = new Random();
        SoundPlayer rareSound = new SoundPlayer();
       switch (plot) {
           case Inventory.WOOD:
               if (rand.nextInt(Base_Rare_Drop_Chance * (1 + Magic_Seeds)) == 0){
                   Magic_Seeds = Magic_Seeds + 1;
                   DialogueManager.Show(activity, "Magic seed", R.drawable.magicseed, 1, Gravity.CENTER, DialogueManager.RAREITEM);
                   rareSound.Play(activity, R.raw.found_item, Player.isMuted);
               }
               break;
           case Inventory.STONE:
               if (rand.nextInt(Base_Rare_Drop_Chance * (1 + Gem)) == 0){
                   Gem = Gem + 1;
                   DialogueManager.Show(activity, "Gem", R.drawable.gem, 1, Gravity.CENTER, DialogueManager.RAREITEM);
                   rareSound.Play(activity, R.raw.found_item, Player.isMuted);
               }
               break;
           case Inventory.FISH:
               if (rand.nextInt(Base_Rare_Drop_Chance * (1 + RainbowFish)) == 0){
                   RainbowFish = RainbowFish + 1;
                   DialogueManager.Show(activity, "Rainbow fish", R.drawable.rainbow_fish, 1, Gravity.CENTER, DialogueManager.RAREITEM);
                   rareSound.Play(activity, R.raw.found_item, Player.isMuted);
               }
               break;

       }

    }
    public static int getMagic_Seeds() {
        return Magic_Seeds;
    }



    public static int getGiant_Wheat_Seeds() {
        return Giant_Wheat_Seeds;
    }
}
