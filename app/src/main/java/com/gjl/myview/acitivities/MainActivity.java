package com.gjl.myview.acitivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.gjl.myview.R;

import java.util.ArrayList;
import java.util.concurrent.CompletionService;

public class MainActivity extends AppCompatActivity {
	private ArrayList<String> list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ListView main_listview = (ListView) findViewById(R.id.main_listview);
		list = initData();
		MyAdapter myAdapter = new MyAdapter();
		main_listview.setAdapter(myAdapter);
		//设置listview条目点击事件
		main_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				switch (position){
					case 0:
						Intent intent = new Intent(MainActivity.this, MyTextViewActivity.class);
						startActivity(intent);
						break;
				}
			}
		});
	}

	private ArrayList<String> initData() {
		ArrayList<String> list = new ArrayList<>();
		list.add("自定义TextView");
		return list;
	}

	//适配器
	class MyAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			return list.size();
		}

		@Override
		public Object getItem(int position) {
			return null;
		}

		@Override
		public long getItemId(int position) {
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			TextView tv = new TextView(MainActivity.this);
			tv.setTextSize(30);
			tv.setText(list.get(position));
			return tv;
		}
	}
}
