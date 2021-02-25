package com.nguyenvantho.maytho1;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nguyenvantho.maytho1.model.hamvabien;

import java.util.HashMap;
import java.util.Map;

import static com.nguyenvantho.maytho1.R.drawable.custom_suongon;

public class drawer_activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, CompoundButton.OnCheckedChangeListener, View.OnClickListener {
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBar actionBar;
    NavigationView navigationView;
    FragmentManager fragmentManager;
    RadioGroup rgchedo;
    RadioButton rbtudong,rbdieukhien;
    TextView tvnhietdo,tvdoam,tvsuong,tvquat,tvden,tvrem,tvmai,tvchoan,tvuong;

    ToggleButton tgquat,tgrem,tgden,tgmai,tgchoan,tgchouong,tgsuong;
    int suong=0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_layout);


        Intent intent= getIntent();
        Bundle LayGoiThongTin= intent.getExtras();
        String Ten=LayGoiThongTin.getString("ten");
        Toast.makeText(drawer_activity.this,Ten,Toast.LENGTH_SHORT).show();

        toolbar= this.<Toolbar>findViewById(R.id.toolbar);
        drawerLayout= this.<DrawerLayout>findViewById(R.id.drawer_layout);
        navigationView= this.<NavigationView>findViewById(R.id.navigation_view);
        tgquat= this.<ToggleButton>findViewById(R.id.tgquat);
        tgrem= this.<ToggleButton>findViewById(R.id.tgrem);
        tgden= this.<ToggleButton>findViewById(R.id.tgden);
        tgmai= this.<ToggleButton>findViewById(R.id.tgmai);
        tgchoan= this.<ToggleButton>findViewById(R.id.tgchoan);
        tgchouong= this.<ToggleButton>findViewById(R.id.tguong);
        tgsuong= this.<ToggleButton>findViewById(R.id.tgsuong);
        rgchedo= this.<RadioGroup>findViewById(R.id.rgchedo);
        rbtudong= this.<RadioButton>findViewById(R.id.rbtudong);
        rbdieukhien= this.<RadioButton>findViewById(R.id.rbdieukhien);

        tvnhietdo= this.<TextView>findViewById(R.id.tvnhietdo);
        tvdoam= this.<TextView>findViewById(R.id.tvdoam);
        tvsuong= this.<TextView>findViewById(R.id.tvsuong);
        tvquat= this.<TextView>findViewById(R.id.tvquat);
        tvden= this.<TextView>findViewById(R.id.tvden);
        tvrem= this.<TextView>findViewById(R.id.tvrem);
        tvmai= this.<TextView>findViewById(R.id.tvmai);
        tvchoan= this.<TextView>findViewById(R.id.tvchoan);
        tvuong= this.<TextView>findViewById(R.id.tvuong);



        tgquat.setOnCheckedChangeListener(this);
        tgrem.setOnCheckedChangeListener(this);
        tgden.setOnCheckedChangeListener(this);
        tgmai.setOnCheckedChangeListener(this);
        tgchouong.setOnCheckedChangeListener(this);
        tgchoan.setOnCheckedChangeListener(this);
        tgsuong.setOnCheckedChangeListener(this);
        rbtudong.setOnClickListener(this);
        rbdieukhien.setOnClickListener(this);


        setSupportActionBar(toolbar);
        actionBar= getSupportActionBar();

        actionBar.setDisplayHomeAsUpEnabled(true);

        ActionBarDrawerToggle drawerToggle=new ActionBarDrawerToggle(drawer_activity.this,drawerLayout,R.string.open,R.string.close);
        drawerToggle.syncState();

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        navigationView.setNavigationItemSelectedListener(this);
        fragmentManager= getSupportFragmentManager();

        readdata();

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int i=item.getItemId();
        switch (i)
        {
            case R.id.so1:
            {
                FragmentTransaction transaction= fragmentManager.beginTransaction();

                FramentSo1_activity framentSo1_activity= new FramentSo1_activity();
                transaction.replace(R.id.content_layout,framentSo1_activity);
                transaction.commit();
                drawerLayout.closeDrawer(GravityCompat.START);
               ; break;
            }
            case R.id.so2:
            {
                FragmentTransaction transaction1= fragmentManager.beginTransaction();

                FramentSo2_activity framentSo2_activity= new FramentSo2_activity();
                transaction1.replace(R.id.content_layout,framentSo2_activity);
                transaction1.commit();
                drawerLayout.closeDrawer(GravityCompat.START);
               break;
            }
            case R.id.so3:
             {
                 FragmentTransaction transaction2= fragmentManager.beginTransaction();

                 FramentSo3_activity framentSo3_activity = new FramentSo3_activity();
                 transaction2.replace(R.id.content_layout,framentSo3_activity);
                 transaction2.commit();
                 drawerLayout.closeDrawer(GravityCompat.START);
                break;
            }

            case R.id.so5:
            {
                break;
            }
            case R.id.so6:
            {
                break;
            }
        }
        return true;
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
       switch (buttonView.getId())
       {
           case R.id.tgquat:
           {
               if(isChecked)
               {
                   writedata("Quat" ,"off" );
                   tvquat.setText("Quạt Tắt");
                   Toast.makeText(drawer_activity.this,"quat bat !",Toast.LENGTH_SHORT).show();
               }
               else
               {
                   writedata("Quat" ,"on" );
                   tvquat.setText("Quạt Bật");
                   Toast.makeText(drawer_activity.this,"quat tat !",Toast.LENGTH_SHORT).show();
               }
               break;
           }
           case R.id.tgrem:
           {
               if(isChecked)
               {
                   writedata("Rem" ,"off" );
                   tvrem.setText("Rèm Tắt");
                   Toast.makeText(drawer_activity.this,"Rem bat!",Toast.LENGTH_SHORT).show();
               }
               else
               {
                   writedata("Rem" ,"on" );
                   tvrem.setText("Rèm Bật");
                   Toast.makeText(drawer_activity.this,"rem tat !",Toast.LENGTH_SHORT).show();
               }
               break;
           }
           case R.id.tgden:
           {
               if(isChecked)
               {
                   writedata("Den" ,"off" );
                   tvden.setText("Đèn Tắt");
                   Toast.makeText(drawer_activity.this,"den bat !",Toast.LENGTH_SHORT).show();
               }
               else
               {
                   writedata("Den" ,"on" );
                   tvden.setText("Đèn Bật");
                   Toast.makeText(drawer_activity.this,"den tat !",Toast.LENGTH_SHORT).show();
               }
               break;
           }
           case R.id.tgmai:
           {
               if(isChecked)
               {
                   writedata("Mai" ,"off" );
                   tvmai.setText("Mái Tắt");
                   Toast.makeText(drawer_activity.this,"mai bat !",Toast.LENGTH_SHORT).show();
               }
               else
               {
                   writedata("Mai" ,"on" );
                   tvmai.setText("Mái Bật");
                   Toast.makeText(drawer_activity.this,"mai tat !",Toast.LENGTH_SHORT).show();
               }
               break;
           }
           case R.id.tgchoan:
           {
               if(isChecked)
               {
                   writedata("An" ,"off" );
                   tvchoan.setText("Ăn Tắt");
                   Toast.makeText(drawer_activity.this,"cho an bat !",Toast.LENGTH_SHORT).show();
               }
               else
               {
                   writedata("An" ,"on" );
                   tvchoan.setText("Ăn Bật");
                   Toast.makeText(drawer_activity.this,"cho an tat !",Toast.LENGTH_SHORT).show();
               }
               break;
           }
           case R.id.tguong:
           {
               if(isChecked)
               {
                   writedata("Uong" ,"off" );
                   tvuong.setText("Uống Tắt");
                   Toast.makeText(drawer_activity.this,"uong bat !",Toast.LENGTH_SHORT).show();
               }
               else
               {
                   writedata("Uong" ,"on" );
                   tvuong.setText("Uống Bật");
                   Toast.makeText(drawer_activity.this,"uong tat !",Toast.LENGTH_SHORT).show();
               }
               break;
           }
           case R.id.tgsuong:
           {
               if(isChecked)
               {
                   writedata("Suong" ,"off" );
                   tvsuong.setText("Sương Tắt");
                   Toast.makeText(drawer_activity.this,"suong bat !",Toast.LENGTH_SHORT).show();
               }
               else
               {
                   writedata("Suong" ,"on" );
                   tvsuong.setText("Sương Bật");
                   Toast.makeText(drawer_activity.this,"suong tat !",Toast.LENGTH_SHORT).show();
               }
               break;
           }
       }
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch (id)
        {
            case R.id.rbdieukhien:
            {
                writedata("CheDo" ,"dieukhien" );
                Toast.makeText(drawer_activity.this,"Điều khiển !",Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.rbtudong:
            {
                writedata("CheDo" ,"tudong" );
                Toast.makeText(drawer_activity.this,"Tự Động!",Toast.LENGTH_SHORT).show();
                break;
            }
        }
    }

    public void writedata(String ten,String data)
    {
        DatabaseReference mDatabase;
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child(ten).setValue(data);
    }
    public void readdata()
    {
        DatabaseReference datachedo,datanhietdo,datadoam,datasuong,dataquat,dataden,datarem,datamai,dataan,datauong;
        datachedo = FirebaseDatabase.getInstance().getReference("CheDo");
        datachedo.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
               String dulieu= (String) snapshot.getValue();
               if(dulieu.equals("dieukhien"))
               {
                    rbdieukhien.setChecked(true);
                    rbtudong.setChecked(false);
               }
               else
               {
                   rbtudong.setChecked(true);
                   rbdieukhien.setChecked(false);
               }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        ////////
        datanhietdo = FirebaseDatabase.getInstance().getReference("NhietDo");
        datanhietdo.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String dulieu= (String) snapshot.getValue();
                tvnhietdo.setText(dulieu+" C");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        ///
        datadoam = FirebaseDatabase.getInstance().getReference("DoAm");
        datadoam.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String dulieu= (String) snapshot.getValue();
                tvdoam.setText(dulieu+" %");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        ///
        datasuong = FirebaseDatabase.getInstance().getReference("Suong");
        datasuong.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String dulieu= (String) snapshot.getValue();
                if(dulieu.equals("on"))
                {
                    tvsuong.setText("Sương Bật");
                }
                else
                {
                    tvsuong.setText("Sương Tắt");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        ////////
        dataquat = FirebaseDatabase.getInstance().getReference("Quat");
        dataquat.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String dulieu= (String) snapshot.getValue();
                if(dulieu.equals("on"))
                {
                    tvquat.setText("Quạt Bật");
                }
                else
                {
                    tvquat.setText("Quạt Tắt");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        ////////////
        dataden = FirebaseDatabase.getInstance().getReference("Den");
        dataden.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String dulieu= (String) snapshot.getValue();
                if(dulieu.equals("on"))
                {
                    tvden.setText("Đèn Bật");
                }
                else
                {
                    tvden.setText("Đèn Tắt");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        /////
        datarem = FirebaseDatabase.getInstance().getReference("Rem");
        datarem.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String dulieu= (String) snapshot.getValue();
                if(dulieu.equals("on"))
                {
                    tvrem.setText("Rèm Bật");
                }
                else
                {
                    tvrem.setText("Rèm Tắt");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        /////////
        datamai = FirebaseDatabase.getInstance().getReference("Mai");
        datamai.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String dulieu= (String) snapshot.getValue();
                if(dulieu.equals("on"))
                {
                    tvmai.setText("Mái Bật");
                }
                else
                {
                    tvmai.setText("Mái Tắt");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        //////////
        dataan = FirebaseDatabase.getInstance().getReference("An");
        dataan.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String dulieu= (String) snapshot.getValue();
                if(dulieu.equals("on"))
                {
                    tvchoan.setText("Ăn Bật");
                }
                else
                {
                    tvchoan.setText("Ăn Tắt");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        //////// datauong
        datauong = FirebaseDatabase.getInstance().getReference("Uong");
        datauong.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String dulieu= (String) snapshot.getValue();
                if(dulieu.equals("on"))
                {
                    tvuong.setText("Uống Bật");
                }
                else
                {
                    tvuong.setText("Uống Tắt");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


}
