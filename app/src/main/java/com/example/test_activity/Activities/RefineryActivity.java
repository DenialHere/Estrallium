package com.example.test_activity.Activities;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test_activity.Inventory.Inventory;
import com.example.test_activity.Inventory.Refinery;
import com.example.test_activity.R;

public class RefineryActivity extends AppCompatActivity {

   TextView LumberQuantityText, BreadQuantityText, FilletQuantityText, BrickQuantityText, task1time, task2time, task3time, task4time;
   ImageView task1bar, task2bar, task3bar, task4bar;

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
        BreadQuantityText = findViewById(R.id.BreadQuantityText);
        FilletQuantityText = findViewById(R.id.FilletQuantityText);
        BrickQuantityText = findViewById(R.id.BrickQuantityText);
        task1bar = findViewById(R.id.task1bar);
        task2bar = findViewById(R.id.task2bar);
        task3bar = findViewById(R.id.task3bar);
        task4bar = findViewById(R.id.task4bar);

    }

    public void LumberTask(View view){

        int craftingcost = 0;
        int craftingtime = 0;
        int totalToCraft = Integer.parseInt(LumberQuantityText.getText().toString());

        if (totalToCraft == 0){

            return;
        }

        craftingcost = totalToCraft * 35;

        if(Inventory.Log_Quantity > craftingcost && iscraftinglumber == false){

            iscraftinglumber = true;

            craftingtime = totalToCraft * 3000;
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
            System.out.println("Already Crafting Lumber!");
            return;

        }
    }

    public void BrickTask(View view){
        int craftingcost = 0;
        int craftingtime = 0;
        int totalToCraft = Integer.parseInt(BrickQuantityText.getText().toString());

        if (totalToCraft == 0){

            return;
        }

        craftingcost = totalToCraft * 35;

        if(Inventory.Stone_Quantity > craftingcost && iscraftingbricks == false){

            iscraftingbricks = true;

            craftingtime = totalToCraft * 3000;

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
            System.out.println("Already Crafting Bricks!");
            return;

        }
    }
    public void FilletTask(View view){

        int craftingcost = 0;
        int craftingtime = 0;
        int totalToCraft = Integer.parseInt(FilletQuantityText.getText().toString());

        if (totalToCraft == 0){

            return;
        }

        craftingcost = totalToCraft * 35;

        if(Inventory.Fish_Quantity > craftingcost && iscraftingfillets == false){

            iscraftingfillets = true;

            craftingtime = totalToCraft * 3000;

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
            System.out.println("Already Crafting Fillets!");
            return;

        }
    }
    public void BreadTask(View view){
        int craftingcost = 0;
        int craftingtime = 0;
        int totalToCraft = Integer.parseInt(BreadQuantityText.getText().toString());

        if (totalToCraft == 0){

            return;
        }

        craftingcost = totalToCraft * 8;

        if(Inventory.Wheat_Quantity > craftingcost && iscraftingbreads == false){

            iscraftingbreads = true;

            craftingtime = totalToCraft * 3000;

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
            System.out.println("Already Crafting Bread!");
            return;

        }
    }
}
