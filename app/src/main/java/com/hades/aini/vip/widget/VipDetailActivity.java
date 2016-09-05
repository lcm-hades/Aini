package com.hades.aini.vip.widget;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

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
        if(mSource == VipFragmet.Update){
            mVipInfoBean = (VipInfoBean) getIntent().getSerializableExtra(VipFragmet.DATA);
            setUI(mVipInfoBean);
        }
        vipDetailPresenter = new VipDetailPresenterImpl(this);
    }

    private void setUI(VipInfoBean vipInfoBean) {

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
        Log.i("test", "showProgress");
        setLoadingVisible(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        Log.i("test", "hideProgress");
        setLoadingVisible(View.GONE);
    }

    @Override
    public void onFailure(String msg, Exception e) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
