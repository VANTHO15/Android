package com.nguyenvantho.maytrotho.ConnnectDatabaseFirebase;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.nguyenvantho.maytrotho.Model.ObjectClass.NhanVien;

public class ConnnectDatabase {
    String dulieu="";

    public void setData(String ten,String data)
    {
        DatabaseReference mDatabase;
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child(ten).setValue(data);
    }
    public void pushData(String ten, String data)
    {
        DatabaseReference mDatabase;
        mDatabase = FirebaseDatabase.getInstance().getReference();
        String key= mDatabase.child(ten).getKey();
    }
    public void updatavitri(String vitri)
    {
        DatabaseReference mDatabase;
//        ChatItem chatItem= new ChatItem(ID,email,noidung);
//        Map<String,Object> chatvalues=chatItem.toMap();
//
//        String key=mDatabase.child("chats").push().getKey();
//
//        Map<String,Object> childupdate=new HashMap<>();
//        childupdate.put("/chats/"+key),chatvalues);
//        childupdate.put("/user-chats/"+id+"/"+key,chatvalues);
//        mDatabase.updateChildren(childupdate);

    }
    public void removedata(String vitri)
    {
        FirebaseDatabase database= FirebaseDatabase.getInstance();
        DatabaseReference myRes= database.getReference(vitri);
        myRes.removeValue();
    }
    public String GetObject()
    {

//        DatabaseReference data;
//        data = FirebaseDatabase.getInstance().getReference();

//        DatabaseReference allPost = FirebaseDatabase.getInstance().getReference().child("haha");
//        DatabaseReference post = FirebaseDatabase.getInstance().getReference().child("haha").child("1");
        DatabaseReference all = FirebaseDatabase.getInstance().getReference();
        all.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Object dulieu1= snapshot.getValue();
                Gson gson = new Gson();
                dulieu = gson.toJson(dulieu1);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        // begin 1
//        datachedo = FirebaseDatabase.getInstance().getReference("CheDo");
//        datachedo.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                String dulieu= (String) snapshot.getValue();
//                if(dulieu.equals("dieukhien"))
//                {
//                }
//                else
//                {
//                }
//            }
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//            }
//        });
        // end 1
        Log.d("haha", dulieu);
        return dulieu;
    }

    public void DangKiThanhVien(String tennv,String tendangnhap, String matkhau,String diachi,String ngaysinh,
                                String sodienthoai, String gioitinh,String maloainv)
    {
        DatabaseReference mDatabase;
        mDatabase = FirebaseDatabase.getInstance().getReference();
        NhanVien nhanVien= new NhanVien(tennv,tendangnhap,matkhau,diachi,ngaysinh,sodienthoai,gioitinh,maloainv);
        mDatabase.child("NHANVIEN").setValue(nhanVien);
    }

}
