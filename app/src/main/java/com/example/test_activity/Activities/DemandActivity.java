package com.example.test_activity.Activities;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test_activity.Constants;
import com.example.test_activity.Inventory.Inventory;
import com.example.test_activity.Inventory.Kingdom;
import com.example.test_activity.Inventory.Workers;
import com.example.test_activity.Managers.DialogueManager;
import com.example.test_activity.R;
import com.example.test_activity.Skills.Player;
import com.example.test_activity.Tasks;

import java.util.Random;

public class DemandActivity extends AppCompatActivity {

    private static String demand;
    TextView demandTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demand_dialog);
        demandTextView = findViewById(R.id.textViewDemand);
        demandTextView.setText(Tasks.Demand);
        //Random event
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
               Refuse();
                handler.postDelayed(this, Tasks.TaskTimer);
            }
        }, Tasks.TaskTimer);
    }


    @Override
    public void onBackPressed() {
        Refuse();
    }

    public void GiveButton(View view){

        switch (Tasks.DemandRequired[0][0]) {
            case Inventory.WOOD:
                if (Inventory.Log_Quantity >= Tasks.DemandRequired[1][0]) {
                    Inventory.Log_Quantity = Inventory.Log_Quantity - Tasks.DemandRequired[1][0];
                    Kingdom.Favour = Kingdom.Favour + 0.5;
                    break;
                }
                DialogueManager.ShowMessage(this, "You don't have the required resources.", R.drawable.villager, Gravity.CENTER);
                break;
            case Inventory.STONE:
                if (Inventory.Stone_Quantity >= Tasks.DemandRequired[1][0]) {
                    Inventory.Stone_Quantity = Inventory.Stone_Quantity - Tasks.DemandRequired[1][0];
                    Kingdom.Favour = Kingdom.Favour + 0.5;
                    break;
                }
                DialogueManager.ShowMessage(this, "You don't have the required resources.", R.drawable.villager, Gravity.CENTER);
                break;
            case Inventory.FISH:
                if (Inventory.Fish_Quantity >= Tasks.DemandRequired[1][0]) {
                    Inventory.Fish_Quantity = Inventory.Fish_Quantity - Tasks.DemandRequired[1][0];
                    Kingdom.Favour = Kingdom.Favour + 0.5;
                    break;
                }
                DialogueManager.ShowMessage(this, "You don't have the required resources.", R.drawable.villager, Gravity.CENTER);
                break;
            case Inventory.WHEAT:
                if (Inventory.Wheat_Quantity >= Tasks.DemandRequired[1][0]) {
                    Inventory.Wheat_Quantity = Inventory.Wheat_Quantity - Tasks.DemandRequired[1][0];
                    Kingdom.Favour = Kingdom.Favour + 0.5;
                    break;
                }
                DialogueManager.ShowMessage(this, "You don't have the required resources.", R.drawable.villager, Gravity.CENTER);
                break;
        }
        finish();
    }

    public void RefuseButton(View view){
        Refuse();
    }

    public void Refuse(){
        Tasks.Demand = "";
        Tasks.DemandRequired[0][0] = 0;
        Tasks.DemandRequired[1][0] = 0;
        if (Kingdom.Favour <= 0){
            Kingdom.Favour = Kingdom.Favour - 0.5;
        }
        finish();
    }
}
