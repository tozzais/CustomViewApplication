package com.xmm.customviewapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;

/**
 * Created byAdministrator on 2017/6/14.
 */

public class MyViewGroup extends ViewGroup {

    private int mLastY;
    private int mStart;
    private Scroller mScroller;
    private int mEnd;

    public MyViewGroup(Context context) {
        super(context);

        init();

    }

    private int mScreenHeight;
    private void init() {

        mScreenHeight =  ScreenUtil.getScreenHeight(getContext());
        mScroller = new Scroller(getContext());

    }

    public MyViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int count = getChildCount();
        MarginLayoutParams mlp = (MarginLayoutParams) getLayoutParams();
        mlp.height = mScreenHeight * count;
        setLayoutParams(mlp);
        for(int i =0;i<count;i++){
            View child = getChildAt(i);
            child.layout(l,i*mScreenHeight,r,(i+1)*mScreenHeight);
        }

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int count = getChildCount();
        for(int i=0;i<count;i++){
            View childView = getChildAt(i);
            measureChild(childView,widthMeasureSpec,heightMeasureSpec);
        }


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int y = (int) event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                mLastY = y;
                mStart = getScrollY();
                break;
            case MotionEvent.ACTION_MOVE:
                if(!mScroller.isFinished()){
                    mScroller.abortAnimation();
                }
                int dy = mLastY - y;
                if (getScrollY() < 0){
                    dy = 0;
                }
                if(getScrollY()>getHeight() - mScreenHeight){
                    dy = 0;
                }
                scrollBy(0,dy);
                mLastY = y;
                break;
            case MotionEvent.ACTION_UP:
                mEnd = getScrollY();
                int dScrolly = mEnd - mStart;
                if(dScrolly >0){
                    if(dScrolly<mScreenHeight/3){
                        mScroller.startScroll(0,getScrollY(),0,-dScrolly);
                    }else{
                        mScroller.startScroll(0,getScrollY(),0,mScreenHeight-dScrolly);
                    }
                }else{
                    if(-dScrolly<mScreenHeight/3){
                        mScroller.startScroll(0,getScrollY(),0,-dScrolly);
                    }else{
                        mScroller.startScroll(0,getScrollY(),0,-mScreenHeight-dScrolly);
                    }
                }
                break;
        }
        postInvalidate();
        return true;
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (mScroller.computeScrollOffset()){
            scrollTo(0,mScroller.getCurrY());
            postInvalidate();
        }
    }
}
