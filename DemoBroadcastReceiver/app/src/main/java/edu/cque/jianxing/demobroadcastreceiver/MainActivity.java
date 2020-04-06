package edu.cque.jianxing.demobroadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import edu.cque.jianxing.demobroadcastreceiver.R;

public class MainActivity extends AppCompatActivity {

    private NetworkChangeReceiver receiver;  //声明成员变量来持有接收器对象
    private MyBroadCastReceiver2 receiver2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //动态注册接收器接收系统广播 CONNECTIVITY_CHANGE
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        receiver = new NetworkChangeReceiver();
        registerReceiver(receiver, intentFilter); //注册接收器，

        //android8.0以上系统,动态注册接收器接收来自其它应用的自定义广播
        //使用此动态注册时，必须要将之前实验用的manifest中的静态注册删除
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("edu.cque.jianxing.demobroadcast.MY_BROADCAST");
        receiver2 = new MyBroadCastReceiver2();
        //注册 receiver 时除了 receiver实例和过滤器以外，还必须要有广播的相关权限，该权限要已在 manifest中声明
        registerReceiver(receiver2, intentFilter2, "edu.cque.jianxing.demobroadcast.permission.MY_BROADCAST", null);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver); //必须在activity结束时取消注册 BroadcastReceiver
        unregisterReceiver(receiver2);
    }

    /**
     * 接收器类定义
     */
    private class NetworkChangeReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {

            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

            if (networkInfo != null && networkInfo.isAvailable()) {
                Toast.makeText(context, "network is up", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(context, "network is down", Toast.LENGTH_LONG).show();
            }
        }
    }

    /**
     * 接收器类定义
     */
    private class MyBroadCastReceiver2 extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "MY_BROADCAST has received by dynamic manner", Toast.LENGTH_LONG).show();
            Log.d("DemoBroadcastReceiver", "MY_BROADCAST has received by dynamic manner");
        }
    }
}
