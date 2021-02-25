package com.nguyenvantho.a22tho_intentsendata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nguyenvantho.a22tho_intentsendata.DTO.SinhVien;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnTruyen;
    EditText edtHoTen,edtLop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTruyen= this.<Button>findViewById(R.id.button);
        edtHoTen= this.<EditText>findViewById(R.id.editTextTextPersonName);
        edtLop= this.<EditText>findViewById(R.id.editTextTextPersonName2);

        btnTruyen.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
//        Intent iOpenManHinh2= new Intent(MainActivity.this,manhinh2.class);
//        Bundle goithongtin= new Bundle();
//        goithongtin.putString("hoten",edtHoTen.getText().toString());
//        goithongtin.putString("lop",edtLop.getText().toString());
//        iOpenManHinh2.putExtra("goithongtin",goithongtin);
//        startActivity(iOpenManHinh2);

        Intent iOpenManHinh2= new Intent(MainActivity.this,manhinh2.class);
        SinhVien sv= new SinhVien(99,"Nguyễn Văn Thọ","18CDT1");
        iOpenManHinh2.putExtra("sinhvien",sv);
        startActivity(iOpenManHinh2);

    }
}