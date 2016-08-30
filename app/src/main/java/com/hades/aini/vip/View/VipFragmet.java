package com.hades.aini.vip.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.hades.aini.R;
import com.hades.aini.vip.presenter.VipPresnter;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

/**
 * Created by Hades on 2016/8/29.
 */
public class VipFragmet extends Fragment {
    @ViewInject(R.id.vip_name)
    private EditText vip_name;

    @ViewInject(R.id.vip_tel)
    private EditText vip_tel;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = View.inflate(getActivity(), R.layout.fg_vip_layout, null);
        ViewUtils.inject(getActivity(), v);
        return v;
    }

    @OnClick(R.id.vip_add_btn)
    public void onAddClick(View v){
        VipPresnter presnter = new VipPresnter(getActivity());
        presnter.newVip(vip_name.getText().toString(), vip_tel.getText().toString());
    }
}
