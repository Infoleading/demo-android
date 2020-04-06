package edu.cque.jianxing.demobroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * 接收器类定义
 * 该接收器采用静态方法注册接收其它app广播的 MY_BROADCAST 广播
 * android8.0以上的系统已不允许通过静态方式注册receiver来接收来自其它应用的自定义广播
 * 所以该类的回调是收不到广播的
 */
public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        //throw new UnsupportedOperationException("Not yet implemented");
        Toast.makeText(context, "MY_BROADCAST has received by static manner", Toast.LENGTH_LONG).show();
        Log.d("DemoBroadcastReceiver", "MY_BROADCAST has received by static manner");
    }
}
