package com.nguyenvantho.maytho1.model;
import com.google.firebase.database.IgnoreExtraProperties;
import java.util.HashMap;
import java.util.Map;

public class hamvabien {
    public String nhietdo,doam,suong,chedo,quat,den,rem,mai,an,uong;
    public hamvabien()
    {

    }

    public hamvabien(String nhietdo, String doam, String suong, String chedo, String quat, String den, String rem, String mai, String an, String uong) {
        this.nhietdo = nhietdo;
        this.doam = doam;
        this.suong = suong;
        this.chedo = chedo;
        this.quat = quat;
        this.den = den;
        this.rem = rem;
        this.mai = mai;
        this.an = an;
        this.uong = uong;
    }

    public Map<String,Object> toMap(){
        HashMap<String,Object> result= new HashMap<>();
        result.put("NhietDo",nhietdo);
        result.put("DoAm",doam);
        result.put("Suong",suong);
        result.put("CheDo",chedo);
        result.put("Quat",quat);
        result.put("Den",den);
        result.put("Rem",rem);
        result.put("CheDo",chedo);
        result.put("Quat",quat);
        result.put("Den",den);
        result.put("Rem",rem);
        result.put("Mai",mai);
        result.put("An",an);
        result.put("Uong",uong);
        return result;
    }
}
