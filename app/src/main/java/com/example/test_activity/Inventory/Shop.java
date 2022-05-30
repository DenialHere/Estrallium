package com.example.test_activity.Inventory;

public class Shop {
    public static int LogBuyPrice = 5;
    public static int StoneBuyPrice = 8;
    public static int FishBuyPrice = 10;
    public static int FarmBuyPrice = 15;

    public static int LogSellPrice = 1;
    public static int StoneSellPrice = 2;
    public static int FishSellPrice = 3;
    public static int FarmSellPrice = 4;


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
