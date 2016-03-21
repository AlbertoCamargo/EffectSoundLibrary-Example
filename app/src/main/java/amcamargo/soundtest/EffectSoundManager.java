package amcamargo.soundtest;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

import java.util.Hashtable;

/**
 * Created by Acama on 21-Mar-16.
 */
public class EffectSoundManager {
    // Api Must be greater than 17. min API: 21. Params(maximum effects playing ,kind of audio and quality of sound. default 0  )
    SoundPool effectPool;
    Context context;
    Hashtable<String,EffectSound> effects = new Hashtable<>();


    public EffectSoundManager(Context context) {
        this.context = context;
        this.effectPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
    }

    public void addEffect(String name, int effect){

    }
}
