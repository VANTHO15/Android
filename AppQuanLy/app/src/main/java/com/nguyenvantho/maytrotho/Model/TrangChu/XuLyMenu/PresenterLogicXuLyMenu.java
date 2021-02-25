package com.nguyenvantho.maytrotho.Model.TrangChu.XuLyMenu;

import android.util.Log;

import androidx.annotation.NonNull;

import com.facebook.AccessToken;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.nguyenvantho.maytrotho.Model.DangNhap_DangKy.ModelDangNhap;
import com.nguyenvantho.maytrotho.Model.ObjectClass.LoaiSanPham;
import com.nguyenvantho.maytrotho.Presenter.TrangChu.ViewXuLyMenu;
import com.nguyenvantho.maytrotho.Presenter.TrangChu.XuLyMenu.IPresenterXyLyMenu;

import java.util.List;

public class PresenterLogicXuLyMenu implements IPresenterXyLyMenu {
    ViewXuLyMenu viewXuLyMenu;
    String tennguoidung="";
    public PresenterLogicXuLyMenu(ViewXuLyMenu viewXuLyMenu)
    {
       this.viewXuLyMenu=viewXuLyMenu;
    }
    @Override
    public void LayDanhSachMenu() {
//        List<LoaiSanPham> loaiSanPhamList;
//
//        ConnnectDatabase connnectDatabase= new ConnnectDatabase();
//        String dataJson=connnectDatabase.GetObject();
//        Log.d("kaka",dataJson);
//        XuLyJSONMenu xuLyJSONMenu= new XuLyJSONMenu();
//        loaiSanPhamList= xuLyJSONMenu.ParseJSONMenu(dataJson);
//        viewXuLyMenu.HienThiDanhSachMenu(loaiSanPhamList);
        DatabaseReference all = FirebaseDatabase.getInstance().getReference();
        all.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Object dulieu1= snapshot.getValue();
                Gson gson = new Gson();
                String dulieu = gson.toJson(dulieu1);
                Log.d("haha", dulieu);
                List<LoaiSanPham> loaiSanPhamList;
                XuLyJSONMenu xuLyJSONMenu= new XuLyJSONMenu();
                loaiSanPhamList= xuLyJSONMenu.ParseJSONMenu(dulieu);
                Log.d("hihi", loaiSanPhamList.toString());
                viewXuLyMenu.HienThiDanhSachMenu(loaiSanPhamList);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    @Override
    public AccessToken LayTenNguoiDungFacebook() {
        ModelDangNhap modelDangNhap= new ModelDangNhap();
       AccessToken accessToken= modelDangNhap.layTokenFacebookHienTai();

        return accessToken;
    }
}
