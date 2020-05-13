package edu.cque.demodialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button button1,button2,button3,button4,button5,button6;
	private AlertDialog.Builder builder;
	private ProgressDialog pd;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		button1 = (Button)findViewById(R.id.button1);
		button2 = (Button)findViewById(R.id.button2);
		button3 = (Button)findViewById(R.id.button3);
		button4 = (Button)findViewById(R.id.button4);
		button5 = (Button)findViewById(R.id.button5);
		button6 = (Button)findViewById(R.id.button6);
		ButtonListener bl = new ButtonListener();
		button1.setOnClickListener(bl);
		button2.setOnClickListener(bl);
		button3.setOnClickListener(bl);
		button4.setOnClickListener(bl);
		button5.setOnClickListener(bl);
		button6.setOnClickListener(bl);
		builder = new AlertDialog.Builder(this);
		
	}
	
	class ButtonListener implements OnClickListener{
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId()){
			case R.id.button1:
				builder.setIcon(R.drawable.ico_info)
				.setTitle("消息")
				.setMessage("铵钮1按下")
				.setPositiveButton("确定", null)
				.show();
				break;
			case R.id.button2:
				builder.setIcon(R.drawable.ico_warning)
				.setTitle("消息")
				.setMessage("铵钮2按下")
				.setPositiveButton("确定", null)
				.setNegativeButton("取消", null)
				.show();
				break;
			case R.id.button3:
				builder.setIcon(R.drawable.ico_modify)
				.setTitle("消息")
				.setMessage("铵钮3按下")
				.setPositiveButton("确定", null)
				.setNegativeButton("取消", null)
				.show();
				break;		
			case R.id.button4:
				builder.setIcon(R.drawable.ico_question)
				.setTitle("消息")
				.setMessage("铵钮4按下")
				.setPositiveButton("确定", null)
				.setNegativeButton("取消", null)
				.show();
				break;		
			case R.id.button5:
				builder.setIcon(R.drawable.ico_wrong)
				.setTitle("消息")
				.setMessage("铵钮5按下")
				.setPositiveButton("确定", null)
				.setNegativeButton("取消", null)
				.show();
				break;		
			case R.id.button6:
				pd = ProgressDialog.show(MainActivity.this, "标题", "正在读取... 请稍后", true);
				break;				
			}
			
		}
	}
	
	


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
