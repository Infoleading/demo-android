package edu.cque.jianxing.demospinner;

import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class DualSpinnerActivity extends Activity {
	
	private Spinner spinner1, spinner2;
	private TextView tvBirth, tvDeed;
	private ImageView imageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dual_spinner);
		
		spinner1 = (Spinner)findViewById(R.id.spinner1);
		spinner2 = (Spinner)findViewById(R.id.spinner2);	
		tvBirth = (TextView)findViewById(R.id.birth);
		tvDeed = (TextView)findViewById(R.id.deed);
		imageView = (ImageView)findViewById(R.id.image);
		
		ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(
				this, 
				android.R.layout.simple_list_item_1, 
				Raw.nationGroup);
		
		spinner1.setAdapter(adapter1);
		spinner1.setOnItemSelectedListener(new OnMyFirstItemSelectedListener());
		spinner2.setOnItemSelectedListener(new OnMySecondItemSelectedListener());
		
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
	
	class OnMyFirstItemSelectedListener implements OnItemSelectedListener{

		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
			ArrayAdapter adapter = (ArrayAdapter)arg0.getAdapter();
			String nation = (String)adapter.getItem(arg2);
			List nationGroup = Arrays.asList(Raw.nationGroup);
			int dim = nationGroup.indexOf(nation);
			String[] names = Raw.nationName[dim];
			adapter = new ArrayAdapter(DualSpinnerActivity.this, android.R.layout.simple_list_item_1, names);
			spinner2.setAdapter(adapter);
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			
		}
	
	}	
	
	class OnMySecondItemSelectedListener implements OnItemSelectedListener{

		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
			ArrayAdapter adapter = (ArrayAdapter)arg0.getAdapter();
			String name = (String)adapter.getItem(arg2);
			List names = Arrays.asList(Raw.names);
			int position = names.indexOf(name);
			tvBirth.setText("出生日期："+Raw.birthday[position]);
			tvDeed.setText("事迹："+Raw.deed[position]);
			imageView.setImageResource(Raw.imageId[position]);
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			
		}
	
	}	

}
