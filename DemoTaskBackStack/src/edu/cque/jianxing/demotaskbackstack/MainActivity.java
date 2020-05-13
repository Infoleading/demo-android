package edu.cque.jianxing.demotaskbackstack;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		TextView tv = (TextView)findViewById(R.id.tv);
		tv.setText(this.toString());
	}
	
	public void onBtnClick(View view){
		Intent intent = new Intent(MainActivity.this, MainActivity.class);
		startActivity(intent);
	}

}
