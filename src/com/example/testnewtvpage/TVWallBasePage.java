package com.example.testnewtvpage;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public abstract class TVWallBasePage
{
    private String mProgramType;
    protected ITVWallPageCallback mSTBFragmentCallback;
    private View mContainer;
    protected Context mContext;
    
    public TVWallBasePage(Context context, ITVWallPageCallback stbFragmentCallback) {
        mSTBFragmentCallback = stbFragmentCallback;
        mContext = context;
        setContentView();
    }
    
    public interface ITVWallPageCallback
    {
        /**
         * @title: onCallback
         * @description: 暂时无用
         * @return: void
         */
        public void onRefreshData();
    }
    
    public void setContentView() {
        int layout = onSetContentView();
        if (layout > 0) {
            mContainer = ViewUtil.inflateView(onSetContentView(), mContext);
            initView();
            setListener();
            initData();
        }
        else {
            mContainer = new TextView(mContext);
            Log.e("Error:", " onSetContentView returns error layout!");
        }
    }
    
    public View findViewById(int resId) {
        if (mContainer != null) {
            return mContainer.findViewById(resId);
        }
        return null;
    }
    
    public abstract int onSetContentView();
    
    public abstract void initView();
    
    public void setListener() {};
    
    public void initData() {};
    
    public abstract void fetchData();
    
    public abstract void notifiData();
    
    /**
     * 控制UI显示LoadingView
     * 
     * @title: showLoadingView
     * @description: TODO
     * @return: void
     */
    public void showLoadingView() {
        
    }
    
    public View getView() {
        return mContainer;
    };
    
    public String getProgramType() {
        return mProgramType;
    }
    
    public Context getContext() {
        return mContext;
    }
    
    public void setFoucusItem(int position) {
        
    }
    
    public void setSelectItem(int index) {}
    
}
