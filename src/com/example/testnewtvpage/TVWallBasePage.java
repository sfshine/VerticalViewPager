package com.example.testnewtvpage;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public abstract class TVWallBasePage
{
    protected ITVWallPageCallback mSTBFragmentCallback;
    protected View mContainer;
    protected Context mContext;
    
    public interface ITVWallPageCallback
    {
        public void onRefreshData();
    }
    
    public TVWallBasePage(Context context) {
        mContext = context;
    }
    
    public void bindView(Context context) {
        mContext = context;
        int layout = onSetContentView();
        if (layout > 0) {
            mContainer = ViewUtil.inflateView(onSetContentView(), mContext);
            initView();
            setListener();
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
    
    public abstract void fetchData();
    
    public View getView() {
        return mContainer;
    };
    
    public Context getContext() {
        return mContext;
    }
    
    public void setFoucusItem(int position) {
        
    }
    
}
