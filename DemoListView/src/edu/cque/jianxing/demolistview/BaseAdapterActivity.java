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

public class BaseAdapterActivity extends Activity {
	
	private List data = new ArrayList();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_base_adapter);
		
		initDate();
		MyBaseAdapter myBaseAdapter = new MyBaseAdapter(this, R.layout.my_list_item_4, data);
		
		ListView listView = (ListView)findViewById(R.id.listView);
		listView.setAdapter(myBaseAdapter);
		listView.setOnItemClickListener(new OnMyItemClickListener());
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
		menu.findItem(R.id.activity7).setIntent(new Intent(this, BaseAdapterActivity.class));		
		return true;
	}
	
	class OnMyItemClickListener implements OnItemClickListener{

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			MyBaseAdapter adapter = (MyBaseAdapter)parent.getAdapter();
			HashMap map = (HashMap)adapter.getItem(position);
			Intent intent = new Intent(BaseAdapterActivity.this, ShowActivity3.class);
			Bundle bundle = new Bundle();
			bundle.putSerializable("sci", map);
			intent.putExtras(bundle);
			startActivity(intent);
		}
		
	}
	
	public void initDate(){
		for(int i=0; i<Raw.names.length; i++){
			Map item = new HashMap();
			item.put("name", Raw.names[i]);
			item.put("icon", Raw.iconId[i]);
			item.put("nationality", Raw.nationality[i]);
			item.put("birthday", Raw.birthday[i]);
			item.put("deed", Raw.deed[i]);
			item.put("imageId", Raw.imageId[i]);
			item.put("favour", new Integer(5));
			data.add(item);
		}
	}	
	
	

}
