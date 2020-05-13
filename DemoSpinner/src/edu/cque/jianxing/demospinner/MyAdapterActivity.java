package edu.cque.jianxing.demospinner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MyAdapterActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_adapter);
		Spinner spinner = (Spinner)findViewById(R.id.sp_complex);
		spinner.setAdapter(new BaseAdapter() {
			
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				// TODO Auto-generated method stub
				TextView view = new TextView(MyAdapterActivity.this);
				view.setText(Raw.names[position]);
				return view;
			}
			
			@Override
			public long getItemId(int position) {
				// TODO Auto-generated method stub			
				return position;
			}
			
			@Override
			public Object getItem(int position) {
				// TODO Auto-generated method stub			
				return Raw.names[position];
			}
			
			@Override
			public int getCount() {
				// TODO Auto-generated method stub			
				return Raw.names.length;
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		menu.findItem(R.id.act1).setIntent(new Intent(this, SpinnerActivity.class));
		menu.findItem(R.id.act2).setIntent(new Intent(this, ArrayAdapterActivity.class));
		menu.findItem(R.id.act3).setIntent(new Intent(this, MainActivity.class));		
		menu.findItem(R.id.act4).setIntent(new Intent(this, DualSpinnerActivity.class));
		menu.findItem(R.id.act5).setIntent(new Intent(this, MyAdapterActivity.class));
		return true;
	}

}
