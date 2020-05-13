package edu.cque.jianxing.demotoast;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ToastActivity extends Activity {
	
	private EditText etUser, etPass;
	private Button btLogin;
	private String userName = "jianxing";
	private String password = "12345678";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		etUser = (EditText)findViewById(R.id.etUser);
		etPass = (EditText)findViewById(R.id.etPass);
		btLogin = (Button)findViewById(R.id.btLogin);
		
		btLogin.setOnClickListener(new OnMyClickListener());

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu, menu);
		menu.findItem(R.id.a1).setIntent(new Intent(this, LoginActivity.class));
		menu.findItem(R.id.a2).setIntent(new Intent(this, ToastActivity.class));		
		return true;
	}
	
	class OnMyClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			
			Toast toast = new Toast(ToastActivity.this);	
			
			LayoutInflater inflater = getLayoutInflater();
			View view = inflater.inflate(R.layout.toast_layout, null);
			ImageView feeling = (ImageView)view.findViewById(R.id.felling);
			TextView words = (TextView)view.findViewById(R.id.words);
			
			toast.setView(view);
			
			String user = etUser.getText().toString();
			String pass = etPass.getText().toString();
			if(user.equals(userName) && pass.equals(password)){
				feeling.setImageResource(R.drawable.felling_smill);
				words.setText("验证成功，正在登录...");
				toast.setDuration(Toast.LENGTH_LONG);
				toast.show();
			}else{
				if(!user.equals(userName)){
					feeling.setImageResource(R.drawable.felling_question);
					words.setText("无效的用户名，请重新输入");
					toast.setDuration(Toast.LENGTH_SHORT);
					toast.show();
				}
				else{
					feeling.setImageResource(R.drawable.felling_shock);
					words.setText("密码错误，请重新输入");
					toast.setDuration(Toast.LENGTH_SHORT);
					toast.show();
				}
					
			}
		}
		
	}	

}
