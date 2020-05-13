package edu.cque.jianxing.demofragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if( getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
			replaceFragment(new RightFragment());
	}
	
	public void onBtn1Click(View view){
		if( getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
			replaceFragment(new RightFragment());	
	}
	
	public void onBtn2Click(View view){
		if( getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
			replaceFragment(new AnotherFragment());
	}
	
	
	private void replaceFragment(Fragment fragment){
		FragmentManager fragmentManager = getFragmentManager();
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		transaction.replace(R.id.right_layout, fragment);
		transaction.commit();
	}

}
