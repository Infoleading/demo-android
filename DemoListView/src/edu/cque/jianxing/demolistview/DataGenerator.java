package edu.cque.jianxing.demolistview;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import android.content.res.AssetManager;

public class DataGenerator {
	
	/**
	 * 将一个asset子目录中的文件名称组装成一个名称数组，其中不含扩展名
	 * @param am AssetManager对象，可用Activity的getAssets()方法获得
	 * @param textFilePath 目录路径，使用以asset目录为根的相对路径
	 * @return 文件名的String数组
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
