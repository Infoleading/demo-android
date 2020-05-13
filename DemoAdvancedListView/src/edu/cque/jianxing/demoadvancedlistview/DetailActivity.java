package edu.cque.jianxing.demoadvancedlistview;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);
		
		Intent intent = getIntent();
		Map item = (HashMap)intent.getSerializableExtra("itemMap");
		
		TextView tvName = (TextView)findViewById(R.id.name);
		TextView tvDeed = (TextView)findViewById(R.id.deed);
		TextView tvBirthday = (TextView)findViewById(R.id.birthday);
		TextView tvNationality = (TextView)findViewById(R.id.nationality);
		ImageView image = (ImageView)findViewById(R.id.figure);
		
		tvName.setText((String)item.get("name"));
		tvDeed.setText("事迹:"+item.get("deed"));
		tvBirthday.setText("出生日期:"+item.get("birth"));
		tvNationality.setText("出生地:"+item.get("nation"));
		image.setImageResource((Integer)item.get("image"));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.detail, menu);
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
}
