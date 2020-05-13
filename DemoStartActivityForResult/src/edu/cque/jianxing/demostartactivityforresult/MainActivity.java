package edu.cque.jianxing.demostartactivityforresult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	public static final int REQUEST_CITY = 0x01;
	public static final int REQUEST_CAREER = 0x02;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void onBtnCityClick(View view) {
		Intent intent = new Intent(MainActivity.this, CitySelectActivity.class);
		startActivityForResult(intent, this.REQUEST_CITY);
	}

	public void onBtnCareerClick(View view) {
		Intent intent = new Intent(MainActivity.this, CareerSelectActivity.class);
		startActivityForResult(intent, this.REQUEST_CAREER);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		switch (requestCode) {
		case REQUEST_CITY:
			if (resultCode == RESULT_OK) {
				EditText etCity = (EditText) findViewById(R.id.et_city);
				etCity.setText(data.getStringExtra("city"));
			}
			break;
		case REQUEST_CAREER:
			if (resultCode == RESULT_OK) {
				EditText etCareer = (EditText) findViewById(R.id.et_career);
				etCareer.setText(data.getStringExtra("career"));
			}
			break;
		}

	}

}
