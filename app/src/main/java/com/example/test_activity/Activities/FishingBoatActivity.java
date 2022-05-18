package com.example.test_activity.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test_activity.Inventory.Rare;
import com.example.test_activity.R;
import com.example.test_activity.Resources.Logs;
import com.example.test_activity.Inventory.Inventory;
import com.example.test_activity.Skills.Fishing;
import com.example.test_activity.Skills.Woodcutting;

public class FishingBoatActivity extends AppCompatActivity {

    TextView fishcount, artifactcount, fishinglevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fishingboat);
        fishcount = findViewById(R.id.FishDisplay);
        artifactcount = findViewById(R.id.ArtifactDisplay);
        fishinglevel = findViewById(R.id.FishingLevelDisplay);
    }
    public void goToBuildingsActivity(View view){

        Intent intent = new Intent(this, BuildingsActivity.class);
        startActivity(intent);

    }
    public void goToInventoryActivity(View view){

        Intent intent = new Intent(this, InventoryActivity.class);
        startActivity(intent);

    }
    public void goToRefineryActivity(View view){


    }
    public void goToCashShopActivity(View view){

        Intent intent = new Intent(this, CashShopActivity.class);
        startActivity(intent);

    }
    public void goToStoreActivity(View view){

        Intent intent = new Intent(this, StoreActivity.class);
        startActivity(intent);

    }
    public void TapFish(View view) {

        Fishing.AddExp();
        fishinglevel.setText(String.valueOf(Fishing.getLevel()));
        Rare.checkForRareDrop(3);
        artifactcount.setText(String.valueOf(Rare.get_Artifacts()));
        Inventory.AddResource(3);
        fishcount.setText(String.valueOf(Inventory.getFish_Quantity()));

    }

}
