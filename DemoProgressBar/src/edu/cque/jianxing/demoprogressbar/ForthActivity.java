package edu.cque.jianxing.demoprogressbar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ForthActivity extends Activity {
	
	private ProgressBar pbRed, pbGreen;
	private Button btRed, btGreen;
	private TextView tvRed, tvGreen, tvOver;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_forth);
		
		pbRed = (ProgressBar)findViewById(R.id.pbRed);
		pbGreen = (ProgressBar)findViewById(R.id.pbGreen);
		btRed = (Button)findViewById(R.id.btnRed);
		btGreen = (Button)findViewById(R.id.btnGreen);
		tvRed = (TextView)findViewById(R.id.tvRed);
		tvGreen = (TextView)findViewById(R.id.tvGreen);
		tvOver = (TextView)findViewById(R.id.over);
		
		OnBtnClickListener btnLsn = new OnBtnClickListener();
		btRed.setOnClickListener(btnLsn);
		btGreen.setOnClickListener(btnLsn);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		menu.findItem(R.id.activity_1).setIntent(new Intent(this, MainActivity.class));
		menu.findItem(R.id.activity_2).setIntent(new Intent(this, SecondActivity.class));
		menu.findItem(R.id.activity_3).setIntent(new Intent(this, ThirdActivity.class));
		menu.findItem(R.id.activity_4).setIntent(new Intent(this, ForthActivity.class));
		return true;
	}
	
	class OnBtnClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			Button btn = (Button)v;
			if(btn.getId()==R.id.btnRed){
				pbRed.incrementProgressBy(10);
				if(pbRed.getProgress()==100){
					tvRed.setBackgroundResource(R.drawable.boom);
					btRed.setEnabled(false);
					btGreen.setEnabled(false);
					tvOver.setText("Congratulation! Red Win!!!");
				}
			}
			if(btn.getId()==R.id.btnGreen){
				pbGreen.incrementProgressBy(10);
				if(pbGreen.getProgress()==100){
					tvGreen.setBackgroundResource(R.drawable.boom);
					btRed.setEnabled(false);
					btGreen.setEnabled(false);
					tvOver.setText("Congratulation! Green Win!!!");
				}
			}
		}
		
	}

}
