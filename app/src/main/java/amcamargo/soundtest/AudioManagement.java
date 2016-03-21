package amcamargo.soundtest;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;

/** Created by Alberto Camargo on 15-Mar-16. **/

public class AudioManagement {

   public class BackgroundAudio {
       private MediaPlayer backgroundMusic = null;
       private float currentVolume;

       public BackgroundAudio(Context ctx, int media) {
           if (backgroundMusic == null) {

               // Create Media Player object
               backgroundMusic = MediaPlayer.create(ctx, media);
               backgroundMusic.setLooping(true);


           }
           // Saving current volume of STREAM_MUSIC
           AudioManager audioController = (AudioManager) ctx.getSystemService(ctx.AUDIO_SERVICE);
           currentVolume = audioController.getStreamVolume(AudioManager.STREAM_MUSIC) / audioController.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
       }

       public void play() {
           if (isPlaying() == false)
               backgroundMusic.start();
       }

       public void mute() {
           //backgroundMusic.release();
           backgroundMusic.setVolume(0, 0);
       }

       public  void unmute() {
           backgroundMusic.setVolume(currentVolume, currentVolume);
       }

       public void pause() {
           backgroundMusic.pause();
       }

       public void resume() {
           play();
       }

       public boolean isPlaying() {
           return  backgroundMusic == null ? false : backgroundMusic.isPlaying();
       }
   }

}
