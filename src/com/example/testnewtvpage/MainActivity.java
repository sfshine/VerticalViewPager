package com.example.testnewtvpage;

import java.util.ArrayList;
import java.util.List;

import com.example.testnewtvpage.TVWallBasePage.ITVWallPageCallback;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends Activity implements ITVWallPageCallback
{
    
    private int mCurrentPosition;
    private VerticalViewPager mViewpager_v3;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    
    private void initView() {
        mViewpager_v3 = (VerticalViewPager) findViewById(R.id.viewpager_v3);
        TVWallAdapter tvWallAdapter = new TVWallAdapter();
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
        
        tvWallAdapter.setData(pages);
        mViewpager_v3.setAdapter(tvWallAdapter);
        
    }
    
    class TVWallAdapter extends PagerAdapter
    {
        private String[] titles = null;
        private List<TVWallBasePage> mDatas = null;
        
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
}
