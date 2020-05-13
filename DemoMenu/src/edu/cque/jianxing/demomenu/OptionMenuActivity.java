package edu.cque.jianxing.demomenu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;

public class OptionMenuActivity extends Activity {
	
	final int ITEM_ID1 = 0x1;
	final int ITEM_ID2 = 0x2;
	final int ITEM_ID3 = 0x3;
	final int ITEM_ID4 = 0x4;
	final int ITEM_ID41 = 0x5;
	final int ITEM_ID42 = 0x6;
	
	private int itemId1, itemId2, itemId3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_option_menu);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		MenuItem item1 = menu.add(0, this.ITEM_ID1, 0, "菜单项1");
		item1.setIcon(R.drawable.ico_info);
		item1.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
		item1.setIntent(new Intent(this, MainActivity.class));
		MenuItem item2 = menu.add(0, ITEM_ID2, 0, "菜单项2");
		MenuItem item3 = menu.add(0, ITEM_ID3, 0, "菜单项3");
		SubMenu subMenu = menu.addSubMenu(0, ITEM_ID4, 0, "子菜单4");
		subMenu.setHeaderTitle("子菜单标题");
		subMenu.setHeaderIcon(R.drawable.ico_modify);
		subMenu.add(0, ITEM_ID41, 0, "菜单项41");
		subMenu.add(0, ITEM_ID42, 0, "菜单项42");
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		Toast toast = Toast.makeText(OptionMenuActivity.this, "", Toast.LENGTH_SHORT);
		switch(id){
		case ITEM_ID1:
			toast.setText("菜单项1点击");
			toast.show();
			break;
		case ITEM_ID2:
			toast.setText("菜单项2点击");
			toast.show();
			break;
		case ITEM_ID3:
			toast.setText("菜单项3点击");
			toast.show();
			break;		
		case ITEM_ID4:
			toast.setText("菜单项4点击");
			toast.show();
			break;		
		case ITEM_ID41:
			toast.setText("菜单项41点击");
			toast.show();
			break;		
		case ITEM_ID42:
			toast.setText("菜单项42点击");
			toast.show();
			break;				
		}
		return super.onOptionsItemSelected(item);
	}
}
