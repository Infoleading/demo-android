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
		
		//intent.putExtra("name", etName.getText().toString());//��Intent��ֵ����Bundle
		//intent.putExtra("age", etAge.getText().toString());
		
		Bundle bundle = new Bundle();
		bundle.putString("name", etName.getText().toString());
		bundle.putString("age", etAge.getText().toString());
		Person person = new Person(); //�½�DTO
		person.setName(etName.getText().toString()); //��DTO��ֵ
		person.setAge(etAge.getText().toString());
		bundle.putSerializable("person", person); //��DTO����Bundle
		//intent.putExtra("myBundle",bundle); //����ǰBundle��Ϊkey��ʶ��Bundle
		intent.putExtras(bundle); //����ǰBundle��ΪIntentĬ��Bundle
		//intent.putExtra("person", person); //��Intent��DTO�������Bundle��
		startActivity(intent);
	}
}
