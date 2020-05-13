package edu.cque.jianxing.demoradiobutton;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import edu.cque.jianxing.demoradiobutton.MainActivity.RadioButtonListener;

public class ThirdActivity extends Activity {
	
	private RadioGroup profession;
	private EditText logBoard;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_third);
		
		logBoard = (EditText)findViewById(R.id.logBorad);
		
		//1. 获取事件源组件
		profession = (RadioGroup)findViewById(R.id.profession);
		RadioButton professionComputer = (RadioButton)findViewById(R.id.profession_computer);
		RadioButton professionMath = (RadioButton)findViewById(R.id.profession_math);
		RadioButton professionEnglish = (RadioButton)findViewById(R.id.profession_english);	
		
		//3. 生成RadioButton监听器对象，并注册到事件源
		RadioButtonListener buttonListener = new RadioButtonListener();
		professionComputer.setOnCheckedChangeListener(buttonListener);
		professionMath.setOnCheckedChangeListener(buttonListener);
		professionEnglish.setOnCheckedChangeListener(buttonListener);	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.main, menu);
		menu.findItem(R.id.item_demo1).setIntent(new Intent(this, MainActivity.class));
		menu.findItem(R.id.item_demo2).setIntent(new Intent(this, SecondActivity.class));
		menu.findItem(R.id.item_demo3).setIntent(new Intent(this, ThirdActivity.class));
		menu.findItem(R.id.item_demo4).setIntent(new Intent(this, ForthActivity.class));
		return super.onCreateOptionsMenu(menu);
	}

	//2. 
	class RadioButtonListener implements CompoundButton.OnCheckedChangeListener{

		@Override
		public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			RadioButton rb = (RadioButton)buttonView;
			logBoard.append(rb.getText()+" 被 "+(isChecked?"选中":"取消")+"\n\r");
		}
			
	}
}
