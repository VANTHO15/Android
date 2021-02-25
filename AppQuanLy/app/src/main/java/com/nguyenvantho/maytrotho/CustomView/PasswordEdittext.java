package com.nguyenvantho.maytrotho.CustomView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;

import com.google.android.material.textfield.TextInputLayout;
import com.nguyenvantho.maytrotho.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressLint("AppCompatCustomView")
public class PasswordEdittext extends EditText {

    Drawable eye,eyeStrike;
    Boolean visible=false;
    Boolean useStrike=false;
    Boolean useValidate= false;
    Drawable drawable;
    String MATCHER_PATTERN="((?=.*\\d)(?=.*[A-Z])(?=.*[a-z]).{6,20})";  // (?=.*\d)
    Pattern pattern;
    Matcher matcher;
    int ALPHA =(int) (255 * .55f);
    TextInputLayout textInputLayout;

    public PasswordEdittext(Context context) {

        super(context);
        khoitao( null);
    }

    public PasswordEdittext(Context context, AttributeSet attrs) {
        super(context, attrs);
        khoitao( attrs);
    }

    public PasswordEdittext(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        khoitao( attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public PasswordEdittext(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        khoitao( attrs);
    }
    private void khoitao(AttributeSet attrs)
    {
        this.pattern= Pattern.compile(MATCHER_PATTERN);
        if(attrs!=null)
        {
            TypedArray array= getContext().getTheme().obtainStyledAttributes(attrs,R.styleable.PasswordEdittext,0,0);
            this.useStrike= array.getBoolean(R.styleable.PasswordEdittext_useStrike,false);
            this.useValidate=array.getBoolean(R.styleable.PasswordEdittext_useValidate,false);
        }
        eye= ContextCompat.getDrawable(getContext(), R.drawable.ic_visibility_black_24dp).mutate();
        eyeStrike= ContextCompat.getDrawable(getContext(), R.drawable.ic_visibility_off_black_24dp).mutate();
        if (this.useValidate)
        {
            setOnFocusChangeListener(new OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean b) {
                    if(!b)
                    {
                        String chuoi=getText().toString();
                         textInputLayout= getRootView().<TextInputLayout>findViewById(R.id.input_edMatKhauDangKy);
                          matcher= pattern.matcher(chuoi);
                          if(!matcher.matches())
                          {
                              textInputLayout.setErrorEnabled(true);
                              textInputLayout.setError("Mật khẩu gồm 6 kí tự  1 chữ Hoa 1 Số !");
                          }
                          else
                          {
                              textInputLayout.setErrorEnabled(false);
                              textInputLayout.setError("");
                          }

                    }
                }
            });
        }
        caidat();
    }

    private void caidat()
    {
        setInputType(InputType.TYPE_CLASS_TEXT | (visible?InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD:InputType.TYPE_TEXT_VARIATION_PASSWORD));
        Drawable[] drawables= getCompoundDrawables();
        drawable=useStrike && !visible? eyeStrike:eye;
        drawable.setAlpha(ALPHA);
       setCompoundDrawablesWithIntrinsicBounds(drawables[0],drawables[1],drawable,drawables[3]);;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction()==MotionEvent.ACTION_UP  && event.getX()>=(getRight()-drawable.getBounds().width()))
        {
            visible=!visible;
            caidat();
            invalidate();
        }
        return super.onTouchEvent(event);
    }
}
