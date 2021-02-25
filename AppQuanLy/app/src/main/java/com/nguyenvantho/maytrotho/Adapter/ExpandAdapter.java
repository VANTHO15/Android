package com.nguyenvantho.maytrotho.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nguyenvantho.maytrotho.Model.ObjectClass.LoaiSanPham;
import com.nguyenvantho.maytrotho.Model.TrangChu.XuLyMenu.XuLyJSONMenu;
import com.nguyenvantho.maytrotho.R;

import java.util.List;

public class ExpandAdapter extends BaseExpandableListAdapter {
    Context context;
    List<LoaiSanPham> loaiSanPhams;
    ViewHolderMenu viewHolderMenu;
    public ExpandAdapter(Context context, List<LoaiSanPham> loaiSanPhams)
    {
        this.context= context;
        this.loaiSanPhams= loaiSanPhams;

        XuLyJSONMenu xuLyJSONMenu= new XuLyJSONMenu();
        int count= loaiSanPhams.size();

        for (int i=0;i<count;i++)
        {
            int maloaisp=loaiSanPhams.get(i).getMALOAICHA();
            loaiSanPhams.get(i).setListCon(xuLyJSONMenu.LayLoaiSanPhamTheoMaLoai(maloaisp+100));
        }
    }
    @Override
    public int getGroupCount() {
        return loaiSanPhams.size();
    }

    @Override
    public int getChildrenCount(int vitrigroupcha) {
        return loaiSanPhams.get(vitrigroupcha).getListCon().size();
    }

    @Override
    public Object getGroup(int vitrigroupcha) {
        return loaiSanPhams.get(vitrigroupcha);
    }

    @Override
    public Object getChild(int vitrigroupcha, int vitrigroupcon) {
        return loaiSanPhams.get(vitrigroupcha).getListCon().get(vitrigroupcon);
    }

    @Override
    public long getGroupId(int vitrigroupcha) {
        return loaiSanPhams.get(vitrigroupcha).getMALOAISP();
    }

    @Override
    public long getChildId(int vitrigroupcha, int vitrigroupcon) {
        return loaiSanPhams.get(vitrigroupcha).getListCon().get(vitrigroupcon).getMALOAISP();
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    public class ViewHolderMenu{
        TextView txtTenloaisp;
        ImageView hinhMenu;
    }

    @Override
    public View getGroupView(int vitrigroupcha, boolean isExpanded, View convertView, ViewGroup parent) {

        View viewgroupcha=convertView;
        if(viewgroupcha==null)
        {
            viewHolderMenu= new ViewHolderMenu();

            LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            viewgroupcha=layoutInflater.inflate(R.layout.custom_layout_groupcha,parent,false);

            viewHolderMenu.txtTenloaisp= viewgroupcha.<TextView>findViewById(R.id.txtTenloaisp);
            viewHolderMenu.hinhMenu= viewgroupcha.<ImageView>findViewById(R.id.immenu);

            viewgroupcha.setTag(viewHolderMenu);

        }
        else
        {
            viewHolderMenu= (ViewHolderMenu) viewgroupcha.getTag();
        }




        viewHolderMenu.txtTenloaisp.setText(loaiSanPhams.get(vitrigroupcha).getTENLOAISP());
        int demsanphamcon= loaiSanPhams.get(vitrigroupcha).getListCon().size();
        if(demsanphamcon>0)
        {
            viewHolderMenu.hinhMenu.setVisibility(View.VISIBLE);
        }
        else
        {
            viewHolderMenu.hinhMenu.setVisibility(View.INVISIBLE);
        }

        if(isExpanded)
        {
            viewHolderMenu.hinhMenu.setImageResource(R.drawable.ic_remove_black_24dp);
            viewgroupcha.setBackgroundResource(R.color.colorxanh);
        }
        else
        {
            viewHolderMenu.hinhMenu.setImageResource(R.drawable.ic_add_black_24dp);
            viewgroupcha.setBackgroundResource(R.color.colorwhite);
        }

        viewgroupcha.setOnTouchListener(new View.OnTouchListener() {   // set sự kiện click
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d("sanpham",loaiSanPhams.get(vitrigroupcha).getTENLOAISP()+" ");
                return false;
            }
        });

        return viewgroupcha;
    }

    @Override
    public View getChildView(int vitrigroupcha, int vitrigroupcon, boolean isExpanded, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewgroupcon=layoutInflater.inflate(R.layout.custom_layout_group_con,parent,false);

        TextView txtTenloaisanpham= viewgroupcon.<TextView>findViewById(R.id.txtTenloaisp);
        txtTenloaisanpham.setText(loaiSanPhams.get(vitrigroupcha).getListCon().get(vitrigroupcon).getTENLOAISP());
        return viewgroupcon;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }


}
