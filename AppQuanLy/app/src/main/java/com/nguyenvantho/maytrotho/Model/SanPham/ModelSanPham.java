package com.nguyenvantho.maytrotho.Model.SanPham;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.nguyenvantho.maytrotho.Model.ObjectClass.SanPham;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ModelSanPham {
    JSONObject jsonObject;
    List<SanPham> sanPhamList= new ArrayList<>();
    public List<SanPham> LayDanhSachSanPham( String xapxepsp)
    {
        DatabaseReference all = FirebaseDatabase.getInstance().getReference("SANPHAM");
            all.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    Object dulieu1= snapshot.getValue();
                    Gson gson = new Gson();
                    String dulieu = gson.toJson(dulieu1);
                    Log.d("kiemtra1",dulieu);
                    try {
                        jsonObject = new JSONObject(dulieu);
                        JSONArray tencha = jsonObject.names();
                        Log.d("kiemtra2", tencha.toString());
                        int dodai = jsonObject.length();
                        Log.d("kiemtra3", dodai + "");
                        Log.d("kiemtra4", tencha.get(1).toString());
                        for (int i = 0; i < dodai; i++)
                        {
                           Log.d("kiemtra5",i + " ");
                            String bien= tencha.get(i).toString();
                            Log.d("kiemtra6",bien);
                            JSONObject value=jsonObject.getJSONObject(bien);
                            Log.d("kiemtra7",value.toString());
                            if(value.getString("XAPXEPSP").equals(xapxepsp))
                            {
                                Log.d("kiemtra8","xxx");
//                                SanPham sanPham= new SanPham();
//                                sanPham.setANHLON(value.getString("ANHLON"));
//                                sanPham.setANHNHO(value.getString("ANHNHO"));
//                                sanPham.setGIA(value.getString("GIA"));
//                                sanPham.setLUOTMUA(value.getString("LUOTMUA"));
//                                sanPham.setMALOAISP(value.getString("MALOAISP"));
//                                sanPham.setSOLUONG(value.getString("SOLUONG"));
//                                sanPham.setTENSP(value.getString("TENSP"));
//                                sanPham.setTHONGSOKITHUAT(value.getString("THONGSOKITHUAT"));
//                                sanPham.setTHONGTIN(value.getString("THONGTIN"));
//                                sanPham.setXAPXEPSP(value.getString("XAPXEPSP"));
//                                sanPhamList.add(sanPham);
                            }
                         }

                    } catch (JSONException e) {
                        Log.d("kiemtrasai","error");
                        e.printStackTrace();
                    }
//                    JSONObject jsonObject= null;
//                    try {
//                        jsonObject = new JSONObject(dulieu);
//                        JSONArray tencha = jsonObject.names();
//                        int dodai=jsonObject.length();
//                        Log.d("kiemtra2",tencha.toString());
//                        Log.d("kiemtra3",tencha.get(0).toString());
//                        for (int i=0;i<dodai;i++)
//                        {
//                            Log.d("kiemtra4",i + " ");
//                            String bien= tencha.get(i).toString();
//                            JSONObject value=jsonObject.getJSONObject(bien);
//                            Log.d("kiemtra4",bien);
////                            if(value.getString("XAPXEPSP").equals(xapxepsp))
////                            {
////                                SanPham sanPham= new SanPham();
////                                sanPham.setANHLON(value.getString("ANHLON"));
////                                sanPham.setANHNHO(value.getString("ANHNHO"));
////                                sanPham.setGIA(value.getString("GIA"));
////                                sanPham.setLUOTMUA(value.getString("LUOTMUA"));
////                                sanPham.setMALOAISP(value.getString("MALOAISP"));
////                                sanPham.setSOLUONG(value.getString("SOLUONG"));
////                                sanPham.setTENSP(value.getString("TENSP"));
////                                sanPham.setTHONGSOKITHUAT(value.getString("THONGSOKITHUAT"));
////                                sanPham.setTHONGTIN(value.getString("THONGTIN"));
////                                sanPham.setXAPXEPSP(value.getString("XAPXEPSP"));
////                                sanPhamList.add(sanPham);
////                            }
//
//                        }
//
//
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
            Log.d("kiemtran",sanPhamList +" ");
            return sanPhamList;
    }
}
