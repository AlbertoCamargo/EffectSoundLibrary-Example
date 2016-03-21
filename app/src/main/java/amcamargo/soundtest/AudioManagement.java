package amcamargo.soundtest;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.util.Log;

import java.util.ArrayList;

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

    public class EffectSound {

        private SoundPool effectPool;
        private ArrayList<Integer> effects = new ArrayList<>();
        private float currentVolume;

        public EffectSound(Context ctx, int[] effects) {
            // Getting the current volume
            AudioManager audioController = (AudioManager) ctx.getSystemService(ctx.AUDIO_SERVICE);
            currentVolume = audioController.getStreamVolume(AudioManager.STREAM_MUSIC) / audioController.getStreamMaxVolume(AudioManager.STREAM_MUSIC);

            effectPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);

            for (int effect: effects) {
                int v  = effectPool.load(ctx, effect, 1);
                Log.d("valueeeeeeeeeee", "" + v);
                this.effects.add(v);
            }
        }

        public void play(int effect) {
            Log.d("valueeeeeeeeeee2222", "" + effect);
            effect = effects.get(this.effects.indexOf(effect));
            effectPool.play(effect, currentVolume, currentVolume, 1, 0, 1);
        }
    }

}
