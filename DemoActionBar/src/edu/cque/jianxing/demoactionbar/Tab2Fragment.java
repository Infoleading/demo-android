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
		textView.setText("����\n����   4��\n\n����\n������   40g\n�ͷ�    80g\nţ��    60g\nϸɰ��    60g\n������    300g\n���ҹ�ͷ    1��\n������    1��\nϸɰ��     25g");
		textView.setTextSize(25);
		return textView;
	}

}
