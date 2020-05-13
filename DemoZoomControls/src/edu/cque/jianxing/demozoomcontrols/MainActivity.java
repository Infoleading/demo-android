package edu.cque.jianxing.demozoomcontrols;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.GridLayout;
import android.widget.ImageView;

public class MainActivity extends Activity {
	
	private int[] imageRes={R.drawable.pic01, R.drawable.pic02, R.drawable.pic03, 
			R.drawable.pic04, R.drawable.pic05, R.drawable.pic06, R.drawable.pic07, 
			R.drawable.pic08, R.drawable.pic09, R.drawable.pic10, R.drawable.pic11, 
			R.drawable.pic12, R.drawable.pic13, R.drawable.pic14, R.drawable.pic15}; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		int imageNum=imageRes.length;
		int colNum = 3;
		int maxWidth = 160;
		int maxHeight = 120;
		
		GridLayout gridLayout = (GridLayout)findViewById(R.id.mainLayout);
		gridLayout.setColumnCount(colNum);
		gridLayout.setRowCount(imageNum/colNum+1);
		
		OnMyClickListener myClickLsn = new OnMyClickListener();
		
		for(int i=0; i<imageNum; i++){
			ImageView image = new ImageView(this);
			image.setImageResource(imageRes[i]);
			image.setMaxWidth(maxWidth);
			image.setMaxHeight(maxHeight);
			image.setAdjustViewBounds(true);
			image.setOnClickListener(myClickLsn);
			image.setId(imageRes[i]);

			int row = i/colNum; //计算所在行数
			int col = i%colNum; //计算所在列数
			GridLayout.Spec rowSpec = GridLayout.spec(row);
			GridLayout.Spec colSpec = GridLayout.spec(col);
			GridLayout.LayoutParams layoutParam = new GridLayout.LayoutParams(rowSpec, colSpec);
			layoutParam.setGravity(Gravity.CENTER);
			image.setLayoutParams(layoutParam);
			
			gridLayout.addView(image);
		}		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	class OnMyClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			Bundle bundle = new Bundle();
			bundle.putInt("id", v.getId());
			Intent intent  = new Intent();
			intent.setClass(MainActivity.this, DetailActivity.class);
			intent.putExtras(bundle);
			startActivity(intent);
		}
		
	}

}
