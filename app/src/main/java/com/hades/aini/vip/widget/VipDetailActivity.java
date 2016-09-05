package com.hades.aini.vip.widget;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hades.aini.main.BaseActivity;
import com.hades.aini.R;
import com.hades.aini.vip.View.IVipDetailView;
import com.hades.aini.vip.bean.VipInfoBean;
import com.hades.aini.vip.presenter.VipDetailPresenter;
import com.hades.aini.vip.presenter.VipDetailPresenterImpl;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class VipDetailActivity extends BaseActivity implements IVipDetailView{

    @ViewInject(R.id.vip_name)
    private EditText vip_name;

    @ViewInject(R.id.vip_tel)
    private EditText vip_tel;

    @ViewInject(R.id.vip_add_btn)
    private Button vip_add_btn;

    private int mSource;
    private VipInfoBean mVipInfoBean;

    private VipDetailPresenter  vipDetailPresenter;

    @Override
    protected void init() {
        setBody(R.layout.ac_vip_detail_layout);
        mSource = (int) getIntent().getSerializableExtra(VipFragmet.Source);
        mVipInfoBean = (VipInfoBean) getIntent().getSerializableExtra(VipFragmet.DATA);
        vipDetailPresenter = new VipDetailPresenterImpl(this);
    }

    @OnClick(R.id.vip_add_btn)
    public void onAddClick(View v){
        if(mSource == VipFragmet.Insert){
            vipDetailPresenter.addNewVip(vip_name.getText().toString(), vip_tel.getText().toString());
        }else if (mSource == VipFragmet.Update){
            vipDetailPresenter.updateVip(mVipInfoBean.getId());
        }
    }

    @Override
    public void insert(VipInfoBean vipInfoBean) {

    }

    @Override
    public void update(VipInfoBean vipInfoBean) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }
}
