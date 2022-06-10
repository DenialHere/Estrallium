package com.example.test_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.test_activity.Activities.DemandActivity;
import com.example.test_activity.Activities.KingdomActivity;
import com.example.test_activity.Activities.RefineryActivity;
import com.example.test_activity.Activities.SettingsActivity;
import com.example.test_activity.Activities.StoreActivity;
import com.example.test_activity.Activities.TasksActivity;
import com.example.test_activity.Activities.TutorialActivity;
import com.example.test_activity.Inventory.Kingdom;
import com.example.test_activity.Inventory.Workers;
import com.example.test_activity.Inventory.Inventory;
import com.example.test_activity.Inventory.Rare;
import com.example.test_activity.Managers.SaveManager;
import com.example.test_activity.Managers.SoundPlayer;
import com.example.test_activity.Skills.Farming;
import com.example.test_activity.Skills.Fishing;
import com.example.test_activity.Skills.Mining;
import com.example.test_activity.Skills.Player;
import com.example.test_activity.Skills.Woodcutting;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    LinearLayout linearLayout;
    TextView textView;
    SwipeListener swipeListener;
    static int DIRECTION_RIGHT = 1;
    static int DIRECTION_LEFT = 2;
    ProgressBar skillLevelPb, playerLevelPb;
    private AdView mAdView;
    ImageView plotCursor, kingdomCursor;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = new AdView(this);

        mAdView.setAdSize(AdSize.BANNER);

        mAdView.setAdUnitId("ca-app-pub-3940256099942544/6300978111");


        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdFailedToLoad(LoadAdError adError) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }
        });



        skillLevelPb = findViewById(R.id.progressBarSkillLevel);
        playerLevelPb = findViewById(R.id.progressBarPlayerLevel);

        skillLevelPb.setMax((int) Woodcutting.ExperienceLeft);
        skillLevelPb.setProgress(Woodcutting.Experience);

        playerLevelPb.setMax((int) Player.ExperienceLeft);
        playerLevelPb.setProgress(Player.Experience);

        linearLayout = findViewById(R.id.linear_layout);
        swipeListener = new SwipeListener(linearLayout);

        Activity activity = this;

        plotCursor = findViewById(R.id.cursorPlot);
        kingdomCursor = findViewById(R.id.cursorKingdom);
        StartTutorial();

        /** LOAD PREVIOUS GAME DATA **/
        SaveManager.LoadData(this);
        Handler handler = new Handler();
        int delay = 1000; //milliseconds


        //Wood workers
        handler.postDelayed(new Runnable() {
            public void run() {
                Workers.AddResource_Worker(Inventory.WOOD);
                System.out.println(Integer.toString(Workers.MineWorkerSpeed));
                handler.postDelayed(this, Workers.MineWorkerSpeed);
            }
        }, Workers.MineWorkerSpeed);

        //Stone workers
        handler.postDelayed(new Runnable() {
            public void run() {
                Workers.AddResource_Worker(Inventory.STONE);
                System.out.println(Integer.toString(Workers.ForestWorkerSpeed));
                handler.postDelayed(this, Workers.ForestWorkerSpeed);
            }
        }, Workers.ForestWorkerSpeed);

        //Updating resources every second
        handler.postDelayed(new Runnable() {
            public void run() {
                UpdateTutorial();
                UpdateViews();
                handler.postDelayed(this, delay);

            }
        }, delay);



        //Random event
        handler.postDelayed(new Runnable() {
            public void run() {
                Random rand = new Random(); //instance of random class
                int chance = rand.nextInt(3);
                if (chance == 0)
                {
                    chance = rand.nextInt(3);
                    if (chance == 0){
                        Tasks.GenerateScenario(activity);
                    }
                    if (chance == 1){
                        Tasks.GenerateDemand();
                        if (Tasks.Demand != ""){
                            Intent intent = new Intent(activity, DemandActivity.class);
                            startActivity(intent);
                        }
                    }
                    if (chance == 2){
                        Tasks.GenerateFree(activity);
                    }
                }
                    handler.postDelayed(this, Tasks.TaskTimer);

            }
        }, Tasks.TaskTimer);




    }

    public void UpdateTutorial(){
        if (Tutorial.Done == true && plotCursor.getVisibility() != View.GONE){
            plotCursor.setVisibility(View.GONE);
        }
        if (Inventory.Log_Quantity >= 50 && Tutorial.ClickPlotDone == false){
            plotCursor.setVisibility(View.GONE);
            Tutorial.ClickPlotDone = true;
            Intent intent = new Intent(this, TutorialActivity.class);
            startActivity(intent);
        }
        if (Tutorial.ClickPlotDone == true && Tutorial.KingdomDone == false){
            kingdomCursor.setVisibility(View.VISIBLE);
        }
        if (Kingdom.Level >= 2){
            kingdomCursor.setVisibility(View.GONE);
        }
    }

    public void CheatButton(View view){
        Inventory.Log_Quantity = 1000000;
        Inventory.Stone_Quantity = 1000000;
        Inventory.Fish_Quantity = 1000000;
        Player.Level = 1000;
        UpdateViews();

    }
    public void TasksButton(View view){
        Intent intent = new Intent(this, TasksActivity.class);
        startActivity(intent);
    }
    public void StartTutorial(){
        Intent intent = new Intent(this, TutorialActivity.class);
        startActivity(intent);
    }

    public void SettingsButton(View view){
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    public void StoreButton(View view){
        Intent intent = new Intent(this, StoreActivity.class);
        startActivity(intent);
    }
    public void RefineryButton(View view){
        Intent intent = new Intent(this, RefineryActivity.class);
        startActivity(intent);
    }

    public void UpdateViews(){
        ImageButton PlotImg = findViewById(R.id.imageButtonResource);
        TextView resourceTxt = findViewById(R.id.textViewResource);
        TextView specialItem = findViewById(R.id.textViewRare);
        TextView workers = findViewById(R.id.textViewWorkers);
        TextView workersAvailable = findViewById(R.id.textViewWorkersAvaliable);

        if (Player.CurrentPlot == Constants.WOOD){
            resourceTxt.setText(Integer.toString(Inventory.Log_Quantity));
            specialItem.setText(Integer.toString(Rare.Magic_Seeds));
            workers.setText(Integer.toString(Workers.Forest_Workers));
        }
        if (Player.CurrentPlot == Constants.STONE){
            resourceTxt.setText(Integer.toString(Inventory.Stone_Quantity));
            specialItem.setText(Integer.toString(Rare.Gem));
            workers.setText(Integer.toString(Workers.Mine_Workers));
        }
        if (Player.CurrentPlot == Constants.FISHING){
            resourceTxt.setText(Integer.toString(Inventory.Fish_Quantity));
            specialItem.setText(Integer.toString(Rare.RainbowFish));
            workers.setText(Integer.toString(Workers.FishingBoat_Workers));
        }
        if (Player.CurrentPlot == Inventory.WHEAT){
            resourceTxt.setText(Integer.toString(Inventory.Wheat_Quantity));
            specialItem.setText(Integer.toString(Rare.Giant_Wheat_Seeds));
            workers.setText(Integer.toString(Workers.Farm_Workers));
        }
        workersAvailable.setText("/" + Workers.workerUnassigned);
        ProgressBarSkillLevel();
    }

    public void KingdomButton(View view){

        SaveManager.Clear(this);
        Intent intent = new Intent(this, KingdomActivity.class);
        startActivity(intent);



    }

    public void ProgressBarSkillLevel(){
        switch (Player.CurrentPlot){
            case Inventory.WOOD:
                skillLevelPb.setMax((int)Woodcutting.ExperienceLeft);
                skillLevelPb.setProgress(Woodcutting.Experience);
                break;
            case Inventory.STONE:
                skillLevelPb.setMax((int)Mining.ExperienceLeft);
                skillLevelPb.setProgress(Mining.Experience);
                break;
            case Inventory.FISH:
                skillLevelPb.setMax((int)Fishing.ExperienceLeft);
                skillLevelPb.setProgress(Fishing.Experience);
                break;
            case Inventory.WHEAT:
                skillLevelPb.setMax((int) Farming.ExperienceLeft);
                skillLevelPb.setProgress(Farming.Experience);
                break;
        }

    }

    public void ProgressPlayerLevel(){
        playerLevelPb.setMax((int)Player.ExperienceLeft);
        playerLevelPb.setProgress(Player.Experience);
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
        Activity activity = this;

            textViewPlayerLevel.setText(Integer.toString(Player.Level));
            if (Player.CurrentPlot == Constants.WOOD){
                gatherSound.Play(this, R.raw.wood_chop2, Player.SoundIsMuted);
                Inventory.AddResource(Inventory.WOOD, this);
                textViewResource.setText(Integer.toString(Inventory.Log_Quantity));
                textViewRare.setText(Integer.toString(Rare.Magic_Seeds));
                textViewSkill.setText(Integer.toString(Woodcutting.Level));
                Player.AddExperience(this);


            }
            if (Player.CurrentPlot == Constants.STONE && Player.Level >=5){
                gatherSound.Play(this, R.raw.pickaxe, Player.SoundIsMuted);
                Inventory.AddResource(Inventory.STONE, this);
                textViewResource.setText(Integer.toString(Inventory.Stone_Quantity));
                textViewRare.setText(Integer.toString(Rare.Gem));
                textViewSkill.setText(Integer.toString(Mining.Level));
                Player.AddExperience(this);

            }
        if (Player.CurrentPlot == Constants.FISHING && Player.Level >=10){
            gatherSound.Play(this, R.raw.fishing_sound, Player.SoundIsMuted);
            Inventory.AddResource(Inventory.FISH, this);
            textViewResource.setText(Integer.toString(Inventory.Fish_Quantity));
            textViewRare.setText(Integer.toString(Rare.RainbowFish));
            textViewSkill.setText(Integer.toString(Fishing.Level));
            Player.AddExperience(this);

        }
        if (Player.CurrentPlot == Inventory.WHEAT && Player.Level >=15 && Farming.IsFarming == false){
            Farming.IsFarming = true;
            gatherSound.Play(this, R.raw.fishing_sound, Player.SoundIsMuted);
            TextView farmTimer = findViewById(R.id.textViewTime);

            new CountDownTimer(Farming.Time, 1000) {

                public void onTick(long millisUntilFinished) {
                    farmTimer.setText("Seconds remaining: " + millisUntilFinished / 1000);
                    //here you can have your logic to set text to edittext
                }

                public void onFinish() {

                    Inventory.AddResource(Inventory.WHEAT, activity);
                    Player.AddExperience(activity);
                    textViewResource.setText(Integer.toString(Inventory.Wheat_Quantity));
                    textViewRare.setText(Integer.toString(Rare.Giant_Wheat_Seeds));
                    textViewSkill.setText(Integer.toString(Farming.Level));
                    Farming.IsFarming = false;
                    farmTimer.setText("Farming complete!");


                }

            }.start();

        }
            if (Player.CurrentPlot == 99 ){

            }
            else {

            }
            ProgressBarSkillLevel();
            ProgressPlayerLevel();
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


        UpdateViews();
        switch (Player.CurrentPlot){
            case 1:
                Player.CurrentPlot = Inventory.WOOD;
                specialItemImg.setImageResource(R.drawable.magicseed);
                plotImg.setImageResource(R.drawable.forest_background);
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
                resourceImg.setImageResource(R.drawable.stone);
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
            case 4:
                specialItemImg.setImageResource(R.drawable.artifact);
                plotImg.setImageResource(R.drawable.lock);
                skillImg.setImageResource(R.drawable.farmingicon);
                resourceImg.setImageResource(R.drawable.grain);
                resourceTxt.setText(Integer.toString(Inventory.Wheat_Quantity));
                rareTxt.setText(Integer.toString(Rare.Giant_Wheat_Seeds));
                skillTxt.setText(Integer.toString(Farming.Level));
                workers.setText(Integer.toString(Workers.Farm_Workers));
                if (Player.Level >= 15) {
                    plotImg.setImageResource(R.drawable.farmbackground);
                    Player.CurrentPlot = Inventory.WHEAT;
                }
                break;
        }



    }
}

