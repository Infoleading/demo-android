package edu.cque.jianxing.demothread;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity {

	private Button button;
	private TextView textView;
	private ProgressBar progressBar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		button = (Button)findViewById(R.id.button1);
		textView = (TextView)findViewById(R.id.textView1);
		progressBar = (ProgressBar)findViewById(R.id.progressBar1);
		ButtonListener bl = new ButtonListener();
		button.setOnClickListener(bl);
		
		
	}
	
	class ButtonListener implements OnClickListener{
		@Override
		public void onClick(View v) {
			Thread t = new MyThread();
			t.start();
			
		}
	}
	
	//worker thread
	class MyThread extends Thread{
		@Override
		public void run() {
			for(int i=0; i<=100; i++){
				try{
					Thread.sleep(1*1000);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				progressBar.setProgress(progressBar.getProgress()+1);
			}
			
		}
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
}
