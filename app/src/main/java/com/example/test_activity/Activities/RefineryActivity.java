package com.example.test_activity.Activities;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.test_activity.Inventory.Inventory;
import com.example.test_activity.Inventory.Refinery;
import com.example.test_activity.R;

public class RefineryActivity extends AppCompatActivity {

   TextView LumberQuantityText, BreadQuantityText, FilletQuantityText, BrickQuantityText, task1time, task2time, task3time, task4time;
   TextView estimate1, estimate2, estimate3, estimate4, time1,time2,time3,time4;
   ImageView task1bar, task2bar, task3bar, task4bar;
   protected static int lumbertime, bricktime, fishtime, breadtime;

    static boolean iscraftinglumber = false;
    static boolean iscraftingbricks = false;
    static boolean iscraftingfillets = false;
    static boolean iscraftingbreads = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.refinery);
        task1time = findViewById(R.id.task1time);
        task2time = findViewById(R.id.task2time);
        task3time = findViewById(R.id.task3time);
        task4time = findViewById(R.id.task4time);
        LumberQuantityText = findViewById(R.id.LumberQuantityText);
        LumberQuantityText.setText("0");
        BreadQuantityText = findViewById(R.id.BreadQuantityText);
        FilletQuantityText = findViewById(R.id.FilletQuantityText);
        BrickQuantityText = findViewById(R.id.BrickQuantityText);
        task1bar = findViewById(R.id.task1bar);
        task2bar = findViewById(R.id.task2bar);
        task3bar = findViewById(R.id.task3bar);
        task4bar = findViewById(R.id.task4bar);

        estimate1 = findViewById(R.id.estimatedcost1);
        estimate2 = findViewById(R.id.estimatedcost2);
        estimate3 = findViewById(R.id.estimatedcost3);
        estimate4 = findViewById(R.id.estimatedcost4);

        time1 = findViewById(R.id.estimatedtime1);
        time2 = findViewById(R.id.estimatedtime2);
        time3 = findViewById(R.id.estimatedtime3);
        time4 = findViewById(R.id.estimatedtime4);

        new CountDownTimer(1999999990, 1000) {

            public void onTick(long millisUntilFinished) {
                try {
                    time1.setText(String.valueOf(Integer.parseInt(LumberQuantityText.getText().toString()) * 300));

                    time2.setText(String.valueOf(Integer.parseInt(FilletQuantityText.getText().toString()) * 30));
                    time3.setText(String.valueOf(Integer.parseInt(BrickQuantityText.getText().toString()) * 960));
                    time4.setText(String.valueOf(Integer.parseInt(BreadQuantityText.getText().toString()) * 60));


                    estimate1.setText(String.valueOf(Integer.parseInt(LumberQuantityText.getText().toString()) * 35));
                    estimate2.setText(String.valueOf(Integer.parseInt(FilletQuantityText.getText().toString()) * 8));
                    estimate3.setText(String.valueOf(Integer.parseInt(BrickQuantityText.getText().toString()) * 160));
                    estimate4.setText(String.valueOf(Integer.parseInt(BreadQuantityText.getText().toString()) * 3));
                } catch(NumberFormatException nfe) {
                    System.out.println("Could not parse " + nfe);
                }
            }
            public void onFinish() {

            }
        }.start();

    }

    public void LumberTask(View view){

        int craftingcost = 0;
        int craftingtime = 0;
        int totalToCraft = Integer.parseInt(LumberQuantityText.getText().toString());

        if (totalToCraft == 0){

            System.out.println("error");
            return;
        }

        craftingcost = totalToCraft * 35;

        if(Inventory.Log_Quantity > craftingcost && iscraftinglumber == false){

            iscraftinglumber = true;

            craftingtime = totalToCraft * 300000;
            //new merge
            double twelvepercent = craftingtime /1000 * 0.125;
            double twentyfivepercent = craftingtime /1000 * 0.25;
            double thirtysevenpercent = craftingtime /1000  * 0.37;
            double fiftypercent = craftingtime /1000  * 0.50;
            double sixtytwopercent = craftingtime /1000  * 0.625;
            double seventyfivepercent = craftingtime /1000  * 0.75;
            double eightysevenpercent = craftingtime /1000  * 0.8725;
            double onehundredpercent = craftingtime /1000  * 0.96;

            int finalCraftingcost = craftingcost;
            new CountDownTimer(craftingtime, 1000) {

                public void onTick(long millisUntilFinished) {
                    task1time.setText(String.valueOf(millisUntilFinished/1000));
                    System.out.println(millisUntilFinished);
                    System.out.println(twelvepercent);
                    task1bar.setImageResource(R.drawable.zerobar);
                    System.out.println(millisUntilFinished / 1000);
                    if(millisUntilFinished/1000 < twelvepercent){
                        System.out.println("12% loop");
                        task1bar.setImageResource(R.drawable.sevenbar);
                    }else if(millisUntilFinished/1000 < twentyfivepercent){
                        System.out.println("25% loop");
                        task1bar.setImageResource(R.drawable.sixbar);
                    }else if(millisUntilFinished/1000 < thirtysevenpercent){
                        System.out.println("37% loop");
                        task1bar.setImageResource(R.drawable.fivebar);
                    }else if(millisUntilFinished/1000 < fiftypercent){
                        System.out.println("50% loop");
                        task1bar.setImageResource(R.drawable.fourbar);
                    }else if(millisUntilFinished/1000 < sixtytwopercent){
                        System.out.println("62% loop");
                        task1bar.setImageResource(R.drawable.threebar);
                    }else if(millisUntilFinished/1000 < seventyfivepercent){
                        System.out.println("75% loop");
                        task1bar.setImageResource(R.drawable.twobar);
                    }else if(millisUntilFinished/1000 < eightysevenpercent){
                        System.out.println("87% loop");
                        task1bar.setImageResource(R.drawable.onebar);
                    }else if(millisUntilFinished/1000 < onehundredpercent){
                        System.out.println("100% loop");
                        task1bar.setImageResource(R.drawable.zerobar);
                    }
                }
                public void onFinish() {
                    Refinery.CraftLumber(totalToCraft);
                    Inventory.Log_Quantity = Inventory.Log_Quantity - finalCraftingcost;
                    task1bar.setImageResource(R.drawable.completebar);
                    iscraftinglumber = false;
                    task1time.setText("Complete!");
                }
            }.start();
        }
        else {
            System.out.println("Already Crafting Lumber! or not enough!");
            return;

        }
    }

    public void BrickTask(View view){
        int craftingcost = 0;
        int craftingtime = 0;
        int totalToCraft = Integer.parseInt(BrickQuantityText.getText().toString());

        if (totalToCraft == 0){

            System.out.println("error");
            return;
        }

        craftingcost = totalToCraft * 35;

        if(Inventory.Stone_Quantity > craftingcost && iscraftingbricks == false){

            iscraftingbricks = true;

            craftingtime = totalToCraft * 960000;

            double twelvepercent = craftingtime /1000 * 0.125;
            double twentyfivepercent = craftingtime /1000 * 0.25;
            double thirtysevenpercent = craftingtime /1000  * 0.37;
            double fiftypercent = craftingtime /1000  * 0.50;
            double sixtytwopercent = craftingtime /1000  * 0.625;
            double seventyfivepercent = craftingtime /1000  * 0.75;
            double eightysevenpercent = craftingtime /1000  * 0.8725;
            double onehundredpercent = craftingtime /1000  * 0.96;

            int finalCraftingcost = craftingcost;
            new CountDownTimer(craftingtime, 1000) {

                public void onTick(long millisUntilFinished) {
                    task2time.setText(String.valueOf(millisUntilFinished/1000));
                    System.out.println(millisUntilFinished);
                    System.out.println(twelvepercent);
                    task2bar.setImageResource(R.drawable.zerobar);
                    System.out.println(millisUntilFinished / 1000);
                    if(millisUntilFinished/1000 < twelvepercent){
                        System.out.println("12% loop");
                        task2bar.setImageResource(R.drawable.sevenbar);
                    }else if(millisUntilFinished/1000 < twentyfivepercent){
                        System.out.println("25% loop");
                        task2bar.setImageResource(R.drawable.sixbar);
                    }else if(millisUntilFinished/1000 < thirtysevenpercent){
                        System.out.println("37% loop");
                        task2bar.setImageResource(R.drawable.fivebar);
                    }else if(millisUntilFinished/1000 < fiftypercent){
                        System.out.println("50% loop");
                        task2bar.setImageResource(R.drawable.fourbar);
                    }else if(millisUntilFinished/1000 < sixtytwopercent){
                        System.out.println("62% loop");
                        task2bar.setImageResource(R.drawable.threebar);
                    }else if(millisUntilFinished/1000 < seventyfivepercent){
                        System.out.println("75% loop");
                        task2bar.setImageResource(R.drawable.twobar);
                    }else if(millisUntilFinished/1000 < eightysevenpercent){
                        System.out.println("87% loop");
                        task2bar.setImageResource(R.drawable.onebar);
                    }else if(millisUntilFinished/1000 < onehundredpercent){
                        System.out.println("100% loop");
                        task2bar.setImageResource(R.drawable.zerobar);
                    }
                }
                public void onFinish() {
                    Refinery.CraftLumber(totalToCraft);
                    Inventory.Stone_Quantity = Inventory.Stone_Quantity - finalCraftingcost;
                    task2bar.setImageResource(R.drawable.completebar);
                    iscraftingbricks = false;
                    task2time.setText("Complete!");
                }
            }.start();
        }
        else {
            System.out.println("Already Crafting Bricks! or not enough!");
            return;

        }
    }
    public void FilletTask(View view){

        int craftingcost = 0;
        int craftingtime = 0;
        int totalToCraft = Integer.parseInt(FilletQuantityText.getText().toString());
        if (totalToCraft == 0){

            System.out.println("error");
            return;
        }

        craftingcost = totalToCraft * 35;

        if(Inventory.Fish_Quantity > craftingcost && iscraftingfillets == false){

            iscraftingfillets = true;

            craftingtime = totalToCraft * 30000;

            double twelvepercent = craftingtime /1000 * 0.125;
            double twentyfivepercent = craftingtime /1000 * 0.25;
            double thirtysevenpercent = craftingtime /1000  * 0.37;
            double fiftypercent = craftingtime /1000  * 0.50;
            double sixtytwopercent = craftingtime /1000  * 0.625;
            double seventyfivepercent = craftingtime /1000  * 0.75;
            double eightysevenpercent = craftingtime /1000  * 0.8725;
            double onehundredpercent = craftingtime /1000  * 0.96;

            int finalCraftingcost = craftingcost;
            new CountDownTimer(craftingtime, 1000) {

                public void onTick(long millisUntilFinished) {
                    task4time.setText(String.valueOf(millisUntilFinished/1000));
                    System.out.println(millisUntilFinished);
                    System.out.println(twelvepercent);
                    task4bar.setImageResource(R.drawable.zerobar);
                    System.out.println(millisUntilFinished / 1000);
                    if(millisUntilFinished/1000 < twelvepercent){
                        System.out.println("12% loop");
                        task4bar.setImageResource(R.drawable.sevenbar);
                    }else if(millisUntilFinished/1000 < twentyfivepercent){
                        System.out.println("25% loop");
                        task4bar.setImageResource(R.drawable.sixbar);
                    }else if(millisUntilFinished/1000 < thirtysevenpercent){
                        System.out.println("37% loop");
                        task4bar.setImageResource(R.drawable.fivebar);
                    }else if(millisUntilFinished/1000 < fiftypercent){
                        System.out.println("50% loop");
                        task4bar.setImageResource(R.drawable.fourbar);
                    }else if(millisUntilFinished/1000 < sixtytwopercent){
                        System.out.println("62% loop");
                        task4bar.setImageResource(R.drawable.threebar);
                    }else if(millisUntilFinished/1000 < seventyfivepercent){
                        System.out.println("75% loop");
                        task4bar.setImageResource(R.drawable.twobar);
                    }else if(millisUntilFinished/1000 < eightysevenpercent){
                        System.out.println("87% loop");
                        task4bar.setImageResource(R.drawable.onebar);
                    }else if(millisUntilFinished/1000 < onehundredpercent){
                        System.out.println("100% loop");
                        task4bar.setImageResource(R.drawable.zerobar);
                    }
                }
                public void onFinish() {
                    Refinery.CraftLumber(totalToCraft);
                    Inventory.Fish_Quantity = Inventory.Fish_Quantity - finalCraftingcost;
                    task4bar.setImageResource(R.drawable.completebar);
                    iscraftingfillets = false;
                    task4time.setText("Complete!");
                }
            }.start();
        }
        else {
            System.out.println("Already Crafting Fillets! or not enough!");
            return;

        }
    }
    public void BreadTask(View view){
        int craftingcost = 0;
        int craftingtime = 0;
        int totalToCraft = Integer.parseInt(BreadQuantityText.getText().toString());

        if (totalToCraft == 0){

            System.out.println("error");
            return;
        }

        craftingcost = totalToCraft * 8;

        if(Inventory.Wheat_Quantity > craftingcost && iscraftingbreads == false){

            iscraftingbreads = true;

            craftingtime = totalToCraft * 60000;

            double twelvepercent = craftingtime /1000 * 0.125;
            double twentyfivepercent = craftingtime /1000 * 0.25;
            double thirtysevenpercent = craftingtime /1000  * 0.37;
            double fiftypercent = craftingtime /1000  * 0.50;
            double sixtytwopercent = craftingtime /1000  * 0.625;
            double seventyfivepercent = craftingtime /1000  * 0.75;
            double eightysevenpercent = craftingtime /1000  * 0.8725;
            double onehundredpercent = craftingtime /1000  * 0.96;

            int finalCraftingcost = craftingcost;
            new CountDownTimer(craftingtime, 1000) {

                public void onTick(long millisUntilFinished) {
                    task3time.setText(String.valueOf(millisUntilFinished/1000));
                    System.out.println(millisUntilFinished);
                    System.out.println(twelvepercent);
                    task3bar.setImageResource(R.drawable.zerobar);
                    System.out.println(millisUntilFinished / 1000);
                    if(millisUntilFinished/1000 < twelvepercent){
                        System.out.println("12% loop");
                        task3bar.setImageResource(R.drawable.sevenbar);
                    }else if(millisUntilFinished/1000 < twentyfivepercent){
                        System.out.println("25% loop");
                        task3bar.setImageResource(R.drawable.sixbar);
                    }else if(millisUntilFinished/1000 < thirtysevenpercent){
                        System.out.println("37% loop");
                        task3bar.setImageResource(R.drawable.fivebar);
                    }else if(millisUntilFinished/1000 < fiftypercent){
                        System.out.println("50% loop");
                        task3bar.setImageResource(R.drawable.fourbar);
                    }else if(millisUntilFinished/1000 < sixtytwopercent){
                        System.out.println("62% loop");
                        task3bar.setImageResource(R.drawable.threebar);
                    }else if(millisUntilFinished/1000 < seventyfivepercent){
                        System.out.println("75% loop");
                        task3bar.setImageResource(R.drawable.twobar);
                    }else if(millisUntilFinished/1000 < eightysevenpercent){
                        System.out.println("87% loop");
                        task3bar.setImageResource(R.drawable.onebar);
                    }else if(millisUntilFinished/1000 < onehundredpercent){
                        System.out.println("100% loop");
                        task3bar.setImageResource(R.drawable.zerobar);
                    }
                }
                public void onFinish() {
                    Refinery.CraftBread(totalToCraft);
                    Inventory.Wheat_Quantity = Inventory.Wheat_Quantity - finalCraftingcost;
                    task3bar.setImageResource(R.drawable.completebar);
                    iscraftingbreads = false;
                    task3time.setText("Complete!");
                }
            }.start();
        }
        else {
            System.out.println("Already Crafting Bread! or not enough!");
            return;

        }
    }
}
