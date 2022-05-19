package com.example.test_activity.Activities;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test_activity.Inventory.Inventory;
import com.example.test_activity.Inventory.Kingdom;
import com.example.test_activity.R;
import com.example.test_activity.Skills.Player;

public class KingdomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kingdom);
        GetRequirements();



    }

    private void GetRequirements()
    {
        Kingdom.getRequirements();


        //DECLARING ALL TEXT VIEWS
        TextView kingdomLevel = findViewById(R.id.textViewKingdomLevelKingdom);
        TextView playerLevel = findViewById(R.id.textViewPlayerLevelKingdom);
        TextView rewards = findViewById(R.id.textViewRewardsKingdom);

        //NEEDED RESOURCES
        TextView woodNeeded = findViewById(R.id.textViewWoodNeededKingdom);
        TextView stoneNeeded = findViewById(R.id.textViewStoneNeededKingdom);

        //TEXT VIEWS
        TextView stoneText = findViewById(R.id.textViewStoneKingdom);
        TextView woodText = findViewById(R.id.textViewWoodKingdom);


        //HIDING ELEMENTS THAT ARE NOT REQUIRED
        //WOOD
        if (Kingdom.Requirements[1] == 0){
            woodNeeded.setVisibility(View.INVISIBLE);
            woodText.setVisibility(View.INVISIBLE);
        }
        else {
            woodNeeded.setVisibility(View.VISIBLE);
            woodNeeded.setVisibility(View.VISIBLE);
        }
        //STONE
        if (Kingdom.Requirements[2] == 0){
            stoneNeeded.setVisibility(View.INVISIBLE);
            stoneText.setVisibility(View.INVISIBLE);
        }
        else {
            stoneNeeded.setVisibility(View.VISIBLE);
            stoneText.setVisibility(View.VISIBLE);
        }


        //Setting the requirements
        kingdomLevel.setText(Integer.toString(Kingdom.Level));
        playerLevel.setText(Integer.toString(Kingdom.Requirements[0]));
        woodNeeded.setText(Integer.toString(Kingdom.Requirements[1]));
        stoneNeeded.setText(Integer.toString(Kingdom.Requirements[2]));
        rewards.setText(Kingdom.GetRewardsText());

        //Setting text color if player meets requirements or not
        if (Player.Level < Integer.parseInt(playerLevel.getText().toString())){
            playerLevel.setTextColor(Color.RED);
        }
        else
        {
            playerLevel.setTextColor(Color.GREEN);
        }

        if (Inventory.Log_Quantity < Integer.parseInt(woodNeeded.getText().toString())){
            woodNeeded.setTextColor(Color.RED);
        }
        else
        {
            woodNeeded.setTextColor(Color.GREEN);
        }
        if (Inventory.Stone_Quantity < Integer.parseInt(stoneNeeded.getText().toString())){
            stoneNeeded.setTextColor(Color.RED);
        }
        else
        {
            stoneNeeded.setTextColor(Color.GREEN);
        }
    }

    public void LevelUp(View view){
        Kingdom.LevelUp();
        GetRequirements();
    }

}
