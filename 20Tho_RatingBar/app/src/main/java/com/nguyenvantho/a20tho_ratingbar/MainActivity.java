package com.nguyenvantho.a20tho_ratingbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements  RatingBar.OnRatingBarChangeListener {
    RatingBar rtDanhGia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rtDanhGia= this.<RatingBar>findViewById(R.id.rtBar);
        rtDanhGia.setOnRatingBarChangeListener(this);
    }

    @Override
    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
        Toast.makeText(MainActivity.this,"Bạn đánh giá "+rating+" sao",Toast.LENGTH_SHORT).show();
    }
}