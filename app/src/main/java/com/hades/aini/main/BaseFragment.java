package com.hades.aini.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hades.aini.R;
import com.lidroid.xutils.ViewUtils;

/**
 * Created by Hades on 2016/8/31.
 */
public abstract class BaseFragment extends Fragment implements View.OnClickListener {

    private RelativeLayout mTopRL;
    private ImageView top_left_iv;
    private TextView top_title_tv;
    private LinearLayout body_ll;
    private TextView right_btn;

    protected abstract void init();
    protected abstract void onRightButtonClick(View v);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_base, null);

        initView(v);
        init();
        return v;
    }

    private void initView(View p) {

        body_ll = (LinearLayout) p.findViewById(R.id.body_ll);
        top_title_tv = (TextView) p.findViewById(R.id.top_title_tv);
        body_ll = (LinearLayout) p.findViewById(R.id.body_ll);
        mTopRL = (RelativeLayout) p.findViewById(R.id.top_rl);
        top_left_iv = (ImageView) p.findViewById(R.id.top_left_iv);
        top_left_iv.setVisibility(View.GONE);
        right_btn = (TextView) p.findViewById(R.id.right_btn);
        right_btn.setOnClickListener(this);
    }

    protected void setTopTitle(String title){
        top_title_tv.setText(title);
    }

    protected void setTopTitle(int title){
        top_title_tv.setText(title);
    }

    protected void setRightButtonTextColor(int color){
        right_btn.setTextColor(color);
    }

    protected void setRightButtonVisible(){
        right_btn.setVisibility(View.VISIBLE);
    }

    protected void setRightButtonText(String title){
        right_btn.setText(title);
    }

    protected void setRightButtonText(int title){
        right_btn.setText(title);
    }

    protected View setBody(int bodyLayout){
        View content = View.inflate(getActivity(), bodyLayout, null);
        ViewUtils.inject(this, content);
        body_ll.addView(content);
        return content;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.right_btn:
                onRightButtonClick(v);
            break;
        }
    }

}
