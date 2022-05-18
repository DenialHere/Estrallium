package com.example.test_activity.Inventory;

import java.util.Random;

public class Rare {

    private static int Base_Rare_Drop_Chance = 48;
    public static int Magic_Seeds = 0;
    public static int Gem = 0;
    private static int artifacts = 0;
    private static int Giant_Wheat_Seeds = 0;


    public static void checkForRareDrop(int plot) {
        Random rand = new Random();
       switch (plot) {
           case Inventory.WOOD:
               if (rand.nextInt(Base_Rare_Drop_Chance * (1 + Magic_Seeds)) == 0){
                   Magic_Seeds = Magic_Seeds + 1;
                   System.out.println("RARE WOOD" );
               }
               break;
           case Inventory.STONE:
               if (rand.nextInt(Base_Rare_Drop_Chance * (1 + Gem)) == 0){
                   Gem = Gem + 1;
                   System.out.println("RARE STONE" );
               }
               break;

       }

    }
    public static int getMagic_Seeds() {
        return Magic_Seeds;
    }



    public static int get_Artifacts() {
        return artifacts;
    }

    public static int getGiant_Wheat_Seeds() {
        return Giant_Wheat_Seeds;
    }
}
