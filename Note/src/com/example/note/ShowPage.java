package com.example.note;

import java.util.ArrayList;
import java.util.HashMap;
import com.example.note.R;
import android.annotation.TargetApi;
import android.app.ListActivity;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class ShowPage extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_page);
		// Show the Up button in the action bar.
		// 绑定XML中的ListView，作为Item的容器
		ListView list = (ListView) getListView();

		// 生成动态数组，并且转载数据
		ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();

		HashMap<String, String> map1 = new HashMap<String, String>();
		map1.put("ItemTitle", "添加条目");
		mylist.add(map1);
		HashMap<String, String> map2 = new HashMap<String, String>();
		map2.put("ItemTitle", "添加条目");
		mylist.add(map2);

		
		// 生成适配器，数组->ListItem
		SimpleAdapter mSchedule = new SimpleAdapter(this, // 没什么解释
				mylist,// 数据来源
				R.layout.my_listitem,// ListItem的XML实现

				// 动态数组与ListItem对应的子项
				new String[] { "ItemTitle"},

				// ListItem的XML文件里面的两个TextView ID
				new int[] { R.id.ItemTitle});
		// 添加并且显示
		list.setAdapter(mSchedule);
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
