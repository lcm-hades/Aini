package com.hades.aini.vip.presenter;
import com.hades.aini.R;
import com.hades.aini.main.AiniApplication;
import com.hades.aini.vip.View.IVipDetailView;
import com.hades.aini.vip.bean.VipInfoBean;
import com.hades.aini.vip.model.VipModel;
import com.hades.aini.vip.model.VipModelImpl;

/**
 * Created by Hades on 2016/8/31.
 */
public class VipDetailPresenterImpl implements VipDetailPresenter, VipModelImpl.OnVipInfoChangeListener {

    private VipModel vipModel;

    private IVipDetailView mIVipDetailView;

    public VipDetailPresenterImpl(IVipDetailView iVipDetailView){
        vipModel = new VipModelImpl();
        mIVipDetailView = iVipDetailView;
    }

    @Override
    public void addNewVip(String name, String tel) {
        mIVipDetailView.showProgress();
        if (!name.equals("") && !tel.equals("")){
            VipInfoBean vip = new VipInfoBean();
            vip.setName(name);
            vip.setTel(tel);
            vipModel.insertVipInfo(vip, this);
        }else {
            // mIVipDetailView
            mIVipDetailView.hideProgress();
            mIVipDetailView.onFailure(AiniApplication.getInstance().getAiniApplicationContext().getString(R.string.check_input_tip), null);
        }
    }

    @Override
    public void updateVip(VipInfoBean vip) {
        mIVipDetailView.showProgress();
        vipModel.updateVipInfo(vip, this);
    }

    @Override
    public void onSuccess(VipInfoBean vip, int type) {
        mIVipDetailView.hideProgress();
        if (type == VipModelImpl.INSERT){
            mIVipDetailView.insert(vip);
        }else if (type == VipModelImpl.UPDATE){
            mIVipDetailView.update(vip);
        }
    }

    @Override
    public void onFailure(String msg, Exception e) {
        mIVipDetailView.hideProgress();
        mIVipDetailView.onFailure(msg, e);
    }
}
