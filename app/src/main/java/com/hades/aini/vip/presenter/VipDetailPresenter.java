package com.hades.aini.vip.presenter;

import com.hades.aini.vip.bean.VipInfoBean;

/**
 * Created by Hades on 2016/8/31.
 */
public interface VipDetailPresenter {

    void addNewVip(String name, String tel);

    void updateVip(VipInfoBean vip);

}
