package edu.cque.jianxing.demotabhost;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TabHost;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		TabHost tabhost = (TabHost)findViewById(android.R.id.tabhost);
		tabhost.setup();
		
		LayoutInflater inflater = LayoutInflater.from(this);
		inflater.inflate(R.layout.tab1, tabhost.getTabContentView());
		inflater.inflate(R.layout.tab2, tabhost.getTabContentView());
		
		tabhost.addTab(tabhost.newTabSpec("tab01")
				.setIndicator("未接来电")
				.setContent(R.id.content1));
		
		tabhost.addTab(tabhost.newTabSpec("tab01")
				.setIndicator("已接来电")
				.setContent(R.id.content2));
		
	}

}
