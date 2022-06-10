package com.example.test_activity.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test_activity.Inventory.Inventory;
import com.example.test_activity.Inventory.Kingdom;
import com.example.test_activity.Managers.DialogueManager;
import com.example.test_activity.R;
import com.example.test_activity.Skills.Player;
import com.example.test_activity.Skills.Woodcutting;
import com.example.test_activity.Tasks;

public class TasksActivity extends AppCompatActivity {
    TextView task0, task1, task2, task3;
    Button task0Button,task1Button,task2Button, task3Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tasks);

        //Textview tasks
        task0 = findViewById(R.id.textViewTask0);
        task1 = findViewById(R.id.textViewTask1);
        task2 = findViewById(R.id.textViewTask2);
        task3 = findViewById(R.id.textViewTask3);

        //Complete buttons
        task0Button = findViewById(R.id.buttonCompleteTask0);
        task1Button = findViewById(R.id.buttonCompleteTask1);
        task2Button = findViewById(R.id.buttonCompleteTask2);
        task3Button = findViewById(R.id.buttonCompleteTask3);


        UpdateTasks();



    }

    public void UpdateTasks(){

        //Checking if has tasks
        if (Tasks.Scenario[0] == ""){
            task0.setText("No task at the moment.");
            task0Button.setEnabled(false);
        }
        else {
            task0.setText(Tasks.Scenario[0]);
        }

        if (Tasks.Scenario[1] == ""){
            task1.setText("No task at the moment.");
            task1Button.setEnabled(false);
        }
        else {
            task1.setText(Tasks.Scenario[1]);
        }

        if (Tasks.Scenario[2] == ""){
            task2.setText("No task at the moment.");
            task2Button.setEnabled(false);
        }
        else {
            task2.setText(Tasks.Scenario[2]);
        }

        if (Tasks.Scenario[3] == ""){
            task3.setText("No task at the moment.");
            task3Button.setEnabled(false);
        }
        else {
            task3.setText(Tasks.Scenario[3]);
        }
    }

    public void Task0Button(View view){
        Activity activity = this;
        switch (Tasks.ResourcesRequired[0][0]){
            case Inventory.WOOD:
                if (Inventory.Log_Quantity >= Tasks.ResourcesRequired[1][0]){
                    Inventory.Log_Quantity = Inventory.Log_Quantity - Tasks.ResourcesRequired[1][0];
                    TaskCompleted(activity, 0);
                    break;
                }
                DialogueManager.ShowMessage(activity, "You don't have the required resources.", R.drawable.villager, Gravity.CENTER);
                break;
            case Inventory.STONE:
                if (Inventory.Stone_Quantity >= Tasks.ResourcesRequired[1][0]){
                    Inventory.Stone_Quantity = Inventory.Stone_Quantity - Tasks.ResourcesRequired[1][0];
                    TaskCompleted(activity, 0);
                    break;
                }
                DialogueManager.ShowMessage(activity, "You don't have the required resources.", R.drawable.villager, Gravity.CENTER);
                break;
            case Inventory.FISH:
                if (Inventory.Fish_Quantity >= Tasks.ResourcesRequired[1][0]){
                    Inventory.Fish_Quantity = Inventory.Fish_Quantity - Tasks.ResourcesRequired[1][0];
                    TaskCompleted(activity, 0);
                    break;
                }
                DialogueManager.ShowMessage(activity, "You don't have the required resources.", R.drawable.villager, Gravity.CENTER);
                break;
            case Inventory.WHEAT:
                if (Inventory.Wheat_Quantity >= Tasks.ResourcesRequired[1][0]){
                    Inventory.Wheat_Quantity = Inventory.Wheat_Quantity - Tasks.ResourcesRequired[1][0];
                    TaskCompleted(activity, 0);
                    break;
                }
                DialogueManager.ShowMessage(activity, "You don't have the required resources.", R.drawable.villager, Gravity.CENTER);
                break;
        }

    }

    public void Task1Button(View view) {
        Activity activity = this;
        switch (Tasks.ResourcesRequired[0][1]) {
            case Inventory.WOOD:
                if (Inventory.Log_Quantity >= Tasks.ResourcesRequired[1][1]) {
                    Inventory.Log_Quantity = Inventory.Log_Quantity - Tasks.ResourcesRequired[1][1];
                    TaskCompleted(activity, 1);
                    break;
                }
                DialogueManager.ShowMessage(activity, "You don't have the required resources.", R.drawable.villager, Gravity.CENTER);
                break;
            case Inventory.STONE:
                if (Inventory.Stone_Quantity >= Tasks.ResourcesRequired[1][1]) {
                    Inventory.Stone_Quantity = Inventory.Stone_Quantity - Tasks.ResourcesRequired[1][1];
                    TaskCompleted(activity, 1);
                    break;
                }
                DialogueManager.ShowMessage(activity, "You don't have the required resources.", R.drawable.villager, Gravity.CENTER);
                break;
            case Inventory.FISH:
                if (Inventory.Fish_Quantity >= Tasks.ResourcesRequired[1][1]) {
                    Inventory.Fish_Quantity = Inventory.Fish_Quantity - Tasks.ResourcesRequired[1][1];
                    TaskCompleted(activity, 1);
                    break;
                }
                DialogueManager.ShowMessage(activity, "You don't have the required resources.", R.drawable.villager, Gravity.CENTER);
                break;
            case Inventory.WHEAT:
                if (Inventory.Wheat_Quantity >= Tasks.ResourcesRequired[1][1]) {
                    Inventory.Wheat_Quantity = Inventory.Wheat_Quantity - Tasks.ResourcesRequired[1][1];
                    TaskCompleted(activity, 1);
                    break;
                }
                DialogueManager.ShowMessage(activity, "You don't have the required resources.", R.drawable.villager, Gravity.CENTER);
                break;
        }
    }

    public void Task2Button(View view) {
        Activity activity = this;
        switch (Tasks.ResourcesRequired[0][2]) {
            case Inventory.WOOD:
                if (Inventory.Log_Quantity >= Tasks.ResourcesRequired[1][2]) {
                    Inventory.Log_Quantity = Inventory.Log_Quantity - Tasks.ResourcesRequired[1][2];
                    TaskCompleted(activity, 2);
                    break;
                }
                DialogueManager.ShowMessage(activity, "You don't have the required resources.", R.drawable.villager, Gravity.CENTER);
                break;
            case Inventory.STONE:
                if (Inventory.Stone_Quantity >= Tasks.ResourcesRequired[1][2]) {
                    Inventory.Stone_Quantity = Inventory.Stone_Quantity - Tasks.ResourcesRequired[1][2];
                    TaskCompleted(activity, 2);
                    break;
                }
                DialogueManager.ShowMessage(activity, "You don't have the required resources.", R.drawable.villager, Gravity.CENTER);
                break;
            case Inventory.FISH:
                if (Inventory.Fish_Quantity >= Tasks.ResourcesRequired[1][2]) {
                    Inventory.Fish_Quantity = Inventory.Fish_Quantity - Tasks.ResourcesRequired[1][2];
                    TaskCompleted(activity, 2);
                    break;
                }
                DialogueManager.ShowMessage(activity, "You don't have the required resources.", R.drawable.villager, Gravity.CENTER);
                break;
            case Inventory.WHEAT:
                if (Inventory.Wheat_Quantity >= Tasks.ResourcesRequired[1][2]) {
                    Inventory.Wheat_Quantity = Inventory.Wheat_Quantity - Tasks.ResourcesRequired[1][2];
                    TaskCompleted(activity, 2);
                    break;
                }
                DialogueManager.ShowMessage(activity, "You don't have the required resources.", R.drawable.villager, Gravity.CENTER);
                break;
        }
    }

    public void Task3Button(View view) {
        Activity activity = this;
        switch (Tasks.ResourcesRequired[0][3]) {
            case Inventory.WOOD:
                if (Inventory.Log_Quantity >= Tasks.ResourcesRequired[1][3]) {
                    Inventory.Log_Quantity = Inventory.Log_Quantity - Tasks.ResourcesRequired[1][3];
                    TaskCompleted(activity, 3);
                    break;
                }
                DialogueManager.ShowMessage(activity, "You don't have the required resources.", R.drawable.villager, Gravity.CENTER);
                break;
            case Inventory.STONE:
                if (Inventory.Stone_Quantity >= Tasks.ResourcesRequired[1][3]) {
                    Inventory.Stone_Quantity = Inventory.Stone_Quantity - Tasks.ResourcesRequired[1][3];
                    TaskCompleted(activity, 3);
                    break;
                }
                DialogueManager.ShowMessage(activity, "You don't have the required resources.", R.drawable.villager, Gravity.CENTER);
                break;
            case Inventory.FISH:
                if (Inventory.Fish_Quantity >= Tasks.ResourcesRequired[1][3]) {
                    Inventory.Fish_Quantity = Inventory.Fish_Quantity - Tasks.ResourcesRequired[1][3];
                    TaskCompleted(activity, 3);
                    break;
                }
                DialogueManager.ShowMessage(activity, "You don't have the required resources.", R.drawable.villager, Gravity.CENTER);
                break;
            case Inventory.WHEAT:
                if (Inventory.Wheat_Quantity >= Tasks.ResourcesRequired[1][3]) {
                    Inventory.Wheat_Quantity = Inventory.Wheat_Quantity - Tasks.ResourcesRequired[1][3];
                    TaskCompleted(activity, 3);
                    break;
                }
                DialogueManager.ShowMessage(activity, "You don't have the required resources.", R.drawable.villager, Gravity.CENTER);
                break;
        }
    }


        public void TaskCompleted(Activity activity, int scenario){
        Kingdom.Favour = Kingdom.Favour + 0.5;
        DialogueManager.ShowMessage(activity, "Thank you so much, your actions won't be forgotten. ", R.drawable.villager, Gravity.CENTER);
        Tasks.AmountOfTasks--;
        Tasks.Scenario[scenario] = "";
        UpdateTasks();

    }
}
