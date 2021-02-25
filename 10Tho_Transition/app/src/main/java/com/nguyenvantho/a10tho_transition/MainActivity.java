package com.nguyenvantho.a10tho_transition;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView tvAnh;
    Button btnChuyen;
    TransitionDrawable tranDrawable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvAnh= this.<ImageView>findViewById(R.id.tvAnh);
        btnChuyen= this.<Button>findViewById(R.id.btnChuyen);

        tranDrawable= (TransitionDrawable) tvAnh.getDrawable();
        btnChuyen.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        tranDrawable.reverseTransition(2000);
    }
}