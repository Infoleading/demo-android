package edu.cque.jianxing.demomenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class ContextMenuActivity extends Activity {
	
	private EditText et1, et2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_context_menu);
		
		et1 = (EditText)findViewById(R.id.et1);
		et2 = (EditText)findViewById(R.id.et2);
		registerForContextMenu(et1);
		registerForContextMenu(et2);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		
		switch(v.getId()){
		case R.id.et1 :
			getMenuInflater().inflate(R.menu.courses_menu, menu);
			menu.setHeaderTitle("学科内容");
			menu.setHeaderIcon(R.drawable.ico_info);
			break;
		case R.id.et2 :
			getMenuInflater().inflate(R.menu.grade_menu, menu);
			menu.setHeaderTitle("教学年级");
			menu.setHeaderIcon(R.drawable.ico_info);
			break;
		}

		
		super.onCreateContextMenu(menu, v, menuInfo);
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

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		et2.setText(item.getTitle());
		return super.onContextItemSelected(item);
	}
	
	
}
