package com.nguyenvantho.maytrotho.Presenter.TrangChu_SanPham;

import com.nguyenvantho.maytrotho.Model.ObjectClass.SanPham;
import com.nguyenvantho.maytrotho.Model.SanPham.ModelSanPham;
import com.nguyenvantho.maytrotho.View.TrangChu.ViewSanPham;

import java.util.List;

public class PresenterLogicSanPham implements IPresenterSanPham {
    ViewSanPham viewSanPham;
    ModelSanPham modelSanPham;

    public PresenterLogicSanPham(ViewSanPham viewSanPham)
    {
        this.viewSanPham= viewSanPham;
        modelSanPham= new ModelSanPham();
    }
    @Override
    public void LayDanhSachSanPham(String xapxepsp) {
         List<SanPham> sanPhamList = modelSanPham.LayDanhSachSanPham(xapxepsp);
         if(sanPhamList.size()>0)
         {
             viewSanPham.HienThiDanhSach(sanPhamList);
         }
    }
}
