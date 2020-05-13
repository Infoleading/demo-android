package edu.cque.jianxing.demotoast;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {

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
			String user = etUser.getText().toString();
			String pass = etPass.getText().toString();
			if(user.equals(userName) && pass.equals(password)){
				Toast toast = Toast.makeText(LoginActivity.this, "验证成功，正在登录...", Toast.LENGTH_LONG);
				toast.show();
			}else{
				if(!user.equals(userName))
					Toast.makeText(LoginActivity.this, "无效的用户名，请重新输入。", Toast.LENGTH_SHORT).show();
				else
					Toast.makeText(LoginActivity.this, "密码错误，请重新输入。", Toast.LENGTH_SHORT).show();
					
			}
		}
		
	}
}
