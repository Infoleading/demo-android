package com.example.demopicker;

import java.util.Calendar;
import java.util.TimeZone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

public class SecondActivity extends Activity {
	
	private TimePicker tp;
	private TextView tv2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		tp = (TimePicker)findViewById(R.id.tp);
		tv2 = (TextView)findViewById(R.id.tv2);
		
		//获取当前系统时间，并设置TimePicker组件
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
		int hour = calendar.get(Calendar.HOUR);
		int minute = calendar.get(Calendar.MINUTE);
		tp.setCurrentHour(hour);
		tp.setCurrentMinute(minute);
		
		OnMyTimeChangeListener myTimeChgLsn = new OnMyTimeChangeListener();
		tp.setOnTimeChangedListener(myTimeChgLsn);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		menu.findItem(R.id.activity_1).setIntent(new Intent(this, MainActivity.class));
		menu.findItem(R.id.activity_2).setIntent(new Intent(this, SecondActivity.class));		
		return true;
	}
	
	class OnMyTimeChangeListener implements OnTimeChangedListener{

		@Override
		public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
			tv2.setText("选中时间："+hourOfDay+"时"+minute+"分");			
		}
		
	}

}
