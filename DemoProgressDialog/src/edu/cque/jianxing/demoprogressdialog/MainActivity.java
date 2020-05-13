package edu.cque.jianxing.demoprogressdialog;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

public class MainActivity extends Activity {
	
	private Button progressDialog, datePickerDialog, timePickerDialog;
	private EditText et;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		progressDialog = (Button)findViewById(R.id.progressDialog);
		datePickerDialog = (Button)findViewById(R.id.datePickerDialog);
		timePickerDialog = (Button)findViewById(R.id.timePickerDialog);
		et = (EditText)findViewById(R.id.returned);
		
		progressDialog.setOnClickListener(new OnProgressDialogClickListener());
		datePickerDialog.setOnClickListener(new OnDatePickerDialogClickListener());
		timePickerDialog.setOnClickListener(new OnTimePickerDialogClickListener());
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	class OnProgressDialogClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {

			ProgressDialog pd = new ProgressDialog(MainActivity.this);
			pd.setTitle("进度条对话框");
			pd.setIcon(R.drawable.ico_info);
			pd.setMessage("正在处理，请稍后...");
			pd.setCancelable(true);
			pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			pd.setIndeterminate(true);
			pd.show();
		}
		
	}
	
	class OnDatePickerDialogClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {

			Calendar c = Calendar.getInstance();
			DatePickerDialog dpd = new DatePickerDialog(
					MainActivity.this, 
					new DatePickerDialog.OnDateSetListener() {
						
						@Override
						public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

							et.append(year+"年"+month+"月"+dayOfMonth+"日\n");
							
						}
					}, 
					c.get(Calendar.YEAR), 
					c.get(Calendar.MONTH),
					c.get(Calendar.DAY_OF_MONTH));
			dpd.show();
			
		}
		
	}
	
	class OnTimePickerDialogClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {

			Calendar c = Calendar.getInstance();
			TimePickerDialog dpd = new TimePickerDialog(
					MainActivity.this, 
					new TimePickerDialog.OnTimeSetListener() {

						@Override
						public void onTimeSet(TimePicker tp, int hourODay, int minute) {
							et.append(hourODay+":"+minute+"\n");
						}
					}, 
					c.get(Calendar.HOUR_OF_DAY), 
					c.get(Calendar.MINUTE),
					true);
			dpd.show();
			
		}
		
	}

}
