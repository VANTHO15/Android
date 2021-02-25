package com.nguyenvantho.a31tho_tabhost;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {
    TabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabHost= this.<TabHost>findViewById(R.id.tabhost);
        tabHost.setup();

        TabHost.TabSpec tab1= tabHost.newTabSpec("Tab One");
        tab1.setIndicator("Tab One");
        tab1.setContent(R.id.tab1);

        TabHost.TabSpec tab2= tabHost.newTabSpec("Tab Two");
        tab2.setIndicator("Tab Two");
        tab2.setContent(R.id.tab2);

        TabHost.TabSpec tab3= tabHost.newTabSpec("Tab Three");
        tab3.setIndicator("Tab Three");
        tab3.setContent(R.id.tab3);

        tabHost.addTab(tab1);
        tabHost.addTab(tab2);
        tabHost.addTab(tab3);

    }
}