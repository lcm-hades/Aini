package com.hades.aini;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.util.SparseArrayCompat;

import com.hades.aini.detail.DetailFragment;
import com.hades.aini.haircut.HairCutFragment;
import com.hades.aini.storage.StorageFragment;
import com.hades.aini.vip.View.VipFragmet;

/**
 * Created by Hades on 2016/8/29.
 */
public class MainSwitchHelper {

    private static MainSwitchHelper instance;

    private SparseArrayCompat<Fragment> mFragmentMap;

    private int mLastShowIndex = 0;

    private MainSwitchHelper(){
        mFragmentMap = new SparseArrayCompat<>();

    }

    public static MainSwitchHelper getInstance(FragmentActivity ac){
        if (instance == null){
            synchronized (MainSwitchHelper.class){
                if (instance == null){
                    instance = new MainSwitchHelper();
                }
            }
        }
        return instance;
    }

    public void open(FragmentActivity ac, int index){
        FragmentManager fm = ac.getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();

        if (mFragmentMap.get(index) == null){
            switch (index){
                case 0:
                    HairCutFragment hairCutFragment = new HairCutFragment();
                    transaction.add(R.id.main_content, hairCutFragment);
                    mFragmentMap.put(index, hairCutFragment);
                    break;
                case 1:
                    StorageFragment sf = new StorageFragment();
                    transaction.add(R.id.main_content, sf);
                    mFragmentMap.put(index, sf);
                    break;
                case 2:
                    DetailFragment df = new DetailFragment();
                    transaction.add(R.id.main_content, df);
                    mFragmentMap.put(index, df);
                    break;
                case 3:
                    VipFragmet vf = new VipFragmet();
                    transaction.add(R.id.main_content, vf);
                    mFragmentMap.put(index, vf);
                    break;
            }
        }
        transaction.hide(mFragmentMap.get(mLastShowIndex));
        transaction.show(mFragmentMap.get(index));
        mLastShowIndex = index;
        transaction.commit();
    }

}
