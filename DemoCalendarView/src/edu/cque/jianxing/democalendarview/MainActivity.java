package edu.cque.jianxing.democalendarview;

import java.text.SimpleDateFormat;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private CalendarView calendarView;
	private TextView output;
	private SimpleDateFormat f;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		calendarView = (CalendarView)findViewById(R.id.calendar);
		long timeTemp = calendarView.getDate();
		
		OnMyDateChangeListener listener = new OnMyDateChangeListener();
		calendarView.setOnDateChangeListener(listener);
		
		f = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
		output = (TextView)findViewById(R.id.output);
		output.setText(f.format(timeTemp));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	class OnMyDateChangeListener implements OnDateChangeListener{

		@Override
		public void onSelectedDayChange(CalendarView calendar, int year, int month, int dayofmonth) {
			// TODO Auto-generated method stub
			output.setText("我的生日："+year+"年"+month+"月"+dayofmonth+"日");
		}
		
	}
}
