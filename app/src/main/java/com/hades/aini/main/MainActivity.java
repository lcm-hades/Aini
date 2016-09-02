package com.hades.aini.main;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.hades.aini.R;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import HTabBar.HBottomTabBar;

public class MainActivity extends FragmentActivity implements HBottomTabBar.HBottomTabBarSelectedListener {

    private int[] mNormalIcons = {R.drawable.tab_mypage_normal,
            R.drawable.tab_mypage_normal,
            R.drawable.tab_mypage_normal,
            R.drawable.tab_mypage_normal};
    private int[] mSelectIcons = {R.drawable.tab_mypage_normal,
            R.drawable.tab_mypage_normal,
            R.drawable.tab_mypage_normal,
            R.drawable.tab_mypage_normal};
    private String [] textList = {"理发","仓库","明细","会员"};

    private final int DEFAULT = 0;

    private int curIndex = DEFAULT;

    private MainSwitchHelper helper;

    @ViewInject(R.id.main_tab)
    private HBottomTabBar tabbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewUtils.inject(this);
        helper = MainSwitchHelper.getInstance(this);
        initTab();
        initView();
    }


    private void initView() {
        switchPager(DEFAULT);
    }

    private void initTab() {
        tabbar.setTitle(textList);
        tabbar.setBackgroundColor(getResources().getColor(R.color.theme_color));
        tabbar.setIcons(mNormalIcons, mSelectIcons);
        tabbar.setHTabBarSelectedListener(this);
    }

    @Override
    public void onBottomTabBarSelected(View v, int index) {
        switchPager(index);
    }

    private void switchPager(int index) {
        curIndex = index;
        helper.open(this, curIndex);
    }
}
