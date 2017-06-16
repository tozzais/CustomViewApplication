package com.xmm.customviewapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Administrator on 2017/6/16.
 *
 * 粘性空间 实现下拉刷新
 * 1:
 *  自定义组件中绘制
 *  自定义空间相应，控件高度相应变化
 *  利用贝塞尔曲线实现粘性效果
 * 2:
 *  了解事件传递
 *  获取拉动手势  计算拉动速度
 *  View相应拉动并更改速度
 * 3：
 *
 */

public class ViscosityView extends View{

    private Paint mCirclePaint;
    private int mCircleWidth = 150;

    public ViscosityView(Context context) {
        super(context);

        init();
    }

    public ViscosityView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ViscosityView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ViscosityView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init(){
        mCirclePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        //设置防抖动
        mCirclePaint.setDither(true);
        //设置抗锯齿
        mCirclePaint.setAntiAlias(true);
        //设置为填充方式
        mCirclePaint.setStyle(Paint.Style.FILL);
        mCirclePaint.setColor(0xff000000);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth()>>1;
        int geight = getHeight()>>1;
        canvas.drawCircle(width,geight,mCircleWidth,mCirclePaint);
    }


    public  void setProgress(float progress){
        Log.e("TAG","progress = "+progress);
    }
}
