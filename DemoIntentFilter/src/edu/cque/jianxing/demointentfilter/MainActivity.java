package edu.cque.jianxing.demointentfilter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
	
	public final static String ACTION_OWN="edu.cque.jianxing.intent.action.ACTION_OWN";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void onBtnHomeClick(View view){
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_MAIN);
		intent.addCategory(Intent.CATEGORY_HOME);
		startActivity(intent);
	}
	
	public void onBtnViewClick(View view){
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_VIEW);
		startActivity(intent);
	}
	
	public void onBtnMyActionClick(View view){
		Intent intent = new Intent();
		intent.setAction(MainActivity.ACTION_OWN);
		startActivity(intent);
	}

}
