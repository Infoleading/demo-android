package com.example.demopicker;

import java.util.Calendar;
import java.util.TimeZone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private TextView tv1;
	private DatePicker dp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tv1 = (TextView)findViewById(R.id.tv1);
		dp = (DatePicker)findViewById(R.id.dp);
		
		//获取当前系统时间，并设置TimePicker组件
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		
		OnMyDateChangedListener myListener1 = new OnMyDateChangedListener();
		dp.init(year, month, day, myListener1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		menu.findItem(R.id.activity_1).setIntent(new Intent(this, MainActivity.class));
		menu.findItem(R.id.activity_2).setIntent(new Intent(this, SecondActivity.class));
		return true;
	}
	
	class OnMyDateChangedListener implements OnDateChangedListener{

		@Override
		public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
			// TODO Auto-generated method stub
			tv1.setText("选中日期："+year+"年"+(monthOfYear+1)+"月"+dayOfMonth+"日");
		}
		
	}

}
