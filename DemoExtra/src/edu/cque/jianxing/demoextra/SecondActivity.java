package edu.cque.jianxing.demoextra;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		TextView tvName = (TextView)findViewById(R.id.tv_name);
		TextView tvAge = (TextView)findViewById(R.id.tv_age);
		Intent intent = getIntent();
		
		//String name = intent.getStringExtra("name"); //由Intent从Bundle中取值
		//String age = intent.getStringExtra("age");
		//Bundle bundle = (Bundle)intent.getBundleExtra("myBundle"); //从Intent中取由Key指定的Bundle
		//Person person = (Person)bundle.getSerializable("person"); //从Bundle中取DTO
		
		//Bundle bundle = (Bundle)intent.getExtras(); //从Intent中取默认Bundle
		//String name = bundle.getString("name"); //从Bundle中取值
		//String age = bundle.getString("age");
		//tvName.setText("用户名："+name);
		//tvAge.setText("年龄："+age);
		
		Person person = (Person)intent.getSerializableExtra("person"); //由Intent从Bundle中取DTO
		tvName.setText("用户名："+person.getName());
		tvAge.setText("年龄："+person.getAge());

	}
}
