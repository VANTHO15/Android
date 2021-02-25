package com.nguyenvantho.a28tho_baseadapter.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nguyenvantho.a28tho_baseadapter.Anbum;
import com.nguyenvantho.a28tho_baseadapter.R;

import java.util.List;

public class customadapter extends BaseAdapter {
    Context context;
    int layout;
    List<Anbum> anbums;
    public customadapter(Context context, int layout, List<Anbum> anbums)
    { this.context= context;this.layout= layout;this.anbums= anbums; }
    @Override
    public int getCount() {
        return anbums.size();  // trả ra số item hiển thị trên listView
    }
    @Override
    public Object getItem(int position) {
        return position; }
    @Override
    public long getItemId(int position) {
        return 0; }
    public static class ViewHolder{
        ImageView hinhAnBum;
        TextView txtTen,txtNgay;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewRow=convertView;
        if (viewRow==null)
        {
            viewRow=inflater.inflate(layout,parent,false);
            ViewHolder holder= new ViewHolder();
             holder.hinhAnBum= viewRow.<ImageView>findViewById(R.id.imghinhAnBum);
             holder.txtTen= viewRow.<TextView>findViewById(R.id.txtTen);
             holder.txtNgay= viewRow.<TextView>findViewById(R.id.txtNgayPhatHanh);
             viewRow.setTag(holder);
        }
        ViewHolder holder= (ViewHolder) viewRow.getTag();

        holder.hinhAnBum.setImageResource(anbums.get(position).getHinhAnh());
        holder.txtTen.setText("Tên Album: "+ anbums.get(position).getTen().toString());
        holder.txtNgay.setText("Ngày phát hành: "+anbums.get(position).getNgayPhatHanh().toString());
        return viewRow;
    }
}
