package edu.cque.jianxing.demointentdatatype;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class LuncherActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_luncher);
	}

	public void onBtnDialClick(View view){
		Intent intent = new Intent();
		Uri uri = Uri.parse("tel:1234567890");
		intent.setAction(Intent.ACTION_DIAL);
		intent.setData(uri);
		startActivity(intent);
	}
}
