package com.example.test_activity.Inventory;

public class Refinery {


    public static int Lumber = 0;
    public static int Brick = 0;
    public static int Fillet = 0;
    public static int Bread = 0;

    public static boolean isActive1 = false, isActive2 = false, isActive3 = false, isActive4 = false;


    public static void CraftLumber(int amount){
        Lumber = Lumber + amount;
    }

    public static void CraftBrick(int amount){
        Brick = Brick + amount;
    }

    public static void CraftFillet(int amount){
        Fillet = Fillet + amount;
    }

    public static void CraftBread(int amount){
        Bread = Bread + amount;
    }

    public static void BrickTask(){



    }
    public static void BreadTask(){



    }
    public static void FilletTask(){



    }
}
