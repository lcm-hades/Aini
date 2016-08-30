package com.hades.aini;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

public abstract class BaseActivity extends FragmentActivity implements View.OnClickListener {

    private RelativeLayout mTopRL;
    private ImageView top_left_iv;
    private TextView top_title_tv;
    private LinearLayout body_ll;

    protected abstract void init();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        initView();
        init();

    }

    private void initView() {

        body_ll = (LinearLayout) findViewById(R.id.body_ll);
        top_title_tv = (TextView) findViewById(R.id.top_title_tv);
        body_ll = (LinearLayout) findViewById(R.id.body_ll);
        mTopRL = (RelativeLayout) findViewById(R.id.top_rl);
        top_left_iv = (ImageView) findViewById(R.id.top_left_iv);
        top_left_iv.setOnClickListener(this);
    }

    protected void setTopTitle(String title){
        top_title_tv.setText(title);
    }

    protected void setTopTitle(int title){
        top_title_tv.setText(title);
    }

    protected void setLeftButtonGone(){
        top_left_iv.setVisibility(View.GONE);
    }

    protected View setBody(int bodyLayout){
        View content = View.inflate(this, bodyLayout, null);
        ViewUtils.inject(this, content);
        body_ll.addView(content);
        return content;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.top_left_iv:
                finish();
                break;
        }
    }
}
