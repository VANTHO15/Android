package com.nguyenvantho.a27tho_listview_arrayadapter.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.nguyenvantho.a27tho_listview_arrayadapter.Anbum;
import com.nguyenvantho.a27tho_listview_arrayadapter.R;

import java.util.List;

public class custom_Adapter_ListView extends ArrayAdapter<Anbum> {
    Context context;
    int resource;
    List<Anbum> list;
    public custom_Adapter_ListView(@NonNull Context context, int resource, @NonNull List<Anbum> list) {
        super(context, resource, list);
        this.context= context;
        this.resource= resource;
        this.list= list;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowItem=inflater.inflate(R.layout.custom_layout_listview,parent,false);

        ImageView hinhAnBum= rowItem.<ImageView>findViewById(R.id.imghinhAnBum);
        TextView txtTen= rowItem.<TextView>findViewById(R.id.txtTen);
        TextView txtNgay= rowItem.<TextView>findViewById(R.id.txtNgayPhatHanh);

        hinhAnBum.setImageResource(list.get(position).getHinhAnh());
        txtTen.setText("Tên Album: "+ list.get(position).getTen().toString());
        txtNgay.setText("Ngày phát hành: "+list.get(position).getNgayPhatHanh().toString());
        return rowItem;
    }
}
