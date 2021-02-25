package com.nguyenvantho.a06tho_button;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1, btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1= this.<Button>findViewById(R.id.btn1);
        btn2= this.<Button>findViewById(R.id.btn2);

       btn1. setOnClickListener(this);
       btn2.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        int id= v.getId();
        switch (id)
        {
            case R.id.btn1:
            {
                Toast.makeText(MainActivity.this,"Bạn click vào nút 1",Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.btn2:
                Toast.makeText(MainActivity.this,"Bạn click vào nút 2",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}