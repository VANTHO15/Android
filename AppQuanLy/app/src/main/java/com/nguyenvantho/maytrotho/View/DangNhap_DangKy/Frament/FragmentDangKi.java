package com.nguyenvantho.maytrotho.View.DangNhap_DangKy.Frament;

import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputLayout;
import com.nguyenvantho.maytrotho.Model.ObjectClass.NhanVien;
import com.nguyenvantho.maytrotho.Presenter.DangKi.PresenterLogicDangKy;
import com.nguyenvantho.maytrotho.R;
import com.nguyenvantho.maytrotho.View.DangNhap_DangKy.ViewDangKy;

public class FragmentDangKi extends Fragment implements ViewDangKy, View.OnClickListener, View.OnFocusChangeListener {
    PresenterLogicDangKy presenterLogicDangKy;
    Button btnDangKi;
    EditText edHoTen,edmatKhau,edNhaplaimatkhau,edDiaChiEmial;
    SwitchCompat sw;
    TextInputLayout input_edHoTen,input_edMatKhau,input_edNhaplaiMatKhau,input_DiaChiEmailDangKi;
    String swit="";
    Boolean kiemtrathongtin=false;
    Boolean a=false,b=false,c=false,d=false,e=false,f=false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.layout_fragment_dangky,container,false);


        btnDangKi= view.<Button>findViewById(R.id.btnDangKi);
        edHoTen= view.<EditText>findViewById(R.id.edHoTenDK);
        edmatKhau= view.<EditText>findViewById(R.id.edMatKhauDK);
        edNhaplaimatkhau= view.<EditText>findViewById(R.id.edNhapLaiMatKhauDK);
        edDiaChiEmial= view.<EditText>findViewById(R.id.edDiaChiEmailDK);
        sw= view.<SwitchCompat>findViewById(R.id.sw);
        input_edHoTen= view.<TextInputLayout>findViewById(R.id.input_edHoTenDangKy);
        input_DiaChiEmailDangKi= view.<TextInputLayout>findViewById(R.id.input_edDiaChiEmailDangKy);
        input_edMatKhau= view.<TextInputLayout>findViewById(R.id.input_edMatKhauDangKy);
        input_edNhaplaiMatKhau= view.<TextInputLayout>findViewById(R.id.input_edNhapLaimatKhauDangKy);

        presenterLogicDangKy = new PresenterLogicDangKy(this);

        btnDangKi.setOnClickListener(this);
        edHoTen.setOnFocusChangeListener(this);
        edDiaChiEmial.setOnFocusChangeListener(this);
        edNhaplaimatkhau.setOnFocusChangeListener(this);

        return view;
    }

    @Override
    public void DangKiThanhCong() {
        Toast.makeText(getActivity(),"Đăng kí thành công !",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void DangKiThatbai() {
        Toast.makeText(getActivity(),"Đăng kí thất bại !",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch (id)
        {
            case R.id.btnDangKi:
            {
                btnDangki();
                break;
            }
        }
    }

    private void btnDangki()
    {
        String hoten=edHoTen.getText().toString();
        String email=edDiaChiEmial.getText().toString();
        String matkhau= edmatKhau.getText().toString();
        String nhaplaimk= edNhaplaimatkhau.getText().toString();

        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                swit= isChecked+" ";
            }
        });
        if(!nhaplaimk.equals(matkhau))
        {
                input_edNhaplaiMatKhau.setErrorEnabled(true);
                input_edNhaplaiMatKhau.setError("Mật Khẩu Không Trùng Khớp");
                a=false;
        }
        else
        {
            input_edNhaplaiMatKhau.setErrorEnabled(false);
            input_edNhaplaiMatKhau.setError("");
            a=true;
        }
        Log.d("mnp",a.toString()+ " "+ b.toString()+ " "+ c.toString());
        if(a&&b&&c)
        {
            a=false;
            b=false;
            c=false;
            NhanVien nhanVien= new NhanVien();
            nhanVien.setTenNV(hoten);
            nhanVien.setTenDangNhap(email);
            nhanVien.setMatKhau(matkhau);
            nhanVien.setMaLoaiNV("3");
            presenterLogicDangKy.ThucHienDangKi(nhanVien);

        }

    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        int id= v.getId();

       switch (id)
       {
           case R.id.edHoTenDK:
           {
               if(!hasFocus)
               {
                   String chuoi= ((EditText)v).getText().toString();
                   if(chuoi.trim().equals("")|| chuoi.equals(null))
                   {
                       input_edHoTen.setErrorEnabled(true);
                       input_edHoTen.setError("Bạn chưa nhập mục này !");
                       b=false;
                   }
                   else
                   {
                       input_edHoTen.setErrorEnabled(false);
                       input_edHoTen.setError("");
                      b=true;
                   }
               }

               break;
           }
           case R.id.edDiaChiEmailDK:
           {
               if(!hasFocus)
               {
                   String chuoi= ((EditText)v).getText().toString();
                   if(chuoi.equals("")|| chuoi.equals(null))
                   {
                       input_DiaChiEmailDangKi.setErrorEnabled(true);
                       input_DiaChiEmailDangKi.setError("Bạn chưa nhập mục này !");
                       c=false;
                   }
                   else
                   {
                       Boolean kiemtraemail=Patterns.EMAIL_ADDRESS.matcher(chuoi).matches();
                       if(!kiemtraemail)
                       {
                           input_DiaChiEmailDangKi.setErrorEnabled(true);
                           input_DiaChiEmailDangKi.setError("Đây không phải địa chỉ Email !");
                           c=false;
                       }
                       else
                       {
                           input_DiaChiEmailDangKi.setErrorEnabled(false);
                           input_DiaChiEmailDangKi.setError("");
                           c=true;
                       }

                   }
               }
               break;
           }

           case R.id.edNhapLaiMatKhauDK:
           {
               if(!hasFocus)
               {
                   String chuoi= ((EditText)v).getText().toString();
                   String matkhau=edmatKhau.getText().toString();
                   if(!chuoi.equals(matkhau))
                   {
                       input_edNhaplaiMatKhau.setErrorEnabled(true);
                       input_edNhaplaiMatKhau.setError("Mật khẩu không trùng khớp !");
                   }
                   else
                   {
                       input_edNhaplaiMatKhau.setErrorEnabled(false);
                       input_edNhaplaiMatKhau.setError("");
                   }
               }

           }

       }
    }
}
