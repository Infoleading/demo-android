package edu.cque.jianxing.demomenu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.simple_menu, menu);
		menu.findItem(R.id.sim_item1).setIntent(new Intent(MainActivity.this, OptionMenuActivity.class));
		menu.findItem(R.id.sim_item4).setIntent(new Intent(MainActivity.this, ContextMenuActivity.class));
		menu.findItem(R.id.sim_item5).setIntent(new Intent(MainActivity.this, ListContextActivity.class));
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		Toast toast = Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT);
		switch(id){
		case R.id.sim_item1:
			toast.setText("菜单项1点击");
			toast.show();
			break;
		case R.id.sim_item2:
			toast.setText("菜单项2点击");
			toast.show();
			break;
		case R.id.sim_item3:
			toast.setText("菜单项3点击");
			toast.show();
			break;
		case R.id.sim_item4:
			toast.setText("菜单项4点击");
			toast.show();	
			break;
		case R.id.sim_item5:
			toast.setText("菜单项5点击");
			toast.show();	
			break;
		case R.id.sim_item6:
			toast.setText("菜单项6点击");
			toast.show();
			break;
		case R.id.sim_item7:
			toast.setText("菜单项7点击");
			toast.show();	
			break;
			
		}
		return super.onOptionsItemSelected(item);
	}
}
