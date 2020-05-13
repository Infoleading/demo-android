package edu.cque.jianxing.demoactionbar;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Tab2Fragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		TextView textView = new TextView(getActivity());
		textView.setText("Ö÷ÁÏ\n¼¦µ°   4¸ö\n\n¸¨ÁÏ\nÓñÃ×ÓÍ   40g\nµÍ·Û    80g\nÅ£ÄÌ    60g\nÏ¸É°ÌÇ    60g\nµ­ÄÌÓÍ    300g\n»ÆÌÒ¹ŞÍ·    1¹Ş\n»ğÁú¹û    1¸ö\nÏ¸É°ÌÇ     25g");
		textView.setTextSize(25);
		return textView;
	}

}
