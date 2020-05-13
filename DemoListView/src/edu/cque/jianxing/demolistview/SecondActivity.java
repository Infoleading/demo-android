package edu.cque.jianxing.demolistview;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SecondActivity extends Activity {
	
	private ArrayList data = new ArrayList();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		initDate();
		MyArrayAdapter sciAdapter = new MyArrayAdapter(this, R.layout.my_list_item_2, data);
		
		ListView listView = (ListView)findViewById(R.id.sciImageList);
		listView.setAdapter(sciAdapter);
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
			MyArrayAdapter adapter = (MyArrayAdapter)parent.getAdapter();
			Scientist scientist = adapter.getItem(position);
			Intent intent = new Intent(SecondActivity.this, ShowActivity.class);
			Bundle bundle = new Bundle();
			bundle.putSerializable("sci", scientist);
			intent.putExtras(bundle);
			startActivity(intent);
		}
		
	}
	
	public void initDate(){
		for(int i=0; i<Raw.names.length; i++){
			Scientist scientist = new Scientist();
			scientist.setName(Raw.names[i]);
			scientist.setImageId(Raw.imageId[i]);
			scientist.setIconId(Raw.iconId[i]);
			scientist.setBirthday(Raw.birthday[i]);
			scientist.setDeed(Raw.deed[i]);
			scientist.setNationality(Raw.nationality[i]);
			data.add(scientist);
		}
	}

}
