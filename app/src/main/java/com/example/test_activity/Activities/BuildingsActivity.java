package com.example.test_activity.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import com.example.test_activity.R;

public class BuildingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buildings);
    }

    public void goToForestActivity(View view){

        Intent intent = new Intent(this, ForestActivity.class);
        startActivity(intent);

    }
    public void goToFishingActivity(View view){

        Intent intent = new Intent(this, FishingBoatActivity.class);
        startActivity(intent);

    }
    public void goToFarmingActivity(View view){

        Intent intent = new Intent(this, FarmActivity.class);
        startActivity(intent);

    }
    public void goToMiningActivity(View view){

        Intent intent = new Intent(this, MineActivity.class);
        startActivity(intent);

    }

}
