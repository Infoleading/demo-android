package edu.cque.jianxing.demonumberpicker;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private NumberPicker np1, np2;
	private TextView tv2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		OnMyValueChangeListener myListener = new OnMyValueChangeListener();
		
		np1 = (NumberPicker)findViewById(R.id.np1);
		np1.setMaxValue(10);
		np1.setMinValue(1);
		np1.setOnValueChangedListener(myListener);
		np2 = (NumberPicker)findViewById(R.id.np2);
		np2.setMaxValue(20);
		np2.setMinValue(10);
		np2.setOnValueChangedListener(myListener);
				
		tv2 = (TextView)findViewById(R.id.tv2);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	class OnMyValueChangeListener implements OnValueChangeListener{

		@Override
		public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
			// TODO Auto-generated method stub			
			if(picker.getId()==R.id.np1)
				tv2.setText("最低价被从 "+oldVal+" 设为了 "+newVal);
			if(picker.getId()==R.id.np2)
				tv2.setText("最高价被从 "+oldVal+" 设为了 "+newVal);
		}
		
	}

}
