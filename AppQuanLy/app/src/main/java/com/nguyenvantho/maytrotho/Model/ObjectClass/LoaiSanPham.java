package com.nguyenvantho.maytrotho.Model.ObjectClass;

import java.util.List;

public class LoaiSanPham {
    int MALOAISP,MALOAICHA;
    String TENLOAISP;
    List<LoaiSanPham> listCon;

    public LoaiSanPham(int MALOAISP, int MALOAICHA, String TENLOAISP, List<LoaiSanPham> listCon) {
        this.MALOAISP = MALOAISP;
        this.MALOAICHA = MALOAICHA;
        this.TENLOAISP = TENLOAISP;
        this.listCon = listCon;
    }
    public LoaiSanPham() {
    }

    public int getMALOAISP() {
        return MALOAISP;
    }

    public void setMALOAISP(int MALOAISP) {
        this.MALOAISP = MALOAISP;
    }

    public int getMALOAICHA() {
        return MALOAICHA;
    }

    public void setMALOAICHA(int MALOAICHA) {
        this.MALOAICHA = MALOAICHA;
    }

    public String getTENLOAISP() {
        return TENLOAISP;
    }

    public void setTENLOAISP(String TENLOAISP) {
        this.TENLOAISP = TENLOAISP;
    }

    public List<LoaiSanPham> getListCon() {
        return listCon;
    }

    public void setListCon(List<LoaiSanPham> listCon) {
        this.listCon = listCon;
    }

//    public Map<String,Object> tomap()
//    {
//        HashMap<String,Object> result= new HashMap<>();
//        result.put("MALOAISANPHAM",MALOAISP);
//        result.put("MALOAICHA",MALOAICHA);
//        result.put("TENLOAISP", TENLOAISP);
//        result.put("listCon",listCon);
//        return result;
//    }

}
