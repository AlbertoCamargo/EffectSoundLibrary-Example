package amcamargo.soundtest;

import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;

import static amcamargo.soundtest.R.raw.*;


public class Main extends AppCompatActivity {

    private AudioManagement audioManagement = null;
    private AudioManagement.BackgroundAudio backgroundSound = null;
    private AudioManagement.EffectSound effectSound = null;
    int[] ARRAY_EFFECTS = new int[] { beast, car_breaking, crash, death_blood_splatter, explosion, fuck_you, noaaah, scream, war };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (backgroundSound == null) {
            audioManagement = new AudioManagement();
            backgroundSound = audioManagement.new BackgroundAudio(this, halloween_horror);
            backgroundSound.play();
        }

        if (effectSound == null) {
            int[] effects = ARRAY_EFFECTS;
            effectSound = audioManagement.new EffectSound(this, effects);
        }

    }

    // When the multi-apps button is pressed
    @Override
    protected void onPause() {
        super.onPause();
        backgroundSound.pause();
        Log.d("message Event", "On pause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        backgroundSound.resume();
        Log.d("message Event", "On resume");
    }

    // Mute or unmute background sound
    public void enableSound(View view) {
        CheckBox checkBox = (CheckBox) findViewById(R.id.mutecheckbox);
        if(checkBox.isChecked()){
            backgroundSound.mute();
        } else {
            backgroundSound.unmute();
        }
    }

        public void fuckYou(View view) {
            effectSound.play(fuck_you);
        }
}
