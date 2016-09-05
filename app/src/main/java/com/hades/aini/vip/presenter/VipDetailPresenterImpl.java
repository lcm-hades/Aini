package com.hades.aini.vip.presenter;

import android.content.Context;

import com.hades.aini.vip.View.IVipDetailView;
import com.hades.aini.vip.bean.VipInfoBean;
import com.hades.aini.vip.model.VipModel;
import com.hades.aini.vip.model.VipModelImpl;

/**
 * Created by Hades on 2016/8/31.
 */
public class VipDetailPresenterImpl implements VipDetailPresenter {

    private VipModel vipModel;

    private IVipDetailView mIVipDetailView;

    public VipDetailPresenterImpl(IVipDetailView iVipDetailView){
        vipModel = new VipModelImpl();
        mIVipDetailView = iVipDetailView;
    }


    @Override
    public void addNewVip(String name, String tel) {
        if (!name.equals("") && !tel.equals("")){
            VipInfoBean vip = new VipInfoBean();
            vip.setName(name);
            vip.setTel(tel);
            vipModel.insertVipInfo(vip);
        }else {

        }
    }

    @Override
    public void updateVip(int id) {
        vipModel.updateVipInfo(id);
    }
}
