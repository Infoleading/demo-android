package edu.cque.jianxing.demogridview;

import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowActivity extends Activity {
	
	private TextView tvName, tvDeed, tvBirthday, tvNationality;
	private ImageView image;	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show);
		
		Intent intent = getIntent();
		Map map = (Map)intent.getSerializableExtra("sci");
		
		tvName = (TextView)findViewById(R.id.name);
		tvDeed = (TextView)findViewById(R.id.deed);
		tvBirthday = (TextView)findViewById(R.id.birthday);
		tvNationality = (TextView)findViewById(R.id.nationality);
		image = (ImageView)findViewById(R.id.figure);
		
		tvName.setText((String)map.get("name"));
		tvDeed.setText("事迹:"+map.get("deed"));
		tvBirthday.setText("出生日期:"+map.get("birthday"));
		tvNationality.setText("出生地:"+map.get("nation"));
		image.setImageResource((Integer)map.get("figure"));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show, menu);
		return true;
	}

}

