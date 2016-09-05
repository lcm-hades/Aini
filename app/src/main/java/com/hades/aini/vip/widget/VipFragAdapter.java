package com.hades.aini.vip.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hades.aini.R;
import com.hades.aini.vip.bean.VipInfoBean;

import java.util.List;

/**
 * Created by Hades on 2016/8/31.
 */
public class VipFragAdapter extends RecyclerView.Adapter<VipFragAdapter.MyViewHolder> {
    private List<VipInfoBean> mVipInfoBeanList;

    private Context mContext;
    private OnVipFragAdapterItemClickLitsener litsener;

    public VipFragAdapter(Context context, List<VipInfoBean> list){
        mVipInfoBeanList = list;
        mContext = context;
    }

    @Override
    public VipFragAdapter.MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        MyViewHolder holder = new MyViewHolder(
                LayoutInflater.from(mContext).inflate(R.layout.item_vip_layout, viewGroup, false), this.litsener);
        return holder;
    }

    public void setOnVipFragAdapterItemClickLitsener(OnVipFragAdapterItemClickLitsener litsener){
        this.litsener = litsener;
    }

    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int position) {
        VipInfoBean vip = mVipInfoBeanList.get(position);

        viewHolder.name.setText(vip.getName());
        viewHolder.tel.setText(vip.getTel());
        viewHolder.time.setText("" + vip.getTime());
    }

    @Override
    public int getItemCount() {
        return mVipInfoBeanList == null ? 0 : mVipInfoBeanList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name;
        TextView tel;
        TextView time;
        private OnVipFragAdapterItemClickLitsener litsener;

        public MyViewHolder(View itemView, OnVipFragAdapterItemClickLitsener litsener) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name_tv);
            tel = (TextView) itemView.findViewById(R.id.tel_tv);
            time = (TextView) itemView.findViewById(R.id.time_tv);
            itemView.setOnClickListener(this);
            this.litsener = litsener;
        }

        @Override
        public void onClick(View v) {
            litsener.onItemClick(v, getPosition());
        }
    }
    public interface OnVipFragAdapterItemClickLitsener{
        void onItemClick(View v, int positin);
    }

}
