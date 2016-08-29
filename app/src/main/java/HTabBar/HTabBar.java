package HTabBar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.hades.aini.R;

import java.util.List;

import SHTimer.SHTimer;

/**
 * Created by Hades on 2015/10/16.
 */
public class HTabBar extends HorizontalScrollView implements View.OnClickListener {

    private int m_tab_count;
    private int m_indicator_color;
    private int m_indicator_height;
    private int m_indicator_selected_color;
    private String m_tab_text;
    private int m_tab_background;
    private int m_tab_selected_background;
    private int m_tab_selected_text_color;

    private LinearLayout mLinearLayout;

    private int m_select_index;

    private Context mContext;

    private HTabBarSelectedListener listener;

    private int width;


    public HTabBar(Context context) {
        this(context, null);
    }

    public HTabBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HTabBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        mContext = context;
        mLinearLayout = new LinearLayout(context);
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mLinearLayout.setLayoutParams(lp);
        addView(mLinearLayout);
//        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.HTabBar, defStyleAttr, 0);
//        m_tab_count = a.getInt(R.styleable.HTabBar_tab_count, m_tab_count);
//        m_indicator_color = a.getColor(R.styleable.HTabBar_indicator_color, m_indicator_color);
//        m_indicator_height = a.getDimensionPixelSize(R.styleable.HTabBar_indicator_height, m_indicator_height);
//        m_indicator_selected_color = a.getColor(R.styleable.HTabBar_indicator_selected_color, m_indicator_selected_color);
//        m_tab_text = a.getString(R.styleable.HTabBar_tab_text);
//        m_tab_background = a.getColor(R.styleable.HTabBar_tab_background, m_tab_background);
//        m_tab_selected_background = a.getColor(R.styleable.HTabBar_tab_selected_background, m_tab_selected_background);
//        m_tab_selected_text_color = a.getColor(R.styleable.HTabBar_tab_selected_text_color, m_tab_selected_text_color);
    }



    public void setSelectIndex(int index){
        m_select_index = index;
    }

    public void setTabText(List<String> list){
        int size = 0;
        int lenght = list.size();
        size = lenght>=5 ? 5 : lenght;
        width = getScreenWidth()/(size);
        for (int i=0; i<list.size();i++){
            LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            LinearLayout content = (LinearLayout) layoutInflater.inflate(R.layout.item, null);
            content.setTag(String.valueOf(i));
            content.setOnClickListener(this);
            TextView textView = (TextView)content.findViewById(R.id.order_all_tv);
            textView.setText(list.get(i));
            TextView textView1 = (TextView)content.findViewById(R.id.order_all_bottom);
            if (m_select_index == i){
                textView1.setVisibility(View.VISIBLE);
            }else {
                textView1.setVisibility(View.INVISIBLE);
            }
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(width, dip2px(54));
            content.setLayoutParams(layoutParams);
            mLinearLayout.addView(content);


            SHTimer shTimer = new SHTimer();
            shTimer.start(100, 100, 1, new SHTimer.SHTimerCallback() {
                @Override
                public void onTimerCallback() {
                    smoothScrollTo(m_select_index * width, 0);
                }
            });

        }
    }

    public void setTabText(String [] list){
        int size = 0;
        int lenght = list.length;
        size = lenght>=5 ? 5 : lenght;
        width = getScreenWidth()/(size);
        for (int i=0; i<list.length;i++){
            LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            LinearLayout content = (LinearLayout) layoutInflater.inflate(R.layout.item, null);
            content.setTag(String.valueOf(i));
            content.setOnClickListener(this);
            TextView textView = (TextView)content.findViewById(R.id.order_all_tv);
            textView.setText(list[i]);
            TextView textView1 = (TextView)content.findViewById(R.id.order_all_bottom);
            if (m_select_index == i){
                textView1.setVisibility(View.VISIBLE);
            }else {
                textView1.setVisibility(View.INVISIBLE);
            }
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(width, dip2px(54));
            content.setLayoutParams(layoutParams);
            mLinearLayout.addView(content);
            SHTimer shTimer = new SHTimer();
            shTimer.start(100, 100, 1, new SHTimer.SHTimerCallback() {
                @Override
                public void onTimerCallback() {
                    smoothScrollTo(m_select_index * width, 0);
                }
            });

        }
    }


    private int getScreenWidth(){
        WindowManager wm = (WindowManager)mContext.getSystemService(Context.WINDOW_SERVICE);
        return wm.getDefaultDisplay().getWidth();
    }

    private int dip2px(int dipValue){
        final float scale = mContext.getResources().getDisplayMetrics().density;
        return (int)(dipValue * scale + 0.5f);
    }

    @Override
    public void onClick(View v) {
        int index = Integer.parseInt(v.getTag().toString());
        View con = mLinearLayout.getChildAt(index);
        TextView bottom = (TextView)con.findViewById(R.id.order_all_bottom);
        for(int i=0; i< mLinearLayout.getChildCount();i++){
            View content = mLinearLayout.getChildAt(i);
            TextView textView = (TextView)content.findViewById(R.id.order_all_bottom);
            textView.setVisibility(View.INVISIBLE);
        }
        bottom.setVisibility(View.VISIBLE);
        m_select_index = index;
        SHTimer shTimer = new SHTimer();
        shTimer.start(100, 100, 1, new SHTimer.SHTimerCallback() {
            @Override
            public void onTimerCallback() {
                smoothScrollTo((m_select_index - 1) * width, 0);
            }
        });

        if (this.listener != null)
            listener.onTabBarSelected(v, index);
    }

    public interface HTabBarSelectedListener{
        void onTabBarSelected(View v, int index);
    }

    public void setHTabBarSelectedListener(HTabBarSelectedListener listener){
        this.listener = listener;
    }


    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return super.onTouchEvent(ev);
    }
}
