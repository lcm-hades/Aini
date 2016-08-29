package SHTimer;

import android.os.Handler;
import android.os.Message;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Xiunaer on 2015/10/1.
 */
public class SHTimer {

    private int mCount = 0;

    TimerTask task = new TimerTask(){
        public void run() {
            Message message = new Message();
            message.what = 1;
            handler.sendMessage(message);
        }
    };

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    if (mCallback != null){
                        mCallback.onTimerCallback();
                    }
                    if (mCount -- == 0){
                        cancel();
                    }
                    break;
            }
            super.handleMessage(msg);
        }
    };
    Timer timer = new Timer();

    SHTimerCallback mCallback;
    public void start(int deley, int start, int count, SHTimerCallback callback){
        mCount = count;
        mCallback = callback;
        timer.schedule(task, deley, start);
    }

    public void cancel(){
        timer.cancel();
        task.cancel();
        timer = null;
        task = null;
        handler.removeCallbacksAndMessages(null);
    }

    public interface SHTimerCallback{
        void onTimerCallback();
    }
}
