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

public class AdapterNoibat extends RecyclerView.Adapter<AdapterNoibat.ViewHolder> {
    Context context;
    List<String> stringList;
    public AdapterNoibat(Context context, List<String> stringList)
    {
        this.context= context;
        this.stringList= stringList;
    }

    // chạy thứ 2
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView= itemView.<TextView>findViewById(R.id.txttieudenoibat);
        }
    }
    // chạy đầu tiên
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view= layoutInflater.inflate(R.layout.custom_recyclerview_noibat,parent,false);

        ViewHolder viewHolder= new ViewHolder(view);
        return viewHolder;
    }
    // chạy thứ 3
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(stringList.get(position));
    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }


}
