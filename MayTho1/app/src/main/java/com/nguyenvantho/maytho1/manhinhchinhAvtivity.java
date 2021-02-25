package com.nguyenvantho.maytho1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.tabs.TabLayout;

public class manhinhchinhAvtivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manhinhchinh);

//        Intent intent= getIntent();
//        Bundle LayGoiThongTin= intent.getExtras();
//        String Ten=LayGoiThongTin.getString("ten");
//        Toast.makeText(manhinhchinhAvtivity.this,Ten,Toast.LENGTH_SHORT).show();

        // tab host
        TabHost tabHost= this.<TabHost>findViewById(R.id.tabhost);
        tabHost.setup();

        TabHost.TabSpec tab1=tabHost.newTabSpec("Tab 1");
        tab1.setIndicator("Điều Khiển");
        tab1.setContent(R.id.tab1);

        TabHost.TabSpec tab2=tabHost.newTabSpec("Tab 2");
        tab2.setIndicator("Đồ Thị");
        tab2.setContent(R.id.tab2);

        TabHost.TabSpec tab3=tabHost.newTabSpec("Tab 3");
        tab3.setIndicator("Đăng Xuất");
        tab3.setContent(R.id.tab3);

        tabHost.addTab(tab1);
        tabHost.addTab(tab2);
        tabHost.addTab(tab3);
    }
}
