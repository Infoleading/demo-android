package edu.cque.jianxing.demogridviewsimpleadapter;

import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import edu.cque.jianxing.demogridviewsimpleadapter.R;

public class DetailActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);
		
		Intent intent = getIntent();
		Map map = (Map)intent.getSerializableExtra("itemMap");
		
		TextView tvName = (TextView)findViewById(R.id.name);
		TextView tvDeed = (TextView)findViewById(R.id.deed);
		TextView tvBirthday = (TextView)findViewById(R.id.birthday);
		TextView tvNationality = (TextView)findViewById(R.id.nationality);
		ImageView image = (ImageView)findViewById(R.id.figure);
		
		tvName.setText((String)map.get("name"));
		tvNationality.setText("出生地:"+map.get("nationality"));		
		tvBirthday.setText("出生日期:"+map.get("birthday"));
		tvDeed.setText("事迹:"+map.get("deed"));
		image.setImageResource((Integer)map.get("figure"));
		
		
	}
	
	
}
