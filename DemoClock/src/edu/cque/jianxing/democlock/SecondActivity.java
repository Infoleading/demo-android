package edu.cque.jianxing.democlock;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.Menu;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Chronometer.OnChronometerTickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ToggleButton;

public class SecondActivity extends Activity {
	
	private Chronometer chronometer;
	private ToggleButton btn;
	private EditText edit;
	private int seconds;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		edit = (EditText)findViewById(R.id.edit);
		
		chronometer = (Chronometer)findViewById(R.id.chronometer);
		OnMyChronometerTickListener tickListener = new OnMyChronometerTickListener();
		chronometer.setOnChronometerTickListener(tickListener);
		
		btn = (ToggleButton)findViewById(R.id.startBt);
		OnMyCheckedListener checkLisener = new OnMyCheckedListener();
		btn.setOnCheckedChangeListener(checkLisener);		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		menu.findItem(R.id.activity_main).setIntent(new Intent(this, MainActivity.class));
		menu.findItem(R.id.activity_second).setIntent(new Intent(this, SecondActivity.class));
		return true;
	}
	
	
	class OnMyChronometerTickListener implements OnChronometerTickListener{

		@Override
		public void onChronometerTick(Chronometer chronometer) {
			// TODO Auto-generated method stub
			Log.d("Chronometer", "OnMyChronometer occurs: seconds="+seconds);
			if(seconds<0){
				chronometer.stop();
				btn.setChecked(false);
			}
			else
				seconds--;
		}
		
	}
	
	class OnMyCheckedListener implements OnCheckedChangeListener{

		@Override
		public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			// TODO Auto-generated method stub
			if(isChecked){
				if(edit.getText().toString().length()==0)
					edit.setHintTextColor(Color.RED);
				else{
					seconds = Integer.parseInt(edit.getText().toString());
					chronometer.setBase(SystemClock.elapsedRealtime());
					chronometer.start();
				}
			}else
				chronometer.stop();
		}
		
	}

}
