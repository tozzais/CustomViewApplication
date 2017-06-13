package com.xmm.customviewapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Administrator on 2017/6/12.
 */

public class MyView extends View {

    Paint mPaint;
    Rect mRect;

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
        mPaint.setStrokeWidth(5);
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
         * getX view距离父容器左边缘的距离
         * 当一个组件没有PaddingLeft的时候  是一样的。有PaddingLeft的时候 就是这个值
         * getY同理 也是32
         *
         *  1.在构造方法中无论是getWidth还是getMeasuredWidth都是得不到正确数值的。
         *  2.getMeasuredWidth得到正确数值需要在调用过onMeasure之后。
         *  3.getWidth得到正确数值需要调用过onLayout之后。
         *
         */
        Log.e("-------",getX()+":"+getY()+":"+getWidth()+":"+getHeight()+":"+getMeasuredWidth());
        //绘制直线  一块画布的对角线
//        canvas.drawLine(0,0,getWidth(),getHeight(),mPaint);
        //绘制 一条水平的直线 距离组件的顶部 10个像素
        canvas.drawLine(0,10,getWidth(),10,mPaint);

        /**
         * Rect 和 RectF 都是用来表示坐标系中的一个区域
         * Rect的参数是int， RectF的参数是 Float(更加的准确一点)
         */
        //绘制矩形
        mRect = new Rect();
        canvas.drawRect(mRect,mPaint);


    }
}
