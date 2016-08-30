package com.hades.aini.vip.model;

import com.hades.aini.vip.bean.VipInfoBean;

/**
 * Created by Hades on 2016/8/30.
 */
public interface VipModel {
    void insertVipInfo(VipInfoBean vip);
    void updateVipInfo(int id);
    void deleteVipInfo(int id);
    void getVipInfoList();
    boolean isExist(String tel);
}
