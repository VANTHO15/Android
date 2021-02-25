package com.nguyenvantho.maytrotho.View.DangNhap_DangKy.Frament;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.nguyenvantho.maytrotho.Model.DangNhap_DangKy.ModelDangNhap;
import com.nguyenvantho.maytrotho.R;
import com.nguyenvantho.maytrotho.View.TrangChu.TrangChuActivity;

import java.util.Arrays;


public class FragmentDangNhap extends Fragment implements View.OnClickListener, GoogleApiClient.OnConnectionFailedListener {
    AppCompatButton btnDangNhapFB,btnDangNhapGoogle,btnDangNhap;
    CallbackManager callbackManager;
    GoogleApiClient mGoogleApiClient;
    public static  int SING_IN_GOOGLE_PLUS= 111;
    ProgressDialog progressDialog;
    ModelDangNhap modelDangNhap;
    EditText edtenDN,edmatKhau;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.layout_fragment_dangnhap,container,false);



        modelDangNhap= new ModelDangNhap();
        mGoogleApiClient= modelDangNhap.LayGoogleApiClient(getContext(),this);

        FacebookSdk.sdkInitialize(getContext().getApplicationContext());
        callbackManager= CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Intent iTrangChu= new Intent(getActivity(), TrangChuActivity.class);
                startActivity(iTrangChu);
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });

        btnDangNhapFB= view.<AppCompatButton>findViewById(R.id.btnDangNhapfacebook);
        btnDangNhapGoogle= view.<AppCompatButton>findViewById(R.id.btnDangNhapGoogle);
        btnDangNhap= view.<AppCompatButton>findViewById(R.id.btnDangNhap);
        edtenDN= view.<EditText>findViewById(R.id.edDiaChiEmailDangNhap);
        edmatKhau= view.<EditText>findViewById(R.id.edMatKhauDangNhap);

        btnDangNhapFB.setOnClickListener(this);
        btnDangNhapGoogle.setOnClickListener(this);
        btnDangNhap.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        int id= v.getId();
        switch (id)
        {
            case R.id.btnDangNhapfacebook:
            {
                LoginManager.getInstance().logInWithReadPermissions(FragmentDangNhap.this, Arrays.asList("public_profile"));
                break;
            }
            case R.id.btnDangNhapGoogle:
            {
                Intent iGoogleplus=Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
                startActivityForResult(iGoogleplus,SING_IN_GOOGLE_PLUS);
                showprogressDialog();
                break;
            }
            case R.id.btnDangNhap:
            {
                String tendn=edtenDN.getText().toString();
                String matkhau= edmatKhau.getText().toString();
                Boolean kiemtra= modelDangNhap.KiemTraDangNhap(getActivity(),tendn,matkhau);
                if(kiemtra)
                {
                    Intent iTrangChu= new Intent(getActivity(), TrangChuActivity.class);
                    startActivity(iTrangChu);
                }
                else
                {
                    Toast.makeText(getActivity(),"Tên đăng nhập hoặc mật khẩu không đúng !",Toast.LENGTH_SHORT).show();
                }
                break;
            }
        }

    }
    private  void  showprogressDialog()
    {
        if (progressDialog== null)
        {
            progressDialog= new ProgressDialog(getContext());
            progressDialog.setIndeterminate(true);
            progressDialog.show();
        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode,resultCode,data);

        if(requestCode==SING_IN_GOOGLE_PLUS)
        {
            GoogleSignInResult result= Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            Log.d("google",result.getSignInAccount().getEmail());
            if(result.isSuccess())
            {
                progressDialog.cancel();
                Intent iTrangChu= new Intent(getActivity(), TrangChuActivity.class);
                startActivity(iTrangChu);
            }
        }

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        progressDialog.cancel();
    }
}
