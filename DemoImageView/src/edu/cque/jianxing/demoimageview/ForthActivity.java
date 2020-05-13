package edu.cque.jianxing.demoimageview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class ForthActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_forth);
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
