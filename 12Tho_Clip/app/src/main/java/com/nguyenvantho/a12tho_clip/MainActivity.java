package com.nguyenvantho.a12tho_clip;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tv;
    Button btnCat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv= this.<TextView>findViewById(R.id.tvAnh);
        btnCat= this.<Button>findViewById(R.id.btnCat);

        btnCat.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        ClipDrawable clipDrawable= (ClipDrawable) tv.getBackground();
        clipDrawable.setLevel(clipDrawable.getLevel()+1000);
    }
}