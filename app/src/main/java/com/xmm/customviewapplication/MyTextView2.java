package com.xmm.customviewapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/6/14.
 */

public class MyTextView2 extends TextView {




    public MyTextView2(Context context) {
        super(context);
    }


    public MyTextView2(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyTextView2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }





    @Override
    public void draw(Canvas canvas) {
//        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), mPaint1);
//        canvas.drawRect(10, 10, getMeasuredWidth() - 10, getMeasuredHeight() - 10, mPaint2);
//        canvas.save();
//        canvas.translate(20,0);
        super.draw(canvas);
//        canvas.restore();

        if(mGradientMatrix != null){
            mTranslate += mViewWidth/5;
            if(mTranslate > 2*mViewWidth){
                mTranslate = -mViewWidth;
            }
            mGradientMatrix.setTranslate(mTranslate,0);
            mLinearGradient.setLocalMatrix(mGradientMatrix);
            postInvalidateDelayed(100);
        }
    }


    private int mViewWidth;
    private int mTranslate;
    private LinearGradient mLinearGradient;
    private Matrix mGradientMatrix;
    private Paint mPaint;

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (mViewWidth == 0) {
            mViewWidth = getMeasuredWidth();
            if(mViewWidth > 0){
                mPaint = getPaint();
                mLinearGradient = new LinearGradient(0, 0, mViewWidth, 0, new int[]{Color.BLUE, 0xffffffff, Color.BLUE}, null, Shader.TileMode.CLAMP);
                mPaint.setShader(mLinearGradient);
                mGradientMatrix = new Matrix();
            }
        }
    }
}
