package com.nguyenvantho.maytrotho.Model.DangNhap_DangKy;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ModelDangNhap {
    AccessToken accessToken;
    AccessTokenTracker accessTokenTracker;
    Boolean ketquaKiemTraDangNhap=false;
    public AccessToken layTokenFacebookHienTai()
    {
        accessTokenTracker= new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {
                accessToken= currentAccessToken;
            }
        };

        accessToken= AccessToken.getCurrentAccessToken();
        return accessToken;
    }
    public GoogleApiClient LayGoogleApiClient(Context context, GoogleApiClient.OnConnectionFailedListener failedListener)
    {
        GoogleApiClient mGoogleApiClient;
        GoogleSignInOptions googleSignInOptions= new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleApiClient = new GoogleApiClient.Builder(context)
                .enableAutoManage(((AppCompatActivity)context),failedListener)
                .addApi(Auth.GOOGLE_SIGN_IN_API,googleSignInOptions)
                .build();
        return mGoogleApiClient;
    }
    public GoogleSignInResult LayThongTinDangNhapGoogle(GoogleApiClient googleApiClient)
    {
        OptionalPendingResult<GoogleSignInResult> opr= Auth.GoogleSignInApi.silentSignIn(googleApiClient);
        if(opr.isDone())
        {
            return opr.get();
        }
        else
        {
            return null;
        }
    }
    public void HuyToKenTracker()
    {
        accessTokenTracker.stopTracking();
    }
    // hamf truyen ten dawng nhap tu cached
    public  String LayCachedsDangNhap(Context context)
    {
        SharedPreferences cachedDangNhap=context.getSharedPreferences("dangnhap",Context.MODE_PRIVATE);
        String tennhanvien= cachedDangNhap.getString("tennv","");

       return tennhanvien;
    }
    public  void  CapNhatCachedDangNhap(Context context,String tennv)
    {
        SharedPreferences cachedDangNhap=context.getSharedPreferences("dangnhap",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=cachedDangNhap.edit();
        editor.putString("tennv",tennv);
        editor.commit();
    }
    //begin  dăng nhập
    public  boolean KiemTraDangNhap(Context context,String tendn,String matkhau)
    {

        DatabaseReference all = FirebaseDatabase.getInstance().getReference("NHANVIEN");
        all.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Object dulieu1= snapshot.getValue();
                Gson gson = new Gson();
                String dulieu = gson.toJson(dulieu1);
                Log.d("kiemtra",dulieu);
                JSONObject jsonObject= null;
                try {
                    jsonObject = new JSONObject(dulieu);
                    JSONArray tencha = jsonObject.names();
                    int dodai=jsonObject.length();
                    for (int i=0;i<dodai;i++)
                    {

                        JSONObject value=jsonObject.getJSONObject(tencha.get(i).toString());
                        Log.d("kitu",value.toString());  // tencha.get(i).toString()
                        if(value.getString("TENDANGNHAP").equals(tendn) && value.getString("MATKHAU").equals(matkhau))
                        {
                            ketquaKiemTraDangNhap=true;
                            String tennhanvien=value.getString("TENNV");
                            CapNhatCachedDangNhap(context,tennhanvien);

                            break;
                        }
                        else
                        {
                            ketquaKiemTraDangNhap=false;
                        }

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return ketquaKiemTraDangNhap;
    }

}
