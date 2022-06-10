package com.example.test_activity;

import android.app.Activity;
import android.view.Gravity;
import android.widget.Switch;

import com.example.test_activity.Inventory.Inventory;
import com.example.test_activity.Managers.DialogueManager;
import com.example.test_activity.Skills.Player;

import java.util.Random;

public class Tasks {

    public static int MinAmount, MaxAmount, NewestTask;
    public static int AmountOfTasks = 0;
    public static int TaskTimer = 5000;
    public static Boolean IsEnabled = true;

    public static String[] Thing = {"Our barn ", "The chapel ", "The town hall ", "The inn ", "My house ", "My barn ", "The bridge ", "The theater ", "The barracks ", "The general store ", "My store ", "The mill ",
    "The stables ", "My forge ", "The workshop ", "My granary ", "Our military outpost ", "The great hall ", "The blacksmith's workshop ", "The brewery ", "The butcher shop ", "My farmhouse ", "The smokehouse ", "The bathhouse ",
    "The carpenter's shop "
    };

    public static String[] Action = {"has burned down! ", "is falling apart. ", "is in need of repairs. ", "is in desperate need of repairs! ", "has come crashing to the ground! ", "is destroyed!", "has been looted!",
    "has been looted by bandits! ", "is burnt to a crisp! ", "has collapsed. ", "has flooded. ", "is damaged. ", "is severely damaged! ", "is no longer usable and has been abandoned! ", "is not safe for use and has been abandoned.  ",
    "has been demolished. ",
    };

    public static String Demand = "";
    public static int[][] DemandRequired = { {0}, {0} };

    public static String[] Scenario = {"", "", "", "", ""};
    public static int[][] ResourcesRequired = { {0,0,0,0}, {0,0,0,0} };

    public static void GenerateScenario(Activity activity){

        if (Tasks.AmountOfTasks < 4) {

            Random rand = new Random();

            int thingSelection = rand.nextInt(Thing.length);
            int actionSelection = rand.nextInt(Action.length);

            CalculateMinMax(Player.Level);

            String resourceName = "";

            int randomResource = 1;

            if (Player.Level >= Constants.miningLevelRequiredForPlot){
                randomResource++;
            }
            if (Player.Level >= Constants.fishingLevelRequiredForPlot){
                randomResource++;
            }
            if (Player.Level >= Constants.farmingLevelRequiredForPlot){
                randomResource++;
            }

            int resource = rand.nextInt(randomResource + 1 - 1) + 1;

            switch (resource){
                case Inventory.WOOD:
                    resourceName = "Wood";
                    break;
                case Inventory.STONE:
                    resourceName = "Stone";
                    break;
                case Inventory.FISH:
                    resourceName = "Fish";
                    break;
                case Inventory.WHEAT:
                    resourceName = "Wheat";
                    break;
            }

            int amount = rand.nextInt(MaxAmount + 1 - MinAmount) + MinAmount;
            CalculateMinMax(Player.Level);

            if (Scenario[0] == ""){
                Scenario[0] = Thing[thingSelection] + Action[actionSelection] + "\n" + amount + " " + resourceName + " is needed.";
                NewestTask = 0;
                AmountOfTasks++;
                ResourcesRequired[0][0] = resource;
                ResourcesRequired[1][0] = amount;

            }
            else if (Scenario[1] == ""){
                Scenario[1] = Thing[thingSelection] + Action[actionSelection] + "\n" + amount + " " + resourceName + " is needed.";
                NewestTask = 1;
                AmountOfTasks++;
                ResourcesRequired[0][1] = resource;
                ResourcesRequired[1][1] = amount;
            }
            else if (Scenario[2] == ""){
                Scenario[2] = Thing[thingSelection] + Action[actionSelection] + "\n" + amount + " " + resourceName + " is needed.";
                NewestTask = 2;
                AmountOfTasks++;
                ResourcesRequired[0][2] = resource;
                ResourcesRequired[1][2] = amount;
            }
            else if (Scenario[3] == ""){
                Scenario[3] = Thing[thingSelection] + Action[actionSelection] + "\n" + amount + " " + resourceName + " is needed.";
                NewestTask = 3;
                AmountOfTasks++;
                ResourcesRequired[0][3] = resource;
                ResourcesRequired[1][3] = amount;
            }

            DialogueManager.ShowMessage(activity, Tasks.Scenario[Tasks.NewestTask], R.drawable.villager, Gravity.CENTER);

        }

    }
    public static void GenerateFree(Activity activity){

        Random rand = new Random();

        CalculateMinMax(Player.Level);

        String resourceName = "";

        int randomResource = 1;

        if (Player.Level >= Constants.miningLevelRequiredForPlot){
            randomResource++;
        }
        if (Player.Level >= Constants.fishingLevelRequiredForPlot){
            randomResource++;
        }
        if (Player.Level >= Constants.farmingLevelRequiredForPlot){
            randomResource++;
        }

        int resource = rand.nextInt(randomResource + 1 - 1) + 1;
        int quantity = MinAmount / 2;


        switch (resource){
            case Inventory.WOOD:
                resourceName = "Wood";
                Inventory.Log_Quantity = Inventory.Log_Quantity + quantity;
                break;
            case Inventory.STONE:
                resourceName = "Stone";
                Inventory.Stone_Quantity = Inventory.Stone_Quantity + quantity;
                break;
            case Inventory.FISH:
                resourceName = "Fish";
                Inventory.Fish_Quantity = Inventory.Fish_Quantity + quantity;
                break;
            case Inventory.WHEAT:
                resourceName = "Wheat";
                Inventory.Wheat_Quantity = Inventory.Wheat_Quantity + quantity;
                break;
        }

        DialogueManager.ShowMessage(activity, "We have found " + quantity + " " + resourceName + " just lying around. ", R.drawable.villager, Gravity.CENTER);
    }

