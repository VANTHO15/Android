package com.nguyenvantho.a21tho_intenttuongminh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class manhinh1 extends AppCompatActivity implements View.OnClickListener {
    Button btn1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manhinh1);

        btn1= this.<Button>findViewById(R.id.btn1);
        btn1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent iManHinh1ToManHinh2=new Intent(manhinh1.this,manhinh2.class);
        startActivity(iManHinh1ToManHinh2);
    }


}
