package com.example.test_activity.Managers;

import android.app.Activity;
import android.app.Dialog;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.test_activity.R;

public class DialogueManager {

/**   To show a level up dialog pass through the current activity your in,
 *    the name of the skill in with the first letter in UPPERCASE, the picture
 *    you wish to be displayed, the level of the skill and the desired position of the dialog box
 *    ex: dm.Show(this, "Woodcutting", R.drawable.wood_cutting_icon, player.getWoodCuttingLevel(),
 *    Gravity.BOTTOM , 1);
 */

    public void Show(Activity activity, String name, int picture, int level, int position,
                     int dialogType)
    {
        String messageString = "";

        if (dialogType == 1)
        {
            messageString = name + " level up! \nYou are now level " + level + ".";
        }
        else if (dialogType == 2)
        {
            messageString = "You found " + level + " " + name +
                    "! \n Your gather rate has been improved by 100%";
        }


            /** Every 5 levels the skill gains an extra boost to gather rate
             *   If the passed through level is a multiple of 5 & is not the player level then edit
             *   the level up string to indicate the increase to gather rate */

            if (level % 5 == 0 && name != "You" ) {
                messageString += "\n2x more xp per click!";
            }


            //Creating a new dialog with the passed activity
            Dialog dialog = new Dialog(null);

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





}
