package edu.cque.jianxing.practicebroadcastoffline;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends BaseActivity {

    private Button btnOffline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOffline = findViewById(R.id.btn_offline);
        btnOffline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("edu.cque.jianxing.practicebroadcastoffline.FORCE_OFFLINE");
                sendBroadcast(intent);
            }
        });

    }
}
