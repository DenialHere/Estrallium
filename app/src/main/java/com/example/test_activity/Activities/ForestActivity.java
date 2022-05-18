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
import com.example.test_activity.Skills.Woodcutting;

public class ForestActivity extends AppCompatActivity {

    TextView logcount, magicseedcount, woodcuttinglevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forest);
        logcount = findViewById(R.id.LogsDisplay);
        magicseedcount = findViewById(R.id.MagicSeedDisplay);
        woodcuttinglevel = findViewById(R.id.WoodcuttingLevelDisplay);
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
    public void goToStoreActivity(View view){

        Intent intent = new Intent(this, StoreActivity.class);
        startActivity(intent);

    }
    public void goToCashShopActivity(View view){

        Intent intent = new Intent(this, CashShopActivity.class);
        startActivity(intent);

    }
    public void TapLogs(View view) {


        Rare.checkForRareDrop(1);
        magicseedcount.setText(String.valueOf(Rare.getMagic_Seeds()));
        Inventory.AddResource(1);
        logcount.setText(String.valueOf(Inventory.getLog_Quantity()));

    }

}
