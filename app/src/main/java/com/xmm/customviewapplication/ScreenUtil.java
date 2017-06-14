package com.xmm.customviewapplication;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;

/**
 * Created by Administrator on 2017/6/14.
 */

public class ScreenUtil {

    public  static int getScreenWidth(Activity activity){
        int screenWidth; // 屏幕宽（像素，如：480px）
        screenWidth = activity.getWindowManager().getDefaultDisplay().getWidth();
        return screenWidth;
    }
    public  static int getScreenWidth(Context context){
        DisplayMetrics dm = new DisplayMetrics();
        dm = context.getResources().getDisplayMetrics();
        float density = dm.density; // 屏幕密度（像素比例：0.75/1.0/1.5/2.0）
        int densityDPI = dm.densityDpi; // 屏幕密度（每寸像素：120/160/240/320）
        float xdpi = dm.xdpi;
        float ydpi = dm.ydpi;
        int screenWidth = dm.widthPixels; // 屏幕宽（像素，如：480px）

        return screenWidth;
    }
    public  static int getScreenHeight(Activity activity){
        int screenWidth; // 屏幕宽（像素，如：480px）
        screenWidth = activity.getWindowManager().getDefaultDisplay().getHeight();
        return screenWidth;
    }
    public  static int getScreenHeight(Context context){
        DisplayMetrics dm = new DisplayMetrics();
        dm = context.getResources().getDisplayMetrics();
        int screenWidth = dm.heightPixels; // 屏幕宽（像素，如：480px）
        return screenWidth;
    }


}
