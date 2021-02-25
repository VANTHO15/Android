package com.nguyenvantho.a17tho_tooglebutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.material.appbar.AppBarLayout;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    ToggleButton tg1,tg2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tg1= this.<ToggleButton>findViewById(R.id.tgOnOff);
        tg2= this.<ToggleButton>findViewById(R.id.tgOnOff1);
        tg1.setOnCheckedChangeListener(this);
        tg2.setOnCheckedChangeListener(this);


    }
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        int id= buttonView.getId();
        switch (id)
        {
            case R.id.tgOnOff:
                if(isChecked)
                    Toast.makeText(MainActivity.this,"Bạn Chọn ON ĐÈN",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this,"Bạn Chọn OFF ĐÈN",Toast.LENGTH_SHORT).show();
                break;
            case R.id.tgOnOff1:
                if(isChecked)
                    Toast.makeText(MainActivity.this,"Bạn Chọn ON QUẠT",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this,"Bạn Chọn OFF QUẠT",Toast.LENGTH_SHORT).show();
        }
    }
}