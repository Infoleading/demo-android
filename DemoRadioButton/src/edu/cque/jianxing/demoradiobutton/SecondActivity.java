package edu.cque.jianxing.demoradiobutton;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class SecondActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.main, menu);
		menu.findItem(R.id.item_demo1).setIntent(new Intent(this, MainActivity.class));
		menu.findItem(R.id.item_demo2).setIntent(new Intent(this, SecondActivity.class));
		menu.findItem(R.id.item_demo3).setIntent(new Intent(this, ThirdActivity.class));
		menu.findItem(R.id.item_demo4).setIntent(new Intent(this, ForthActivity.class));
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
