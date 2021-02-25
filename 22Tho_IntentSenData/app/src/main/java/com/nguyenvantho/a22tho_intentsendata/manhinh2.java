package com.nguyenvantho.a22tho_intentsendata;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.nguyenvantho.a22tho_intentsendata.DTO.SinhVien;

public class manhinh2 extends AppCompatActivity {
    TextView txtNhanHoTen,txtNhanLop;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manhinh2);
        txtNhanHoTen= this.<TextView>findViewById(R.id.txtNhanHoTen);
        txtNhanLop= this.<TextView>findViewById(R.id.txtNhanLop);

//        Intent iNhan = getIntent();
//        Bundle laygoithongtin= iNhan.getBundleExtra("goithongtin");
//        String HoTen=laygoithongtin.getString("hoten");
//        String Lop=laygoithongtin.getString("lop");
//        txtNhanHoTen.setText(HoTen);
//        txtNhanLop.setText(Lop);


        SinhVien sv= (SinhVien) getIntent().getSerializableExtra("sinhvien");
        txtNhanHoTen.setText(sv.getTen());
        txtNhanLop.setText(sv.getLop());
    }
}
