package com.nguyenvantho.a27tho_listview_arrayadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.nguyenvantho.a27tho_listview_arrayadapter.Adapter.custom_Adapter_ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lvAnBum;
    int[] hinhAnBum={R.drawable.aqua,R.drawable.images,R.drawable.nevergone,R.drawable.noname};
    String[] Ten={"Con cò bé bé","Cháu lên ba","Một con vịt","Nu na nu nống"};
    String[] Ngayphathanh={"01/01/2000","02/01/2001","03/01/2022","04/02/2023"};
    List<Anbum> danhsachAnBum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvAnBum= this.<ListView>findViewById(R.id.lvAnbum);

        danhsachAnBum= new ArrayList<>();
        for (int i=0;i<Ten.length;i++)
        {
            Anbum anbum= new Anbum(hinhAnBum[i],Ten[i],Ngayphathanh[i]);
            danhsachAnBum.add(anbum);
        }
        custom_Adapter_ListView adapteralbum= new custom_Adapter_ListView(MainActivity.this
                ,R.layout.custom_layout_listview,danhsachAnBum);
        adapteralbum.notifyDataSetChanged();
        lvAnBum.setAdapter(adapteralbum);
    }
}