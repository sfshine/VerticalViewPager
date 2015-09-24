package com.example.testnewtvpage;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;

public class TVWallPageFactory
{
    private static final int PAGE_COUNT = 8;
    
    /**
     * 
     * @title: generateTVWallPage
     * @description: 拿到每个分类对应的List<TVWallData> ,每九个生成一个TVWallPage
     * @return
     * @return: List<TVWallBasePage>
     */
    public static List<TVWallBasePage> generateTVWallPage(Context context, String programType) {
        List<TVWallBasePage> pages = new ArrayList<TVWallBasePage>();
        TVWallPage tvWallPage = new TVWallPage(context);
        TVWallPage tvWallPage2 = new TVWallPage(context);
        TVWallPage tvWallPage3 = new TVWallPage(context);
        TVWallPage tvWallPage4 = new TVWallPage(context);
        TVWallPage tvWallPage5 = new TVWallPage(context);
        
        pages.add(tvWallPage);
        pages.add(tvWallPage2);
        pages.add(tvWallPage3);
        pages.add(tvWallPage4);
        pages.add(tvWallPage5);
        return pages;
    };
    
}
