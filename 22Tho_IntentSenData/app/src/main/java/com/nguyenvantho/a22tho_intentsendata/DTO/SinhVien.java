package com.nguyenvantho.a22tho_intentsendata.DTO;

import java.io.Serializable;

public class SinhVien implements Serializable {
    int Ma;
    String Ten;
    String Lop;

    public SinhVien(int ma, String ten, String lop) {
        this.Ma = ma;
        this.Ten = ten;
        this.Lop = lop;
    }

    public int getMa() {
        return Ma;
    }

    public void setMa(int ma) {
        Ma = ma;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getLop() {
        return Lop;
    }

    public void setLop(String lop) {
        Lop = lop;
    }
}
