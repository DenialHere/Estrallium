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
    Button btnBuyLogs, btnBuyStone, btnBuyFish, btnBuyFarm, btnBuySell;

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
        btnBuySell = findViewById(R.id.buttonBuySell);
        btnBuySell.setTag(0);

        //setting price per
        logsPricePer = findViewById(R.id.textViewLogsPricePer);
        stonePricePer = findViewById(R.id.textViewStonePricePer);
        fishPricePer = findViewById(R.id.textViewFishPricePer);
        farmPricePer = findViewById(R.id.textViewFarmPricePer);

        //Grabbing prices from shop class and putting them in text views
        logsPricePer.setText(Shop.PricePer(Shop.LogBuyPrice));
        stonePricePer.setText(Shop.PricePer(Shop.StoneBuyPrice));
        fishPricePer.setText(Shop.PricePer(Shop.FishBuyPrice));
        farmPricePer.setText(Shop.PricePer(Shop.FarmBuyPrice));

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
                    if (btnBuySell.getTag().equals(0)){
                        logPrice.setText(Integer.toString(Shop.CalculatePrice(logQuantity.getText().toString(), Shop.LogBuyPrice)));
                    }
                    else {
                        if (Integer.parseInt(logQuantity.getText().toString()) > Inventory.Log_Quantity)
                        {
                            logQuantity.setText(Integer.toString(Inventory.Log_Quantity));
                        }
                        logPrice.setText(Integer.toString(Shop.CalculatePrice(logQuantity.getText().toString(), Shop.LogSellPrice)));
                    }
                } catch (Exception e){
                    logPrice.setText("0");
                }

            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });

        //on text change of stone
        stoneQuantity.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                try {
                if (btnBuySell.getTag().equals(0))
                {
                    stonePrice.setText(Integer.toString(Shop.CalculatePrice(stoneQuantity.getText().toString(), Shop.StoneBuyPrice)));
                }
                else
                {
                    if (Integer.parseInt(stoneQuantity.getText().toString()) > Inventory.Stone_Quantity)
                    {
                        stoneQuantity.setText(Integer.toString(Inventory.Stone_Quantity));
                    }
                    stonePrice.setText(Integer.toString(Shop.CalculatePrice(stoneQuantity.getText().toString(), Shop.StoneSellPrice)));
                }
            } catch (Exception e){
                    stonePrice.setText("0");
                }
                }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });

        //on text change of fish
        fishQuantity.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                try {
                    if (btnBuySell.getTag().equals(0)) {
                        fishPrice.setText(Integer.toString(Shop.CalculatePrice(fishQuantity.getText().toString(), Shop.FishBuyPrice)));
                    } else {
                        if (Integer.parseInt(fishQuantity.getText().toString()) > Inventory.Fish_Quantity) {
                            fishQuantity.setText(Integer.toString(Inventory.Fish_Quantity));
                        }
                        fishPrice.setText(Integer.toString(Shop.CalculatePrice(fishQuantity.getText().toString(), Shop.FishSellPrice)));
                    }
                }catch (Exception e){
                    fishPrice.setText("0");
                }
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });

        //on text change of farm
        farmQuantity.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                try {
                    if (btnBuySell.getTag().equals(0)) {
                        farmPrice.setText(Integer.toString(Shop.CalculatePrice(farmQuantity.getText().toString(), Shop.FarmBuyPrice)));
                    } else {
                        if (Integer.parseInt(farmQuantity.getText().toString()) > Inventory.Wheat_Quantity) {
                            farmQuantity.setText(Integer.toString(Inventory.Wheat_Quantity));
                        }
                        farmPrice.setText(Integer.toString(Shop.CalculatePrice(farmQuantity.getText().toString(), Shop.FarmSellPrice)));
                    }
                } catch (Exception e){
                    farmPrice.setText("0");
                }
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });
    }

    public void UpdateCoins()
    {
        //Setting coins
        gold = findViewById(R.id.textViewCoins);
        gold.setText(Integer.toString(Inventory.Gold));
    }

    public void UpdateSellAmounts()
    {
        logQuantity.setHint(Integer.toString(Inventory.Log_Quantity));
        stoneQuantity.setHint(Integer.toString(Inventory.Stone_Quantity));
        fishQuantity.setHint(Integer.toString(Inventory.Fish_Quantity));
        farmQuantity.setHint(Integer.toString(Inventory.Wheat_Quantity));
    }

    public void BuySellButton(View view)
    {

        //Switching to sell
        if (btnBuySell.getTag().equals(0))
        {
            btnBuyLogs.setText("Sell");
            btnBuyStone.setText("Sell");
            btnBuyFish.setText("Sell");
            btnBuyFarm.setText("Sell");
            btnBuySell.setText("Buy");

            logsPricePer.setText(Shop.PricePer(Shop.LogSellPrice));
            stonePricePer.setText(Shop.PricePer(Shop.StoneSellPrice));
            fishPricePer.setText(Shop.PricePer(Shop.FishSellPrice));
            farmPricePer.setText(Shop.PricePer(Shop.FarmSellPrice));

            logPrice.setText(Integer.toString(Shop.CalculatePrice(logQuantity.getText().toString(), Shop.LogSellPrice)));
            stonePrice.setText(Integer.toString(Shop.CalculatePrice(stoneQuantity.getText().toString(), Shop.StoneSellPrice)));
            fishPrice.setText(Integer.toString(Shop.CalculatePrice(fishQuantity.getText().toString(), Shop.FishSellPrice)));
            farmPrice.setText(Integer.toString(Shop.CalculatePrice(farmQuantity.getText().toString(), Shop.FarmSellPrice)));

            logQuantity.setHint(Integer.toString(Inventory.Log_Quantity));
            stoneQuantity.setHint(Integer.toString(Inventory.Stone_Quantity));
            fishQuantity.setHint(Integer.toString(Inventory.Fish_Quantity));
            farmQuantity.setHint(Integer.toString(Inventory.Wheat_Quantity));
            btnBuySell.setTag(1);

        }
        //Switching to buy
        else {
            btnBuyLogs.setText("Buy");
            btnBuyStone.setText("Buy");
            btnBuyFish.setText("Buy");
            btnBuyFarm.setText("Buy");
            btnBuySell.setText("Sell");
            logsPricePer.setText(Shop.PricePer(Shop.LogBuyPrice));
            stonePricePer.setText(Shop.PricePer(Shop.StoneBuyPrice));
            fishPricePer.setText(Shop.PricePer(Shop.FishBuyPrice));
            farmPricePer.setText(Shop.PricePer(Shop.FarmBuyPrice));

            logPrice.setText(Integer.toString(Shop.CalculatePrice(logQuantity.getText().toString(), Shop.LogBuyPrice)));
            stonePrice.setText(Integer.toString(Shop.CalculatePrice(stoneQuantity.getText().toString(), Shop.StoneBuyPrice)));
            fishPrice.setText(Integer.toString(Shop.CalculatePrice(fishQuantity.getText().toString(), Shop.FishBuyPrice)));
            farmPrice.setText(Integer.toString(Shop.CalculatePrice(farmQuantity.getText().toString(), Shop.FarmBuyPrice)));

            logQuantity.setHint("0");
            stoneQuantity.setHint("0");
            fishQuantity.setHint("0");
            farmQuantity.setHint("0");
            btnBuySell.setTag(0);
        }
    }


    public void BuyButton(View view){

        btnBuySell = findViewById(R.id.buttonBuySell);
            switch (view.getId()){
                case R.id.buttonShopLogs:

                    if (logQuantity.getText().toString().equals("") || Integer.parseInt(logQuantity.getText().toString()) <= 0 ){
                        DialogueManager.ShowMessage(this, "Please select an amount" , 0, Gravity.CENTER);
                        break;
                    }
                    //Buying
                    if (btnBuySell.getTag().equals(0))
                    {
                        if (Shop.CalculatePrice(logQuantity.getText().toString(), Shop.LogBuyPrice) > Inventory.Gold ){
                            DialogueManager.ShowMessage(this, " You don't have enough gold" , R.drawable.coin, Gravity.CENTER);
                        }
                        else {
                            Inventory.Gold -= Shop.CalculatePrice(logQuantity.getText().toString(), Shop.LogBuyPrice);
                            UpdateCoins();
                            DialogueManager.ShowMessage(this, "You bought " + logQuantity.getText().toString() + " logs" , R.drawable.logs, Gravity.CENTER);
                            Inventory.Log_Quantity += Integer.parseInt(logQuantity.getText().toString());
                        }
                        break;
                    }
                    //Selling
                    else {
                        if (Integer.parseInt(logQuantity.getText().toString()) > Inventory.Log_Quantity){
                            DialogueManager.ShowMessage(this, " You don't have enough logs" , R.drawable.logs, Gravity.CENTER);
                        }
                        else {
                            Inventory.Gold += Shop.CalculatePrice(logQuantity.getText().toString(), Shop.LogSellPrice);
                            UpdateCoins();
                            UpdateSellAmounts();
                            DialogueManager.ShowMessage(this, "You Sold " + logQuantity.getText().toString() + " logs" , R.drawable.logs, Gravity.CENTER);
                            Inventory.Log_Quantity -= Integer.parseInt(logQuantity.getText().toString());
                        }
                        break;
                    }

                case R.id.buttonShopStone:

                    if (stoneQuantity.getText().toString().equals("") || Integer.parseInt(stoneQuantity.getText().toString()) <= 0 ){
                        DialogueManager.ShowMessage(this, "Please select an amount" , 0, Gravity.CENTER);
                        break;
                    }
                    //Buying
                    if (btnBuySell.getTag().equals(0))
                    {
                        if (Shop.CalculatePrice(stoneQuantity.getText().toString(), Shop.StoneBuyPrice) > Inventory.Gold) {
                            DialogueManager.ShowMessage(this, " You don't have enough gold", R.drawable.coin, Gravity.CENTER);
                        } else {
                            Inventory.Gold -= Shop.CalculatePrice(stoneQuantity.getText().toString(), Shop.StoneBuyPrice);
                            UpdateCoins();
                            DialogueManager.ShowMessage(this, "You bought " + stoneQuantity.getText().toString() + " stone", R.drawable.ironore, Gravity.CENTER);
                            Inventory.Stone_Quantity += Integer.parseInt(stoneQuantity.getText().toString());
                        }

                    }
                    //Selling
                    else
                    {
                        if (Integer.parseInt(stoneQuantity.getText().toString()) > Inventory.Stone_Quantity) {
                            DialogueManager.ShowMessage(this, " You don't have enough Stone", R.drawable.ironore, Gravity.CENTER);
                        } else {
                            Inventory.Gold += Shop.CalculatePrice(stoneQuantity.getText().toString(), Shop.StoneSellPrice);
                            UpdateCoins();
                            UpdateSellAmounts();
                            DialogueManager.ShowMessage(this, "You Sold " + stoneQuantity.getText().toString() + " Stone" , R.drawable.ironore, Gravity.CENTER);
                            Inventory.Stone_Quantity -= Integer.parseInt(stoneQuantity.getText().toString());
                        }
                    }
                    break;
                case R.id.buttonShopFish:
                    if (fishQuantity.getText().toString().equals("") || Integer.parseInt(fishQuantity.getText().toString()) <= 0 ){
                        DialogueManager.ShowMessage(this, "Please select an amount" , 0, Gravity.CENTER);
                        break;
                    }
                    if (btnBuySell.getTag().equals(0))
                    {
                        if (Shop.CalculatePrice(fishQuantity.getText().toString(), Shop.FishBuyPrice) > Inventory.Gold) {
                            DialogueManager.ShowMessage(this, " You don't have enough gold", R.drawable.coin, Gravity.CENTER);
                        } else {
                            Inventory.Gold -= Shop.CalculatePrice(fishQuantity.getText().toString(), Shop.FishBuyPrice);
                            UpdateCoins();
                            DialogueManager.ShowMessage(this, "You bought " + fishQuantity.getText().toString() + " fish", R.drawable.trout, Gravity.CENTER);
                            Inventory.Fish_Quantity += Integer.parseInt(fishQuantity.getText().toString());
                        }
                    }
                    //Selling
                    else
                    {
                        if (Integer.parseInt(fishQuantity.getText().toString()) > Inventory.Fish_Quantity) {
                            DialogueManager.ShowMessage(this, " You don't have enough fish", R.drawable.trout, Gravity.CENTER);
                        } else {
                            Inventory.Gold += Shop.CalculatePrice(fishQuantity.getText().toString(), Shop.FishSellPrice);
                            UpdateCoins();
                            UpdateSellAmounts();
                            DialogueManager.ShowMessage(this, "You Sold " + fishQuantity.getText().toString() + " fish" , R.drawable.trout, Gravity.CENTER);
                            Inventory.Fish_Quantity -= Integer.parseInt(fishQuantity.getText().toString());
                        }

                    }
                    break;
                case R.id.buttonShopFarm:
                    if (farmQuantity.getText().toString().equals("") || Integer.parseInt(farmQuantity.getText().toString()) <= 0){
                        DialogueManager.ShowMessage(this, "Please select an amount" , 0, Gravity.CENTER);
                        break;
                    }
                    if (Shop.CalculatePrice(farmQuantity.getText().toString(), Shop.FarmBuyPrice) > Inventory.Gold ){
                        DialogueManager.ShowMessage(this, " You don't have enough gold" , R.drawable.coin, Gravity.CENTER);
                    }
                    else {
                        Inventory.Gold -= Shop.CalculatePrice(farmQuantity.getText().toString(), Shop.FarmBuyPrice);
                        UpdateCoins();
                        DialogueManager.ShowMessage(this, "You bought " + farmQuantity.getText().toString() + " wheat" , R.drawable.grain, Gravity.CENTER);
                        Inventory.Wheat_Quantity += Integer.parseInt(farmQuantity.getText().toString());
                    }
                    break;
            }
            }

    }








