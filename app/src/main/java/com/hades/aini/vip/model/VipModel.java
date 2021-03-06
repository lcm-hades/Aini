package com.hades.aini.vip.model;

import com.hades.aini.vip.bean.VipInfoBean;

import java.util.List;

/**
 * Created by Hades on 2016/8/30.
 */
public interface VipModel {
    void insertVipInfo(VipInfoBean vip, VipModelImpl.OnVipInfoChangeListener listener);
    void updateVipInfo(VipInfoBean vipInfoBean, VipModelImpl.OnVipInfoChangeListener listener);
    void deleteVipInfo(int id);
    void getVipInfoList(VipModelImpl.OnLoadVipInfoListener listener);
    boolean isExist(String tel);
}
