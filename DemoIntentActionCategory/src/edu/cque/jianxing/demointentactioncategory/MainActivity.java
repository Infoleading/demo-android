
package edu.cque.jianxing.demointentactioncategory;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	public final static String MY_ACTION = "edu.cque.jianxing.intent.action.MY_ACTION";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void onBtnHomeClick(View view) {
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_MAIN);
		intent.addCategory(Intent.CATEGORY_HOME);
		startActivity(intent);
	}

	public void onBtnViewClick(View view) {
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_VIEW);
		startActivity(intent);
	}

	public void onBtnOwnClick(View view) {
		Intent intent = new Intent();
		intent.setAction(MainActivity.MY_ACTION);
		startActivity(intent);
	}

}
