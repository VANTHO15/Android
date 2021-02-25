package com.nguyenvantho.maytrotho.Model.TrangChu.XuLyMenu;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.nguyenvantho.maytrotho.Model.ObjectClass.LoaiSanPham;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class XuLyJSONMenu {
    String tennguoidung="";
    public List<LoaiSanPham> ParseJSONMenu(String dulieujson){
        List<LoaiSanPham> loaiSanPhamList= new ArrayList<>();

        try {
            JSONObject jsonObject= new JSONObject(dulieujson);
            JSONArray loaisanpham=jsonObject.getJSONArray("LOAISANPHAM");
            Log.d("ppp", loaisanpham.toString());
            int count=loaisanpham.length();
            Log.d("kkk",""+count);
            for(int i=0;i<count;i++)
            {

                JSONObject value= loaisanpham.getJSONObject(i);
                Log.d("laa",value.toString());
                if(Integer.parseInt(value.getString("MALOAI_CHA"))<=100)   // có 100 mã cha
                {
                    LoaiSanPham dataloaiSanPham=new LoaiSanPham();
                    dataloaiSanPham.setMALOAICHA(Integer.parseInt(value.getString("MALOAI_CHA")) );
                    dataloaiSanPham.setTENLOAISP(value.getString("TENLOAISP"));
                    Log.d("lll",value.getString("TENLOAISP"));
                    loaiSanPhamList.add(dataloaiSanPham);
                }

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d("fff",loaiSanPhamList.toString());
        return loaiSanPhamList;
    }

    public List<LoaiSanPham> LayLoaiSanPhamTheoMaLoai(int maloaisp)
    {
        List<LoaiSanPham> loaiSanPhamList= new ArrayList<>();
        DatabaseReference all = FirebaseDatabase.getInstance().getReference();
        all.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Object dulieu1= snapshot.getValue();
                Gson gson = new Gson();
                String dulieu = gson.toJson(dulieu1);
                JSONObject jsonObject= null;
                try {
                    jsonObject = new JSONObject(dulieu);
                    JSONArray loaisanpham=jsonObject.getJSONArray("LOAISANPHAM");
                    int count=loaisanpham.length();
                    for(int i=0;i<count;i++)
                    {
                        JSONObject value= loaisanpham.getJSONObject(i);
                        if(Integer.parseInt(value.getString("MALOAI_CHA"))== maloaisp  )
                        {
                            LoaiSanPham dataloaiSanPham=new LoaiSanPham();
                            dataloaiSanPham.setMALOAICHA(Integer.parseInt(value.getString("MALOAI_CHA")) );
                            dataloaiSanPham.setTENLOAISP(value.getString("TENLOAISP"));
                            loaiSanPhamList.add(dataloaiSanPham);
                        }
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return loaiSanPhamList;
    }

}
