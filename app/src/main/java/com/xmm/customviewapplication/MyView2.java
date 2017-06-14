package com.xmm.customviewapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Create by Administrator on 2017/6/14.
 */

public class MyView2 extends View {


    private Paint paint;
    private int rectCount;  // 矩形条目的数目
    private int width;
    private int height;
    private int rectItemWidth;  //定义每一个条目的宽度
    private double mRandom;
    private int offset = 6; // 每个item的偏移量

    public MyView2(Context context) {
        this(context, null);
        initView();
    }

    public MyView2(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        initView();
    }

    public MyView2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        // 初始化画笔
        paint = new Paint();
        paint.setColor(Color.GREEN);    // 设置颜色
        paint.setStyle(Paint.Style.FILL);   // 设置风格
        rectCount = 15;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (int i = 0; i < rectCount; i++) {
            mRandom = Math.random();     // 生成0到1的随机数
            float rectItemHeight = (float) (height * mRandom);  // 随机生成每一个item的高度
            // 画矩形,设置上下左右坐标
            canvas.drawRect((float)(width * 0.3 / 2 + rectItemWidth * i + offset),rectItemHeight,
                    (float)(width * 0.3 / 2 + rectItemWidth * (i + 1)),height,paint);
        }
        postInvalidateDelayed(200);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        width = getWidth(); // 控件的宽度
        height = getHeight();// 控件的高度
        Log.i("tag", "控件宽：" + String.valueOf(width) + "   控件高：" + String.valueOf(height));
        rectItemWidth = (int) ((width * 0.6) / rectCount);
        Log.i("tag", "每一个宽宽：" + String.valueOf(rectItemWidth));
        // 给paint设置LinearGradient属性
        LinearGradient linearGradient = new LinearGradient(0, 0,
                rectItemWidth, height,
                Color.BLUE, Color.GREEN,
                Shader.TileMode.CLAMP);
        paint.setShader(linearGradient);

    }
}
