package com.hades.aini.main;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hades on 2015/9/23.
 */
public class AiniApplication extends Application {
    /**打开的activity**/
    private List<Activity> activities = new ArrayList<Activity>();
    /**应用实例**/
    private static AiniApplication instance;

    /**
     *  获得实例
     * @return
     */

    public static AiniApplication getInstance(){
        return instance;
    }

    /**
     * 新建了一个activity
     * @param activity
     */

    public void addActivity(Activity activity){
        activities.add(activity);
    }

    /**
     *  结束指定的Activity
     * @param activity
     */

    public void finishActivity(Activity activity){
        if (activity!=null) {
            this.activities.remove(activity);
            activity.finish();
            activity = null;
        }
    }

    public void closeAllActivityExceptOne(Activity ac) {
        for (Activity activity : activities) {
            if (activity.equals(ac)) {
                continue;
            }
            activity.finish();
        }
    }

    /*
     * 应用退出，结束所有的activity
     */

    public void exit(){
        for (Activity activity : activities) {
            if (activity!=null) {
                activity.finish();
            }
        }
        System.exit(0);
    }

    public Context getAiniApplicationContext(){
        return getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

    }
}
