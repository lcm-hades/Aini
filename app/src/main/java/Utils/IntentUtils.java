package Utils;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.io.Serializable;

/**
 * Created by Hades on 2016/3/6.
 */
public class IntentUtils {
    public static void skip(Activity activity, Class<? extends Activity> cls, boolean finish) {
        Intent intent = new Intent(activity, cls);
        activity.startActivity(intent);
        if (finish){
            activity.finish();
        }
    }

    public static void skip(Activity activity, Class<? extends Activity> cls,String key, String value, boolean finish) {
        Intent intent = new Intent(activity, cls);
        intent.putExtra(key, value);
        activity.startActivity(intent);
        if (finish){
            activity.finish();
        }
    }

    public static void skip(Activity activity, Class<? extends Activity> cls,String key, Serializable value, boolean finish) {
        Intent intent = new Intent(activity, cls);
        intent.putExtra(key, value);
        activity.startActivity(intent);
        if (finish){
            activity.finish();
        }
    }

    public static void skip(Activity activity, Class<? extends Activity> cls,String key, Serializable value, String key2, String val2, boolean finish) {
        Intent intent = new Intent(activity, cls);
        intent.putExtra(key, value);
        intent.putExtra(key2, val2);
        activity.startActivity(intent);
        if (finish){
            activity.finish();
        }
    }

    public static void skip(Activity activity, Class<? extends Activity> cls,String key, Serializable value, String key2, String val2, String key3, String val3, boolean finish) {
        Intent intent = new Intent(activity, cls);
        intent.putExtra(key, value);
        intent.putExtra(key2, val2);
        intent.putExtra(key3, val3);
        activity.startActivity(intent);
        if (finish){
            activity.finish();
        }
    }

    public static void skip(Activity activity, Class<? extends Activity> cls,String key, Serializable value, String key2, int val2, boolean finish) {
        Intent intent = new Intent(activity, cls);
        intent.putExtra(key, value);
        intent.putExtra(key2, val2);
        activity.startActivity(intent);
        if (finish){
            activity.finish();
        }
    }

    public static void skip(Activity activity, Class<? extends Activity> cls,String key, int value, boolean finish) {
        Intent intent = new Intent(activity, cls);
        intent.putExtra(key, value);
        activity.startActivity(intent);
        if (finish){
            activity.finish();
        }
    }

    public static void skipResult(Activity activity, Class<? extends Activity> cls, boolean finish, int requestCode) {
        Intent intent = new Intent(activity, cls);
        activity.startActivityForResult(intent, requestCode);
        if (finish){
            activity.finish();
        }
    }

    public static void skipResult(Activity activity, Class<? extends Activity> cls, String key, String value, boolean finish, int requestCode) {
        Intent intent = new Intent();
        intent.putExtra(key, value);
        intent.setClass(activity, cls);
        activity.startActivityForResult(intent, requestCode);
        if (finish) {
            activity.finish();
        }
    }

    public static void skipResult(Activity activity, Class<? extends Activity> cls, String key, int value, boolean finish, int requestCode) {
        Intent intent = new Intent();
        intent.putExtra(key, value);
        intent.setClass(activity, cls);
        activity.startActivityForResult(intent, requestCode);
        if (finish) {
            activity.finish();
        }
    }

    public static void skipResult(Activity activity, Class<? extends Activity> cls, String key, Serializable value, String key1, int value1, boolean finish, int requestCode) {
        Intent intent = new Intent();
        intent.putExtra(key, value);
        intent.putExtra(key1, value1);
        intent.setClass(activity, cls);
        activity.startActivityForResult(intent, requestCode);
        if (finish) {
            activity.finish();
        }
    }

    public static void skipResult(Fragment fragment, Class<? extends Activity> cls, String key, Serializable value, String key1, int value1, boolean finish, int requestCode) {
        Intent intent = new Intent();
        intent.putExtra(key, value);
        intent.putExtra(key1, value1);
        intent.setClass(fragment.getActivity(), cls);
        fragment.startActivityForResult(intent, requestCode);
        if (finish) {
            fragment.getActivity().finish();
        }
    }

    public static void skipResult(Activity activity, Class<? extends Activity> cls, String key, String value, String key1, String value1, boolean finish, int requestCode) {
        Intent intent = new Intent();
        intent.putExtra(key, value);
        intent.putExtra(key1, value1);
        intent.setClass(activity, cls);
        activity.startActivityForResult(intent, requestCode);
        if (finish) {
            activity.finish();
        }
    }

    public static void skipResult(Activity activity, Class<? extends Activity> cls, String key, Serializable value, boolean finish, int requestCode) {
        Intent intent = new Intent();
        intent.putExtra(key, value);
        intent.setClass(activity, cls);
        activity.startActivityForResult(intent, requestCode);
        if (finish) {
            activity.finish();
        }
    }

    public static void finishResult(Activity ac, int resultCode, String key, Serializable value){
        Intent intent = new Intent();
        intent.putExtra(key, value);
        ac.setResult(resultCode, intent);
        ac.finish();
    }
}
