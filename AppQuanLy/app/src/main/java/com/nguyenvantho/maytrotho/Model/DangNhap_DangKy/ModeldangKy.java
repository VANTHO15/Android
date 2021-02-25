package com.nguyenvantho.maytrotho.Model.DangNhap_DangKy;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.nguyenvantho.maytrotho.Model.ObjectClass.NhanVien;

import java.util.HashMap;
import java.util.Map;

public class ModeldangKy {
    Boolean ketqua=true;
    public Boolean DangKiThanhVien(NhanVien nhanVien)
    {
        NhanVien nhanVien1= new NhanVien();
        nhanVien1= nhanVien;
        DatabaseReference mDatabase;
        mDatabase = FirebaseDatabase.getInstance().getReference();
        String key = mDatabase.child("NHANVIEN").push().getKey();

        Map<String, Object> nhanvienValue = nhanVien1.toMap();
        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/NHANVIEN/" + key, nhanvienValue);
        mDatabase.updateChildren(childUpdates).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                ketqua=true;
            }
        });

        return ketqua;
    }
}
