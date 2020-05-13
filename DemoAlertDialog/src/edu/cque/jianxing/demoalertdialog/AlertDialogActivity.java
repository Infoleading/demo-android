package edu.cque.jianxing.demoalertdialog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleAdapter;

public class AlertDialogActivity extends Activity {
	
	private Button btnMessageAlert, btnItemsAlert, singleAlert, multiAlert, adapterAlert, viewAlert;
	private EditText et;
	private String[] courses = {"国学","哲学","数学","信息学"};
	private List data = new ArrayList();
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alert_dialog);
		
		init();
		
		btnMessageAlert = (Button)findViewById(R.id.messageAlert);
		btnItemsAlert = (Button)findViewById(R.id.itemsAlert);
		singleAlert = (Button)findViewById(R.id.singleAlert);
		multiAlert = (Button)findViewById(R.id.MultiAlert);
		adapterAlert = (Button)findViewById(R.id.adapterAlert);
		viewAlert = (Button)findViewById(R.id.viewAlert);
		et = (EditText)findViewById(R.id.returned);
		
		btnMessageAlert.setOnClickListener(new OnMessageAlertClickListener());
		btnItemsAlert.setOnClickListener(new OnItemsAlertClickListener());
		singleAlert.setOnClickListener(new OnSingleAlertClickListener());
		multiAlert.setOnClickListener(new OnMultiAlertClickListener());
		adapterAlert.setOnClickListener(new OnAdapterAlertClickListener());
		viewAlert.setOnClickListener(new OnViewAlertClickListener());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.alert_dialog, menu);
		return true;
	}
	
	class OnMessageAlertClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			
			AlertDialog.Builder builder = new AlertDialog.Builder(AlertDialogActivity.this)
			.setTitle("文件删除")
			.setIcon(R.drawable.ico_question)
			.setMessage("是否真的删除文件？\n该操作将不可恢复")
			.setPositiveButton("确定", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {

					et.append("确定删除文件\n");
					
				}
			})
			.setNegativeButton("取消", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {

					et.append("取消删除文件\n");
					
				}
			});
			builder.create().show();
		}
		
	}
	
	class OnItemsAlertClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {

			AlertDialog.Builder builder = new AlertDialog.Builder(AlertDialogActivity.this)
			.setTitle("选择你最喜欢的学科")
			.setIcon(R.drawable.ico_question)
			.setItems(courses, new DialogInterface.OnClickListener(){

				@Override
				public void onClick(DialogInterface dialog, int which) {

					et.append("你喜欢"+courses[which]+"\n");
					
				}
				
			})
			.setNeutralButton("返回", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {

					et.append("返回\n");
					
				}
			});
			builder.create().show();
			
		}
		
	}
	
	class OnSingleAlertClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {

			AlertDialog.Builder builder = new AlertDialog.Builder(AlertDialogActivity.this)
					.setTitle("请选择你喜欢的学科")
					.setIcon(R.drawable.ico_question)
					.setSingleChoiceItems(courses, 1, new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {

							et.append("你喜欢"+courses[which]+"\n");
							
						}
					})
					.setNeutralButton("返回", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {

							et.append("返回\n");
							
						}
					});
					builder.create().show();			
		}
		
	}
	
	class OnMultiAlertClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {

			AlertDialog.Builder builder = new AlertDialog.Builder(AlertDialogActivity.this)
					.setTitle("请选择你喜欢的学科")
					.setIcon(R.drawable.ico_question)
					.setMultiChoiceItems(
							courses, 
							new boolean[]{true, false, false, false}, 
							new OnMultiChoiceClickListener() {
								
								@Override
								public void onClick(DialogInterface dialog, int which, boolean isChecked) {

									if(isChecked)
										et.append("你选中了"+courses[which]+"\n");
									else
										et.append("你取消了"+courses[which]+"\n");
									
								}
							})
					.setNeutralButton("返回", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {

							et.append("返回\n");
							
						}
					});
			builder.create().show();
			
		}
		
	}
	
	class OnAdapterAlertClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {

			SimpleAdapter adapter = new SimpleAdapter(
					AlertDialogActivity.this, 
					data, 
					R.layout.item_layout, 
					new String[]{"icon","name"}, 
					new int[]{R.id.icon, R.id.name});
			
			AlertDialog.Builder builder = new AlertDialog.Builder(AlertDialogActivity.this)
					.setTitle("请选择你喜欢的科学家")
					.setIcon(R.drawable.ico_info)
					.setAdapter(adapter, new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {

							et.append("科学家 "+Raw.names[which]+"\n");
							
						}
					})
					.setNeutralButton("返回", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {

							et.append("返回\n");
							
						}
					});
			builder.create().show();
		}
		
	}
	
	class OnViewAlertClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {

			View view = getLayoutInflater().inflate(R.layout.add_info_layout, null);
			final EditText contacter = (EditText)view.findViewById(R.id.contacter);
			final EditText tel = (EditText)view.findViewById(R.id.tel);
			
			AlertDialog.Builder builder = new AlertDialog.Builder(AlertDialogActivity.this)
					.setTitle("添加联系人")
					.setIcon(R.drawable.ico_modify)
					.setView(view)
					.setPositiveButton("确定", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							
							et.append("联系人:"+contacter.getText().toString()+"\n");
							et.append("联系电话:"+tel.getText().toString()+"\n");
							
						}
					})
					.setNegativeButton("取消", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {

							et.append("取消返回\n");
							
						}
					});
			builder.create().show();
			
		}
		
	}
	
	private void init(){
		for(int i=0; i<Raw.names.length; i++){
			Map item = new HashMap();
			item.put("name", Raw.names[i]);
			item.put("birthday", Raw.birthday[i]);
			item.put("deed", Raw.deed[i]);
			item.put("nation", Raw.nationality[i]);
			item.put("icon", Raw.iconId[i]);
			item.put("figure", Raw.imageId[i]);
			data.add(item);
		}
	}

}
