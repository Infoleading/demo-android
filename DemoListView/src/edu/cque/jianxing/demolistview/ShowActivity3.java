package edu.cque.jianxing.demolistview;

import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ShowActivity3 extends Activity {
	
	private TextView tvName, tvDeed, tvBirthday, tvNationality;
	private ImageView image;		
	private RatingBar favour;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show3);
		
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		Map map = (Map)bundle.getSerializable("sci");
		
		tvName = (TextView)findViewById(R.id.name);
		tvDeed = (TextView)findViewById(R.id.deed);
		tvBirthday = (TextView)findViewById(R.id.birthday);
		tvNationality = (TextView)findViewById(R.id.nationality);
		image = (ImageView)findViewById(R.id.figure);
		favour = (RatingBar)findViewById(R.id.favour);
		
		tvName.setText((String)map.get("name"));
		tvDeed.setText("事迹:"+map.get("deed"));
		tvBirthday.setText("出生日期:"+map.get("birthday"));
		tvNationality.setText("出生地:"+map.get("nationality"));
		image.setImageResource((Integer)map.get("imageId"));	
		int i = (Integer)map.get("favour");
		favour.setProgress(i);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show_activity3, menu);
		return true;
	}
}
