package com.nguyenvantho.a27tho_listview_arrayadapter;

public class Anbum {
    int HinhAnh;
    String Ten;
    String NgayPhatHanh;

    public Anbum(int hinhAnh, String ten, String ngayPhatHanh) {
        this.HinhAnh = hinhAnh;
        this.Ten = ten;
        this.NgayPhatHanh = ngayPhatHanh;
    }

    public int getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(int hinhAnh) {
        HinhAnh = hinhAnh;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getNgayPhatHanh() {
        return NgayPhatHanh;
    }

    public void setNgayPhatHanh(String ngayPhatHanh) {
        NgayPhatHanh = ngayPhatHanh;
    }


}
