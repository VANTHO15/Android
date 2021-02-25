package com.nguyenvantho.maytrotho.View.TrangChu.Frament;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nguyenvantho.maytrotho.Adapter.AdapterSanPham1;
import com.nguyenvantho.maytrotho.R;

import java.util.ArrayList;
import java.util.List;

public class FramentSanPham1 extends Fragment {
    RecyclerView recyclerViewsanpham1;
    AdapterSanPham1 adapterSanPham1;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.sanpham1_layout,container,false);
        recyclerViewsanpham1= view.<RecyclerView>findViewById(R.id.recycleSanPham1);
        List<String> dulieu= new ArrayList<>();
        for(int i=0;i<30;i++)
        {
            String ten="Chu Mục "+ i;
            dulieu.add(ten);
        }
        RecyclerView.LayoutManager layoutManager= new GridLayoutManager(getActivity(),2,RecyclerView.HORIZONTAL,false); // 5 là số cột trên 1 dòng
      //  RecyclerView.LayoutManager layoutManager= new GridLayoutManager(getActivity(),3);
        adapterSanPham1 = new AdapterSanPham1(getActivity(),dulieu);

        recyclerViewsanpham1.setLayoutManager(layoutManager);
        recyclerViewsanpham1.setAdapter(adapterSanPham1);

        adapterSanPham1.notifyDataSetChanged();
        return view;
    }
}
