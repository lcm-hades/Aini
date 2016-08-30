package com.hades.aini.vip.presenter;

import android.content.Context;

import com.hades.aini.vip.bean.VipInfoBean;
import com.hades.aini.vip.model.VipModel;
import com.hades.aini.vip.model.VipModelImpl;

/**
 * Created by Hades on 2016/8/30.
 */
public class VipPresnter  {

    private VipModel mVipModel;

    public VipPresnter(Context context){
        mVipModel = new VipModelImpl(context);
    }

    public void newVip(String name, String tel){
        VipInfoBean vip = new VipInfoBean();
        vip.setName(name);
        vip.setTel(tel);
        mVipModel.insertVipInfo(vip);
    }
}

