package com.nguyenvantho.maytrotho.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nguyenvantho.maytrotho.Model.ObjectClass.SanPham;
import com.nguyenvantho.maytrotho.R;

import java.util.List;

public class AdapterSanPhamMoiNhat extends RecyclerView.Adapter<AdapterSanPhamMoiNhat.ViewHolderSanPhamMoiNhat> {

    Context context;
    List<SanPham> sanPhams;
    public AdapterSanPhamMoiNhat(Context context, List<SanPham> sanPhams)
    {
        this.context= context;
        this.sanPhams= sanPhams;
    }
    public class ViewHolderSanPhamMoiNhat extends  RecyclerView.ViewHolder {
        TextView txtTieuDeSanPham;
        ImageView imHinhSanPham;
        public ViewHolderSanPhamMoiNhat(@NonNull View itemView) {
            super(itemView);
            txtTieuDeSanPham= itemView.<TextView>findViewById(R.id.tieudeSanPham);
            imHinhSanPham= itemView.<ImageView>findViewById(R.id.imHinhSanPham);
        }
    }
    @Override
    public ViewHolderSanPhamMoiNhat onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view= inflater.inflate(R.layout.custom_layout_sanpham_moinhat,parent,false);

        ViewHolderSanPhamMoiNhat viewHolder= new ViewHolderSanPhamMoiNhat(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderSanPhamMoiNhat holder, int position) {
        SanPham sanPham= sanPhams.get(position);
       // holder.txtTieuDeSanPham.setText(sanPham.getTENSP());
       // Picasso.with(context).load(sanPham.getANHNHO()).resize(150,150).into(holder.imHinhSanPham);
        holder.txtTieuDeSanPham.setText("Chu Muc");
        holder.imHinhSanPham.setImageResource(R.drawable.anh);
    }

    @Override
    public int getItemCount() {
        return 10;
       // return sanPhams.size();
    }


}
