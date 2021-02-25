package com.nguyenvantho.maytrotho.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.nguyenvantho.maytrotho.View.TrangChu.Frament.FramentBieuDo;
import com.nguyenvantho.maytrotho.View.TrangChu.Frament.FramentNoibat;
import com.nguyenvantho.maytrotho.View.TrangChu.Frament.FramentSanPham;
import com.nguyenvantho.maytrotho.View.TrangChu.Frament.FramentSanPham1;
import com.nguyenvantho.maytrotho.View.TrangChu.Frament.FramentThanhVien;
import com.nguyenvantho.maytrotho.View.TrangChu.Frament.FramentTinhTien;

import java.util.ArrayList;
import java.util.List;

public class ViewpagerAdapter extends FragmentPagerAdapter {
    List<Fragment> listFrament = new ArrayList<Fragment>();
    List<String> titleFrament = new ArrayList<String>();

    public ViewpagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
        listFrament.add(new FramentSanPham1());
        listFrament.add(new FramentNoibat());
        listFrament.add(new FramentSanPham());
        listFrament.add(new FramentBieuDo());
        listFrament.add(new FramentTinhTien());
        listFrament.add(new FramentThanhVien());


        titleFrament.add("Trang Chủ");
        titleFrament.add("Nổi Bật");
        titleFrament.add("Sản Phẩm");
        titleFrament.add("Biểu Đồ");
        titleFrament.add("Tính Tiền");
        titleFrament.add("Thành Viên");

    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return listFrament.get(position);
    }

    @Override
    public int getCount() {
        return listFrament.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titleFrament.get(position);
    }
}
