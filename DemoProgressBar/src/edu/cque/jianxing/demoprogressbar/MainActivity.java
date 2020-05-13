package edu.cque.jianxing.demoprogressbar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		menu.findItem(R.id.activity_1).setIntent(new Intent(this, MainActivity.class));
		menu.findItem(R.id.activity_2).setIntent(new Intent(this, SecondActivity.class));
		menu.findItem(R.id.activity_3).setIntent(new Intent(this, ThirdActivity.class));
		menu.findItem(R.id.activity_4).setIntent(new Intent(this, ForthActivity.class));
		return true;
	}

}
