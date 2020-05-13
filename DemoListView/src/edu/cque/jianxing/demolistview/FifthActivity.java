package edu.cque.jianxing.demolistview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FifthActivity extends Activity {
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fifth);
		
		ArrayAdapter<String> adapter = 
				new ArrayAdapter<String>(this, R.layout.my_list_item_1,R.id.checkedTextView, Raw.names);
		ListView listView = (ListView)findViewById(R.id.listView);
		listView.setAdapter(adapter);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.first, menu);
		menu.findItem(R.id.activity1).setIntent(new Intent(this, FirstActivity.class));
		menu.findItem(R.id.activity2).setIntent(new Intent(this, SecondActivity.class));
		menu.findItem(R.id.activity3).setIntent(new Intent(this, ThirdActivity.class));
		menu.findItem(R.id.activity4).setIntent(new Intent(this, ForthActivity.class));		
		menu.findItem(R.id.activity5).setIntent(new Intent(this, FifthActivity.class));			
		return true;
	}

}
