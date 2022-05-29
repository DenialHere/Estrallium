package com.example.test_activity.Inventory;

public class Shop {
    public static int LogPrice = 5;
    public static int StonePrice = 8;
    public static int FishPrice = 10;
    public static int FarmPrice = 15;


    public static String PricePer(int price){
        return Integer.toString(price) + "/per";

    }
    public static int CalculatePrice(String amountEntered, int price){
        try {
            return Integer.parseInt(amountEntered) * price;
        }
        catch (Exception e){
            return 0;
        }
    }
}
