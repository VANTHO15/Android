package com.nguyenvantho.a25tho_imagebutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton btnimage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnimage= this.<ImageButton>findViewById(R.id.btnimage);
        btnimage.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View v) {
        btnimage.setImageResource(R.drawable.loading);
    }
}