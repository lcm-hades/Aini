package com.hades.aini.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hades.aini.R;
import com.hades.aini.main.BaseFragment;

/**
 * Created by Hades on 2016/8/29.
 */
public class DetailFragment extends BaseFragment {
    @Override
    protected void init() {
        setBody(R.layout.fg_detail_layout);
        setTopTitle("明细");
    }

}
