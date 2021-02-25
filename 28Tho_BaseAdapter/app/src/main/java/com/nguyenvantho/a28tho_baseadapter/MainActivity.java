package com.nguyenvantho.a28tho_baseadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.nguyenvantho.a28tho_baseadapter.Adapter.customadapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
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
        lvAnBum.setOnItemClickListener(this);

        danhsachAnBum= new ArrayList<>();
        for (int i=0;i<Ten.length;i++)
        {
            Anbum anbum= new Anbum(hinhAnBum[i],Ten[i],Ngayphathanh[i]);
            danhsachAnBum.add(anbum);
        }
        customadapter customadapter= new customadapter(this,R.layout.custom_layout_adapter,danhsachAnBum);
        customadapter.notifyDataSetChanged();
        lvAnBum.setAdapter(customadapter);
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(MainActivity.this,danhsachAnBum.get(position).getTen().toString()
                ,Toast.LENGTH_SHORT).show();
    }
}