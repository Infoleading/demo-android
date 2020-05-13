package edu.cque.jianxing.demostartactivityforresult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CitySelectActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_city_select);
	}

	public void onBt01Click(View view) {
		Intent intent = getIntent();
		intent.putExtra("city", "ÖØÇì");
		setResult(RESULT_OK, intent);
		finish();
	}
	
	public void onBt02Click(View view) {
		Intent intent = getIntent();
		intent.putExtra("city", "Äþ²¨");
		setResult(RESULT_OK, intent);
		finish();
	}

	public void onBt03Click(View view) {
		Intent intent = getIntent();
		intent.putExtra("city", "ÉîÛÚ");
		setResult(RESULT_OK, intent);
		finish();
	}

}
