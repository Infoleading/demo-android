package edu.cque.jianxing.demoactionmode;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private ListView listView;
	private int position; //记录列表项位置

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listView = (ListView)findViewById(R.id.listView);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				this,
				android.R.layout.simple_list_item_1,
				Raw.names);
		listView.setAdapter(adapter);
		listView.setOnItemLongClickListener(new OnListItemLongClick());
	}

	private ActionMode.Callback callBack = new ActionMode.Callback() {
		
		@Override
		public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
			Log.i("MainActivity", "onPrepareActionMode");
			return false;
		}
		
		@Override
		public void onDestroyActionMode(ActionMode mode) {
			Log.i("MainActivity", "onDestroyActionMode");
		}
		
		@Override
		public boolean onCreateActionMode(ActionMode mode, Menu menu) {
			Log.i("MainActivity", "onCreateActionMode");
			mode.getMenuInflater().inflate(R.menu.action_mode, menu);
			return true;
		}
		
		@Override
		public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
			Log.i("MainActivity", "onActionItemClicked");
			ArrayAdapter adapter = (ArrayAdapter)listView.getAdapter();
			String name = (String)adapter.getItem(position);
			switch(item.getItemId()){
			case R.id.item_1:
				Toast.makeText(MainActivity.this, "正在打开"+name, Toast.LENGTH_SHORT).show();
				break;
			case R.id.item_2:
				Toast.makeText(MainActivity.this, "准备修改"+name, Toast.LENGTH_SHORT).show();
				break;
			case R.id.item_3:
				Toast.makeText(MainActivity.this, "正在删除"+name, Toast.LENGTH_SHORT).show();
				break;
			}
			return false;
		}
	};
	
	class OnListItemLongClick implements OnItemLongClickListener{

		@Override
		public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
			position = arg2;
			startActionMode(callBack);
			return false;
		}
		
	}
}
