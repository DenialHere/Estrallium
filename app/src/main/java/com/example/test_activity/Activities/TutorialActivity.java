package com.example.test_activity.Activities;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test_activity.MainActivity;
import com.example.test_activity.R;
import com.example.test_activity.Tasks;
import com.example.test_activity.Tutorial;

public class TutorialActivity extends AppCompatActivity {
    TextView dialog;
    Button btnNo;

    @Override
    public void onBackPressed() {
        Tasks.IsEnabled = true;
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial);
        dialog = findViewById(R.id.textViewDialog);
        btnNo = findViewById(R.id.buttonNo);

        Tasks.IsEnabled = false;
        //Hide skip tutorial button
        if (Tutorial.ClickPlotDone == true){
            btnNo.setVisibility(View.GONE);
        }

        dialog.setText(Tutorial.Message);

    }

    public void OkButton(View view){
        Tasks.IsEnabled = true;
        finish();
    }

    public void NoButton(View view){
        Tasks.IsEnabled = true;
        Tutorial.Done = true;
        finish();
    }
}
