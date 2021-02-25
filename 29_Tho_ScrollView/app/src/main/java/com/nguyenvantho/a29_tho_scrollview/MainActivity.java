package com.nguyenvantho.a29_tho_scrollview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;

import android.os.Bundle;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ViewTreeObserver.OnScrollChangedListener {
    ScrollView scrollView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scrollView = this.<ScrollView>findViewById(R.id.scrollview);
        scrollView.getViewTreeObserver().addOnScrollChangedListener(this);
    }

    @Override
    public void onScrollChanged() {
        Toast.makeText(MainActivity.this,"Bạn đang scroll",Toast.LENGTH_SHORT).show();
    }
}