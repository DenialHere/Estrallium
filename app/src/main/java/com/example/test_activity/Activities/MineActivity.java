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
import com.example.test_activity.Skills.Mining;
import com.example.test_activity.Skills.Woodcutting;

public class MineActivity extends AppCompatActivity {

    TextView stonecount, coarsestonecount, mininglevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mine);
        stonecount = findViewById(R.id.ItemDisplay);
        coarsestonecount = findViewById(R.id.RaresDisplay);
        mininglevel = findViewById(R.id.LevelDisplay);
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
    public void TapStones(View view) {


        Rare.checkForRareDrop(2);
        Inventory.AddResource(2);
        stonecount.setText(String.valueOf(Inventory.getStone_Quantity()));

    }

}
