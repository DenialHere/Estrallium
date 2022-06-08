package com.example.test_activity.Activities;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test_activity.MainActivity;
import com.example.test_activity.R;
import com.example.test_activity.Tasks;
import com.example.test_activity.Tutorial;

public class TutorialActivity extends AppCompatActivity {
    TextView dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial);
        dialog = findViewById(R.id.textViewDialog);

        if (Tutorial.ClickPlotDone == false){
            dialog.setText("Your wish has been granted! \n But that doesn't mean that it's going be easy. \n You are now in charge of your very own kingdom, but theres still lots to do before you can can call it home. \n Why don't you start off by collecting some logs?");
        }
        else if (Tutorial.KingdomDone == false){
            dialog.setText("You have enough resources to upgrade your kingdom! \n Click on the kingdom button to upgrade.");
        }
    }

    public void OkButton(View view){
        System.out.println("TUTORIAL YES");
        finish();
    }

    public void NoButton(View view){
        Tutorial.Done = true;
        finish();
    }
}
