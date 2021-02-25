package com.nguyenvantho.maytrotho.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nguyenvantho.maytrotho.Model.ObjectClass.SanPham;
import com.nguyenvantho.maytrotho.R;

import java.util.List;

public class AdapterSanPham  extends RecyclerView.Adapter<AdapterSanPham.ViewHolderSanPham> {
    Context context;
    List<SanPham> sanPhamList;
    public AdapterSanPham(Context context, List<SanPham> sanPhamList){
        this.context= context;
       this.sanPhamList= sanPhamList;
    }

    public class ViewHolderSanPham extends RecyclerView.ViewHolder {
        ImageView imHinhKhuyenMai;
        RecyclerView recyclerViewMoiNhat,recyclerViewUaChuongNhat;
        public ViewHolderSanPham(@NonNull View itemView) {
            super(itemView);

            recyclerViewMoiNhat= itemView.<RecyclerView>findViewById(R.id.recycleSanPhamMoiNhat);
            recyclerViewUaChuongNhat= itemView.<RecyclerView>findViewById(R.id.recycleSanPhamMoiNhat);
            imHinhKhuyenMai= itemView.<ImageView>findViewById(R.id.imKhuyenMaiSanPham);
        }
    }
    @NonNull
    @Override
    public ViewHolderSanPham onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view= inflater.inflate(R.layout.custom_layout_recycellayout_sanpham,parent,false);

        ViewHolderSanPham viewHolderSanPham= new ViewHolderSanPham(view);

        return viewHolderSanPham;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderSanPham holder, int position) {
       // SanPham sanPham= sanPhamList.get(position);
        AdapterSanPhamMoiNhat adapterSanPham= new AdapterSanPhamMoiNhat(context,sanPhamList);

        RecyclerView.LayoutManager layoutManager= new GridLayoutManager(context,3,GridLayoutManager.HORIZONTAL,false);
        holder.recyclerViewMoiNhat.setLayoutManager(layoutManager);
        holder.recyclerViewMoiNhat.setAdapter(adapterSanPham);
        adapterSanPham.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return sanPhamList.size();
    }


}
