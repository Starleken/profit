package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;

import java.lang.ref.Reference;

public class FullButton extends View {

    private Reference icon;
    private CharSequence text;
    private Color textColor;
    private Paint paint;

    public FullButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        paint = new Paint();

        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.FullButton);
        text = typedArray.getText(R.styleable.FullButton_text);


        typedArray.recycle();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setColor(Color.parseColor("#14fff"));
        canvas.drawText((String)text,14,14, paint);
        canvas.drawCircle(100,100,100, paint);
    }


}
