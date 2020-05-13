package edu.cque.jianxing.demolistview;

import java.util.List;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyArrayAdapter extends ArrayAdapter<Scientist> {
	
	private int resourceId;

	public MyArrayAdapter(Context context, int resource, List<Scientist> objects) {
		super(context, resource, objects);
		this.resourceId = resource;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		Scientist scientist = getItem(position);
		
		LayoutInflater layoutInflater = LayoutInflater.from(getContext());
		View view = layoutInflater.inflate(resourceId, null);
		
		ImageView imageView = (ImageView)view.findViewById(R.id.icon);
		TextView textView = (TextView)view.findViewById(R.id.name);
		
		imageView.setImageResource(scientist.getIconId());
		textView.setText(scientist.getName());
		
		return view;
	}

}
