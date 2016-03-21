package amcamargo.soundtest;

import android.content.Context;
import android.media.SoundPool;

/**
 * Created by Alberto Camargo on 21-Mar-16.
 */
public class EffectSound {

    String name; // identification for the effect
    // Memory address: Value return by R.raw.effect, SoundId: value return by SoundPoll.load, StreamId
    int memoryAddress, soundId;

    public EffectSound(String name, int memoryAddress) {
        this.name = name;
        this.memoryAddress = memoryAddress;
    }

    public void loadEffect(SoundPool soundPool, Context context) {
        // params: Context, memory address of sound and priority
        this.soundId = soundPool.load(context, this.memoryAddress, 1);
    }


}
