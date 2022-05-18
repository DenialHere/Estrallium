package com.example.test_activity.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test_activity.Inventory.Inventory;
import com.example.test_activity.Inventory.Rare;
import com.example.test_activity.R;
import com.example.test_activity.Skills.Woodcutting;

public class InventoryActivity extends AppCompatActivity {

    TextView Logs, Stones, Wheat, Fish, Logsrare, Stonesrare, Wheatrare, Fishrare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inventory);
        Logs = findViewById(R.id.LogsDisplay);
        Logs.setText(String.valueOf(Inventory.getLog_Quantity()));
        Stones = findViewById(R.id.StoneDisplay);
        Stones.setText(String.valueOf(Inventory.getStone_Quantity()));
        Wheat = findViewById(R.id.WheatDisplay);
        Wheat.setText(String.valueOf(Inventory.getWheat_Quantity()));
        Fish = findViewById(R.id.FishDisplay);
        Fish.setText(String.valueOf(Inventory.getFish_Quantity()));
        Logsrare = findViewById(R.id.MagicSeedDisplay);
        Logsrare.setText(String.valueOf(Rare.getMagic_Seeds()));
        Stonesrare = findViewById(R.id.CoarseStoneDisplay);
        Wheatrare = findViewById(R.id.GiantSeedDisplay);
        Wheatrare.setText(String.valueOf(Rare.getGiant_Wheat_Seeds()));
        Fishrare = findViewById(R.id.ArtifactDisplay);
        Fishrare.setText(String.valueOf(Rare.get_Artifacts()));
    }
    public void goBack(View view){

        Intent intent = new Intent(this, BuildingsActivity.class);
        startActivity(intent);

    }

}
