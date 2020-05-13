package edu.cque.jianxing.demointent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	private EditText editText;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		editText = (EditText)findViewById(R.id.editText);
	}
	
	public void onClickBtn1(View view){
		Intent intent = new Intent();
		intent.setClass(MainActivity.this, OtherActivity.class);
		intent.putExtra("edu.cque.jianxing.demointent.account", editText.getText().toString());
		startActivity(intent);
	}
	
	public void onClickBtn2(View view){
		Intent intent = new Intent();
		intent.setClass(MainActivity.this, OtherActivity.class);
		intent.putExtra("edu.cque.jianxing.demointent.account", editText.getText().toString());
		startActivityForResult(intent, 1);
	}
	

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		
		if(requestCode == 1 )
			switch(resultCode){
			case Activity.RESULT_OK :
				String msg = data.getStringExtra("edu.cque.jianxing.demointent.back");
				editText.setText(msg);
				break;
			case Activity.RESULT_CANCELED :
				break;
			default :
				break;
			}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