    public static void GenerateDemand(){
            Random rand = new Random();

            int thingSelection = rand.nextInt(Thing.length);
            int actionSelection = rand.nextInt(Action.length);

            CalculateMinMax(Player.Level);

            String resourceName = "";

            int randomResource = 1;

            if (Player.Level >= Constants.miningLevelRequiredForPlot){
                randomResource++;
            }
            if (Player.Level >= Constants.fishingLevelRequiredForPlot){
                randomResource++;
            }
            if (Player.Level >= Constants.farmingLevelRequiredForPlot){
                randomResource++;
            }

            int resource = rand.nextInt(randomResource + 1 - 1) + 1;
            int quantity = 0;
            switch (resource){
                case Inventory.WOOD:
                    resourceName = "Wood";
                    if (Inventory.Log_Quantity >= (MaxAmount / 3))
                    {
                        quantity = MaxAmount / 3;
                        Demand = Thing[thingSelection] + Action[actionSelection] + "\n" + quantity + " " + resourceName + " is needed right away.";
                        DemandRequired[0][0] = resource;
                        DemandRequired[1][0] = quantity;
                    }
                    break;
                case Inventory.STONE:
                    resourceName = "Stone";
                    if (Inventory.Stone_Quantity >= (MaxAmount / 3))
                    {
                        quantity = MaxAmount / 3;
                        Demand = Thing[thingSelection] + Action[actionSelection] + "\n" + quantity + " " + resourceName + " is needed right away.";
                        DemandRequired[0][0] = resource;
                        DemandRequired[1][0] = quantity;
                    }
                    break;
                case Inventory.FISH:
                    resourceName = "Fish";
                    if (Inventory.Fish_Quantity >= (MaxAmount / 3))
                    {
                        quantity = MaxAmount / 3;
                        Demand = Thing[thingSelection] + Action[actionSelection] + "\n" + quantity + " " + resourceName + " is needed right away.";
                        DemandRequired[0][0] = resource;
                        DemandRequired[1][0] = quantity;
                    }
                    break;
                case Inventory.WHEAT:
                    resourceName = "Wheat";
                    if (Inventory.Wheat_Quantity >= (MaxAmount / 3))
                    {
                        quantity = MaxAmount / 3;
                        Demand = Thing[thingSelection] + Action[actionSelection] + "\n" + quantity + " " + resourceName + " is needed right away.";
                        DemandRequired[0][0] = resource;
                        DemandRequired[1][0] = quantity;
                    }
                    break;
            }


    }


    private static void CalculateMinMax(int level) {
       MinAmount = 10 + (Player.Level * 2);
       MaxAmount = 25 + (Player.Level * 4);
    }
}
