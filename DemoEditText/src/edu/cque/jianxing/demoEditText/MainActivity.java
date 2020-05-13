package edu.cque.jianxing.demoEditText;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		EditText editCount = (EditText)findViewById(R.id.count);
		editCount.setOnFocusChangeListener(new OnFocusChangeListener() {
			
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				// TODO Auto-generated method stub
				EditText edit = (EditText)v;
				if(hasFocus==false)
					if(edit.getText().toString().length()==0)
						edit.setText("用户名不可为空");						
			}
		});
		
		EditText editAge = (EditText)findViewById(R.id.age);
		editAge.setOnFocusChangeListener(new OnFocusChangeListener() {
			
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				// TODO Auto-generated method stub
				EditText edit = (EditText)v;
				if(hasFocus==false){
					String strAge = edit.getText().toString();
					if(strAge.length()>0){
						int age = Integer.parseInt(strAge);
						if(age>100)
							edit.setText("0");
					}
				}
				
			}
		});
		
		EditText editPhone = (EditText)findViewById(R.id.phoneNum);
		editPhone.setOnFocusChangeListener(new OnFocusChangeListener() {
			
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				// TODO Auto-generated method stub
				EditText edit = (EditText)v;
				if(hasFocus==false){
					int num = edit.getText().toString().length();
					if(num!=11)
						edit.setText("非法电话号码");
				}
			}
		});
		
		EditText date = (EditText)findViewById(R.id.date);
		date.setOnFocusChangeListener(new OnFocusChangeListener() {
			
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				// TODO Auto-generated method stub
				EditText edit = (EditText)v;
				
			}
		});

		
	}
}
