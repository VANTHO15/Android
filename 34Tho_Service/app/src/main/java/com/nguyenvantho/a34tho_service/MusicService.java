package com.nguyenvantho.a34tho_service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MusicService extends Service {
    MediaPlayer mediaPlayer;
    @Override
    public void onCreate() {
        super.onCreate();
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer= MediaPlayer.create(this,R.raw.nhac);
        mediaPlayer.start();
        Toast.makeText(this,"Nhạc đang chạy",Toast.LENGTH_SHORT).show();
        return START_NOT_STICKY;
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public void onDestroy() {
        mediaPlayer.stop();
        mediaPlayer.release();
        Toast.makeText(this,"Nhạc đã tắt",Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
}
