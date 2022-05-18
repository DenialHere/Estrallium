package com.example.test_activity.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test_activity.Inventory.Inventory;
import com.example.test_activity.Inventory.Rare;
import com.example.test_activity.R;
import com.example.test_activity.Resources.Logs;
import com.example.test_activity.Skills.Farming;
import com.example.test_activity.Skills.Woodcutting;

public class FarmActivity extends AppCompatActivity {
    TextView WheatCount, GiantWheatSeed, FarmingLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.farm);
        WheatCount = findViewById(R.id.WheatDisplay);
        GiantWheatSeed = findViewById(R.id.GiantSeedDisplay);
        FarmingLevel = findViewById(R.id.FarmingLevelDisplay);
    }
    public void goToBuildingsActivity(View view){

        Intent intent = new Intent(this, BuildingsActivity.class);
        startActivity(intent);

    }
    public void goToCashShopActivity(View view){

        Intent intent = new Intent(this, CashShopActivity.class);
        startActivity(intent);

    }
    public void goToInventoryActivity(View view){

        Intent intent = new Intent(this, InventoryActivity.class);
        startActivity(intent);

    }
    public void goToRefineryActivity(View view){


    }
    public void goToStoreActivity(View view){

        Intent intent = new Intent(this, StoreActivity.class);
        startActivity(intent);

    }
    public void TapWheat(View view){

        Farming.AddExp();
        FarmingLevel.setText(String.valueOf(Farming.getLevel()));
        Rare.checkForRareDrop(4);
        GiantWheatSeed.setText(String.valueOf(Rare.getGiant_Wheat_Seeds()));
        Inventory.AddResource(4);
        WheatCount.setText(String.valueOf(Inventory.getWheat_Quantity()));

    }

}

