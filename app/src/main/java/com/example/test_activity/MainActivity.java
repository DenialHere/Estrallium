package com.example.test_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.test_activity.Activities.StoreActivity;
import com.example.test_activity.Activities.Workers;
import com.example.test_activity.Fragments.UiFragment;
import com.example.test_activity.Inventory.Inventory;
import com.example.test_activity.Inventory.Rare;
import com.example.test_activity.Skills.Mining;
import com.example.test_activity.Skills.Player;
import com.example.test_activity.Skills.Woodcutting;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void PlayButton(View view){
        UiFragment uiFragment = (UiFragment) getSupportFragmentManager().
                findFragmentById(R.id.UifragmentContainerView);


        ImageButton PlotImg = uiFragment.getView().findViewById(R.id.imageButtonResource);
        PlotImg.setImageResource(R.drawable.lock);
        PlotImg.setTag(99);

        if (Player.Level >= 5) {
            PlotImg.setImageResource(R.drawable.minebackground);
            PlotImg.setTag(2);


        }


        ImageView skillImg = uiFragment.getView().findViewById(R.id.imageViewSkill);
        skillImg.setImageResource(R.drawable.miningicon);

        ImageView resourceImg = uiFragment.getView().findViewById(R.id.imageViewResource);
        resourceImg.setImageResource(R.drawable.ironore);

        ImageView specialItemImg = uiFragment.getView().findViewById(R.id.imageViewSpecialItem);
        specialItemImg.setImageResource(R.drawable.gem);

        TextView resourceTxt = uiFragment.getView().findViewById(R.id.textViewResource);
        resourceTxt.setText(Integer.toString(Inventory.Stone_Quantity));

        TextView rareTxt = uiFragment.getView().findViewById(R.id.textViewRare);
        rareTxt.setText(Integer.toString(Rare.Gem));

        TextView skillTxt = uiFragment.getView().findViewById(R.id.textViewSkill);
        skillTxt.setText(Integer.toString(Mining.Level));



//        UiFragment fragment_obj = (UiFragment) getSupportFragmentManager().
//                findFragmentById(R.id.fragmentContainerView3);
//        TextView tx = fragment_obj.getView().findViewById(R.id.textViewResource);
//        tx.setText("hi");

    }
    public void StoreButton(View view){

        Intent intent = new Intent(this, StoreActivity.class);
        startActivity(intent);

    }
    public void SettingsButton(View view){

        UiFragment uiFragment = (UiFragment) getSupportFragmentManager().
                findFragmentById(R.id.UifragmentContainerView);

        ImageButton plotImg = uiFragment.getView().findViewById(R.id.imageButtonResource);
        plotImg.setImageResource(R.drawable.forestbackground);

        plotImg.setTag(1);

        ImageView skillImg = uiFragment.getView().findViewById(R.id.imageViewSkill);
        skillImg.setImageResource(R.drawable.woodcutting);

        ImageView resourceImg = uiFragment.getView().findViewById(R.id.imageViewResource);
        resourceImg.setImageResource(R.drawable.logs);

        ImageView specialItemImg = uiFragment.getView().findViewById(R.id.imageViewSpecialItem);
        specialItemImg.setImageResource(R.drawable.magicseed);

        TextView resourceTxt = uiFragment.getView().findViewById(R.id.textViewResource);
        resourceTxt.setText(Integer.toString(Inventory.Log_Quantity));

        TextView rareTxt = uiFragment.getView().findViewById(R.id.textViewRare);
        rareTxt.setText(Integer.toString(Rare.Magic_Seeds));

        TextView skillTxt = uiFragment.getView().findViewById(R.id.textViewSkill);
        skillTxt.setText(Integer.toString(Woodcutting.Level));
    }

}