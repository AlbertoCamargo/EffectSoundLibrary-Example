package amcamargo.soundtest;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;

/**
 * Created by Alberto Camargo on 21-Mar-16.
 */
public class EffectSoundManager {
    float volume;
    Context context;
    Hashtable<String,EffectSound> effects = new Hashtable<>();
    SoundPool soundpool;
    private boolean mute;

    public EffectSoundManager(Context context) {

        this.mute = false;

        /*  Api Must be greater than 17. min API: 21.
            Params: maximum effects playing ,kind of audio, quality of sound (default 0, actually is deprecated)
        */
        this.soundpool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        this.context = context;

        // Getting the current volume
        AudioManager audioController = (AudioManager) this.context.getSystemService(this.context.AUDIO_SERVICE);
        volume = audioController.getStreamVolume(AudioManager.STREAM_MUSIC) / audioController.getStreamMaxVolume(AudioManager.STREAM_MUSIC);

    }

    public void addEffect(String name, int addressMemoryEffect) {
        // {'explosion': Object EffectSound}
        EffectSound effectSound =  new  EffectSound(name, addressMemoryEffect);
        effectSound.loadEffect(this.soundpool, this.context);
        effects.put(name, effectSound );
    }

    public  void playEffect(String name) {
        if (!this.mute)
            effects.get(name).play(this.soundpool, volume);

    }

    public  void mute() {
        this.mute = true;
        this.soundpool.autoPause();

       /* Iterator<EffectSound> values = this.effects.values().iterator();
        do {
            values.next().mute(this.soundpool);
        } while (values.hasNext());
        */

    }

    public  void unmute() {
        this.mute = false;
        this.soundpool.autoResume();
    }


}
