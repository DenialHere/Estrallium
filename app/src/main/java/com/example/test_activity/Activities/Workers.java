package com.example.test_activity.Activities;

import com.example.test_activity.Inventory.Inventory;
import com.example.test_activity.Inventory.Rare;

//TODO
import java.util.Calendar;
import java.util.Date;

public class Workers {

    static int workerCapacity = 24;
    static int workerUnassigned = 0;
    static int Forest_Workers = 1, FishingBoat_Workers = 0, Farm_Workers = 0, Mine_Workers = 0;

    public static void AddWorkerToPlot(int i){

        if (i == 0) {
            if (Forest_Workers < workerCapacity){
                Forest_Workers++;
            }
        }else if (i == 1){
            if (FishingBoat_Workers < workerCapacity){
                FishingBoat_Workers++;
            }
        }
        else if (i == 2){
            if (Farm_Workers < workerCapacity){
                Farm_Workers++;
            }
        }
        else if (i == 3){
            if (Mine_Workers < workerCapacity){
                Mine_Workers++;
            }
        }

    }
    public static void AddResource_Worker(int i){
        switch (i) {
            case 1:
                Inventory.Log_Quantity = Inventory.Log_Quantity + Rare.Magic_Seeds * Forest_Workers;
                System.out.println("Log_Quantity");
                break;

        }

    }

}
