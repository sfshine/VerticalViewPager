package com.example.testnewtvpage;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ViewUtil
{
    public static View inflateView(int redId, ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(redId, parent, false);
        return view;
    }
    
    /**
     * 通过制定的 layout xml 生成一个view
     * 
     * @param redId
     *            layout的id
     * @param context
     * @return
     */
    public static View inflateView(int redId, Context context) {
        View view = LayoutInflater.from(context).inflate(redId, null, false);
        return view;
    }
    
    /**
     * 获取控件的高度，如果获取的高度为0，则重新计算尺寸后再返回高度
     * 
     * @param view
     * @return
     */
    public static int getViewMeasuredHeight(View view) {
        calcViewMeasure(view);
        return view.getMeasuredHeight();
    }
    
    /**
     * 获取控件的宽度，如果获取的宽度为0，则重新计算尺寸后再返回宽度
     * 
     * @param view
     * @return
     */
    public static int getViewMeasuredWidth(View view) {
        calcViewMeasure(view);
        return view.getMeasuredWidth();
    }
    
    private static void calcViewMeasure(View view) {
        int width = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        int expandSpec = View.MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, View.MeasureSpec.AT_MOST);
        view.measure(width, expandSpec);
    }
    
    public static ColorStateList createColorStateList(int normal, int pressed) {
        ColorStateList myColorStateList = new ColorStateList(new int[][] { new int[] { android.R.attr.state_pressed }, new int[] { android.R.attr.state_focused }, new int[] { android.R.attr.state_checked }, new int[] { -android.R.attr.state_enabled }, new int[] { android.R.attr.state_enabled } //state
        }, new int[] { pressed, pressed, pressed, normal, normal });
        return myColorStateList;
    }
    
    /**
     * @title: getStatusBarHeight
     * @description: 获取状态栏的高度, 注意在Activity 的 onSizeChanged之后调用, 在onCreate 调用返回0
     * @param activity
     * @return
     * @return: int
     */
    public static int getStatusBarHeight(Activity activity) {
        Rect localRect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
        return localRect.top;
    }
}
