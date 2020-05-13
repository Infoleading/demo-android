package edu.cque.jianxing.demogridviewsimpleadapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		GridView gridView = (GridView)findViewById(R.id.gridView);
		SimpleAdapter adapter = new SimpleAdapter(
				MainActivity.this, 
				initData(), 
				R.layout.item_grid, 
				new String[]{"icon","name"}, 
				new int[]{R.id.iv_icon,R.id.tv_name});
		gridView.setAdapter(adapter);
		gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				SimpleAdapter adapter = (SimpleAdapter)arg0.getAdapter();
				HashMap itemMap = (HashMap)adapter.getItem(arg2);
				Intent intent = new Intent(MainActivity.this, DetailActivity.class);
				Bundle bundle = new Bundle();
				intent.putExtra("itemMap", itemMap);
				startActivity(intent);
			}
			
		});
	}
	
	private List initData(){
		List data = new ArrayList();
		for(int i=0; i<Raw.names.length; i++){
			Map item = new HashMap();
			item.put("name", Raw.names[i]);
			item.put("birthday", Raw.birthday[i]);
			item.put("deed", Raw.deed[i]);
			item.put("nation", Raw.nationality[i]);
			item.put("icon", Raw.iconId[i]);
			item.put("figure", Raw.imageId[i]);
			data.add(item);
		}
		return data;
	}

}
