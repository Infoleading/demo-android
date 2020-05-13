package edu.cque.jianxing.demotimedate;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

public class MainActivity extends Activity {

	private TimePicker timePicker;
	private Button button;
	private Button button2;
	private DatePicker datePicker;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		timePicker = (TimePicker)findViewById(R.id.firstTimePicker);
		timePicker.setIs24HourView(true);
		TimeListener tl = new TimeListener();
		timePicker.setOnTimeChangedListener(tl);
		
		button = (Button)findViewById(R.id.b1);
		ButtonListener bl = new ButtonListener();
		button.setOnClickListener(bl);

		button2 = (Button)findViewById(R.id.b2);
		button2.setOnClickListener(bl);
	}
	
	class ButtonListener implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			if(arg0.getId()==R.id.b1){
				int h = timePicker.getCurrentHour();
				int m = timePicker.getCurrentMinute();
				System.out.println("determing: Hour :"+h+", Minutes :"+m);
			}else if(arg0.getId()==R.id.b2){
				int y = datePicker.getYear();
				int m = datePicker.getMonth();
				int d = datePicker.getDayOfMonth();
				System.out.println("year:"+y+", month:"+m+" day:"+d);
			}
		}
		
	}
	
	class TimeListener implements OnTimeChangedListener{
		/**
		 * arg0: 表示TimePicker对象
		 * arg1: TimePicker中的小时数值
		 * arg2: TimePicker中的分钟数值
		 */
		@Override
		public void onTimeChanged(TimePicker arg0, int arg1, int arg2) {
			System.out.println("Hour:"+arg1+", minute："+arg2);
			
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
