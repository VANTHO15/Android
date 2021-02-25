package com.nguyenvantho.a18tho_buttonxe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    ToggleButton tgButton;
    TextView txtValue;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tgButton= this.<ToggleButton>findViewById(R.id.tgButton);
        txtValue= this.<TextView>findViewById(R.id.txtValue);
        tgButton.setOnTouchListener(this);
    }
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:{
                txtValue.setText("1");
                break; }
            case MotionEvent.ACTION_MOVE:{
                i++;
                txtValue.setText(i+"");
                break; }
            case MotionEvent.ACTION_UP:{
                i=0;
                txtValue.setText("0"); }
        }
        return false;
    }
}