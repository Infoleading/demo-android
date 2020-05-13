package edu.cque.jianxing.demolistview;

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
		Bundle bundle = intent.getExtras();
		Scientist scientist = (Scientist)bundle.getSerializable("sci");
		
		tvName = (TextView)findViewById(R.id.name);
		tvDeed = (TextView)findViewById(R.id.deed);
		tvBirthday = (TextView)findViewById(R.id.birthday);
		tvNationality = (TextView)findViewById(R.id.nationality);
		image = (ImageView)findViewById(R.id.figure);
		
		tvName.setText(scientist.getName());
		tvDeed.setText("事迹:"+scientist.getDeed());
		tvBirthday.setText("出生日期:"+scientist.getBirthday());
		tvNationality.setText("出生地:"+scientist.getNationality());
		image.setImageResource(scientist.getImageId());
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show, menu);
		return true;
	}

}
