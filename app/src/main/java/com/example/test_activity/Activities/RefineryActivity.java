package com.example.test_activity.Activities;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test_activity.Inventory.Inventory;
import com.example.test_activity.Inventory.Refinery;
import com.example.test_activity.R;
import com.example.test_activity.Tasks;

public class RefineryActivity extends AppCompatActivity {

    static TextView amount, previewbox;
    static CheckBox bricks,gravel,mortar,lumber,planks,sawdust,bread,stew,sandwich,oil,fillet,bones;
    @Override
    public void onBackPressed() {
        Tasks.IsEnabled = true;
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.refinery);

        amount = findViewById(R.id.quantityboxrefinery);
        previewbox = findViewById(R.id.previewbox);

        bricks = findViewById(R.id.brickbox);
        gravel = findViewById(R.id.gravelbox);
        mortar = findViewById(R.id.mortarbox);

        lumber = findViewById(R.id.lumberbox);
        planks = findViewById(R.id.plankbox);
        sawdust = findViewById(R.id.sawdustbox);

        bread = findViewById(R.id.breadbox);
        stew = findViewById(R.id.stewbox);
        sandwich = findViewById(R.id.sandwichbox);

        oil = findViewById(R.id.oilbox);
        fillet = findViewById(R.id.filletbox);
        bones = findViewById(R.id.bonesbox);
    }

    public void Refine(View view){

        int craftingcost = 0;
        int craftingtime = 0;

        if (bricks.isChecked()){

           craftingcost = Integer.parseInt(amount.getText().toString()) * 5;

           if (Inventory.Stone_Quantity > craftingcost){

               craftingtime = Integer.parseInt(amount.getText().toString()) * 10000;

               int finalCraftingcost = craftingcost;
               new CountDownTimer(craftingtime, 1000) {

                   public void onTick(long millisUntilFinished) {
                       previewbox.setText("seconds remaining: " + millisUntilFinished / 1000);
                       //here you can have your logic to set text to edittext
                   }

                   public void onFinish() {
                       Refinery.CraftBrick(Integer.parseInt(amount.getText().toString()));
                       Inventory.Stone_Quantity = Inventory.Stone_Quantity - finalCraftingcost;
                       previewbox.setText("Bricks are done!");
                   }

               }.start();

           }else{

               System.out.println("Not enough crafting Materials!");

           }
        }else if (gravel.isChecked()){

            craftingcost = Integer.parseInt(amount.getText().toString()) * 3;

            if (Inventory.Stone_Quantity > craftingcost){

                craftingtime = Integer.parseInt(amount.getText().toString()) * 8000;

                int finalCraftingcost = craftingcost;
                new CountDownTimer(craftingtime, 1000) {

                    public void onTick(long millisUntilFinished) {
                        previewbox.setText("seconds remaining: " + millisUntilFinished / 1000);
                        //here you can have your logic to set text to edittext
                    }

                    public void onFinish() {
                        Refinery.CraftGravel(Integer.parseInt(amount.getText().toString()));
                        Inventory.Stone_Quantity = Inventory.Stone_Quantity - finalCraftingcost;
                        previewbox.setText("Gravel is done!");
                        System.out.println(Refinery.Gravel);
                    }

                }.start();
            }else{

                System.out.println("Not enough crafting Materials!");

            }
        }else if (mortar.isChecked()){
            craftingcost = Integer.parseInt(amount.getText().toString()) * 70;

            if (Inventory.Stone_Quantity > craftingcost){

                craftingtime = Integer.parseInt(amount.getText().toString()) * 35000;

                int finalCraftingcost = craftingcost;
                new CountDownTimer(craftingtime, 1000) {

                    public void onTick(long millisUntilFinished) {
                        previewbox.setText("seconds remaining: " + millisUntilFinished / 1000);
                        //here you can have your logic to set text to edittext
                    }

                    public void onFinish() {
                        Refinery.CraftMortar(Integer.parseInt(amount.getText().toString()));
                        Inventory.Stone_Quantity = Inventory.Stone_Quantity - finalCraftingcost;
                        previewbox.setText("Mortar is done!");
                        System.out.println(Refinery.Mortar);
                    }

                }.start();
            }else{

                System.out.println("Not enough crafting Materials!");

            }
        }else if (lumber.isChecked()){
            craftingcost = Integer.parseInt(amount.getText().toString()) * 2;

            if (Inventory.Log_Quantity > craftingcost){

                int finalCraftingcost = craftingcost;
                new CountDownTimer(craftingtime, 1000) {

                    public void onTick(long millisUntilFinished) {
                        previewbox.setText("seconds remaining: " + millisUntilFinished / 1000);
                        //here you can have your logic to set text to edittext
                    }

                    public void onFinish() {
                        Refinery.CraftLumber(Integer.parseInt(amount.getText().toString()));
                        Inventory.Log_Quantity = Inventory.Log_Quantity - finalCraftingcost;
                        previewbox.setText("Lumber is done!");
                        System.out.println(Refinery.Lumber);
                    }

                }.start();
            }else{

                System.out.println("Not enough crafting Materials!");

            }
        }else if (planks.isChecked()){
            craftingcost = Integer.parseInt(amount.getText().toString()) * 10;

            if (Inventory.Log_Quantity > craftingcost){

                int finalCraftingcost = craftingcost;
                new CountDownTimer(craftingtime, 1000) {

                    public void onTick(long millisUntilFinished) {
                        previewbox.setText("seconds remaining: " + millisUntilFinished / 1000);
                        //here you can have your logic to set text to edittext
                    }

                    public void onFinish() {
                        Refinery.CraftPlank(Integer.parseInt(amount.getText().toString()));
                        Inventory.Log_Quantity = Inventory.Log_Quantity - finalCraftingcost;
                        previewbox.setText("Planks are done!");
                        System.out.println(Refinery.Plank);
                    }

                }.start();
            }else{

                System.out.println("Not enough crafting Materials!");

            }
        }else if (sawdust.isChecked()){
            craftingcost = Integer.parseInt(amount.getText().toString()) * 1;

            if (Inventory.Log_Quantity > craftingcost){

                int finalCraftingcost = craftingcost;
                new CountDownTimer(craftingtime, 1000) {

                    public void onTick(long millisUntilFinished) {
                        previewbox.setText("seconds remaining: " + millisUntilFinished / 1000);
                        //here you can have your logic to set text to edittext
                    }

                    public void onFinish() {
                        Refinery.CraftSawdust(Integer.parseInt(amount.getText().toString()));
                        Inventory.Log_Quantity = Inventory.Log_Quantity - finalCraftingcost;
                        previewbox.setText("Sawdust is done!");
                        System.out.println(Refinery.Sawdust);
                    }

                }.start();
            }else{

                System.out.println("Not enough crafting Materials!");

            }
        }else if (bread.isChecked()){
            craftingcost = Integer.parseInt(amount.getText().toString()) * 70;

            if (Inventory.Wheat_Quantity > craftingcost){

                int finalCraftingcost = craftingcost;
                new CountDownTimer(craftingtime, 1000) {

                    public void onTick(long millisUntilFinished) {
                        previewbox.setText("seconds remaining: " + millisUntilFinished / 1000);
                        //here you can have your logic to set text to edittext
                    }

                    public void onFinish() {
                        Refinery.CraftBread(Integer.parseInt(amount.getText().toString()));
                        Inventory.Wheat_Quantity = Inventory.Wheat_Quantity - finalCraftingcost;
                        previewbox.setText("Bread is done!");
                        System.out.println(Refinery.Bread);
                    }

                }.start();

            }else{

                System.out.println("Not enough crafting Materials!");

            }
        }else if (stew.isChecked()){
            craftingcost = Integer.parseInt(amount.getText().toString()) * 70;

            if (Inventory.Wheat_Quantity > craftingcost){

                int finalCraftingcost = craftingcost;
                new CountDownTimer(craftingtime, 1000) {

                    public void onTick(long millisUntilFinished) {
                        previewbox.setText("seconds remaining: " + millisUntilFinished / 1000);
                        //here you can have your logic to set text to edittext
                    }

                    public void onFinish() {
                        Refinery.CraftStew(Integer.parseInt(amount.getText().toString()));
                        Inventory.Wheat_Quantity = Inventory.Wheat_Quantity - finalCraftingcost;
                        previewbox.setText("Stew is done!");
                        System.out.println(Refinery.Stew);
                    }

                }.start();

            }else{

                System.out.println("Not enough crafting Materials!");

            }
        }else if (sandwich.isChecked()){
            craftingcost = Integer.parseInt(amount.getText().toString()) * 70;

            if (Inventory.Wheat_Quantity > craftingcost){

                int finalCraftingcost = craftingcost;
                new CountDownTimer(craftingtime, 1000) {

                    public void onTick(long millisUntilFinished) {
                        previewbox.setText("seconds remaining: " + millisUntilFinished / 1000);
                        //here you can have your logic to set text to edittext
                    }

                    public void onFinish() {
                        Refinery.CraftStew(Integer.parseInt(amount.getText().toString()));
                        Inventory.Wheat_Quantity = Inventory.Wheat_Quantity - finalCraftingcost;
                        previewbox.setText("Sandwich is done!");
                        System.out.println(Refinery.Sandwich);
                    }

                }.start();

            }else{

                System.out.println("Not enough crafting Materials!");

            }
        }else if (oil.isChecked()){
            craftingcost = Integer.parseInt(amount.getText().toString()) * 70;

            if (Inventory.Fish_Quantity > craftingcost){

                int finalCraftingcost = craftingcost;
                new CountDownTimer(craftingtime, 1000) {

                    public void onTick(long millisUntilFinished) {
                        previewbox.setText("seconds remaining: " + millisUntilFinished / 1000);
                        //here you can have your logic to set text to edittext
                    }

                    public void onFinish() {
                        Refinery.CraftStew(Integer.parseInt(amount.getText().toString()));
                        Inventory.Fish_Quantity = Inventory.Fish_Quantity - finalCraftingcost;
                        previewbox.setText("Fish oil is done!");
                        System.out.println(Refinery.Oil);
                    }

                }.start();

            }else{

                System.out.println("Not enough crafting Materials!");

            }
        }else if (fillet.isChecked()){
            craftingcost = Integer.parseInt(amount.getText().toString()) * 70;

            if (Inventory.Fish_Quantity > craftingcost){

                int finalCraftingcost = craftingcost;
                new CountDownTimer(craftingtime, 1000) {

                    public void onTick(long millisUntilFinished) {
                        previewbox.setText("seconds remaining: " + millisUntilFinished / 1000);
                        //here you can have your logic to set text to edittext
                    }

                    public void onFinish() {
                        Refinery.CraftStew(Integer.parseInt(amount.getText().toString()));
                        Inventory.Fish_Quantity = Inventory.Fish_Quantity - finalCraftingcost;
                        previewbox.setText("Fillets are done!");
                        System.out.println(Refinery.Fillet);
                    }

                }.start();

            }else{

                System.out.println("Not enough crafting Materials!");

            }
        }else if (bones.isChecked()){
            craftingcost = Integer.parseInt(amount.getText().toString()) * 70;

            if (Inventory.Fish_Quantity > craftingcost){

                int finalCraftingcost = craftingcost;
                new CountDownTimer(craftingtime, 1000) {

                    public void onTick(long millisUntilFinished) {
                        previewbox.setText("seconds remaining: " + millisUntilFinished / 1000);
                        //here you can have your logic to set text to edittext
                    }

                    public void onFinish() {
                        Refinery.CraftStew(Integer.parseInt(amount.getText().toString()));
                        Inventory.Fish_Quantity = Inventory.Fish_Quantity - finalCraftingcost;
                        previewbox.setText("Bones are done!");
                        System.out.println(Refinery.Bones);
                    }

                }.start();

            }else{

                System.out.println("Not enough crafting Materials!");

            }
        }else{

            System.out.println("Nothing refined...");

        }

    }

}
