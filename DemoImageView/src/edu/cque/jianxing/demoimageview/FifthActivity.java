package edu.cque.jianxing.demoimageview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class FifthActivity extends Activity {
	
	private ImageView imageView;
	private SeekBar sb;
	private TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fifth);
		
		imageView = (ImageView)findViewById(R.id.image);
		sb = (SeekBar)findViewById(R.id.seekScale);
		tv = (TextView)findViewById(R.id.tv);
		
		sb.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				int scale = progress-50;
				int newWidth = imageView.getWidth()+scale;
				int newHeight = imageView.getHeight()+scale;
				imageView.setLayoutParams(new RelativeLayout.LayoutParams(newWidth, newHeight));
				tv.setText("Àı∑≈¥Û–°£∫"+scale+"x");
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		menu.findItem(R.id.demo1).setIntent(new Intent(this,MainActivity.class));
		menu.findItem(R.id.demo2).setIntent(new Intent(this,SecondActivity.class));
		menu.findItem(R.id.demo3).setIntent(new Intent(this,ThirdActivity.class));
		menu.findItem(R.id.demo4).setIntent(new Intent(this,ForthActivity.class));
		menu.findItem(R.id.demo5).setIntent(new Intent(this,FifthActivity.class));		
		return true;
	}

}
