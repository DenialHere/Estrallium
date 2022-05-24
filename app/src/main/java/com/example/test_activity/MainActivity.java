package com.example.test_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.test_activity.Activities.KingdomActivity;
import com.example.test_activity.Inventory.Kingdom;
import com.example.test_activity.Inventory.Workers;
import com.example.test_activity.Inventory.Inventory;
import com.example.test_activity.Inventory.Rare;
import com.example.test_activity.Managers.SaveManager;
import com.example.test_activity.Managers.SoundPlayer;
import com.example.test_activity.Skills.Fishing;
import com.example.test_activity.Skills.Mining;
import com.example.test_activity.Skills.Player;
import com.example.test_activity.Skills.Woodcutting;

public class MainActivity extends AppCompatActivity {
    LinearLayout linearLayout;
    TextView textView;
    SwipeListener swipeListener;
    static int DIRECTION_RIGHT = 1;
    static int DIRECTION_LEFT = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        linearLayout = findViewById(R.id.linear_layout);
        swipeListener = new SwipeListener(linearLayout);


        /** LOAD PREVIOUS GAME DATA **/
        SaveManager.LoadData(this);
        Handler handler = new Handler();
        int delay = 1000; //milliseconds

        //Wood workers
        handler.postDelayed(new Runnable(){
            public void run(){
                Workers.AddResource_Worker(Inventory.WOOD);
                System.out.println(Integer.toString(Workers.MineWorkerSpeed));
                handler.postDelayed(this, Workers.MineWorkerSpeed);
            }
        }, Workers.MineWorkerSpeed);

        //Stone workers
        handler.postDelayed(new Runnable(){
            public void run(){
                Workers.AddResource_Worker(Inventory.STONE);
                System.out.println(Integer.toString(Workers.ForestWorkerSpeed));
                handler.postDelayed(this, Workers.ForestWorkerSpeed);
            }
        }, Workers.ForestWorkerSpeed);

