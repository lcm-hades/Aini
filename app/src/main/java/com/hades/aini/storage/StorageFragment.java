package com.hades.aini.storage;

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
public class StorageFragment extends BaseFragment {


    @Override
    protected void init() {
        setBody(R.layout.fg_storage_layout);
        setTopTitle("仓库");
    }

    @Override
    protected void onRightButtonClick(View v) {

    }
}
