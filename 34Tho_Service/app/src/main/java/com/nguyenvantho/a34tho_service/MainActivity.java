package com.nguyenvantho.a34tho_service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnStar,btnStop;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStar= this.<Button>findViewById(R.id.btnStar);
        btnStop= this.<Button>findViewById(R.id.btnStop);

        btnStop.setOnClickListener(this);
        btnStar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id= v.getId();
        switch (id)
        {
            case R.id.btnStar:
                intent= new Intent(MainActivity.this,MusicService.class);
                startService(intent);
                break;
            case R.id.btnStop:
                stopService(intent);


        }
    }
}