package com.example.test_activity.Managers;

import android.app.Activity;
import android.media.MediaPlayer;


public class SoundPlayer {

    //Creating a new mediaPlayer that will be used for all sound effects
    MediaPlayer soundEffect;

    /**   To play a sound pass the activity you're in, the sound you wish to play and if sound has
     *    been muted by the player
     *    Ex:  SoundPlayer sm = new SoundPlayer();
     *         sm.Play(this, R.raw.level_up_sound, isMuted);
     */

    public void Play(Activity activity, int sound, boolean isMuted) {
        //Checking if sound effects are muted before playing
        if (!isMuted) {
            //Loading the sound that was passed in
            soundEffect = MediaPlayer.create(activity, sound);

            //When the sound has completed stop the sound and free up memory
            soundEffect.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    Stop(soundEffect);
                }

            });
            //Starting the sound effect
            soundEffect.start();
        }
    }
    public void Stop(MediaPlayer sound){
        //Stopping the sound passed and freeing up the memory it took
        try {
            sound.stop();
            sound.reset();
            sound.release();
        }
        catch (Exception e){

        }

    }
}
