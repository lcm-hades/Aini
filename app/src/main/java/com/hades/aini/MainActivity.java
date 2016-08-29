package com.hades.aini;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.hades.aini.haircut.HairCutFragment;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

import DB.AiniDatabaseHelper;
import DB.DatabaseContext;
import HTabBar.HBottomTabBar;

public class MainActivity extends BaseActivity implements HBottomTabBar.HBottomTabBarSelectedListener {

    private int[] mNormalIcons = {R.drawable.tab_mypage_normal,
            R.drawable.tab_mypage_normal,
            R.drawable.tab_mypage_normal,
            R.drawable.tab_mypage_normal};
    private int[] mSelectIcons = {R.drawable.tab_mypage_normal,
            R.drawable.tab_mypage_normal,
            R.drawable.tab_mypage_normal,
            R.drawable.tab_mypage_normal};
    private String [] textList = {"理发","仓库","明细","会员"};

    private MainSwitchHelper helper;

    @ViewInject(R.id.main_tab)
    private HBottomTabBar tabbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper = MainSwitchHelper.getInstance(this);
        ViewUtils.inject(this);
        initTab();
        initView();
    }

    private void initView() {
        helper.open(this, 0);
    }

    private void initTab() {
        tabbar.setTitle(textList);
        tabbar.setBackgroundColor(getResources().getColor(R.color.xiunaer));
        tabbar.setIcons(mNormalIcons, mSelectIcons);
        tabbar.setHTabBarSelectedListener(this);
    }

    @Override
    public void onBottomTabBarSelected(View v, int index) {
//        DatabaseContext dbContext = new DatabaseContext(this);
//        AiniDatabaseHelper dbHelper = new AiniDatabaseHelper(dbContext);
//        SQLiteDatabase db = dbHelper.getReadableDatabase();

        helper.open(this, index);
    }
}
