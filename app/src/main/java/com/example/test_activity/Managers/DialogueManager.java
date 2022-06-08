package com.example.test_activity.Managers;

import android.app.Activity;
import android.app.Dialog;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.test_activity.Activities.DemandActivity;
import com.example.test_activity.R;

public class DialogueManager {

/**   To show a level up dialog pass through the current activity your in,
 *    the name of the skill in with the first letter in UPPERCASE, the picture
 *    you wish to be displayed, the level of the skill and the desired position of the dialog box
 *    ex: dm.Show(this, "Woodcutting", R.drawable.wood_cutting_icon, player.getWoodCuttingLevel(),
 *    Gravity.BOTTOM , 1);
 */

    public static int LEVELUP = 1;
    public static int RAREITEM = 2;
    public static int MESSAGE = 3;
    public static Dialog demand;

    public static void Show(Activity activity, String name, int picture, int level, int position,
                     int dialogType)
    {
        String messageString = "";

        switch (dialogType){
            case 1:
                messageString = name + " level up! \nYou are now level " + level + ".";
                break;
            case 2:
                messageString = "You found " + level + " " + name +
                        "! \n Your gather rate has been improved by 100%";
                break;
            case 3:
                //
        }
            //Creating a new dialog with the passed activity
            Dialog dialog = new Dialog(activity);

            //Setting the dialog to the level_message.xml in Layout
            dialog.setContentView(R.layout.level_message);

            //Setting levelUpMessage to the textview in level_message.xml
            TextView levelUpMessage = dialog.findViewById(R.id.textViewLevelUp);
            //The textview is where the level up text will be
            levelUpMessage.setText(messageString);

            //Setting the position of the dialog box
            dialog.getWindow().setGravity(position);

            //Setting the icon image of the skill from the image passed
            ImageView img = dialog.findViewById(R.id.imageViewIcon);
            img.setImageResource(picture);


            //Displaying the custom dialog
            dialog.show();
        }


    public static void ShowMessage(Activity activity, String message, int picture,int position)
    {


        //Creating a new dialog with the passed activity
        Dialog dialog = new Dialog(activity);

        //Setting the dialog to the level_message.xml in Layout
        dialog.setContentView(R.layout.dialog);

        //Setting levelUpMessage to the textview in level_message.xml
        TextView textViewDialog = dialog.findViewById(R.id.textViewDemand);
        //The textview is where the level up text will be
        textViewDialog.setText(message);

        //Setting the position of the dialog box
        dialog.getWindow().setGravity(position);

        //Setting the icon image of the skill from the image passed
        ImageView img = dialog.findViewById(R.id.imageViewDialog);
        img.setImageResource(picture);


        //Displaying the custom dialog
        dialog.show();
    }



}
