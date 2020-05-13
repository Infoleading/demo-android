package edu.cque.jianxing.democheckbox;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView tv_like, tv_log;
	private CheckBox cb_ty,cb_yy,cb_ms,cb_all;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tv_like = (TextView)findViewById(R.id.text);
		tv_log = (TextView)findViewById(R.id.status);
		
		cb_ty = (CheckBox)findViewById(R.id.cb_tiyu);
		cb_yy = (CheckBox)findViewById(R.id.cb_yinyue);
		cb_ms = (CheckBox)findViewById(R.id.cb_meishu);
		cb_all = (CheckBox)findViewById(R.id.cb_all);
		
		OnMyClickListener myClickListener = new OnMyClickListener();
		OnMyCheckedChangeListener myChangeListener = new OnMyCheckedChangeListener();
		
		cb_ty.setOnClickListener(myClickListener);
		cb_yy.setOnClickListener(myClickListener);
		cb_ms.setOnClickListener(myClickListener);
		cb_all.setOnClickListener(myClickListener);
		
		cb_ty.setOnCheckedChangeListener(myChangeListener);
		cb_yy.setOnCheckedChangeListener(myChangeListener);
		cb_ms.setOnCheckedChangeListener(myChangeListener);
		cb_all.setOnCheckedChangeListener(myChangeListener);
		
	}
	
	class OnMyClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			String likeStr = "爱好：";
			if(cb_ty.isChecked())
				likeStr+="体育 ";
			if(cb_yy.isChecked())
				likeStr+="音乐 ";
			if(cb_ms.isChecked())
				likeStr+="美术 ";
			tv_like.setText(likeStr);
		}
	}
	
	class OnMyCheckedChangeListener implements OnCheckedChangeListener{

		@Override
		public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			// TODO Auto-generated method stub
			switch(buttonView.getId()){
			case R.id.cb_tiyu:
				tv_log.setText(buttonView.getText()+" 被 "+(isChecked?"选中":"取消"));
				break;
			case R.id.cb_yinyue:
				tv_log.setText(buttonView.getText()+" 被 "+(isChecked?"选中":"取消"));
				break;
			case R.id.cb_meishu:
				tv_log.setText(buttonView.getText()+" 被 "+(isChecked?"选中":"取消"));
				break;
			case R.id.cb_all:
				cb_ty.setChecked(isChecked);
				cb_yy.setChecked(isChecked);
				cb_ms.setChecked(isChecked);
			}
		}
		
	}


}
