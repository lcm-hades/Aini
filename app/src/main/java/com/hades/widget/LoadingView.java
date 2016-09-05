package com.hades.widget;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hades.aini.R;


/**
 * Created by Hades on 2016/9/5.
 */
public class LoadingView extends ImageView {


    public LoadingView(Context context) {
        super(context);
        init(context);
    }

    public LoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public LoadingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }


    private void init(Context context){

        AnimationDrawable animationDrawable = (AnimationDrawable) getBackground();
        animationDrawable.start();
    }
}
