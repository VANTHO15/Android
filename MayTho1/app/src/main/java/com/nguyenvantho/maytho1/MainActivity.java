package com.nguyenvantho.maytho1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnDangNhap;
    EditText edMatKhau,edTaiKhoan;
    TextView tvDangKi;

    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDangNhap= this.<Button>findViewById(R.id.btnDangNhap);
        edMatKhau= this.<EditText>findViewById(R.id.edMatKhau);
        edTaiKhoan= this.<EditText>findViewById(R.id.edTaiKhoan);
        tvDangKi= findViewById(R.id.tvDangKi);

        btnDangNhap.setOnClickListener(this);
        tvDangKi.setOnClickListener(this);
        // init instance of firebaseAuth
        firebaseAuth= FirebaseAuth.getInstance();    // dăng kí firebase
        // set up listener Firebase sign-in
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user!=null)
                {
                    // Login thanh cong
//                    user.getEmail();
//                    user.getUid();
                    tvDangKi.setVisibility(View.GONE);

                }
                else
                {
                    // fail
                }
            }
        };
    }

    @Override
    public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.btnDangNhap:
                {
                    String TaiKhoan= edTaiKhoan.getText().toString().trim();
                    String MatKhau=edMatKhau.getText().toString().trim();
                    boolean isvalid=validateForm();
                    if(isvalid)
                    {
                        // nhap day du roi
                        singIn( TaiKhoan, MatKhau);
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this,"Please Check Infomation !",Toast.LENGTH_SHORT).show();
                    }
                    break;
                }
                case R.id.tvDangKi:
                {
                    String TaiKhoan= edTaiKhoan.getText().toString().trim();
                    String MatKhau=edMatKhau.getText().toString().trim();
                    boolean isvalid=validateForm();
                    if(isvalid)
                    {
                        // nhap day du roi
                        signUp(TaiKhoan,MatKhau);
                        edTaiKhoan.setText("");
                        edMatKhau.setText("");
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this,"Please Check Infomation !",Toast.LENGTH_SHORT).show();
                    }

                }
            }
    }
    private void signUp(String email,String password)
    {
        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(MainActivity.this,"Đăng Kí Thành Công !",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Đăng Kí Lỗi Rồi !",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private  void singIn(String email,String password)
    {
        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(MainActivity.this,"Đăng Nhập Thành Công !",Toast.LENGTH_SHORT).show();
                    Intent iMoManHinhChinh=new Intent(MainActivity.this,drawer_activity.class);
                    Bundle GoiThongTin= new Bundle();
                    GoiThongTin.putString("ten",   edTaiKhoan.getText().toString().trim());  // truyền qua man hinh kia
                    edTaiKhoan.setText("");
                    edMatKhau.setText("");
                    iMoManHinhChinh.putExtras(GoiThongTin);
                    startActivity(iMoManHinhChinh);
                    finish();
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Đăng Nhập Lỗi Rồi !",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        firebaseAuth.addAuthStateListener(authStateListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(authStateListener!=null)
        {
            firebaseAuth.removeAuthStateListener(authStateListener);
        }
    }

    private boolean validateForm()
    {
        String TaiKhoan=edTaiKhoan.getText().toString().trim();
        String MatKhau=edMatKhau.getText().toString().trim();
        if(!TaiKhoan.isEmpty() && (!MatKhau.isEmpty()))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}