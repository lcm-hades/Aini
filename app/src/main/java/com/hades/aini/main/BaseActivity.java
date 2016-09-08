package com.hades.aini.main;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hades.aini.R;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

public abstract class BaseActivity extends FragmentActivity implements View.OnClickListener {

    private RelativeLayout mTopRL;
    private ImageView top_left_iv;
    private TextView top_title_tv;
    private LinearLayout body_ll;
    private ViewStub waiting_vs;
    private View mLoadingView;

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
        waiting_vs = (ViewStub) findViewById(R.id.waiting_vs);
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

    protected void setLoadingVisible(int visible){
        if (visible == View.VISIBLE){
            body_ll.setVisibility(View.GONE);
            if (mLoadingView == null){
                mLoadingView = waiting_vs.inflate();
            }else {
                mLoadingView.setVisibility(visible);
            }

        }else {
            body_ll.setVisibility(View.VISIBLE);
            if (mLoadingView != null){
                mLoadingView.setVisibility(visible);
            }
        }

    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        if (ev.getAction() == MotionEvent.ACTION_DOWN){
            if (isFastDoubleClick()){
                return true;
            }

            View v = getCurrentFocus();
            if (isShouldHideInput(v, ev)) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    private long lastClickTime;

    private boolean isFastDoubleClick(){
        long time = System.currentTimeMillis();
        long timeD = time - lastClickTime;
        if (timeD >= 0 && timeD <= 1000){
            return true;
        }else {
            lastClickTime = time;
            return false;
        }
    }

    public  boolean isShouldHideInput(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] leftTop = { 0, 0 };
            //获取输入框当前的location位置
            v.getLocationInWindow(leftTop);
            int left = leftTop[0];
            int top = leftTop[1];
            int bottom = top + v.getHeight();
            int right = left + v.getWidth();
            if (event.getX() > left && event.getX() < right
                    && event.getY() > top && event.getY() < bottom) {
                // 点击的是输入框区域，保留点击EditText的事件
                return false;
            } else {
                return true;
            }
        }
        return false;
    }
}
