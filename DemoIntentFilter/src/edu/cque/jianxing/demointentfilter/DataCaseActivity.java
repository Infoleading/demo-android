package edu.cque.jianxing.demointentfilter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class DataCaseActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_data_case);
	}

	public void onBtn21Click(){
		Intent intent = new Intent();
		Uri uri = Uri.parse("paper");
		intent.setData(uri);
	}
	
	public void onBtn22Click(){
		Intent intent = new Intent();
		Uri uri = Uri.parse("paper:local");
		intent.setData(uri);
	}
	
	public void onBtn23Click(){
		Intent intent = new Intent();
		Uri uri = Uri.parse("paper:local:8090");
		intent.setData(uri);
	}
	
	public void onBtn24Click(){
		Intent intent = new Intent();
		Uri uri = Uri.parse("paper:local:8090/test");
		intent.setData(uri);
	}
	
	public void onBtn25Click(){
		Intent intent = new Intent();
		Uri uri = Uri.parse("paper:local:8090/test");
		intent.setDataAndType(uri,"txt/html");
	}
}
