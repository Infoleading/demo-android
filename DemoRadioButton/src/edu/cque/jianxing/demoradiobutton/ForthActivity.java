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
import edu.cque.jianxing.demoradiobutton.MainActivity.RadioButtonListener;
import edu.cque.jianxing.demoradiobutton.MainActivity.RadioGroupListener;

public class ForthActivity extends Activity {

	private TextView out1, out2;
	private RadioGroup profession, gender, degree;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_forth);
		
		out1 = (TextView)findViewById(R.id.output1);
		out2 = (TextView)findViewById(R.id.output2);
		
		//1. ��ȡ�¼�Դ���
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
		
		//2. ����RadioGroup���������󣬲�ע�ᵽ�¼�Դ
		RadioGroupListener groupListener = new RadioGroupListener();
		gender.setOnCheckedChangeListener(groupListener);
		profession.setOnCheckedChangeListener(groupListener);
		degree.setOnCheckedChangeListener(groupListener);
		
		//3. ����RadioButton���������󣬲�ע�ᵽ�¼�Դ
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

	class RadioButtonListener implements CompoundButton.OnCheckedChangeListener{

		@Override
		public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			RadioButton rb = (RadioButton)buttonView;
			out1.append(rb.getText()+" �� "+(isChecked?"ѡ��":"ȡ��")+"\n\r");
		}
			
	}
	
	class RadioGroupListener implements RadioGroup.OnCheckedChangeListener{

		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {

			switch(group.getId()){
			case R.id.profession:
				RadioButton rb1 = (RadioButton)findViewById(checkedId);
				out2.append("רҵ ���а�ť "+rb1.getText()+" ��ѡ��\n\r");
				break;
			case R.id.gender:
				RadioButton rb2 = (RadioButton)findViewById(checkedId);
				out2.append("�Ա� ���а�ť "+rb2.getText()+" ��ѡ��\n\r");
				break;
			case R.id.degree:
				RadioButton rb3 = (RadioButton)findViewById(checkedId);
				out2.append("ѧλ ���а�ť "+rb3.getText()+" ��ѡ��\n\r");
				break;
			}
		}

	}	
	
}
