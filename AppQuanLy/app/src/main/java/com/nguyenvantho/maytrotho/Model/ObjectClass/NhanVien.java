package com.nguyenvantho.maytrotho.Model.ObjectClass;

import java.util.HashMap;
import java.util.Map;

public class NhanVien {

    public String TenNV;
    public String TenDangNhap;
    public  String MatKhau;
    public String DiaChi;
    public String NgaySinh;
    public String SoDienThoai;
    public String GioiTinh;
    public String MaLoaiNV;

    public NhanVien()
    {

    }

    public NhanVien(String tenNV, String tenDangNhap, String matKhau, String diaChi,
                    String ngaySinh, String soDienThoai, String gioiTinh, String maLoaiNV) {
        TenNV = tenNV;
        TenDangNhap = tenDangNhap;
        MatKhau = matKhau;
        DiaChi = diaChi;
        NgaySinh = ngaySinh;
        SoDienThoai = soDienThoai;
        GioiTinh = gioiTinh;
        MaLoaiNV = maLoaiNV;
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("TENNV", TenNV);
        result.put("TENDANGNHAP", TenDangNhap);
        result.put("MATKHAU", MatKhau);
        result.put("DIACHI", DiaChi);
        result.put("NGAYSINH", NgaySinh);
        result.put("SODIENTHOAI", SoDienThoai);
        result.put("GIOITINH", GioiTinh);
        result.put("MALOAINV", MaLoaiNV);
        return result;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String tenNV) {
        TenNV = tenNV;
    }

    public String getTenDangNhap() {
        return TenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        TenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String matKhau) {
        MatKhau = matKhau;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        SoDienThoai = soDienThoai;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public String getMaLoaiNV() {
        return MaLoaiNV;
    }

    public void setMaLoaiNV(String maLoaiNV) {
        MaLoaiNV = maLoaiNV;
    }


}
