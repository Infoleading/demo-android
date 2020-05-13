package edu.cque.jianxing.demoadvancedlistview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private List data = new ArrayList();
	private CheckBox checkbox;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initData();
		
		ListView lv = (ListView)findViewById(R.id.lv_list);
		lv.setAdapter(new BaseAdapter(){

			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return data.size();
			}

			@Override
			public Object getItem(int position) {
				// TODO Auto-generated method stub
				return data.get(position);
			}

			@Override
			public long getItemId(int arg0) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				// TODO Auto-generated method stub
				HashMap item = (HashMap)getItem(position);
				
				if(convertView == null)
					convertView = LayoutInflater.from(MainActivity.this).inflate(R.layout.my_list_item1, null);
				
				ImageView icon = (ImageView)convertView.findViewById(R.id.icon);
				TextView name = (TextView)convertView.findViewById(R.id.name);
				checkbox = (CheckBox)convertView.findViewById(R.id.checked);
				Button	button = (Button)convertView.findViewById(R.id.btn);
				
				icon.setImageResource((Integer)item.get("icon"));
				name.setText(item.get("name").toString());
				
				button.setTag(R.id.tag_itemData,item);
				button.setTag(R.id.tag_checkbox,checkbox);
				button.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						CheckBox checkbox = (CheckBox)v.getTag(R.id.tag_checkbox);
						checkbox.setChecked(true);
						v.setEnabled(false);
						
						Intent intent = new Intent(MainActivity.this, DetailActivity.class);
						intent.putExtra("itemMap", (HashMap)v.getTag(R.id.tag_itemData));
						startActivity(intent);
					}
				});
				
				checkbox.setTag(R.id.tag_button,button);
				checkbox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
					
					@Override
					public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
						// TODO Auto-generated method stub
						Button button = (Button)buttonView.getTag(R.id.tag_button);
						button.setEnabled(!button.isEnabled());
					}
				});
				
				return convertView;
			}
			
		});
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
	
	private List initData(){
		
		for(int i=1; i<Raw.names.length; i++){
			Map map  = new HashMap();
			map.put("icon", Raw.iconId[i]);
			map.put("name", Raw.names[i]);
			map.put("image", Raw.imageId[i]);
			map.put("birth", Raw.birthday[i]);
			map.put("nation", Raw.nationality[i]);
			map.put("deed", Raw.deed[i]);
			
			data.add(map);
		}
		
		return data;
	}
}
