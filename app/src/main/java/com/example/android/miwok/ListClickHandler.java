package com.example.android.miwok;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import java.util.List;

/**
 * Created by Panda on 12/24/2017.
 */

public class ListClickHandler  implements AdapterView.OnItemClickListener, AudioManager.OnAudioFocusChangeListener{


        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                // The AUDIOFOCUS_LOSS_TRANSIENT case means that we've lost audio focus for a
                // short amount of time. The AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK case means that
                // our app is allowed to continue playing sound but at a lower volume. We'll treat
                // both cases the same way because our app is playing short sound files.

                // Pause playback and reset player to the start of the file. That way, we can
                // play the word from the beginning when we resume playback.
                player.pause();
                player.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                // The AUDIOFOCUS_GAIN case means we have regained focus and can resume playback.
                player.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                // The AUDIOFOCUS_LOSS case means we've lost audio focus and
                // Stop playback and clean up resources
                releaseMediaPlayer();
            }
        }

    public ListClickHandler(MediaPlayer player, AudioManager audioManager){this.player = player; this.audioManager = audioManager;}
    private AudioManager audioManager;
    private MediaPlayer player;
    View v;
    private final String TAG = "MyActivity";
    @Override
    public void onItemClick(AdapterView<?> adapter, View view, int position, long args){
        int result = audioManager.requestAudioFocus(this,AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
        if(result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
//            Log.i(TAG,"access granted?");
            play(adapter,view,position,args);
            //we have audiofocus now
        }


    }

    public void releaseMediaPlayer(){
        if(player !=null){
            player.release();
        audioManager.abandonAudioFocus(this);
        }
        player = null;

    }
    private void play(AdapterView<?> adapter, View view, int position,long args){
        Word myWord = (Word)adapter.getAdapter().getItem(position);
//        releaseMediaPlayer();
        if(player !=null)
            player.release();
        player = null;
        v = view;
        player = MediaPlayer.create(view.getContext(), myWord.getAudioID());
        player.start();
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                releaseMediaPlayer();


            }
        });
    }
//    private void pause()
}
