package com.nguyenvantho.a15tho_checkbox;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnXacNhan;
    CheckBox chkAndroid,chkIos,chkReactNative;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        btnXacNhan= this.<Button>findViewById(R.id.btnXacNhan);
        chkAndroid= this.<CheckBox>findViewById(R.id.chkAndroid);
        chkIos= this.<CheckBox>findViewById(R.id.chkIos);
        chkReactNative= this.<CheckBox>findViewById(R.id.chkReactNative);
        btnXacNhan.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        String str="";
        if(chkAndroid.isChecked())
        {
           str+="Android ";
        }
        if(chkIos.isChecked())
        {
           str +="Ios ";
        }
        if(chkReactNative.isChecked())
        {
           str +="React Native";
        }
        Toast.makeText(MainActivity.this,"Bạn chọn "+str,Toast.LENGTH_SHORT).show();
    }
}