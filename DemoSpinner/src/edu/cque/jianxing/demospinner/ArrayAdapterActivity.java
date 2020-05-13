package edu.cque.jianxing.demospinner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class ArrayAdapterActivity extends Activity {

	private Spinner spinner;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_array_adapter);
		
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				this, 
				android.R.layout.simple_list_item_1,
				Raw.names);
		
		spinner = (Spinner)findViewById(R.id.spinner);
		spinner.setAdapter(adapter);
	
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
	
	class OnMyItemSelectedListener implements OnItemSelectedListener{

		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
			// TODO Auto-generated method stub
			String name = (String)arg0.getSelectedItem();
			Toast.makeText(ArrayAdapterActivity.this, name, Toast.LENGTH_LONG).show();
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			Toast.makeText(ArrayAdapterActivity.this, "non", Toast.LENGTH_LONG);
		}
	
	}
}
