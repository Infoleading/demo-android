package edu.cque.jianxing.demointentdatatype;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
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
		Uri uri = Uri.parse("book://baidu.com:1122/test");
		intent.setData(uri);
		startActivity(intent);		
	}
	
	public void onBtn2Click(View view){
		Intent intent = new Intent();
		Uri uri = Uri.parse("book://local.cn:5678/test");
		intent.setData(uri);
		startActivity(intent);	
	}
	
	public void onBtn3Click(View view){
		Intent intent = new Intent();
		Uri uri = Uri.parse("book://local.cn:9090/test");
		intent.setData(uri);
		startActivity(intent);	
	}
	
	public void onBtn4Click(View view){
		Intent intent = new Intent();
		Uri uri = Uri.parse("book://local.cn:9090/computer");
		intent.setData(uri);
		startActivity(intent);	
	}
	
	public void onBtn5Click(View view){
		Intent intent = new Intent();
		Uri uri = Uri.parse("book://local.cn:9090/computer");
		intent.setDataAndType(uri,"txt/html");
		startActivity(intent);	
	}


}
