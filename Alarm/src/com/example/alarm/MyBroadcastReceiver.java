package com.example.alarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {  
  static  MediaPlayer mp;  
    @Override  
    public void onReceive(Context context, Intent intent) {  
        mp=MediaPlayer.create(context,R.raw.sng );  
        mp.start();  
        Toast.makeText(context, "Alarm....", Toast.LENGTH_LONG).show();  
    }  
}  