package com.example.test_activity.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;

import com.example.test_activity.Activities.Workers;
import com.example.test_activity.Inventory.Inventory;
import com.example.test_activity.Inventory.Rare;
import com.example.test_activity.Managers.DialogueManager;
import com.example.test_activity.Managers.DialougeTest;
import com.example.test_activity.R;
import com.example.test_activity.Skills.Mining;
import com.example.test_activity.Skills.Player;
import com.example.test_activity.Skills.Woodcutting;

import java.util.Timer;
import java.util.TimerTask;


public class UiFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_ui, container, false);

        TextView textViewResource = (TextView) v.findViewById(R.id.textViewResource);
        TextView textViewRare = (TextView) v.findViewById(R.id.textViewRare);
        TextView textViewSkill = (TextView) v.findViewById(R.id.textViewSkill);
        TextView textViewPlayerLevel = (TextView) v.findViewById(R.id.textViewPlayerLevel);
        ImageButton imgBtn = v.findViewById(R.id.imageButtonResource);
        imgBtn.setTag(1);


        TimerTask timertask = new TimerTask() {
            @Override
            public void run() {
                Workers.AddResource_Worker(1);
                //textViewResource.setText(String.valueOf(Inventory.getLog_Quantity()));
            }
        };

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(timertask, 1000, 5000);


        imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewPlayerLevel.setText(Integer.toString(Player.Level));
                if (imgBtn.getTag().equals(1)){
                    Inventory.AddResource(Inventory.WOOD);
                    textViewResource.setText(Integer.toString(Inventory.Log_Quantity));
                    textViewRare.setText(Integer.toString(Rare.Magic_Seeds));
                    textViewSkill.setText(Integer.toString(Woodcutting.Level));

                }
                if (imgBtn.getTag().equals(2)){
                    Inventory.AddResource(Inventory.STONE);
                    textViewResource.setText(Integer.toString(Inventory.Stone_Quantity));
                    textViewRare.setText(Integer.toString(Rare.Gem));
                    textViewSkill.setText(Integer.toString(Mining.Level));

                }
                if (imgBtn.getTag().equals(99)){
                    System.out.println("CANNOT ACCESS");
                }
                else {
                    Player.AddExperience();
                }
            }
        });

        return v;
    }


}