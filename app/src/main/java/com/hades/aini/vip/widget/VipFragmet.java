package com.hades.aini.vip.widget;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.hades.aini.R;
import com.hades.aini.main.BaseFragment;
import com.hades.aini.vip.View.IVipLoadView;
import com.hades.aini.vip.bean.VipInfoBean;
import com.hades.aini.vip.presenter.VipLoadPresenterImpl;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

import Utils.IntentUtils;

/**
 * Created by Hades on 2016/8/29.
 */
public class VipFragmet extends BaseFragment implements IVipLoadView, VipFragAdapter.OnVipFragAdapterItemClickLitsener {

    @ViewInject(R.id.swipeRefreshLayout)
    private SwipeRefreshLayout swipeRefreshLayout;

    @ViewInject(R.id.recyclerView_rv)
    private RecyclerView recyclerView_rv;

    private List<VipInfoBean> mVipBeanList = new ArrayList<>();

    public static final String Source = "source";
    public static final int Update = 0x110;
    public static final int Insert = 0x111;

    public static final String DATA = "data";

    @Override
    protected void init() {
        setBody(R.layout.fg_vip_layout);
        setTopTitle("会员");
        VipLoadPresenterImpl presnter = new VipLoadPresenterImpl(this);
        presnter.loadVipInfo();
    }

    @Override
    public void showVipInfo(List<VipInfoBean> list) {
        for (VipInfoBean vip : list){
            Log.i("test",vip.getId() + " = " + vip.getName() + " = " + vip.getTel());
        }
        mVipBeanList.clear();
        mVipBeanList.addAll(list);
        recyclerView_rv.setHasFixedSize(true);
        recyclerView_rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView_rv.setItemAnimator(new DefaultItemAnimator());
        recyclerView_rv.addItemDecoration(
                new DividerItemDecoration(getActivity(),
                        DividerItemDecoration.VERTICAL_LIST));
        VipFragAdapter adt = new VipFragAdapter(getActivity(), list);
        adt.setOnVipFragAdapterItemClickLitsener(this);
        recyclerView_rv.setAdapter(adt);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void onItemClick(View v, int positin) {
        VipInfoBean vip = mVipBeanList.get(positin);
        IntentUtils.skip(getActivity(), VipDetailActivity.class, DATA, vip, Source, Update,  false);
    }
}
