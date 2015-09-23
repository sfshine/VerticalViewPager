package com.example.testnewtvpage;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.testnewtvpage.TVWallBasePage.ITVWallPageCallback;

public class MainActivity extends Activity implements ITVWallPageCallback
{
    
    public static int mCurrentPosition;
    private VerticalViewPager mViewpager_v3;
    private TVWallAdapter mTvWallAdapter;
    private View mNav2;
    private View mNav3;
    private LinearLayout mLinearLayout;
    private View mNav1;
    private Handler mHandler = new Handler();
    private RelativeLayout mRelativeLayout;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setListener();
    }
    
    private void initView() {
        mLinearLayout = (LinearLayout) findViewById(R.id.ll);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.rt);
        
        mNav1 = findViewById(R.id.nav1);
        mNav2 = findViewById(R.id.nav2);
        mNav3 = findViewById(R.id.nav3);
        
        mViewpager_v3 = (VerticalViewPager) findViewById(R.id.viewpager_v3);
        mTvWallAdapter = new TVWallAdapter();
        List<TVWallBasePage> pages = new ArrayList<TVWallBasePage>();
        TVWallPage tvWallPage = new TVWallPage(this, this);
        TVWallPage tvWallPage2 = new TVWallPage(this, this);
        TVWallPage tvWallPage3 = new TVWallPage(this, this);
        TVWallPage tvWallPage4 = new TVWallPage(this, this);
        TVWallPage tvWallPage5 = new TVWallPage(this, this);
        
        pages.add(tvWallPage);
        pages.add(tvWallPage2);
        pages.add(tvWallPage3);
        pages.add(tvWallPage4);
        pages.add(tvWallPage5);
        
        mTvWallAdapter.setData(pages);
        mViewpager_v3.setAdapter(mTvWallAdapter);
        
        mViewpager_v3.setNextFocusLeft(mNav1);
        mNav1.post(new Runnable()
        {
            
            @Override
            public void run() {
                mNav1.requestFocus();
            }
        });
        
    }
    
    private void setListener() {
        mViewpager_v3.setOnPageChangeListener(new OnPageChangeListener()
        {
            
            @Override
            public void onPageSelected(int arg0) {
                mTvWallAdapter.getPage(arg0).setFoucusItem(mCurrentPosition);
            }
            
            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                
            }
            
            @Override
            public void onPageScrollStateChanged(int arg0) {
                
            }
        });
        
    }
    
    class TVWallAdapter extends PagerAdapter
    {
        private String[] titles = null;
        private List<TVWallBasePage> mDatas = null;
        
        public TVWallBasePage getPage(int position) {
            return mDatas.get(position);
        }
        
        public void setData(List<TVWallBasePage> datas) {
            this.mDatas = datas;
            titles = new String[datas.size()];
            for (int i = 0; i < datas.size(); i++) {
                titles[i] = datas.get(i).getProgramType();
            }
            notifyDataSetChanged();
        }
        
        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }
        
        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
        
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
        
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            TVWallBasePage tvWallBasePage = mDatas.get(position);
            //tvWallBasePage.fetchData();
            
            View view = tvWallBasePage.getView();
            view.setId(position);
            container.addView(view);
            return view;
        }
        
        @Override
        public int getCount() {
            return mDatas == null ? 0 : mDatas.size();
        }
    }
    
    @Override
    public void onRefreshData() {
        
    }
    
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        View view = mLinearLayout.findFocus();
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            if (view != null && event.getKeyCode() == KeyEvent.KEYCODE_DPAD_RIGHT) {
                mTvWallAdapter.getPage(mViewpager_v3.getCurrentItem()).setFoucusItem(0);
                mViewpager_v3.setNextFocusLeft(view);
                return true;
            }
        }
        return super.dispatchKeyEvent(event);
    }
}
