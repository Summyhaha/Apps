package com.example.note;

//
//public class HttpGetActivity {
//
//}

//import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
//import org.apache.http.HttpResponse;
//import org.apache.http.HttpStatus;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.DefaultHttpClient;
import com.example.note.R;
import android.app.ListActivity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
//import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class MainActivity extends ListActivity {
	public static String uri = "http://developer.android.com/";
	public static final int MSG_SUCCESS1 = 0;
	public static final int MSG_FAILURE = 1;
	final String TAG_STRING = "TAG";
	private ListView listView;
	private SimpleAdapter adapter;
	private Context context;

	@Override
	public void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);	    
		
		setContentView(R.layout.activity_main);
		// 绑定XML中的ListView，作为Item的容器
		ListView list = (ListView) getListView();

		// 生成动态数组，并且转载数据
		ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map1 = new HashMap<String, String>();
		map1.put("ItemTitle", "购物");
		mylist.add(map1);
		
//		TextView txtViewRegister = (TextView)findViewById(R.id.ItemTitle);
//		txtViewRegister.setOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View v) {
//			// TODO Auto-generated method stub
//			/**
//			 * 跳到页面
//			 * */
//				ComponentName componentname = new ComponentName(MainActivity.this, "com.example.note.ShowPage");
//				Intent intent = new Intent();
//				intent.setComponent(componentname);
//				startActivity(intent);
//			}
//		});
		
		
		HashMap<String, String> map2 = new HashMap<String, String>();
		map2.put("ItemTitle", "作业");
		mylist.add(map2);
		HashMap<String, String> map3 = new HashMap<String, String>();
		map3.put("ItemTitle", "考试");
		mylist.add(map3);
		HashMap<String, String> map4 = new HashMap<String, String>();
		map4.put("ItemTitle", "课程");
		mylist.add(map4);
		HashMap<String, String> map5 = new HashMap<String, String>();
		map5.put("ItemTitle", "娱乐");
		mylist.add(map5);
		
	    // Get the message from the intent
	    Intent intent = getIntent();
	    String message = intent.getStringExtra(NewPage.EXTRA_MESSAGE);
		if(message!=null){
			HashMap<String, String> map6 = new HashMap<String, String>();
			map6.put("ItemTitle", message);
			mylist.add(map6);
		}
		
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
	
	public void turnToNewPage(View view) {
	    Intent intent = new Intent(this, NewPage.class);
	    startActivity(intent);
	}
	
	public void turnToShowPage(View view) {
	    Intent intent = new Intent(this, ShowPage.class);
	    startActivity(intent);
	}

}