package com.example.note;

import java.util.ArrayList;
import java.util.HashMap;
import com.example.note.R;
import android.annotation.TargetApi;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class NewPage extends ListActivity {
	public final static String EXTRA_MESSAGE = "com.example.note.MESSAGE";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_page);
		// Show the Up button in the action bar.
		// ��XML�е�ListView����ΪItem������
		ListView list = (ListView) getListView();

		// ���ɶ�̬���飬����ת������
		ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();

		HashMap<String, String> map1 = new HashMap<String, String>();
		map1.put("ItemTitle", "�����Ŀ");
		mylist.add(map1);
		HashMap<String, String> map2 = new HashMap<String, String>();
		map2.put("ItemTitle", "�����Ŀ");
		mylist.add(map2);

		
		// ����������������->ListItem
		SimpleAdapter mSchedule = new SimpleAdapter(this, // ûʲô����
				mylist,// ������Դ
				R.layout.my_listitem,// ListItem��XMLʵ��

				// ��̬������ListItem��Ӧ������
				new String[] { "ItemTitle"},

				// ListItem��XML�ļ����������TextView ID
				new int[] { R.id.ItemTitle});
		// ��Ӳ�����ʾ
		list.setAdapter(mSchedule);
	}
	
	public void turnToMainPage(View view) {
	    Intent intent = new Intent(this, MainActivity.class);
	    EditText editText = (EditText) findViewById(R.id.edit_name);
	    String message = editText.getText().toString();
	    intent.putExtra(EXTRA_MESSAGE, message);
	    startActivity(intent);
	}
	
//	/**
//	 * Set up the {@link android.app.ActionBar}, if the API is available.
//	 */
//	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
//	private void setupActionBar() {
//		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
//			getActionBar().setDisplayHomeAsUpEnabled(true);
//		}
//	}
//
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.new_page, menu);
//		return true;
//	}
//
//	@Override
//	public boolean onOptionsItemSelected(MenuItem item) {
//		switch (item.getItemId()) {
//		case android.R.id.home:
//			// This ID represents the Home or Up button. In the case of this
//			// activity, the Up button is shown. Use NavUtils to allow users
//			// to navigate up one level in the application structure. For
//			// more details, see the Navigation pattern on Android Design:
//			//
//			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
//			//
//			NavUtils.navigateUpFromSameTask(this);
//			return true;
//		}
//		return super.onOptionsItemSelected(item);
//	}

}
