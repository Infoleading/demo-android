package edu.cque.jianxing.demointent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class OtherActivity extends Activity {

	String msg;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_other);
		
		Intent intent = getIntent();
		msg = intent.getStringExtra("edu.cque.jianxing.demointent.account");
		
		TextView tv = (TextView)findViewById(R.id.textView);
		tv.setText(msg);
		
	}
	
	public void onClickBtn1(View view){
		Intent intent = new Intent();
		intent.setClass(this, MainActivity.class);
		intent.putExtra("edu.cque.jianxing.demointent.back", "hello"+msg);
		setResult(Activity.RESULT_OK, intent);
		finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.other, menu);
		return true;
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
