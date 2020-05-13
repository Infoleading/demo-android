package edu.cque.jianxing.demogridview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class GridViewActivity extends Activity {
	
	private List data;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grid_view);

		GridView gridView = (GridView)findViewById(R.id.gridView);
		
		/*/方法一：使用 SimpleAdapter
		gridView.setAdapter(new SimpleAdapter(
				this, 
				initData(), 
				R.layout.grid_item_layout, 
				new String[]{"icon", "name"}, 
				new int[]{R.id.icon, R.id.name})); //*/
		
		//方法二：使用自定义Adapter
		initData();
		gridView.setAdapter(new BaseAdapter() {
			
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				// TODO Auto-generated method stub
				if(convertView == null)
					convertView = LayoutInflater.from(GridViewActivity.this).inflate(R.layout.grid_item_layout, null);
				ImageView iv = (ImageView)convertView.findViewById(R.id.icon);
				Map item = (Map)getItem(position);
				iv.setImageResource((Integer)item.get("icon"));
				TextView tv = (TextView)convertView.findViewById(R.id.name);
				tv.setText((String)item.get("name"));
				return convertView; 
			}
			
			@Override
			public long getItemId(int position) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public Object getItem(int position) {
				// TODO Auto-generated method stub
				return data.get(position);
			}
			
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return data.size();
			}

		});//*/
		
		gridView.setOnItemClickListener(new OnItemClickListener() {
			
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				// TODO Auto-generated method stub
				Adapter adapter = arg0.getAdapter();
				HashMap map = (HashMap)adapter.getItem(arg2);
				
				Intent intent = new Intent(GridViewActivity.this, ShowActivity.class);
				intent.putExtra("sci", map);
				
				startActivity(intent);
			}
		});

	}

	private List initData(){
		
		 this.data = new ArrayList();
				 
		 for(int i=0; i<Raw.NAMES.length; i++){
			 
			Map item = new HashMap();
			item.put("name", Raw.NAMES[i]);
			item.put("birthday", Raw.BIRTHDAY[i]);
			item.put("deed", Raw.DEED[i]);
			item.put("nation", Raw.NATIONALITY[i]);
			item.put("icon", Raw.ICONID[i]);
			item.put("figure", Raw.IMAGEID[i]);
			
			data.add(item);
		}
		return data;
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.grid_view, menu);
		menu.findItem(R.id.a1).setIntent(new Intent(this, GridViewActivity.class));
		menu.findItem(R.id.a2).setIntent(new Intent(this, StretchModeActivity.class));
		return true;
	}	

}
