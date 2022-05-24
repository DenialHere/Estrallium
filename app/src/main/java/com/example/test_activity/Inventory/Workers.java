package com.example.test_activity.Inventory;

import android.app.Activity;
import android.view.Gravity;
import android.widget.TextView;

import com.example.test_activity.Managers.DialogueManager;
import com.example.test_activity.Managers.SaveManager;
import com.example.test_activity.R;
import com.example.test_activity.Skills.Player;

//TODO


public class Workers {

    public static int Modifier = 1;

    public static int workerCapacity = 30;
    /** AVAILABLE WORKERS **/
    public static int workerUnassigned = 10;

    /** ASSIGNED THEM ALL TO 1 TO TEST **/
    public static int Forest_Workers = 1, FishingBoat_Workers = 1, Farm_Workers = 1, Mine_Workers = 0;

    public static int ForestWorkerSpeed = 10000;
    public static int MineWorkerSpeed = 10000;
    public static int FishingBoatWorkerSpeed = 10000;
    public static int FarmWorkerSpeed = 10000;

    /** ADD WORKER TO PLOT **/
    public static void AddWorkerToPlot(int i, Activity activity){

        if (i == 1) {
            if (Forest_Workers < workerCapacity && workerUnassigned > 0){
                workerUnassigned--;
                Forest_Workers++;
            }
            else {
                ErrorMessage(activity);
            }
        }else if (i == 2){
            if (Mine_Workers < workerCapacity && workerUnassigned > 0){
                workerUnassigned--;
                Mine_Workers++;
            }
            else {
                ErrorMessage(activity);
            }
        }
        else if (i == 3){
            if (FishingBoat_Workers < workerCapacity && workerUnassigned > 0){
                workerUnassigned--;
                FishingBoat_Workers++;
            } else {
                ErrorMessage(activity);
            }
        }
        else if (i == 4){
            if (Farm_Workers < workerCapacity && workerUnassigned > 0) {
                workerUnassigned--;
                Farm_Workers++;
            } else {
                ErrorMessage(activity);
            }
        }

    }
    /** REMOVE WORKER FROM PLOT **/
    public static void RemoveWorkerFromPlot(int i, Activity activity){

        if (i == 1) {
            if (Forest_Workers > 0){
                Forest_Workers--;
                workerUnassigned++;
            }
            else {
                ErrorMessage(activity);
            }
        }else if (i == 2){
            if (Mine_Workers > 0){
                Mine_Workers--;
                workerUnassigned++;
            }
            else {
                ErrorMessage(activity);
            }
        }
        else if (i == 3){
            if (FishingBoat_Workers > 0){
                FishingBoat_Workers--;
                workerUnassigned++;
            }
            else {
                ErrorMessage(activity);
            }
        }
        else if (i == 4){
            if (Farm_Workers > 0){
                Farm_Workers--;
                workerUnassigned++;
            }
            else {
                ErrorMessage(activity);
            }
        }
    }
    /** WORKER TAP METHOD (NO EXP & NO RARE CHANCE) **/
    public static void AddResource_Worker(int i){

        switch (i) {
            case 1:
                int calculated = Modifier  * Forest_Workers;
                Inventory.Log_Quantity = Inventory.getLog_Quantity() + calculated;
                System.out.println(Inventory.getLog_Quantity());
                System.out.println("Worker adding Log Resource...");
                break;
            case 2:
                if (Player.Level >= 5){
                    calculated = Modifier  * Mine_Workers;
                    Inventory.Stone_Quantity = Inventory.getStone_Quantity() + calculated;
                    System.out.println(Inventory.getStone_Quantity());
                    System.out.println("Worker adding Stone Resource...");
                }
                break;
            case 3:
                if (Player.Level >= 10) {
                    calculated = Modifier  * FishingBoat_Workers;
                    Inventory.Fish_Quantity = Inventory.getFish_Quantity() + calculated;
                    System.out.println(Inventory.getFish_Quantity());
                    System.out.println("Worker adding Fish Resource...");
                }
                break;
            case 4:
                if (Player.Level >= 15) {
                    calculated = (1 + Rare.getGiant_Wheat_Seeds()) * Farm_Workers;
                    //Inventory.Log_Quantity = Inventory.Log_Quantity + Rare.Magic_Seeds * Forest_Workers;
                    Inventory.Wheat_Quantity = Inventory.getFish_Quantity() + calculated;
                    System.out.println(Inventory.getFish_Quantity());
                    System.out.println("Worker adding Wheat Resource...");
                }
                break;

        }

    }

    public static void AddOfflineResources(){
        if (SaveManager.logofftime != 0){
            long timeWorked = SaveManager.logontime - SaveManager.logofftime;
            Inventory.Log_Quantity = Inventory.Log_Quantity + (int) (timeWorked / ForestWorkerSpeed);
            Inventory.Stone_Quantity = Inventory.Stone_Quantity + (int) (timeWorked / MineWorkerSpeed);
            Inventory.Fish_Quantity = Inventory.Fish_Quantity + (int) (timeWorked / FishingBoatWorkerSpeed);
            Inventory.Wheat_Quantity = Inventory.Wheat_Quantity + (int) (timeWorked / FarmWorkerSpeed);

        }

    }

    public static void ErrorMessage(Activity activity){
        DialogueManager.ShowMessage(activity, "You don't have enough workers!", 0, Gravity.CENTER);
    }
}
