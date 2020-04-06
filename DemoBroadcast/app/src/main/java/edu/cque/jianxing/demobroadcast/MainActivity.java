package edu.cque.jianxing.demobroadcast;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.KeyEventDispatcher;

public class MainActivity extends AppCompatActivity {

    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSend = findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("edu.cque.jianxing.demobroadcast.MY_BROADCAST");

                // 高版本android 要接收自己的广播必须设置 component, 第一个参数是包名，第二个参数是接收器类
                // 如果 receiver 在其它 app 中，不能设置 component属性
                //intent.setComponent(new ComponentName("edu.cque.jianxing.demobroadcast", "edu.cque.jianxing.demobroadcast.MyReceiver"));

                sendBroadcast(intent, "edu.cque.jianxing.demobroadcast.permission.MY_BROADCAST");
                Log.d("DemoBroadcast", "MY_BROADCAST has sended");
            }
        });

    }


}
