package com.nguyenvantho.a16tho_radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    RadioGroup radioGroup;
    Button btnChon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup= findViewById(R.id.radioGroup);
        btnChon= findViewById(R.id.btnXacNhan);

        btnChon.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id= radioGroup.getCheckedRadioButtonId();
        switch (id)
        {
            case R.id.rbNam:
                Toast.makeText(MainActivity.this,"Nam",Toast.LENGTH_SHORT).show();
                break;
            case R.id.rbNu:
                Toast.makeText(MainActivity.this,"Nữ",Toast.LENGTH_SHORT).show();
                break;
            case R.id.rbKhac:
                Toast.makeText(MainActivity.this,"Khác",Toast.LENGTH_SHORT).show();
        }
    }
}