package edu.cque.jianxing.demoactionbar;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class TabNaviActivity extends Activity {
	
	private ActionBar actionBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tab_navi);
		
		actionBar = getActionBar();
		actionBar.setIcon(R.drawable.cooker);
		actionBar.setTitle("水果奶油蛋糕制作");
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		actionBar.addTab(actionBar.newTab().setText("知识介绍").setTabListener(new OnMyTabListener()));
		actionBar.addTab(actionBar.newTab().setText("材料准备").setTabListener(new OnMyTabListener()));
		actionBar.addTab(actionBar.newTab().setText("制作方法").setTabListener(new OnMyTabListener()));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tab_navi, menu);
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
	
	public class OnMyTabListener implements TabListener{

		@Override
		public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTabSelected(Tab tab, FragmentTransaction ft) {
			Fragment fragment = new Fragment();
			switch(tab.getPosition()){
			case 0:
				fragment = new Tab1Fragment();
				break;
			case 1:
				fragment = new Tab2Fragment();
				break;
			case 2:
				fragment = new Tab3Fragment();
				break;
			}
			ft.replace(R.id.container, fragment);
		}

		@Override
		public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
			// TODO Auto-generated method stub
			
		}
		
	}	
}
