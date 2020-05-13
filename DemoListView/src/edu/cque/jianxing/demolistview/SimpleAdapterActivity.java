package edu.cque.jianxing.demolistview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class SimpleAdapterActivity extends Activity {
	
	private List data = new ArrayList();
	private ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_simple_adapter);
		
		init();
		
		SimpleAdapter simpleAdapter = new SimpleAdapter(this, 
				data, 
				R.layout.my_list_item_3,
				new String[] {"name","icon","nationality"},
				new int[] {R.id.name, R.id.icon, R.id.nationality});
		
		listView = (ListView)findViewById(R.id.listView_Simple);
		listView.setAdapter(simpleAdapter);
		listView.setOnItemClickListener(new OnMyItemClickListener());		
	}
	
	class OnMyItemClickListener implements OnItemClickListener{

		@Override
		public void onItemClick(AdapterView<?> listView, View arg1, int position, long arg3) {
			
			SimpleAdapter adapter = (SimpleAdapter) listView.getAdapter();
			HashMap map = (HashMap)adapter.getItem(position);
			
			Intent intent = new Intent(SimpleAdapterActivity.this, ShowActivity2.class);
			Bundle bundle = new Bundle();
			bundle.putSerializable("sci", map);
			intent.putExtras(bundle);
			
			startActivity(intent);
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.first, menu);
		menu.findItem(R.id.activity1).setIntent(new Intent(this, FirstActivity.class));
		menu.findItem(R.id.activity2).setIntent(new Intent(this, SecondActivity.class));
		menu.findItem(R.id.activity3).setIntent(new Intent(this, ThirdActivity.class));
		menu.findItem(R.id.activity4).setIntent(new Intent(this, ForthActivity.class));
		menu.findItem(R.id.activity5).setIntent(new Intent(this, FifthActivity.class));
		menu.findItem(R.id.activity6).setIntent(new Intent(this, SimpleAdapterActivity.class));		
		return true;
	}
	
	public void init(){
		for(int i=0; i<Raw.names.length; i++){
			Map item = new HashMap();
			item.put("name", Raw.names[i]);
			item.put("icon", Raw.iconId[i]);
			item.put("nationality", Raw.nationality[i]);
			item.put("birthday", Raw.birthday[i]);
			item.put("deed", Raw.deed[i]);
			item.put("imageId", Raw.imageId[i]);
			data.add(item);
		}
	}		

}
