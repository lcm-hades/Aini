package com.hades.aini.vip.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.hades.aini.main.AiniApplication;
import com.hades.aini.vip.bean.VipInfoBean;

import java.util.ArrayList;
import java.util.List;

import DB.AiniDatabaseHelper;
import DB.DatabaseContext;
import Utils.TimeUtils;

/**
 * Created by Hades on 2016/8/30.
 */
public class VipModelImpl implements VipModel {
    AiniDatabaseHelper dbHelper;
    private OnLoadVipInfoListener listener;

    public VipModelImpl(){
        DatabaseContext dbContext = new DatabaseContext(AiniApplication.getInstance().getAiniApplicationContext());
        dbHelper = AiniDatabaseHelper.getInstance(dbContext);
    }

    public int getIDByTel(String tel){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql = "select id from vip_info where tel = " + tel;
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        if(cursor.moveToNext()){
            return cursor.getInt(0);
        }
        return -1;
    }

    @Override
    public void insertVipInfo(VipInfoBean vip) {
        SQLiteDatabase db = null;
        try {
            db = dbHelper.getWritableDatabase();
            String sql = "insert into vip_info(name, tel, time)" + "values(?, ?, ?)";
            db.execSQL(sql, new Object[]{vip.getName(), vip.getTel(), TimeUtils.getCurStamp()});
        }catch (Exception e){
            if (this.listener != null){
                listener.onFailure("insert failure", e);
            }
        }finally {
            if (db != null){
                db.close();
            }
        }
    }

    @Override
    public void updateVipInfo(int id) {
        SQLiteDatabase db = null;
        try {
            db = dbHelper.getWritableDatabase();
            String sql = "update * where id = ?";
            db.execSQL(sql, new Object[]{id});
        }catch (Exception e){

        }finally {
            if (db != null){
                db.close();
            }
        }
    }

    @Override
    public void deleteVipInfo(int id) {
        SQLiteDatabase db = null;
        try {
            db = dbHelper.getWritableDatabase();
            String sql = "delete from vip_info where id = ?";
            db.execSQL(sql, new Object[]{id});
        }catch (Exception e){

        }finally {
            if (db != null){
                db.close();
            }
        }
    }

    @Override
    public boolean isExist(String tel) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql = "select id from vip_info where tel = ?";
        Cursor cursor = db.rawQuery(sql, new String[]{tel});
        if(cursor.getCount() > 0){
            return true;
        }
        return false;
    }

    @Override
    public void getVipInfoList(OnLoadVipInfoListener listener) {
        List<VipInfoBean> vipInfoBeanList = new ArrayList<>();
        SQLiteDatabase db = null;
        try{
            db = dbHelper.getReadableDatabase();
            String sql = "select * from vip_info";
            Cursor cursor = db.rawQuery(sql, null);
            VipInfoBean vipInfoBean = null;
            cursor.moveToFirst();
            while (cursor.moveToNext()){
                vipInfoBean = new VipInfoBean();
                vipInfoBean.setId(cursor.getInt(0));
                vipInfoBean.setName(cursor.getString(1));
                vipInfoBean.setTel(cursor.getString(2));
                vipInfoBean.setTime(cursor.getLong(3));
                vipInfoBeanList.add(vipInfoBean);
            }
            listener.onSuccess(vipInfoBeanList);
        }catch (Exception e){
            listener.onFailure(e.getMessage(), e);
        }finally {
            if (db != null){
                db.close();
            }
        }
    }

    public interface OnLoadVipInfoListener{
        void onSuccess(List<VipInfoBean> list);
        void onFailure(String msg, Exception e);
    }

    public interface OnVipInfoChangeListener{
        void onSuccess(VipInfoBean vip);
        void onFailure(String msg, Exception e);
    }
}
