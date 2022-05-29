package com.example.test_activity.Activities;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test_activity.Constants;
import com.example.test_activity.Inventory.Inventory;
import com.example.test_activity.Inventory.Shop;
import com.example.test_activity.Managers.DialogueManager;
import com.example.test_activity.R;
import com.example.test_activity.Skills.Player;

public class StoreActivity extends AppCompatActivity {
    TextView logsPricePer, stonePricePer, fishPricePer, farmPricePer,
            logPrice, stonePrice, fishPrice, farmPrice;
    TextView gold;
    EditText logQuantity,stoneQuantity,fishQuantity,farmQuantity;
    Button btnBuyLogs, btnBuyStone, btnBuyFish, btnBuyFarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store);

        //Setting coin value
        UpdateCoins();

        //setting total price
        logPrice = findViewById(R.id.textViewPriceLogs);
        stonePrice = findViewById(R.id.textViewPriceStone);
        fishPrice = findViewById(R.id.textViewPriceFish);
        farmPrice = findViewById(R.id.textViewPriceFarm);

        //setting buy/sell buttons
        btnBuyLogs = findViewById(R.id.buttonShopLogs);
        btnBuyStone = findViewById(R.id.buttonShopStone);
        btnBuyFish = findViewById(R.id.buttonShopFish);
        btnBuyFarm = findViewById(R.id.buttonShopFarm);

        //setting price per
        logsPricePer = findViewById(R.id.textViewLogsPricePer);
        stonePricePer = findViewById(R.id.textViewStonePricePer);
        fishPricePer = findViewById(R.id.textViewFishPricePer);
        farmPricePer = findViewById(R.id.textViewFarmPricePer);

        //Grabbing prices from shop class and putting them in text views
        logsPricePer.setText(Shop.PricePer(Shop.LogPrice));
        stonePricePer.setText(Shop.PricePer(Shop.StonePrice));
        fishPricePer.setText(Shop.PricePer(Shop.FishPrice));
        farmPricePer.setText(Shop.PricePer(Shop.FarmPrice));

        //setting the edit texts of quantities
        logQuantity = findViewById(R.id.editTextLogs);
        stoneQuantity = findViewById(R.id.editTextStone);
        fishQuantity = findViewById(R.id.editTextFish);
        farmQuantity = findViewById(R.id.editTextFarm);


        //Disabling if player doesnt meet requirements
        if (Player.Level < Constants.miningLevelRequiredForPlot){
            btnBuyStone.setEnabled(false);
            stoneQuantity.setEnabled(false);
        }
        if (Player.Level < Constants.fishingLevelRequiredForPlot){
            btnBuyFish.setEnabled(false);
            fishQuantity.setEnabled(false);
        }
        if (Player.Level < Constants.farmingLevelRequiredForPlot){
            btnBuyFarm.setEnabled(false);
            farmQuantity.setEnabled(false);
        }

        //on text change of edit texts
        //on text change of logs
        logQuantity.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                try {
                    logPrice.setText(Integer.toString(Shop.CalculatePrice(logQuantity.getText().toString(), Shop.LogPrice)));
                } catch (Exception e){
                    logPrice.setText(0);
                }

            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });

        //on text change of stone
        stoneQuantity.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                stonePrice.setText(Integer.toString(Shop.CalculatePrice(stoneQuantity.getText().toString(), Shop.StonePrice)));
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });

        //on text change of fish
        fishQuantity.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                fishPrice.setText(Integer.toString(Shop.CalculatePrice(fishQuantity.getText().toString(), Shop.FishPrice)));
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });

        //on text change of farm
        farmQuantity.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                farmPrice.setText(Integer.toString(Shop.CalculatePrice(farmQuantity.getText().toString(), Shop.FarmPrice)));
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });
    }

    public void UpdateCoins(){
        //Setting coins
        gold = findViewById(R.id.textViewCoins);
        gold.setText(Integer.toString(Inventory.Gold));
    }


    public void BuyButton(View view){
            switch (view.getId()){
                case R.id.buttonShopLogs:
                    if ( logQuantity.getText().toString().equals("")){
                        DialogueManager.ShowMessage(this, "Please select an amount" , 0, Gravity.CENTER);
                        break;
                    }
                    if (Shop.CalculatePrice(logQuantity.getText().toString(), Shop.LogPrice) > Inventory.Gold ){
                        DialogueManager.ShowMessage(this, " You don't have enough gold" , R.drawable.coin, Gravity.CENTER);
                    }
                    else {
                        Inventory.Gold -= Shop.CalculatePrice(logQuantity.getText().toString(), Shop.LogPrice);
                        UpdateCoins();
                        DialogueManager.ShowMessage(this, "You bought " + logQuantity.getText().toString() + " logs" , R.drawable.logs, Gravity.CENTER);
                        Inventory.Log_Quantity += Integer.parseInt(logQuantity.getText().toString());
                    }
                    break;
                case R.id.buttonShopStone:
                    if (stoneQuantity.getText().toString().equals("")){
                        DialogueManager.ShowMessage(this, "Please select an amount" , 0, Gravity.CENTER);
                        break;
                    }
                    if (Shop.CalculatePrice(stoneQuantity.getText().toString(), Shop.StonePrice) > Inventory.Gold ){
                        DialogueManager.ShowMessage(this, " You don't have enough gold" , R.drawable.coin, Gravity.CENTER);
                    }
                    else {
                        Inventory.Gold -= Shop.CalculatePrice(stoneQuantity.getText().toString(), Shop.StonePrice);
                        UpdateCoins();
                        DialogueManager.ShowMessage(this, "You bought " + stoneQuantity.getText().toString() + " stone" , R.drawable.ironore, Gravity.CENTER);
                        Inventory.Stone_Quantity += Integer.parseInt(stoneQuantity.getText().toString());
                    }
                    break;
                case R.id.buttonShopFish:
                    if (fishQuantity.getText().toString().equals("")){
                        DialogueManager.ShowMessage(this, "Please select an amount" , 0, Gravity.CENTER);
                        break;
                    }
                    if (Shop.CalculatePrice(fishQuantity.getText().toString(), Shop.FishPrice) > Inventory.Gold ){
                        DialogueManager.ShowMessage(this, " You don't have enough gold" , R.drawable.coin, Gravity.CENTER);
                    }
                    else {
                        Inventory.Gold -= Shop.CalculatePrice(fishQuantity.getText().toString(), Shop.FishPrice);
                        UpdateCoins();
                        DialogueManager.ShowMessage(this, "You bought " + fishQuantity.getText().toString() + " fish" , R.drawable.trout, Gravity.CENTER);
                        Inventory.Fish_Quantity += Integer.parseInt(fishQuantity.getText().toString());
                    }
                    break;
                case R.id.buttonShopFarm:
                    if (farmQuantity.getText().toString().equals("")){
                        DialogueManager.ShowMessage(this, "Please select an amount" , 0, Gravity.CENTER);
                        break;
                    }
                    if (Shop.CalculatePrice(farmQuantity.getText().toString(), Shop.FarmPrice) > Inventory.Gold ){
                        DialogueManager.ShowMessage(this, " You don't have enough gold" , R.drawable.coin, Gravity.CENTER);
                    }
                    else {
                        Inventory.Gold -= Shop.CalculatePrice(farmQuantity.getText().toString(), Shop.FarmPrice);
                        UpdateCoins();
                        DialogueManager.ShowMessage(this, "You bought " + farmQuantity.getText().toString() + " wheat" , R.drawable.grain, Gravity.CENTER);
                        Inventory.Wheat_Quantity += Integer.parseInt(farmQuantity.getText().toString());
                    }
                    break;
            }
            }

    }








