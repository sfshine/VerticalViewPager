package com.example.testnewtvpage;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.sax.EndElementListener;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.Toast;

public class TVWallPage extends TVWallBasePage
{
    
    public TVWallPage(Context context) {
        super(context);
    }
    
    //private List<TVWallData> mTvWallBasePages;
    private List<View> mButtons;
    
    @Override
    public int onSetContentView() {
        return R.layout.layout_tvwall_page;
    }
    
    @Override
    public void initView() {
        mButtons = new ArrayList<View>();
        mButtons.add(findViewById(R.id.button1));
        mButtons.add(findViewById(R.id.button2));
        mButtons.add(findViewById(R.id.button3));
        mButtons.add(findViewById(R.id.button4));
        mButtons.add(findViewById(R.id.button5));
        mButtons.add(findViewById(R.id.button6));
        
    }
    
    public void setSelectItem(int index) {
        mButtons.get(index).requestFocus();
    }
    
    public void setFoucusItem(int position) {
        Toast.makeText(mContext, "position " + position, 1000).show();
        mButtons.get(position).requestFocus();
    }
    
    @Override
    public void setListener() {
        for (int i = 0; i < mButtons.size(); i++) {
            final int finalIndex = i;
            mButtons.get(i).setOnFocusChangeListener(new OnFocusChangeListener()
            {
                
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if (hasFocus) {
                        Toast.makeText(mContext, "finalIndex selected " + finalIndex, 1000).show();
                        MainActivity.mCurrentPosition = finalIndex;
                    }
                    
                }
            });
        }
    }
    
    @Override
    public void fetchData() {
        if (getView() == null) {
            bindView(mContext);
        }
    }
    
}
