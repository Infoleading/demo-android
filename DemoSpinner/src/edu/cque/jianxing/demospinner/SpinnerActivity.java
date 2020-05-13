package edu.cque.jianxing.demospinner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;

public class SpinnerActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_spinner);
		
		
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
