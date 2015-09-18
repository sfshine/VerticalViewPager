package com.example.testnewtvpage;

import android.content.Context;

public class TVWallPage extends TVWallBasePage
{
    
    public TVWallPage(Context context, ITVWallPageCallback stbFragmentCallback) {
        super(context, stbFragmentCallback);
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public int onSetContentView() {
        return R.layout.layout_tvwall_page;
    }
    
    @Override
    public void initView() {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public void fetchData() {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public void notifiData() {
        // TODO Auto-generated method stub
        
    }
    
}
