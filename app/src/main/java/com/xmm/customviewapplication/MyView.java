package com.xmm.customviewapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Administrator on 2017/6/12.
 */

public class MyView extends View {

    private String TAG = "MyView";

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
        Log.e(TAG,getX()+":"+getY()+":"+getWidth()+":"+getHeight()+":"+getMeasuredWidth());
        //绘制直线  一块画布的对角线
//        canvas.drawLine(0,0,getWidth(),getHeight(),mPaint);
        //绘制 一条水平的直线 距离组件的顶部 10个像素
        canvas.drawLine(0,10,getWidth(),10,mPaint);

        /**
         * Rect 和 RectF 都是用来表示坐标系中的一个区域
         * Rect的参数是int， RectF的参数是 Float(更加的准确一点)
         */
        //绘制矩形
        mRect = new Rect(20,20,100,60);
        canvas.drawRect(mRect,mPaint);

        /**
         *  绘制文字
         *  drawText(String text, float x, float y, Paint paint)
         *  x,y 表示绘制的文字所在区域的左下角的坐标
         *  drawText(char[] text, int index, int count, float x, float y, Paint paint)
         *   和上面的类似，字符数组从 index开始绘制 count和字符，会发生越界异常
         */
        mPaint.setTextSize(40);
        canvas.drawText("测试文字",20,100,mPaint);
//        canvas.drawText(c,1,3,20,100,mPaint);

        /**
         *绘制一个路径  moveTo 相当于起点
         */
        Path path = new Path();
        path.moveTo(0, 120);// 此点为多边形的起点
        path.lineTo(0, 200);
        path.lineTo(80, 200);
        path.lineTo(80, 160);
        path.close(); // 使这些点构成封闭的多边形
        canvas.drawPath(path, mPaint);
        /**
         * 绘制Bitmap
         */
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        canvas.drawBitmap(bitmap,200,50,mPaint);

        /**
         * 绘制点
         */
        mPaint.setStrokeWidth(3);
        canvas.drawPoint(200,200,mPaint);
        canvas.drawPoint(205,205,mPaint);
        canvas.drawPoint(210,210,mPaint);
        canvas.drawPoint(215,215,mPaint);

        /**
         *  画椭圆
         */
        RectF m = new RectF(320,20,520,120);
        canvas.drawOval(m,mPaint);

        /**
         *  画圆
         */
        RectF m1= new RectF(320,20,520,120);
        canvas.drawCircle(300,150,10,mPaint);


        /**
         *  画弧
         *  startAngle 开始的角度
         *  sweepAngle 一共要绘制的角度
         *
         *  useCenter 表示是否 使用圆心
         */
        RectF m2= new RectF(100f,400f,400f,700f);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawArc(m2,210,120,true,mPaint);






    }
    private char[] c = {'a','b','c','d'};

}
