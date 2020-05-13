package edu.cque.jianxing.demogridview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class StretchModeActivity extends Activity {
	
	private GridView gv;
	private int[] texts = {R.string.c1, R.string.c2, R.string.c3, R.string.c4, R.string.c5, R.string.c6, R.string.c7, R.string.c8, R.string.c9};
	private int[] colors = {R.color.c1, R.color.c2, R.color.c3, R.color.c4, R.color.c5, R.color.c6, R.color.c7, R.color.c8, R.color.c9};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_stretch_mode);
	
		gv = (GridView)findViewById(R.id.gridview1);	
		gv.setAdapter(new BaseAdapter() {

			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return texts.length;
			}

			@Override
			public Object getItem(int position) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public long getItemId(int position) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				// TODO Auto-generated method stub
				TextView textView;
				if(convertView==null)
					textView=new TextView(StretchModeActivity.this);
				else
					textView = (TextView)convertView;
	            textView.setText(texts[position]);
	            textView.setTextSize(20);
	            textView.setGravity(Gravity.CENTER);
	            textView.setBackgroundResource(colors[position]);
	            //GridView gv = (GridView)parent;
	            //gv.setStretchMode(GridView.STRETCH_SPACING);
				return textView;
			}
			
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.grid_view, menu);
		menu.findItem(R.id.a1).setIntent(new Intent(this, GridViewActivity.class));
		menu.findItem(R.id.a2).setIntent(new Intent(this, StretchModeActivity.class));		
		return true;
	}

}
