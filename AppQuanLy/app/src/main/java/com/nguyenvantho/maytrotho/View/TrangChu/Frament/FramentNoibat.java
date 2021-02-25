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

import com.nguyenvantho.maytrotho.Adapter.AdapterNoibat;
import com.nguyenvantho.maytrotho.R;

import java.util.ArrayList;
import java.util.List;

public class FramentNoibat  extends Fragment {
    RecyclerView recyclerView;
    AdapterNoibat adapterNoibat;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.noibat_layout,container,false);
        recyclerView= view.<RecyclerView>findViewById(R.id.recyclerNoibat);
        List<String> dulieu= new ArrayList<>();
        for(int i=0;i<69;i++)
        {
            String ten="Sản Phẩm "+ i;
            dulieu.add(ten);
        }
        // RecyclerView.LayoutManager layoutManager=new  LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        RecyclerView.LayoutManager layoutManager= new GridLayoutManager(getActivity(),3); // 5 là số cột trên 1 dòng
        adapterNoibat = new AdapterNoibat(getActivity(),dulieu);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterNoibat);

        adapterNoibat.notifyDataSetChanged();
        return view;
    }
}
