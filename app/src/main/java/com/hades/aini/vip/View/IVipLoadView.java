package com.hades.aini.vip.View;

import com.hades.aini.vip.bean.VipInfoBean;

import java.util.List;

/**
 * Created by Hades on 2016/8/31.
 */
public interface IVipLoadView {
    void showVipInfo(List<VipInfoBean> list);
    void showProgress();
    void hideProgress();

}
