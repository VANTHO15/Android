package com.nguyenvantho.a26tho_loadnhac;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ToggleButton btnNut;
    MediaPlayer mediaPlayeron,mediaPlayeroff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNut= this.<ToggleButton>findViewById(R.id.btnNut);
        btnNut.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(btnNut.isChecked())
        {
            mediaPlayeron= MediaPlayer.create(MainActivity.this,R.raw.bat);
            mediaPlayeron.start();
        }
        else
        {
            mediaPlayeroff= MediaPlayer.create(MainActivity.this,R.raw.tat);
            mediaPlayeroff.start();
        }
    }
}