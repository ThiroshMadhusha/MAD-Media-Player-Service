package com.techdecode.mediaplayerservices;

import static android.app.Service.START_STICKY;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MediaPlayer player = MediaPlayer.create(this, Settings.System.DEFAULT_NOTIFICATION_URI);
        player.setLooping(true);
        player.start();
    }
    @Override
    public void onStart(){
        super.onStart();
    }
    public int onStartCommand(Intent intent, int flags, int startId) {
        player = MediaPlayer.create(this, Settings.System.DEFAULT_NOTIFICATION_URI);
        player.setLooping(true);
        player.start();
        return START_STICKY;     //return super.onStartCommand(intent, flags, startId);
    }
    public void Play(View view){
        if(player==null);
        player=MediaPlayer.create(getApplicationContext(),R.raw.song);
        player.start();
    }
    public void Pause(View view){
        if(player !=null){
            player.stop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        player.stop();
    }


}