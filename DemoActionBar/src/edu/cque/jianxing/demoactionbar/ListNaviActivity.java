package edu.cque.jianxing.demoactionbar;

import android.app.ActionBar;
import android.app.ActionBar.OnNavigationListener;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

public class ListNaviActivity extends Activity {
	
	private ActionBar actionBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_navi);
		
		actionBar = getActionBar();
		actionBar.setIcon(R.drawable.cooker);
		actionBar.setTitle("ˮ�����͵�������");
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
		actionBar.setListNavigationCallbacks(
				new ArrayAdapter<String>(
						ListNaviActivity.this,
						android.R.layout.simple_list_item_1,
						new String[]{"֪ʶ����","����׼��","��������"}),
				new OnMyNavigationListener());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list_navi, menu);
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
	
	public class OnMyNavigationListener implements OnNavigationListener{

		@Override
		public boolean onNavigationItemSelected(int position, long arg1) {
			
			Fragment fragment = new Fragment();
			switch(position){
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
			FragmentTransaction ft = getFragmentManager().beginTransaction();
			ft.replace(R.id.container, fragment);
			ft.commit();
			return true;
		}
		
	}
}
