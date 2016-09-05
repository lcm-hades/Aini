package com.hades.aini.vip.View;

import com.hades.aini.vip.bean.VipInfoBean;

import java.util.List;

/**
 * Created by Hades on 2016/9/2.
 */
public interface IVipDetailView {
    void insert(VipInfoBean vipInfoBean);
    void update(VipInfoBean vipInfoBean);
    void showProgress();
    void hideProgress();
    void onFailure(String msg, Exception e);
}
