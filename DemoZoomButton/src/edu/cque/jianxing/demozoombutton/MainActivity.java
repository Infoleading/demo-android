package edu.cque.jianxing.demozoombutton;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import android.widget.TextView;
import android.widget.ZoomButton;

public class MainActivity extends Activity {
	private TextView tv;
	private ImageButton ibDown, ibUp;
	private ZoomButton zbDown, zbUp;
	private EditText logs;
	private NumberPicker picker;
	private int multiple=1;
	private long speed=1000;
	private int count=0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tv = (TextView)findViewById(R.id.tv);
		ibDown = (ImageButton)findViewById(R.id.ib_down);
		ibUp = (ImageButton)findViewById(R.id.ib_up);
		zbDown = (ZoomButton)findViewById(R.id.zb_down);
		zbUp = (ZoomButton)findViewById(R.id.zb_up);
		logs = (EditText)findViewById(R.id.logs);
		picker = (NumberPicker)findViewById(R.id.speed);
		
		OnMyClickListener myClickLsn = new OnMyClickListener();
		zbDown.setOnClickListener(myClickLsn);
		zbUp.setOnClickListener(myClickLsn);
		ibDown.setOnClickListener(myClickLsn);
		ibUp.setOnClickListener(myClickLsn);
		
		picker.setMaxValue(7);
		picker.setMinValue(1);
		picker.setValue(4);
		picker.setOnValueChangedListener(new OnValueChangeListener() {
			
			@Override
			public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
				speed *= Math.pow(10, newVal-oldVal);
				zbDown.setZoomSpeed(speed);
				zbUp.setZoomSpeed(speed);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	class OnMyClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			switch(v.getId()){
			case R.id.ib_down:
				tv.setTextSize(tv.getTextSize()-1);
				logs.append((count++)+": ImageButton_down onclick 事件响应\r\n");
				break;
			case R.id.ib_up:
				tv.setTextSize(tv.getTextSize()+1);
				logs.append((count++)+": ImageButton_up onclick 事件响应\r\n");
				break;
			case R.id.zb_down:
				tv.setTextSize(tv.getTextSize()-1);
				logs.append((count++)+": ZoomButton_down reponses at speed:"+speed+"ms\r\n");
				break;
			case R.id.zb_up:
				tv.setTextSize(tv.getTextSize()+1);
				logs.append((count++)+": ZoomButton_up reponses at speed:"+speed+"ms\r\n");
				break;
			}
		}
	}	
}
