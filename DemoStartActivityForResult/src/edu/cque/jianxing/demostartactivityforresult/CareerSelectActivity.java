package edu.cque.jianxing.demostartactivityforresult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CareerSelectActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_career_select);
	}
	
	public void onBt11Click(View view) {
		Intent intent = getIntent();
		intent.putExtra("career", "公务员");
		setResult(RESULT_OK, intent);
		finish();
	}
	
	public void onBt12Click(View view) {
		Intent intent = getIntent();
		intent.putExtra("career", "医生");
		setResult(RESULT_OK, intent);
		finish();
	}

	public void onBt13Click(View view) {
		Intent intent = getIntent();
		intent.putExtra("career", "教师");
		setResult(RESULT_OK, intent);
		finish();
	}

}
