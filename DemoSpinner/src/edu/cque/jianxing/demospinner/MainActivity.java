package edu.cque.jianxing.demospinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

public class MainActivity extends Activity {
	
	private List data = new ArrayList();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Spinner spinner = (Spinner)findViewById(R.id.sp_image);
		/*spinner.setAdapter(
				new ArrayAdapter(
						MainActivity.this,
						R.layout.spinner_list_item,
						R.id.iv_item,
						data)); */
		
		spinner.setAdapter(
				new SimpleAdapter(
						MainActivity.this,
						initData(),
						R.layout.spinner_list_item,
						new String[] {"icon"},
						new int[] {R.id.iv_item}));
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

	private List initData() {
		for(int i=0; i<Raw.iconId.length; i++) {
			Map item = new HashMap();
			item.put("icon", Raw.iconId[i]);
			data.add(item);
		}
		return data;
	}
}
