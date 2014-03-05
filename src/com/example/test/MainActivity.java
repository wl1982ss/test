package com.example.test;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private static final int ITEM1 = Menu.FIRST;
	private static final int ITEM2 = Menu.FIRST + 1;
	private static final int ITEM3 = Menu.FIRST + 2;
	
	private static final int SUBMENU_ITEM1 = Menu.FIRST + 3;
	private static final int SUBMENU_ITEM2 = Menu.FIRST + 4;
	
	private TextView myTV;
	
	private final String[] items = {"����","","����"};
	
	private final int l = Toast.LENGTH_LONG;
	private final int s = Toast.LENGTH_SHORT;
	private final String s1 = "�Ҷ���ʾһ�����";
	private final String s2 = "������ʾһ�����";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		myTV = (TextView)findViewById(R.id.TextView01);
		registerForContextMenu(myTV);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main, menu);
		SubMenu file = menu.addSubMenu("�ļ�");
		SubMenu edit = menu.addSubMenu("�༭");
		
		file.add(0, SUBMENU_ITEM1, 0, "�½�");
		file.add(0, SUBMENU_ITEM2, 0, "��");
		return true;
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo){
		menu.add(0, ITEM1, 0, "��ɫ����");
		menu.add(0, ITEM2, 0, "��ɫ����");
		menu.add(0, ITEM3, 0, "��ɫ����");
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item){
		switch(item.getItemId()){
		case ITEM1:
			myTV.setBackgroundColor(Color.RED);
			break;
		case ITEM2:
			myTV.setBackgroundColor(Color.GREEN);
			break;
		case ITEM3:
			myTV.setBackgroundColor(Color.WHITE);
			Intent i = new Intent();
			i.setClass(MainActivity.this, FrameLayoutActivity.class);
			startActivity(i);
			break;
		}
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		switch(item.getItemId()){
		case SUBMENU_ITEM1:
			setTitle("�½��ļ�");
			/*
			final AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
			builder1.setTitle("����").setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					setTitle(items[which]);
					dialog.dismiss();
				}
			});
			AlertDialog ad1 = builder1.create();
			ad1.show();
			*/
			Toast t1 = Toast.makeText(getApplicationContext(), s1, l);
			t1.show();
			break;
		case SUBMENU_ITEM2:
			setTitle("���ļ���");
			/*
			final AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
			builder2.setMessage("���Ҫɾ���ü�¼��").
			setPositiveButton("��", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					setTitle("ɾ���ɹ���");
					
				}
			}).
			setNegativeButton("��", new DialogInterface.OnClickListener(){
				public void onClick(DialogInterface dialog, int which){
					setTitle("ȡ��ɾ����");
				}
			});
			AlertDialog ad2 = builder2.create();
			ad2.show();
			*/
			Toast t2 = Toast.makeText(getApplicationContext(), s2, s);
			t2.show();
			break;
		}
		return true;
	}

}
