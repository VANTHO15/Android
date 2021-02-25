package com.nguyenvantho.maytrotho.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nguyenvantho.maytrotho.R;

import java.util.List;

public class AdapterSanPham1 extends RecyclerView.Adapter<AdapterSanPham1.ViewHolder> {
    Context context;
    List<String> stringList;
    public AdapterSanPham1(Context context, List<String> stringList)
    {
        this.context= context;
        this.stringList= stringList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txttieudesanpham1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txttieudesanpham1= itemView.<TextView>findViewById(R.id.txttieudesanpham1);
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view= layoutInflater.inflate(R.layout.custom_recycleview_sanpham1,parent,false);

        AdapterSanPham1.ViewHolder viewHolder= new AdapterSanPham1.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txttieudesanpham1.setText(stringList.get(position));
    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }


}
