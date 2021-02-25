package com.nguyenvantho.a32tho_home_back;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnChuyen;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnChuyen= this.<Button>findViewById(R.id.btnChuyen);
        toolbar= this.<Toolbar>findViewById(R.id.toolbar);
        btnChuyen.setOnClickListener(this);
        setSupportActionBar(toolbar);
    }


    @Override
    public void onClick(View v) {
        Intent iManHinh2= new Intent(MainActivity.this,manhinh2.class);
        startActivity(iManHinh2);
    }
}