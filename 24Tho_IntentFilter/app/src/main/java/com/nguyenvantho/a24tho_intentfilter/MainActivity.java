package com.nguyenvantho.a24tho_intentfilter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img= this.<ImageView>findViewById(R.id.img);
        Bundle bHinhAnh=getIntent().getExtras();
        if(bHinhAnh!=null)
        {
            img.setImageURI((Uri) getIntent().getExtras().get(Intent.EXTRA_STREAM));
        }
    }
}