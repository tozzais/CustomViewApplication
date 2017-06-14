package com.xmm.customviewapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/6/14.
 */

public class MyTextView2 extends TextView {

    private Paint mPaint1,mPaint2;
    public MyTextView2(Context context) {
        super(context);
        init();
    }


    public MyTextView2(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyTextView2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init() {

        mPaint1 = new Paint();
        mPaint1.setColor(Color.RED);
        mPaint1.setStyle(Paint.Style.FILL);
        mPaint2 = new Paint();
        mPaint2.setColor(Color.YELLOW);
        mPaint2.setStyle(Paint.Style.FILL);

//        mPaint1.setStrokeWidth(10);
    }


    @Override
    public void draw(Canvas canvas) {
        canvas.drawRect(0,0,getMeasuredWidth(),getMeasuredHeight(),mPaint1);
        canvas.drawRect(10,10,getMeasuredWidth()-10,getMeasuredHeight()-10,mPaint2);

        canvas.save();

//        canvas.translate(20,0);


        super.draw(canvas);

        canvas.restore();
    }



}
