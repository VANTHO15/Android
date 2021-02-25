package com.nguyenvantho.maytrotho.Presenter.DangKi;

import com.nguyenvantho.maytrotho.Model.DangNhap_DangKy.ModeldangKy;
import com.nguyenvantho.maytrotho.Model.ObjectClass.NhanVien;
import com.nguyenvantho.maytrotho.View.DangNhap_DangKy.ViewDangKy;

public class PresenterLogicDangKy  implements iPresenterdangKi{
    ViewDangKy viewDangKy;
    ModeldangKy modeldangKy;

    public PresenterLogicDangKy(ViewDangKy viewDangKy)
    {
        this.viewDangKy= viewDangKy;
        modeldangKy = new ModeldangKy();
    }
    @Override
    public void ThucHienDangKi(NhanVien nhanVien) {
           Boolean kiemtra= modeldangKy.DangKiThanhVien(nhanVien);
           if(kiemtra)
           {
               viewDangKy.DangKiThanhCong();
           }
           else
           {
               viewDangKy.DangKiThatbai();
           }
    }
}
