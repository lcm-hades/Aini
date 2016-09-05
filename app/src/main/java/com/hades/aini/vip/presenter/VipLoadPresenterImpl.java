package com.hades.aini.vip.presenter;

import android.content.Context;

import com.hades.aini.vip.View.IVipLoadView;
import com.hades.aini.vip.bean.VipInfoBean;
import com.hades.aini.vip.model.VipModel;
import com.hades.aini.vip.model.VipModelImpl;

import java.util.List;

/**
 * Created by Hades on 2016/8/30.
 */
public class VipLoadPresenterImpl implements VipLoadPresenter, VipModelImpl.OnLoadVipInfoListener {

    private VipModel mVipModel;
    private IVipLoadView vipLoadView;

    public VipLoadPresenterImpl(IVipLoadView vipLoadView){
        mVipModel = new VipModelImpl();
        this.vipLoadView = vipLoadView;
    }

    @Override
    public void onSuccess(List<VipInfoBean> list) {
        vipLoadView.hideProgress();
        vipLoadView.showVipInfo(list);
    }

    @Override
    public void onFailure(String msg, Exception e) {
        vipLoadView.hideProgress();
    }

    @Override
    public void loadVipInfo() {
        vipLoadView.showProgress();
        mVipModel.getVipInfoList(this);
    }
}

