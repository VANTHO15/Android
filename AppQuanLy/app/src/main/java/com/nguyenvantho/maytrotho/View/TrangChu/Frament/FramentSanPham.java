package com.nguyenvantho.maytrotho.View.TrangChu.Frament;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nguyenvantho.maytrotho.Adapter.AdapterSanPham;
import com.nguyenvantho.maytrotho.Model.ObjectClass.SanPham;
import com.nguyenvantho.maytrotho.Presenter.TrangChu_SanPham.PresenterLogicSanPham;
import com.nguyenvantho.maytrotho.R;
import com.nguyenvantho.maytrotho.View.TrangChu.ViewSanPham;

import java.util.ArrayList;
import java.util.List;

public class FramentSanPham  extends Fragment implements ViewSanPham {
    RecyclerView recyclerView;
    List<SanPham> sanPhamList  ;
    PresenterLogicSanPham presenterLogicSanPham;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.sanpham_layout,container,false);

        sanPhamList= new ArrayList<>();

        presenterLogicSanPham = new PresenterLogicSanPham(this);

        recyclerView= view.<RecyclerView>findViewById(R.id.recyclSanPham);

        presenterLogicSanPham.LayDanhSachSanPham("MoiNhat");
        return view;
    }

    @Override
    public void HienThiDanhSach(List<SanPham> sanPhams) {

        SanPham sanPham;
        int dai=sanPhams.size();
        for (int i=0;i<dai;i++)
        {
            sanPham=sanPhams.get(i);
            sanPhamList.add(sanPham);
        }
        AdapterSanPham adapterSanPham= new AdapterSanPham(getContext(),sanPhamList);

        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterSanPham);

        adapterSanPham.notifyDataSetChanged();

    }
}