        //Updating resources every second
        handler.postDelayed(new Runnable(){
            public void run(){
                UpdateViews();
                handler.postDelayed(this, delay);
            }
        }, delay);


    }

    public void UpdateViews(){
        ImageButton PlotImg = findViewById(R.id.imageButtonResource);
        TextView resourceTxt = findViewById(R.id.textViewResource);
        TextView specialItem = findViewById(R.id.textViewRare);
        TextView workers = findViewById(R.id.textViewWorkers);
        TextView workersAvailable = findViewById(R.id.textViewWorkersAvaliable);

        if (Player.CurrentPlot == Inventory.WOOD){
            resourceTxt.setText(Integer.toString(Inventory.Log_Quantity));
            specialItem.setText(Integer.toString(Rare.Magic_Seeds));
            workers.setText(Integer.toString(Workers.Forest_Workers));
        }
        if (Player.CurrentPlot == Inventory.STONE){
            resourceTxt.setText(Integer.toString(Inventory.Stone_Quantity));
            specialItem.setText(Integer.toString(Rare.Gem));
            workers.setText(Integer.toString(Workers.Mine_Workers));
        }
        if (Player.CurrentPlot == Inventory.FISH){
            resourceTxt.setText(Integer.toString(Inventory.Fish_Quantity));
            specialItem.setText(Integer.toString(Rare.RainbowFish));
            workers.setText(Integer.toString(Workers.FishingBoat_Workers));
        }
        workersAvailable.setText("/" + Workers.workerUnassigned);
    }

    public void KingdomButton(View view){

        SaveManager.Clear(this);
        Intent intent = new Intent(this, KingdomActivity.class);
        startActivity(intent);



    }

    public void AddWorkerButton(View view){
        Workers.AddWorkerToPlot(Player.CurrentPlot, this);
        UpdateViews();


    }
    public void RemoveWorkerButton(View view){
        Workers.RemoveWorkerFromPlot(Player.CurrentPlot, this);
        UpdateViews();
    }

    public void GatherButton(View view) {
        TextView textViewResource = findViewById(R.id.textViewResource);
        TextView textViewRare = findViewById(R.id.textViewRare);
        TextView textViewSkill = findViewById(R.id.textViewSkill);
        TextView textViewPlayerLevel = findViewById(R.id.textViewPlayerLevel);
        ImageButton imgBtn = findViewById(R.id.imageButtonResource);
        Button cheatButton = findViewById(R.id.buttonCheat);
        SoundPlayer gatherSound = new SoundPlayer();

            textViewPlayerLevel.setText(Integer.toString(Player.Level));
            if (Player.CurrentPlot == Inventory.WOOD){
                gatherSound.Play(this, R.raw.wood_chop2, Player.isMuted);
                Inventory.AddResource(Inventory.WOOD, this);
                textViewResource.setText(Integer.toString(Inventory.Log_Quantity));
                textViewRare.setText(Integer.toString(Rare.Magic_Seeds));
                textViewSkill.setText(Integer.toString(Woodcutting.Level));


            }
            if (Player.CurrentPlot == Inventory.STONE && Player.Level >=5){
                gatherSound.Play(this, R.raw.pickaxe, Player.isMuted);
                Inventory.AddResource(Inventory.STONE, this);
                textViewResource.setText(Integer.toString(Inventory.Stone_Quantity));
                textViewRare.setText(Integer.toString(Rare.Gem));
                textViewSkill.setText(Integer.toString(Mining.Level));

            }
        if (Player.CurrentPlot == Inventory.FISH && Player.Level >=10){
            gatherSound.Play(this, R.raw.fishing_sound, Player.isMuted);
            Inventory.AddResource(Inventory.FISH, this);
            textViewResource.setText(Integer.toString(Inventory.Fish_Quantity));
            textViewRare.setText(Integer.toString(Rare.RainbowFish));
            textViewSkill.setText(Integer.toString(Fishing.Level));

        }
            if (Player.CurrentPlot == 99){
                System.out.println("CANNOT ACCESS");
            }
            else {
                Player.AddExperience(this);
            }
        }

    private class SwipeListener  implements View.OnTouchListener {
        GestureDetector gestureDetector;

        SwipeListener(View view){
            int threshold = 100;
            int velocity_threshold = 100;

            GestureDetector.SimpleOnGestureListener listener =
                    new GestureDetector.SimpleOnGestureListener(){
                    @Override
                        public boolean onDown(MotionEvent e){
                        return true;
                    }

                        @Override
                        public boolean onFling(MotionEvent e1, MotionEvent e2, float veloctiyX, float velocityY){
                            float xDiff = e2.getX() - e1.getX();
                            float yDiff = e2.getY() - e1.getY();
                            try {
                                if (Math.abs(xDiff) > Math.abs(yDiff)){
                                    if (Math.abs(xDiff) > threshold && Math.abs(veloctiyX) > velocity_threshold){
                                        if (xDiff > 0){
                                            //if swiped right
                                            SwitchPlots(DIRECTION_RIGHT);
                                            System.out.println("SWIPED RIGHT");
                                        } else {
                                            SwitchPlots(DIRECTION_LEFT);
                                            System.out.println("SWIPED LEFT");
                                        }
                                        return true;
                                    }
                                } else {
                                    if (Math.abs(yDiff) > threshold && Math.abs(velocityY) > velocity_threshold){
                                        if (yDiff > 0){
                                            //if swiped right
                                            textView.setText("Swiped down");
                                        } else {
                                            textView.setText("Swiped up");
                                        }
                                        return true;
                                    }
                                }
                            } catch (Exception e){
                                e.printStackTrace();
                            }
                            return false;
                        }
                    };
            gestureDetector = new GestureDetector(listener);
            view.setOnTouchListener(this);
        }

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return gestureDetector.onTouchEvent(motionEvent);
        }
    }

    public void SwitchPlots(int direction)
    {
        ImageButton plotImg = findViewById(R.id.imageButtonResource);
        ImageView skillImg = findViewById(R.id.imageViewSkill);
        ImageView resourceImg = findViewById(R.id.imageViewResource);
        ImageView specialItemImg = findViewById(R.id.imageViewSpecialItem);
        TextView rareTxt = findViewById(R.id.textViewRare);
        TextView resourceTxt = findViewById(R.id.textViewResource);
        TextView skillTxt = findViewById(R.id.textViewSkill);
        TextView workers = findViewById(R.id.textViewWorkers);

        if (direction == DIRECTION_RIGHT){
            Player.CurrentPlot++;
        }
        if (direction == DIRECTION_LEFT && Player.CurrentPlot != 1){
            Player.CurrentPlot--;
        }

        System.out.println(Player.CurrentPlot + "");

        switch (Player.CurrentPlot){
            case 1:
                Player.CurrentPlot = Inventory.WOOD;
                specialItemImg.setImageResource(R.drawable.magicseed);
                plotImg.setImageResource(R.drawable.forestbackground);
                skillImg.setImageResource(R.drawable.woodcutting);
                resourceImg.setImageResource(R.drawable.logs);
                resourceTxt.setText(Integer.toString(Inventory.Log_Quantity));
                rareTxt.setText(Integer.toString(Rare.Magic_Seeds));
                skillTxt.setText(Integer.toString(Woodcutting.Level));
                workers.setText(Integer.toString(Workers.Forest_Workers));
                System.out.println("CHANGING TO WOOD");
                break;
            case 2:
                specialItemImg.setImageResource(R.drawable.gem);
                plotImg.setImageResource(R.drawable.lock);
                skillImg.setImageResource(R.drawable.miningicon);
                resourceImg.setImageResource(R.drawable.ironore);
                resourceTxt.setText(Integer.toString(Inventory.Stone_Quantity));
                rareTxt.setText(Integer.toString(Rare.Gem));
                skillTxt.setText(Integer.toString(Mining.Level));
                workers.setText(Integer.toString(Workers.Mine_Workers));
                System.out.println("CHANGING TO STONE");

                if (Player.Level >= 5) {
                    plotImg.setImageResource(R.drawable.minebackground);
                    Player.CurrentPlot = Inventory.STONE;
                }
                break;
            case 3:
                specialItemImg.setImageResource(R.drawable.rainbow_fish);
                plotImg.setImageResource(R.drawable.lock);
                skillImg.setImageResource(R.drawable.fishingicon);
                resourceImg.setImageResource(R.drawable.trout);
                resourceTxt.setText(Integer.toString(Inventory.Fish_Quantity));
                rareTxt.setText(Integer.toString(Rare.RainbowFish));
                skillTxt.setText(Integer.toString(Fishing.Level));
                workers.setText(Integer.toString(Workers.FishingBoat_Workers));
                System.out.println("CHANGING TO Fish");

                if (Player.Level >= 10) {
                    plotImg.setImageResource(R.drawable.fishingbackground);
                    Player.CurrentPlot = Inventory.FISH;
                }
                break;
        }



    }
}

