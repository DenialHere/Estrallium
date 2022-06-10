package com.example.test_activity.Managers;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.test_activity.Inventory.Inventory;
import com.example.test_activity.Inventory.Kingdom;
import com.example.test_activity.Inventory.Rare;
import com.example.test_activity.Inventory.Refinery;
import com.example.test_activity.Inventory.Workers;
import com.example.test_activity.Skills.Farming;
import com.example.test_activity.Skills.Fishing;
import com.example.test_activity.Skills.Mining;
import com.example.test_activity.Skills.Player;
import com.example.test_activity.Skills.Woodcutting;

import java.util.Calendar;

public class SaveManager {

    public static long logofftime, logontime;

        public static void SaveData(Context context){

            SharedPreferences sharedPreferences = context.getSharedPreferences("GAMESTATE", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();

            /** Inventory Values **/
            editor.putInt("amountOfLogs", Inventory.Log_Quantity);
            editor.putInt("amountOfStones", Inventory.Stone_Quantity);
            editor.putInt("amountOfFish", Inventory.Fish_Quantity);
            editor.putInt("amountOfWheat", Inventory.Wheat_Quantity);

            /** Player Statistics **/
            editor.putInt("playerLevel", Player.Level);
            editor.putInt("playerExperience", Player.Experience);

            /** Rare Values **/
            editor.putInt("amountOfLrares", Rare.Magic_Seeds);
            editor.putInt("amountOfSrares", Rare.Gem);
            editor.putInt("amountOfFrares", Rare.RainbowFish);
            editor.putInt("amountOfWrares", Rare.Giant_Wheat_Seeds);

            /** Kingdom Statistics **/
            editor.putInt("kingdomLevel", Kingdom.Level);

            /** Skill Statistics **/
            editor.putInt("woodcuttingLevel", Woodcutting.Level);
            editor.putInt("miningLevel", Mining.Level);
            editor.putInt("fishingLevel", Fishing.Level);
            editor.putInt("farmingLevel", Farming.Level);

            editor.putInt("woodcuttingExperience", (int) Woodcutting.ExperienceLeft);
            editor.putInt("miningExperience", (int) Mining.ExperienceLeft);
            editor.putInt("fishingExperience", (int) Fishing.ExperienceLeft);
            editor.putInt("farmingExperience", (int) Farming.ExperienceLeft);

            /** Worker Values **/
            editor.putInt("forestWorkers", Workers.Forest_Workers);
            editor.putInt("mineWorkers", Workers.Mine_Workers);
            editor.putInt("fishingBoatWorkers", Workers.FishingBoat_Workers);
            editor.putInt("farmWorkers", Workers.Farm_Workers);

            editor.putInt("unassignedWorkers", Workers.workerUnassigned);

            /** Date and Time Values **/
            Calendar calendar = Calendar.getInstance();
            logofftime = calendar.getTimeInMillis();
            editor.putLong("logOffTime", logofftime);

            /** Refined Material Values **/
            editor.putInt("amountOfBricks", Refinery.Brick);

            editor.putInt("amountOfLumber", Refinery.Lumber);

            editor.putInt("amountOfBread", Refinery.Bread);

            editor.putInt("amountOfFillet", Refinery.Fillet);

            /** Commit **/
            editor.commit();
            System.out.println(logofftime);
        }
        public static void LoadData(Context context){

            SharedPreferences sharedPreferences = context.getSharedPreferences("GAMESTATE", Context.MODE_PRIVATE);

            /** Load Refined Material Values **/
            Refinery.Brick = sharedPreferences.getInt("amountOfBricks", 0);

            Refinery.Lumber = sharedPreferences.getInt("amountOfLumber", 0);

            Refinery.Bread = sharedPreferences.getInt("amountOfBread", 0);

            Refinery.Fillet = sharedPreferences.getInt("amountOfFillet", 0);

            /** Load Inventory Values **/
            Inventory.Log_Quantity = sharedPreferences.getInt("amountOfLogs", 0);
            Inventory.Stone_Quantity = sharedPreferences.getInt("amountOfStones", 0);
            Inventory.Fish_Quantity = sharedPreferences.getInt("amountOfFish", 0);
            Inventory.Wheat_Quantity = sharedPreferences.getInt("amountOfWheat", 0);
            System.out.println(Inventory.Log_Quantity);

            /** Load Player Statistics **/
            Player.Level = sharedPreferences.getInt("playerLevel", 1);
            Player.Experience = sharedPreferences.getInt("playerExperience", 0);

            /** Load Rare Values **/
            Rare.Magic_Seeds = sharedPreferences.getInt("amountOfLrares", 0);
            Rare.Gem = sharedPreferences.getInt("amountOfSrares", 0);
            Rare.RainbowFish = sharedPreferences.getInt("amountOfFrares", 0);
            Rare.Giant_Wheat_Seeds = sharedPreferences.getInt("amountOfWrares", 0);

            /** Load Kingdom Statistics **/
            Kingdom.Level = sharedPreferences.getInt("kingdomLevel", 1);

            /** Load Skill Statistics **/
            Woodcutting.Level = sharedPreferences.getInt("woodcuttingLevel", 1);
            Mining.Level = sharedPreferences.getInt("miningLevel", 1);
            Fishing.Level = sharedPreferences.getInt("fishingLevel", 1);
            Farming.Level = sharedPreferences.getInt("farmingLevel", 1);

            //TODO: FIX
            Woodcutting.Experience = sharedPreferences.getInt("woodcuttingExperience", 0);
            Mining.Experience = sharedPreferences.getInt("miningExperience", 0);
            Fishing.Experience = sharedPreferences.getInt("fishingExperience", 0);
            Farming.Experience = sharedPreferences.getInt("farmingExperience", 0);

            /** Load Worker Values **/
            Workers.Forest_Workers = sharedPreferences.getInt("forestWorkers", 0);
            Workers.Mine_Workers = sharedPreferences.getInt("mineWorkers", 0);
            Workers.FishingBoat_Workers = sharedPreferences.getInt("fishingBoatWorkers", 0);
            Workers.Farm_Workers = sharedPreferences.getInt("farmWorkers", 0);

            Workers.workerUnassigned = sharedPreferences.getInt("unassignedWorkers", 0);

            /** Date and Time Values **/

            logofftime = sharedPreferences.getLong("logOffTime", 0);

            System.out.println(logofftime);
            System.out.println(logontime);

            Calendar calendar = Calendar.getInstance();
            logontime  = calendar.getTimeInMillis();

            Workers.AddOfflineResources();

        }
        public static void Clear(Context context){

            SharedPreferences sharedPreferences = context.getSharedPreferences("GAMESTATE", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.apply();
        }
}
