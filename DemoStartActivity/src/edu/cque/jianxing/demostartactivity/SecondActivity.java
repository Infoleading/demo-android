package edu.cque.jianxing.demostartactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class SecondActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
	}

	public void onBtn2Click(View view) {
		finish();
	}

}
