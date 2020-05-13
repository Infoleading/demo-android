package edu.cque.jianxing.demoextra;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void onBtnClick(View view){
		EditText etName = (EditText)findViewById(R.id.et_name);
		EditText etAge = (EditText)findViewById(R.id.et_age);	
		Intent intent = new Intent(MainActivity.this, SecondActivity.class);
		
		//intent.putExtra("name", etName.getText().toString());//由Intent将值放入Bundle
		//intent.putExtra("age", etAge.getText().toString());
		
		Bundle bundle = new Bundle();
		bundle.putString("name", etName.getText().toString());
		bundle.putString("age", etAge.getText().toString());
		Person person = new Person(); //新建DTO
		person.setName(etName.getText().toString()); //向DTO填值
		person.setAge(etAge.getText().toString());
		bundle.putSerializable("person", person); //将DTO存入Bundle
		//intent.putExtra("myBundle",bundle); //将当前Bundle设为key标识的Bundle
		intent.putExtras(bundle); //将当前Bundle设为Intent默认Bundle
		//intent.putExtra("person", person); //由Intent将DTO对象放入Bundle中
		startActivity(intent);
	}
}
