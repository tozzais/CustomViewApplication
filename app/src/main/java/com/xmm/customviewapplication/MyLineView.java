package com.xmm.customviewapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Create by Administrator on 2017/6/14.
 */

public class MyLineView extends View {


    private Paint paint;

    public MyLineView(Context context) {
        this(context, null);
        initView();
    }

    public MyLineView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        initView();
    }

    public MyLineView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        // 初始化画笔
        paint = new Paint();
        paint.setColor(Color.GREEN);    // 设置颜色
        paint.setStyle(Paint.Style.FILL);   // 设置风格

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);



    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);


    }
}
