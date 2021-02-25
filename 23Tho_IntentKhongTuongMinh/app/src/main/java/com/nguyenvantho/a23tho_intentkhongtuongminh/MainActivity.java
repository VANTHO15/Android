package com.nguyenvantho.a23tho_intentkhongtuongminh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnGoi,btnGui;
    EditText edtMess, edtSoDT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGoi= this.<Button>findViewById(R.id.btnGoi);
        btnGui= this.<Button>findViewById(R.id.btnGui);
        edtMess= this.<EditText>findViewById(R.id.edtTinNhan);
        edtSoDT= this.<EditText>findViewById(R.id.edtSoDT);

        btnGoi.setOnClickListener(this);
        btnGui.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id= v.getId();
        switch (id)
        {
            case R.id.btnGoi:
            {
                Call();
                break;
            }
            case R.id.btnGui:
            {
//                Intent iTinNhan= new Intent();      // gọi đến 1 phần mềm gửi Tin nhắn
//                iTinNhan.setAction(Intent.ACTION_SEND);
//                iTinNhan.putExtra(Intent.EXTRA_TEXT,"Hello, This is Văn Thọ");
//                iTinNhan.setType("text/plain");
//                startActivity(iTinNhan);
                if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.SEND_SMS)
                        !=PackageManager.PERMISSION_GRANTED)   // nếu chưa cho phép thì cho phép kakak
                {
                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{Manifest.permission.SEND_SMS},1);
                }
                else
                {
                    SenMessage();
                }
            }
        }

    }

    public void SenMessage()
    {
        String mess=edtMess.getText().toString();
        String sodt= edtSoDT.getText().toString();
        if (mess.equals("")==true || mess==null || sodt.equals("")==true|| sodt==null)
        {
            return;
        }
        else
        {
            SmsManager manager=SmsManager.getDefault();
            manager.sendTextMessage(sodt,null, mess,null,null);
            edtSoDT.setText("");
            edtMess.setText("");
        }

    }
    public void Call()
    {
        String sodt= edtSoDT.getText().toString();
        if(sodt.equals("")==true || sodt==null)
        {
            return;
        }
        else
        {
            String number = ("tel:"+sodt );
            Intent iGoi = new Intent(Intent.ACTION_CALL);
            iGoi.setData(Uri.parse(number));
            if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE)
                    != PackageManager.PERMISSION_GRANTED)    // nếu chưa cho phép thì cho phép kakak
            {
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.CALL_PHONE},1);
            }
            else
            {
                startActivity(iGoi);
                edtSoDT.setText("");
            }
        }
    }
}