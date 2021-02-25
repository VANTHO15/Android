package com.nguyenvantho.a09tho_levellist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.health.TimerStat;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {
    ImageView img;
    AppCompatButton btnNut;
    int i=1,x=1;
    Handler handler;
    Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNut= this.<AppCompatButton>findViewById(R.id.btnNut);
        img= this.<ImageView>findViewById(R.id.img);

        btnNut.setOnClickListener(this);

        handler= new Handler()
        {
            @Override
            public void handleMessage(@NonNull Message msg)
            {
                if(msg.what==0)
                {
                    i++;
                    if(i==6) i=1;
                    img.setImageLevel(i);
                }
            }
        };
        timer= new  Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
            }
        },1000,1000);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(MainActivity.this,i+"",Toast.LENGTH_SHORT).show();
        x++;
        if(x==6)
            x=1;
        img.setImageLevel(x);
    }
}