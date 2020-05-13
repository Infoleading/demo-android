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
		
		//String name = intent.getStringExtra("name"); //��Intent��Bundle��ȡֵ
		//String age = intent.getStringExtra("age");
		//Bundle bundle = (Bundle)intent.getBundleExtra("myBundle"); //��Intent��ȡ��Keyָ����Bundle
		//Person person = (Person)bundle.getSerializable("person"); //��Bundle��ȡDTO
		
		//Bundle bundle = (Bundle)intent.getExtras(); //��Intent��ȡĬ��Bundle
		//String name = bundle.getString("name"); //��Bundle��ȡֵ
		//String age = bundle.getString("age");
		//tvName.setText("�û�����"+name);
		//tvAge.setText("���䣺"+age);
		
		Person person = (Person)intent.getSerializableExtra("person"); //��Intent��Bundle��ȡDTO
		tvName.setText("�û�����"+person.getName());
		tvAge.setText("���䣺"+person.getAge());

	}
}
