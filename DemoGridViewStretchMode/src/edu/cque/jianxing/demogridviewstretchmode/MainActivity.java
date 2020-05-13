package edu.cque.jianxing.demogridviewstretchmode;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	public static final int[] texts = {R.string.c1, R.string.c2, R.string.c3, R.string.c4, R.string.c5, R.string.c6, R.string.c7, R.string.c8, R.string.c9};
	public static final int[] colors = {R.color.c1, R.color.c2, R.color.c3, R.color.c4, R.color.c5, R.color.c6, R.color.c7, R.color.c8, R.color.c9};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		GridView gridView = (GridView)findViewById(R.id.gridView);
		gridView.setAdapter(new BaseAdapter() {
			
			@Override
			public View getView(int arg0, View arg1, ViewGroup arg2) {
				TextView textView = new TextView(MainActivity.this);
				textView.setText(MainActivity.texts[arg0]);
				textView.setTextSize(20);
				textView.setGravity(Gravity.CENTER);
				textView.setBackgroundResource(MainActivity.colors[arg0]);
				return textView;
			}
			
			@Override
			public long getItemId(int arg0) {
				return arg0;
			}
			
			@Override
			public Object getItem(int arg0) {
				return MainActivity.texts[arg0];
			}
			
			@Override
			public int getCount() {
				return MainActivity.texts.length;
			}
		});
		
	}

	
}
