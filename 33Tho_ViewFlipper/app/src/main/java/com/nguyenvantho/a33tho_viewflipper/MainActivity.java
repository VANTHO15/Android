package com.nguyenvantho.a33tho_viewflipper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    ViewFlipper viewFlipper;
    float ToaDoX1,ToaDoX2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewFlipper= this.<ViewFlipper>findViewById(R.id.viewfliper);
        viewFlipper.setInAnimation(MainActivity.this,android.R.anim.fade_in);
        viewFlipper.setOutAnimation(MainActivity.this, android.R.anim.fade_out);
        viewFlipper.setAutoStart(true);
        viewFlipper.setFlipInterval(2000);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                ToaDoX1= event.getX();
                break;
            case MotionEvent.ACTION_UP:
                ToaDoX2= event.getX();
                if (ToaDoX2>ToaDoX1) {
                    viewFlipper.showPrevious();
                }
                else {
                    viewFlipper.showNext();
                }
        }
        return super.onTouchEvent(event);
    }
}