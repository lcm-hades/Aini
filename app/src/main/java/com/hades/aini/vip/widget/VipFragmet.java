package com.hades.aini.vip.widget;

import android.content.Intent;
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
public class VipFragmet extends BaseFragment implements IVipLoadView, VipFragAdapter.OnVipFragAdapterItemClickLitsener, SwipeRefreshLayout.OnRefreshListener {

    @ViewInject(R.id.swipeRefreshLayout)
    private SwipeRefreshLayout swipeRefreshLayout;

    @ViewInject(R.id.recyclerView_rv)
    private RecyclerView recyclerView_rv;

    private List<VipInfoBean> mVipBeanList = new ArrayList<>();

    public static final String Source = "source";
    public static final int Update = 0x110;
    public static final int Insert = 0x111;

    public static final String DATA = "data";

    VipLoadPresenterImpl mPresnter;

    @Override
    protected void init() {
        setBody(R.layout.fg_vip_layout);
        setTopTitle("会员");
        setRightButtonVisible();

        mPresnter = new VipLoadPresenterImpl(this);
        mPresnter.loadVipInfo();

        swipeRefreshLayout.setColorSchemeResources(R.color.red, R.color.green, R.color.blue);
        swipeRefreshLayout.setOnRefreshListener(this);


        recyclerView_rv.setHasFixedSize(true);
        recyclerView_rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView_rv.setItemAnimator(new DefaultItemAnimator());
        recyclerView_rv.addItemDecoration(
                new DividerItemDecoration(getActivity(),
                        DividerItemDecoration.VERTICAL_LIST));
    }

    @Override
    public void showVipInfo(List<VipInfoBean> list) {
        for (VipInfoBean vip : list){
            Log.i("test",vip.getId() + " = " + vip.getName() + " = " + vip.getTel());
        }
        mVipBeanList.clear();
        mVipBeanList.addAll(list);
        VipFragAdapter adt = new VipFragAdapter(getActivity(), list);
        adt.setOnVipFragAdapterItemClickLitsener(this);
        recyclerView_rv.setAdapter(adt);
    }

    @Override
    public void showProgress() {
        swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void hideProgress() {

        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onItemClick(View v, int positin) {
        VipInfoBean vip = mVipBeanList.get(positin);
        IntentUtils.skipResult(getActivity(), VipDetailActivity.class, DATA, vip, Source, Update,  false, Update);
    }

    @Override
    protected void onRightButtonClick(View v) {
        IntentUtils.skipResult(getActivity(), VipDetailActivity.class, Source, Insert, false, Insert);
    }

    @Override
    public void onRefresh() {
        mPresnter.loadVipInfo();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Update && resultCode == Update + 1){

        }else if (requestCode == Insert && resultCode == Insert + 1){

        }
    }
}
