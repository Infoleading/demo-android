package edu.cque.jianxing.demoratingbar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;

public class SecondActivity extends Activity {
	
	private RatingBar rb1, rb2;
	private TextView tv1, tv2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		rb1 = (RatingBar)findViewById(R.id.rb1);
		rb2 = (RatingBar)findViewById(R.id.rb2);
		tv1 = (TextView)findViewById(R.id.tv1);
		tv2 = (TextView)findViewById(R.id.tv2);
		
		rb1.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
			
			@Override
			public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
				tv2.setText("当前等级："+rating);		
				tv1.setAlpha(rating/5);
				rb2.setRating(rating);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		menu.findItem(R.id.activity_main).setIntent(new Intent(this,MainActivity.class));
		menu.findItem(R.id.activity_second).setIntent(new Intent(this,SecondActivity.class));
		return true;
	}
}
