package com.nguyenvantho.a19tho_proccessbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnLoad;
    ProgressBar progressBar;
    Handler handler;
    int xulyhientai=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLoad = this.<Button>findViewById(R.id.btnNut);
        progressBar= this.<ProgressBar>findViewById(R.id.progressBar);
        btnLoad.setOnClickListener(this::onClick);
        handler= new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                progressBar.setProgress(msg.what+10); }}; }
    @Override
    public void onClick(View v) {
//        progressBar.setProgress(progressBar.getProgress()+10);
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                while (xulyhientai<100) {
                    int hientai=progressBar.getProgress();
                    handler.sendEmptyMessage(hientai);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace(); } } }});
        thread.start(); }}