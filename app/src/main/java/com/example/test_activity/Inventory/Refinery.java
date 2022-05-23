package com.example.test_activity.Inventory;

public class Refinery {


    public static int Lumber = 0, Plank = 0, Sawdust = 0;
    public static int Brick = 0, Gravel = 0, Mortar = 0;
    public static int Fillet = 0, Oil = 0, Bones = 0;
    public static int Bread = 0, Sandwich = 0, Stew = 0;


    public static void CraftLumber(int amount){
        Lumber = Lumber + amount;
    }
    public static void CraftPlank(int amount){
        Plank = Plank + amount;
    }
    public static void CraftSawdust(int amount){
        Sawdust = Sawdust + amount;
    }

    public static void CraftBrick(int amount){
        Brick = Brick + amount;
    }
    public static void CraftGravel(int amount){
        Gravel = Gravel + amount;
    }
    public static void CraftMortar(int amount){
        Mortar = Mortar + amount;
    }

    public static void CraftFillet(int amount){
        Fillet = Fillet + amount;
    }
    public static void CraftOil(int amount){
        Oil = Oil + amount;
    }
    public static void CraftBones(int amount){
        Bones = Bones + amount;
    }

    public static void CraftBread(int amount){
        Bread = Bread + amount;
    }
    public static void CraftSandwich(int amount){
        Sandwich = Sandwich + amount;
    }
    public static void CraftStew(int amount){
        Stew = Stew + amount;
    }


}
