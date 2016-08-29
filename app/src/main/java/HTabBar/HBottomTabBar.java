package HTabBar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hades.aini.R;

import Utils.Utils;


/**
 * Created by Hades on 2015/10/26.
 */

public class HBottomTabBar extends LinearLayout implements View.OnClickListener {

    private HBottomTabBarSelectedListener listener;

    private Context mContext;

    private int[] mNormalIcons;

    private int[] mSelectIcons;

    private String[] mTitle;

    private int mWidth;

    private int m_select_index;

    public HBottomTabBar(Context context) {
        this(context, null);
    }

    public HBottomTabBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HBottomTabBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        // init();
    }

    public void setIcons(int[] normal, int[] select){
        mNormalIcons = normal;
        mSelectIcons = select;
        init();
    }

    public void setTitle(String[] title){
        mTitle = title;
    }

    private void init() {
        if (mNormalIcons != null && mSelectIcons != null) {
            int length = mNormalIcons.length;

            mWidth = Utils.getScreenWidth(mContext) / length;
            for (int i = 0; i < length; i++) {
                LayoutInflater layoutInflater = LayoutInflater.from(mContext);
                LinearLayout content = (LinearLayout) layoutInflater.inflate(R.layout.item_b_tab_bar, null);
                content.setTag(String.valueOf(i));
                content.setOnClickListener(this);
                TextView title = (TextView) content.findViewById(R.id.tab_title);
                title.setText(mTitle[i]);
                ImageView icon = (ImageView) content.findViewById(R.id.tab_icon);
                if (i == 0) {
                    icon.setImageDrawable(mContext.getResources().getDrawable(mSelectIcons[i]));
                } else {
                    icon.setImageDrawable(mContext.getResources().getDrawable(mNormalIcons[i]));
                }
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(mWidth, Utils.dip2px(mContext, 54));
                content.setLayoutParams(layoutParams);
                addView(content);
            }
        }
    }

    @Override
    public void onClick(View v) {
        int index = Integer.parseInt(v.getTag().toString());
        View con = getChildAt(index);
        ImageView icon = (ImageView)con.findViewById(R.id.tab_icon);
        for(int i=0; i< getChildCount();i++){
            View content = getChildAt(i);
            ImageView ic = (ImageView)content.findViewById(R.id.tab_icon);
            ic.setImageDrawable(mContext.getResources().getDrawable(mNormalIcons[i]));
        }
        icon.setImageDrawable(mContext.getResources().getDrawable(mSelectIcons[index]));
        m_select_index = index;
        if (listener != null){
            listener.onBottomTabBarSelected(v, index);
        }
    }

    public interface HBottomTabBarSelectedListener{
        void onBottomTabBarSelected(View v, int index);
    }

    public void setHTabBarSelectedListener(HBottomTabBarSelectedListener listener){
        this.listener = listener;
    }
}
