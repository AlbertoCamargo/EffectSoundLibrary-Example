package amcamargo.soundtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;


public class Main extends AppCompatActivity {

    private BackgroundSound backgroundSound = null;
    private EffectSoundManager effectSoundManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (backgroundSound == null) {
            backgroundSound = new BackgroundSound(this, R.raw.halloween_horror);
            backgroundSound.play();
        }

        if  (effectSoundManager == null) {
            // Instance of effectSoundManager. receive as param the context
            effectSoundManager = new EffectSoundManager(this);

            // Adding all effects
            effectSoundManager.addEffect("fuck you", R.raw.fuck_you);
            effectSoundManager.addEffect("beast", R.raw.beast);
            effectSoundManager.addEffect("blood", R.raw.death_blood_splatter);
            effectSoundManager.addEffect("scream", R.raw.scream);
            effectSoundManager.addEffect("crash", R.raw.crash);
            effectSoundManager.addEffect("no", R.raw.noaaah);
            effectSoundManager.addEffect("explosion", R.raw.explosion);
            effectSoundManager.addEffect("war", R.raw.war);
            effectSoundManager.addEffect("car breaking", R.raw.car_breaking);
        }

    }

    // When the multi-apps button is pressed
    @Override
    protected void onPause() {
        super.onPause();
        backgroundSound.pause();
        effectSoundManager.pause();
        Log.d("message Event", "On pause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        backgroundSound.resume();
        effectSoundManager.resume();
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

    public void effectsEnable(View view) {
        CheckBox checkBox = (CheckBox) findViewById(R.id.muteEffects);
        if(checkBox.isChecked()){
            effectSoundManager.mute();
        } else {
            effectSoundManager.unmute();
        }
    }

    public void fuckYou(View view) { effectSoundManager.playEffect("fuck you"); }

    public void beast(View view) {
        effectSoundManager.playEffect("beast");
    }

    public void carBreaking(View view) { effectSoundManager.playEffect("car breaking"); }

    public void screamingNo(View view) {
        effectSoundManager.playEffect("no");
    }

    public void carCrashed(View view) {
        effectSoundManager.playEffect("crash");
    }

    public void explosion(View view) {
        effectSoundManager.playEffect("explosion");
    }

    public void war(View view) {
        effectSoundManager.playEffect("war");
    }

    public void scream(View view) {
        effectSoundManager.playEffect("scream");
    }

    public void blood(View view) {
        effectSoundManager.playEffect("blood");
    }
}
