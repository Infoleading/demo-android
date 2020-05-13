package edu.cque.jianxing.demozoomcontrols;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ZoomControls;

public class DetailActivity extends Activity {

	private ImageView imageView;
	private ZoomControls zoom;
	private Bitmap bmp, newBmp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);
		
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		int picId =  bundle.getInt("id");
		
		bmp = BitmapFactory.decodeResource(getResources(), picId);
		
		imageView = (ImageView)findViewById(R.id.image);
		imageView.setImageResource(picId);
		imageView.setOnClickListener(new OnImageClickListener());
		
		zoom = (ZoomControls)findViewById(R.id.zoom);
		zoom.setZoomSpeed(100);
		zoom.setOnZoomInClickListener(new OnZoomInClickListener());
		zoom.setOnZoomOutClickListener(new OnZoomOutClickListener());
		
		setZoomInEnable(bmp, imageView);
		setZoomOutEnable(bmp, imageView);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.detail, menu);
		return true;
	}
	
	class OnZoomInClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {

			int bmpWidth = bmp.getWidth();
			int bmpHeight = bmp.getHeight();
			int imageWidth = imageView.getWidth();
			int imageHeight = imageView.getHeight();
			float scale;
			
			if(bmpWidth>bmpHeight)
				scale = (float)imageHeight/(float)bmpHeight;
			else
				scale = (float)imageWidth/(float)bmpWidth;				
			
			Matrix matrix = new Matrix();
			matrix.postScale(scale, scale);
			Bitmap newBmp = Bitmap.createBitmap(bmp, 0, 0, bmpWidth, bmpHeight, matrix, true);
			imageView.setImageBitmap(newBmp);
			
			setZoomInEnable(newBmp, imageView);
			setZoomOutEnable(newBmp, imageView);
			

		}
		
	}
	
	class OnZoomOutClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {

			int bmpWidth = bmp.getWidth();
			int bmpHeight = bmp.getHeight();
			int imageWidth = imageView.getWidth();
			int imageHeight = imageView.getHeight();
			float scale;
			
			if(bmpWidth>bmpHeight)
				scale = (float)imageWidth/(float)bmpWidth;
			else
				scale = (float)imageHeight/(float)bmpHeight;
			
			Matrix matrix = new Matrix();
			matrix.postScale(scale, scale);
			Bitmap newBmp = Bitmap.createBitmap(bmp, 0, 0, bmpWidth, bmpHeight, matrix, true);
			imageView.setImageBitmap(newBmp);
			
			setZoomInEnable(newBmp, imageView);
			setZoomOutEnable(newBmp, imageView);
		
		}
		
	}
	
	class OnImageClickListener implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			if(zoom.getVisibility()==View.VISIBLE)
				zoom.hide();
			else
				zoom.show();
		}
		
	}
	
	private void setZoomInEnable(Bitmap bmp, ImageView imageView){
		if(bmp.getWidth()>imageView.getWidth() && bmp.getHeight()>imageView.getHeight())
			zoom.setIsZoomInEnabled(false);
		else
			zoom.setIsZoomInEnabled(true);
	}
	
	private void setZoomOutEnable(Bitmap bmp, ImageView imageView){
		if(bmp.getWidth()<imageView.getWidth() && bmp.getHeight()<imageView.getHeight())
			zoom.setIsZoomOutEnabled(false);
		else
			zoom.setIsZoomOutEnabled(true);
	}


}
