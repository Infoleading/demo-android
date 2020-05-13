package edu.cque.jianxing.demoradiobutton;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private TextView tv_output1, tv_output2, out3;
	private RadioGroup profession, gender, degree;

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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tv_output1 = (TextView)findViewById(R.id.output1);
		tv_output2 = (TextView)findViewById(R.id.output2);
		out3 = (TextView)findViewById(R.id.output3);
		
		//1. 获取事件源组件
		profession = (RadioGroup)findViewById(R.id.profession);
		RadioButton professionComputer = (RadioButton)findViewById(R.id.profession_computer);
		RadioButton professionMath = (RadioButton)findViewById(R.id.profession_math);
		RadioButton professionEnglish = (RadioButton)findViewById(R.id.profession_english);
		
		gender = (RadioGroup)findViewById(R.id.gender);
		RadioButton genderFemale = (RadioButton)findViewById(R.id.gender_female);
		RadioButton genderMale = (RadioButton)findViewById(R.id.gender_male);

		degree = (RadioGroup)findViewById(R.id.degree);
		RadioButton degreeBanchelor = (RadioButton)findViewById(R.id.degree_bachelor);
		RadioButton degreeMarster = (RadioButton)findViewById(R.id.degree_marster);
		RadioButton degreeDoctor = (RadioButton)findViewById(R.id.degree_doctor);
		
		//2. 生成RadioGroup监听器对象，并注册到事件源
		RadioGroupListener groupListener = new RadioGroupListener();
		gender.setOnCheckedChangeListener(groupListener);
		profession.setOnCheckedChangeListener(groupListener);
		degree.setOnCheckedChangeListener(groupListener);
		
		//3. 生成RadioButton监听器对象，并注册到事件源
		RadioButtonListener buttonListener = new RadioButtonListener();
		professionComputer.setOnCheckedChangeListener(buttonListener);
		professionMath.setOnCheckedChangeListener(buttonListener);
		professionEnglish.setOnCheckedChangeListener(buttonListener);		
		genderFemale.setOnCheckedChangeListener(buttonListener);
		genderMale.setOnCheckedChangeListener(buttonListener);
		degreeBanchelor.setOnCheckedChangeListener(buttonListener);
		degreeMarster.setOnCheckedChangeListener(buttonListener);
		degreeDoctor.setOnCheckedChangeListener(buttonListener);
		
	}
	
	class RadioButtonListener implements CompoundButton.OnCheckedChangeListener{

		@Override
		public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			RadioButton rb = (RadioButton)buttonView;
			tv_output1.append(rb.getText()+" 被 "+(isChecked?"选中":"取消")+"\n\r");
		}
			
	}
	
	class RadioGroupListener implements RadioGroup.OnCheckedChangeListener{

		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {

			switch(group.getId()){
			case R.id.profession:
				RadioButton rb1 = (RadioButton)findViewById(checkedId);
				tv_output2.append("专业 组中按钮 "+rb1.getText()+" 被选中\n\r");
				break;
			case R.id.gender:
				RadioButton rb2 = (RadioButton)findViewById(checkedId);
				tv_output2.append("性别 组中按钮 "+rb2.getText()+" 被选中\n\r");
				break;
			case R.id.degree:
				RadioButton rb3 = (RadioButton)findViewById(checkedId);
				tv_output2.append("学位 组中按钮 "+rb3.getText()+" 被选中\n\r");
				break;
			}
			
			getResult();
		}

	}
	
	public void getResult(){
		String str="";
		if(profession.getCheckedRadioButtonId()!=-1){
			RadioButton rb1 = (RadioButton)findViewById(profession.getCheckedRadioButtonId());
			str+=rb1.getText();
		}
		if(gender.getCheckedRadioButtonId()!=-1){
			RadioButton rb1 = (RadioButton)findViewById(gender.getCheckedRadioButtonId());
			str+=rb1.getText();
		}
		if(degree.getCheckedRadioButtonId()!=-1){
			RadioButton rb1 = (RadioButton)findViewById(degree.getCheckedRadioButtonId());
			str+=rb1.getText();
		}
		out3.setText(str);
	}
}
