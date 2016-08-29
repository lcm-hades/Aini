package com.hades.aini.vip;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hades.aini.R;

/**
 * Created by Hades on 2016/8/29.
 */
public class VipFragmet extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = View.inflate(getActivity(), R.layout.fg_vip_layout, null);
        return v;
    }
}
