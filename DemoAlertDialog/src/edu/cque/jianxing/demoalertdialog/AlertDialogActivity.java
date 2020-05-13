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
	private String[] courses = {"��ѧ","��ѧ","��ѧ","��Ϣѧ"};
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
			.setTitle("�ļ�ɾ��")
			.setIcon(R.drawable.ico_question)
			.setMessage("�Ƿ����ɾ���ļ���\n�ò��������ɻָ�")
			.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {

					et.append("ȷ��ɾ���ļ�\n");
					
				}
			})
			.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {

					et.append("ȡ��ɾ���ļ�\n");
					
				}
			});
			builder.create().show();
		}
		
	}
	
	class OnItemsAlertClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {

			AlertDialog.Builder builder = new AlertDialog.Builder(AlertDialogActivity.this)
			.setTitle("ѡ������ϲ����ѧ��")
			.setIcon(R.drawable.ico_question)
			.setItems(courses, new DialogInterface.OnClickListener(){

				@Override
				public void onClick(DialogInterface dialog, int which) {

					et.append("��ϲ��"+courses[which]+"\n");
					
				}
				
			})
			.setNeutralButton("����", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {

					et.append("����\n");
					
				}
			});
			builder.create().show();
			
		}
		
	}
	
	class OnSingleAlertClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {

			AlertDialog.Builder builder = new AlertDialog.Builder(AlertDialogActivity.this)
					.setTitle("��ѡ����ϲ����ѧ��")
					.setIcon(R.drawable.ico_question)
					.setSingleChoiceItems(courses, 1, new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {

							et.append("��ϲ��"+courses[which]+"\n");
							
						}
					})
					.setNeutralButton("����", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {

							et.append("����\n");
							
						}
					});
					builder.create().show();			
		}
		
	}
	
	class OnMultiAlertClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {

			AlertDialog.Builder builder = new AlertDialog.Builder(AlertDialogActivity.this)
					.setTitle("��ѡ����ϲ����ѧ��")
					.setIcon(R.drawable.ico_question)
					.setMultiChoiceItems(
							courses, 
							new boolean[]{true, false, false, false}, 
							new OnMultiChoiceClickListener() {
								
								@Override
								public void onClick(DialogInterface dialog, int which, boolean isChecked) {

									if(isChecked)
										et.append("��ѡ����"+courses[which]+"\n");
									else
										et.append("��ȡ����"+courses[which]+"\n");
									
								}
							})
					.setNeutralButton("����", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {

							et.append("����\n");
							
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
					.setTitle("��ѡ����ϲ���Ŀ�ѧ��")
					.setIcon(R.drawable.ico_info)
					.setAdapter(adapter, new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {

							et.append("��ѧ�� "+Raw.names[which]+"\n");
							
						}
					})
					.setNeutralButton("����", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {

							et.append("����\n");
							
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
					.setTitle("�����ϵ��")
					.setIcon(R.drawable.ico_modify)
					.setView(view)
					.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							
							et.append("��ϵ��:"+contacter.getText().toString()+"\n");
							et.append("��ϵ�绰:"+tel.getText().toString()+"\n");
							
						}
					})
					.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {

							et.append("ȡ������\n");
							
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
