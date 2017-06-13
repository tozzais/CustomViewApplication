package com.xmm.customviewapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Administrator on 2017/6/12.
 */

public class MyView extends View {

    Paint mPaint;

    public MyView(Context context) {

        super(context);

        init();
    }



    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();

    }

    private void init() {

        mPaint = new Paint();
        mPaint.setColor(Color.RED);
    }

    /**
     * 负责View的测量
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(measure(widthMeasureSpec),measure(heightMeasureSpec));
    }

    private int measure(int measureSpec){
        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        if(specMode == MeasureSpec.EXACTLY){
            //EXACTLY是指定高度  或则是match_parent
            result = specSize;
        }else{
            //不是EXACTLY（指定高度的时候 需要给默认值）
            result = 100;
            if(specMode == MeasureSpec.AT_MOST){
                //指定wrap_content的时候  需要去最小值
                result = Math.min(result,specSize);
            }
        }

        //还有一种是 想多大就多大。 MeasureSpec.UNSPECIFIED
        return result;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        /**
         * getX 相对于屏幕远点的位置  本文中是 32
         * getY同理 也是32
         */
       Log.e("-------",getX()+":"+getY()+":"+getWidth()+":"+getHeight());
       canvas.drawLine(0,0,getX()+getHeight(),getY()+getWidth(),mPaint);

    }
}
