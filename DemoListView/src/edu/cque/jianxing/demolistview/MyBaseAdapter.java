package edu.cque.jianxing.demolistview;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.RatingBar.OnRatingBarChangeListener;

public class MyBaseAdapter extends BaseAdapter {
	
	private Context context;
	private LayoutInflater inflator;
	private int resourceId;
	private List<Map<String, Object>> data;

	public MyBaseAdapter(Context context, int resourceId, List<Map<String, Object>> data) {
		super();
		this.context = context;
		this.data = data;
		this.inflator = LayoutInflater.from(context);
		this.resourceId = resourceId;
	}
	
	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int arg0) {
		return data.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		View view1 = this.inflator.inflate(this.resourceId, null);
		
		ImageView icon = (ImageView)view1.findViewById(R.id.icon);
		TextView name = (TextView)view1.findViewById(R.id.name);
		RatingBar favour = (RatingBar)view1.findViewById(R.id.favour);
		
		icon.setImageResource((Integer)data.get(position).get("icon"));
		name.setText((String)data.get(position).get("name"));
		favour.setProgress((Integer)data.get(position).get("favour"));
		favour.setTag(position); //控件所有列表项的位置
		favour.setOnRatingBarChangeListener(new OnMyRatingChangeListener());
		
		return view1;
	}
	
	public class ViewHolder{
		public ImageView icon;
		public TextView name;
		public RatingBar favour;
	}
	
	class OnMyRatingChangeListener implements OnRatingBarChangeListener{

		@Override
		public void onRatingChanged(RatingBar arg0, float arg1, boolean arg2) {
			int position = (Integer)arg0.getTag(); //获取控件所在列表项位置
			if(arg2){
				Map map = (Map)data.get(position);
				map.put("favour", new Integer((int)arg1));
			}
		}
		
	}

}
