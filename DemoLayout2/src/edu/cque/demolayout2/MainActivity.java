package edu.cque.demolayout2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class MainActivity extends Activity {
	
	private CheckBox cb1,cb2,cb3,cb4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.linear_layout);
		cb1 = (CheckBox)this.findViewById(R.id.checkbox1);
		cb2 = (CheckBox)this.findViewById(R.id.checkbox2);
		cb3 = (CheckBox)this.findViewById(R.id.checkbox3);
		cb4 = (CheckBox)this.findViewById(R.id.checkbox4);
		
		/*OnCheckBoxListener listener = new OnCheckBoxListener();
		
		cb1.setOnClickListener(listener);
		cb2.setOnClickListener(listener);
		cb3.setOnClickListener(listener);
		*/
		/*
		OnBoxChangeListener bcListener = new OnBoxChangeListener();
		cb1.setOnCheckedChangeListener(bcListener);
		cb2.setOnCheckedChangeListener(bcListener);
		cb3.setOnCheckedChangeListener(bcListener);*/
		
		
		OnBoxChangeListener ccl = new OnBoxChangeListener();
		cb4.setOnCheckedChangeListener(ccl);
		
		
	}
	
	//
	class OnBoxChangeListener implements OnCheckedChangeListener{

		@Override
		public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			cb1.setChecked(isChecked);
			cb2.setChecked(isChecked);
			cb3.setChecked(isChecked);			
				
			
		}
		
	}
	
	
	//OncheckedChangerListener
	/*
	class OnBoxChangeListener implements OnCheckedChangeListener{

		@Override
		public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			if(buttonView.getId() == R.id.checkbox1)
				System.out.print("Sleep Box");
			else if(buttonView.getId() == R.id.checkbox2)
				System.out.print("Eat Box");
			else
				System.out.print("Play Box");
			
			if(isChecked)
				System.out.println(" is checked");
			else
				System.out.println(" is unChecked");
			
		}
		
	}*/
	
	//OnClickListener 演示单选功能
	/*
	class OnCheckBoxListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			CheckBox cb = (CheckBox)v;
			System.out.println("view id ======>"+v.getId());
			if(v.getId()==R.id.checkbox1)
				System.out.print("sleep box");
			
			else if(v.getId()==R.id.checkbox2)
				System.out.print("Eat box");
				
			else 
				System.out.print("play box");
			
			if(cb.isChecked())
				System.out.println("Checked");
			else
				System.out.println("unChecked");
		}
		
		
	}*/

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
