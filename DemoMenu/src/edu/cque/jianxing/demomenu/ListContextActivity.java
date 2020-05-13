package edu.cque.jianxing.demomenu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListContextActivity extends Activity {
	
	final int ITEM_ID1 = 0x1;
	final int ITEM_ID2 = 0x2;
	final int ITEM_ID3 = 0x3;
	
	private ListView listView;
	private ArrayAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_context);
		
		listView = (ListView)findViewById(R.id.listView);
		
		adapter = new ArrayAdapter(
				this,
				android.R.layout.simple_list_item_1,
				Raw.names);
		
		listView.setAdapter(adapter);
		registerForContextMenu(listView);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.simple_menu, menu);
		menu.findItem(R.id.sim_item1).setIntent(new Intent(this, OptionMenuActivity.class));
		menu.findItem(R.id.sim_item4).setIntent(new Intent(this, ContextMenuActivity.class));
		menu.findItem(R.id.sim_item5).setIntent(new Intent(this, ListContextActivity.class));
		return true;
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {

		menu.setHeaderTitle("请选择操作");
		menu.setHeaderIcon(R.drawable.ico_modify);
		menu.add(0, ITEM_ID1, 0, "打开");
		menu.add(0, ITEM_ID2, 0, "修改");
		menu.add(0, ITEM_ID3, 0, "删除");
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
		AdapterContextMenuInfo adapterMenuInfo = (AdapterContextMenuInfo)item.getMenuInfo();
		String name = (String)adapter.getItem(adapterMenuInfo.position);
		switch(item.getItemId()){
		case ITEM_ID1:
			Toast.makeText(this, "正在打开 科学家 "+name+" 的资料...", Toast.LENGTH_LONG).show();
			break;
		case ITEM_ID2:
			Toast.makeText(this, "准备修改 科学家 "+name+" 的资料...", Toast.LENGTH_LONG).show();
			break;
		case ITEM_ID3:
			Toast.makeText(this, "已删除 科学家 "+name+" 的资料...", Toast.LENGTH_LONG).show();
			break;
		}
		return super.onContextItemSelected(item);
	}
	
	
}
