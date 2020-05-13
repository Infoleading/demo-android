package edu.cque.jianxing.demoactivitylife;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class FirstActivity extends Activity {

	private static final String TAG = "FirstActivity";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first);
		TextView tv1 = (TextView)findViewById(R.id.tv1);
		tv1.setText(this.toString());
		Log.d(TAG, "onCreate");
		Log.d(TAG, this.toString());
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.d(TAG, "onDestroy()");
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.d(TAG, "onPause()");
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Log.d(TAG, "onRestart()");
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.d(TAG, "onResume()");
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.d(TAG, "onStart()");
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.d(TAG, "onStop()");
	}
	
	public void onClickBtn1(View view){
		Intent intent = new Intent();
		intent.setClass(this, FirstActivity.class);
		startActivity(intent);
		
	}	

	public void onClickBtn2(View view){
		Intent intent = new Intent();
		intent.setClass(this, SecondActivity.class);
		startActivity(intent);
		
	}

	public void onClickBtn3(View view){
		Intent intent = new Intent();
		intent.setClass(this, ThirdActivity.class);
		startActivity(intent);
	}
	
}
