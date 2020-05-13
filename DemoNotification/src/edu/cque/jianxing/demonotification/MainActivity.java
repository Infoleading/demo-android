package edu.cque.jianxing.demonotification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	
	private static final int NOTIFICATION_ID = 0x123;
	
	private Button btSend, btDel;
	private NotificationManager nm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
		
		btSend = (Button)findViewById(R.id.send);
		btDel = (Button)findViewById(R.id.del);
		
		btSend.setOnClickListener(new OnSendClickListener());
		btDel.setOnClickListener(new OnDelClickListener());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	class OnSendClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {

			Intent intent = new Intent(Intent.ACTION_SENDTO,Uri.parse("smsto:10000"));
			PendingIntent pi = PendingIntent.getActivity(MainActivity.this, 0x54321, intent, Intent.FLAG_ACTIVITY_NEW_TASK);
			
			Notification notify = new Notification.Builder(MainActivity.this)
					.setAutoCancel(true)
					.setTicker("有新消息")
					.setSmallIcon(R.drawable.phone)
					.setContentTitle("您有 1 未阅读消息")
					.setContentText("来自10000的短信,点击回复")
					.setDefaults(Notification.DEFAULT_SOUND|Notification.DEFAULT_LIGHTS|Notification.DEFAULT_VIBRATE)
					.setContentIntent(pi)
					.build();
			
			nm.notify(NOTIFICATION_ID, notify);
		}
		
	}
	
	class OnDelClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {

			nm.cancel(NOTIFICATION_ID);
			
		}
		
	}


}
