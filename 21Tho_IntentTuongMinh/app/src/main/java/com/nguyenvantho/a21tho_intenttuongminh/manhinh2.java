package com.nguyenvantho.a21tho_intenttuongminh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class manhinh2 extends AppCompatActivity implements View.OnClickListener {
    Button btn2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manhinh2);

        btn2= this.<Button>findViewById(R.id.btn2);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent iMH2ToMH1= new Intent(manhinh2.this,manhinh1.class);
        startActivity(iMH2ToMH1);
    }
}
