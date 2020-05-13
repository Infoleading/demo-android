package edu.cque.jianxing.demotogglebutton;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;
import android.widget.ToggleButton;

public class MainActivity extends Activity {
	
	private ToggleButton tb1,tb2;
	private Switch sw1,sw2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tb1 = (ToggleButton)findViewById(R.id.tb1);
		tb2 = (ToggleButton)findViewById(R.id.tb2);
		sw1 = (Switch)findViewById(R.id.sw1);
		sw2 = (Switch)findViewById(R.id.sw2);
		
		OnMyCheckChangeListener myListener = new OnMyCheckChangeListener();
		tb1.setOnCheckedChangeListener(myListener);
		tb2.setOnCheckedChangeListener(myListener);
		sw1.setOnCheckedChangeListener(myListener);
		sw2.setOnCheckedChangeListener(myListener);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	class OnMyCheckChangeListener implements OnCheckedChangeListener{

		@Override
		public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			// TODO Auto-generated method stub
			switch(buttonView.getId()){
			case R.id.tb1:
				tb2.setChecked(isChecked);
				break;
			case R.id.tb2:
				tb1.setChecked(isChecked);
				break;
			case R.id.sw1:
				sw2.setChecked(isChecked);
				break;
			case R.id.sw2:
				sw1.setChecked(isChecked);
				break;
			}
		}
		
	}

}
