package com.example.test_activity.Inventory;

import android.app.Activity;

import com.example.test_activity.Managers.SaveManager;
import com.example.test_activity.Skills.Fishing;
import com.example.test_activity.Skills.Mining;
import com.example.test_activity.Skills.Woodcutting;

import java.lang.reflect.Modifier;
import java.util.Random;

public class Inventory {

    public static int Log_Quantity = 0, Stone_Quantity = 0, Fish_Quantity = 0, Wheat_Quantity = 0;
    private static int Multiplier = 1;

    public static final int WOOD = 1;
    public static final int STONE = 2;
    public static final int FISH = 3;
    public static final int WHEAT = 4;

    public static void AddResource(int i, Activity activity){
        Random rand = new Random();
        switch (i) {
            case WOOD:
                Rare.checkForRareDrop(WOOD, activity);
                Woodcutting.AddExperience(activity);
                if (rand.nextInt(101 - Woodcutting.Level) == 0) {
                    Multiplier = 2;
                    System.out.println("MEGA HIT");
                }
                else {
                    Multiplier = 1;
                }
                Log_Quantity = Log_Quantity + (Rare.Magic_Seeds + 1 * Multiplier);
                break;
            case STONE:
                Rare.checkForRareDrop(STONE, activity);
                Mining.AddExperience();
                if (rand.nextInt(101 - Mining.Level) == 0) {
                    Multiplier = 2;
                    System.out.println("MEGA HIT");
                }
                else {
                    Multiplier = 1;
                }
                Stone_Quantity = Stone_Quantity + (Rare.Gem + 1 * Multiplier);
                break;
            case FISH:
                Rare.checkForRareDrop(FISH, activity);
                Fishing.AddExperience();
                if (rand.nextInt(101 - Fishing.Level) == 0) {
                    Multiplier = 2;
                    System.out.println("MEGA HIT");
                }
                else {
                    Multiplier = 1;
                }
                Fish_Quantity = Fish_Quantity + (Rare.RainbowFish + 1 * Multiplier);
                break;
            case WHEAT:
                Multiplier = 1 + Rare.getGiant_Wheat_Seeds();
                Wheat_Quantity = Wheat_Quantity + Multiplier;
                System.out.println("testingwheat");
                break;
        }
    }

    public static int getMultiplier() {
        return Multiplier;
    }

    public static void setMultiplier(int multiplier) {
        Multiplier = multiplier;
    }

    public static int getLog_Quantity() {
        return Log_Quantity;
    }

    public static void setLog_Quantity(int log_Quantity) {
        Log_Quantity = log_Quantity;
    }

    public static int getStone_Quantity() {
        return Stone_Quantity;
    }

    public static void setStone_Quantity(int stone_Quantity) {
        Stone_Quantity = stone_Quantity;
    }

    public static int getFish_Quantity() {
        return Fish_Quantity;
    }

    public static void setFish_Quantity(int fish_Quantity) { Fish_Quantity = fish_Quantity; }

    public static int getWheat_Quantity() {
        return Wheat_Quantity;
    }

    public static void setWheat_Quantity(int wheat_Quantity) {
        Wheat_Quantity = wheat_Quantity;
    }
}
