package com.hades.aini.vip.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.hades.aini.vip.bean.VipInfoBean;

import java.util.List;

import DB.AiniDatabaseHelper;
import DB.DatabaseContext;

/**
 * Created by Hades on 2016/8/30.
 */
public class VipModelImpl implements VipModel {
    AiniDatabaseHelper dbHelper;
    private OnVipInfoChangeListener listener;

    public VipModelImpl(Context context){
        DatabaseContext dbContext = new DatabaseContext(context);
        dbHelper = AiniDatabaseHelper.getInstance(dbContext);
        this.listener = (OnVipInfoChangeListener)context;
    }

//    public int getIDByTel(String tel){
//        SQLiteDatabase db = dbHelper.getReadableDatabase();
//        String sql = "select id from vip_info where tel = " + tel;
//        Cursor cursor = db.rawQuery(sql, null);
//        cursor.moveToFirst();
//        while (cursor.moveToNext()){
//            cursor
//        }
//
//    }

    @Override
    public void insertVipInfo(VipInfoBean vip) {
        SQLiteDatabase db = null;
        try {
            db = dbHelper.getWritableDatabase();
            String sql = "insert into vip_info(name, tel)" + "values(?, ?)";
            db.execSQL(sql, new Object[]{vip.getName(), vip.getName()});
            listener.onInsertSuccess(vip);
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

    }

    @Override
    public void deleteVipInfo(int id) {

    }

    @Override
    public boolean isExist(String tel) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql = "select id from vip_info where tel = ?";
        Cursor cursor = db.rawQuery(sql, new String[]{tel});
        if (cursor.moveToNext()){
            if(cursor.getInt(0) > 0){
                return true;
            }
        }
        return false;
    }

    @Override
    public void getVipInfoList() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
    }

    public interface OnVipInfoChangeListener{
        void onInsertSuccess(VipInfoBean vip);
        void onUpdateSuccess(VipInfoBean vip);
        void onSelectSuccess(List<VipInfoBean> list);
        void onDeleteSuccess(VipInfoBean vip);
        void onFailure(String msg, Exception e);
    }
}
