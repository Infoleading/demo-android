package edu.cque.jianxing.demostartactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void onBtn1Click(View view){
		Intent intent = new Intent();
		intent.setClass(MainActivity.this, SecondActivity.class);
		startActivity(intent);
	}

}
