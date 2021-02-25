package com.nguyenvantho.maytrotho.CustomView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;

import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;

import com.nguyenvantho.maytrotho.R;

@SuppressLint("AppCompatCustomView")
public class ClearEditTex extends EditText {
    Drawable crossx,nonecrossx;
    Boolean visible=false;
    Drawable drawable;

    public ClearEditTex(Context context) {
        super(context);
        khoitao();
    }

    public ClearEditTex(Context context, AttributeSet attrs) {
        super(context, attrs);
        khoitao();
    }

    public ClearEditTex(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        khoitao();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ClearEditTex(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        khoitao();
    }

    private void khoitao()
    {
        crossx = ContextCompat.getDrawable(getContext(), R.drawable.ic_clear_black_24dp).mutate();
        nonecrossx= ContextCompat.getDrawable(getContext(), android.R.drawable.screen_background_dark_transparent).mutate();

        cauhinh();
    }
    private  void cauhinh()
    {
        setInputType(InputType.TYPE_CLASS_TEXT );
        Drawable[] drawables= getCompoundDrawables();
        drawable=visible? crossx:nonecrossx;
        setCompoundDrawablesWithIntrinsicBounds(drawables[0],drawables[1],drawable,drawables[3]);;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction()==MotionEvent.ACTION_UP  && event.getX()>=(getRight()-drawable.getBounds().width()))
        {
            setText("");
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
        if (lengthAfter==0 && start==0)
        {
            visible=false;
            cauhinh();
        }
        else
        {
            visible= true;
            cauhinh();
        }
    }
}
