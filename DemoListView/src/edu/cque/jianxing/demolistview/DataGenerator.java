package edu.cque.jianxing.demolistview;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import android.content.res.AssetManager;

public class DataGenerator {
	
	/**
	 * ��һ��asset��Ŀ¼�е��ļ�������װ��һ���������飬���в�����չ��
	 * @param am AssetManager���󣬿���Activity��getAssets()�������
	 * @param textFilePath Ŀ¼·����ʹ����assetĿ¼Ϊ�������·��
	 * @return �ļ�����String����
	 */
	public static String[] getNameArray(AssetManager am, String textFilePath){
		
		ArrayList<String> nameArray=new ArrayList<String>();
		String[] textFileNameArray=null;
		
		try {
			textFileNameArray = am.list(textFilePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String str = "{";
		for(String name:textFileNameArray){
			nameArray.add(name.substring(0, name.length()-4));
			str += "\""+name.substring(0, name.length()-4)+"\", ";
		}
		str += "}";

		String[] data = new String[nameArray.size()];
		nameArray.toArray(data);
		return data;
	}
	
	public static void test(){
		


	}
	
	


}
