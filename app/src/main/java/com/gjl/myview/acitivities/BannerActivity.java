package com.gjl.myview.acitivities;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.Resource;
import com.gjl.myview.R;
import com.gjl.myview.acitivities.views.InnerListView;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Transformer;


/**
 * 顶部无线轮播
 * 使用XBanner第三方实现
 */
public class BannerActivity extends AppCompatActivity {
	private XBanner banner;
	private ArrayList<String> titles;
	private ArrayList<Integer> images;
	private ArrayList<String> names;
	private InnerListView listView;
	private SwipeRefreshLayout srl;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//找到控件
		setContentView(R.layout.activity_banner);
		initViews();
		initDatas();
		// 为XBanner绑定数据
		banner.setData(titles);
		// XBanner适配数据
		banner.setmAdapter(new XBanner.XBannerAdapter() {
			@Override
			public void loadBanner(XBanner banner, View view, int position) {
				ImageView imageView = (ImageView) view;
				imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
				Glide.with(BannerActivity.this).load(images.get(position)).into(imageView);
			}
		});

		listView.setAdapter(new MyAdapter());
	}

	private void initDatas() {
		// 初始化XBanner中展示的数据
		images = new ArrayList<>();
		titles = new ArrayList<>();

		images.add(R.drawable.aaaa);
		images.add(R.drawable.abc);
		images.add(R.drawable.f);
		images.add(R.drawable.f);
//		images.add("http://img3.fengniao.com/forum/attachpics/913/114/36502745.jpg");
		titles.add("这是第1张图片这是第1张图片这是第1张图片这是第1张图片这是第1张图片这是第1张图片这是第1张图片这是第1张图片这是第1张图片");
//		images.add("http://imageprocess.yitos.net/images/public/20160910/99381473502384338.jpg");
		titles.add("这是第2张图片这是第2张图片这是第2张图片这是第2张图片这是第2张图片这是第2张图片这是第2张图片这是第2张图片这是第2张图片");
//		images.add("http://imageprocess.yitos.net/images/public/20160910/77991473496077677.jpg");
		titles.add("这是第3张图片这是第3张图片这是第3张图片这是第3张图片这是第3张图片这是第3张图片这是第3张图片这是第3张图片这是第3张图片");
//		images.add("http://imageprocess.yitos.net/images/public/20160906/1291473163104906.jpg");
		titles.add("这是第4张图片这是第4张图片这是第4张图片这是第4张图片这是第4张图片这是第4张图片这是第4张图片这是第4张图片这是第4张图片");
//ListView
		names = new ArrayList<>();

		for (int i = 0; i < 100; i++) {
			names.add("张三" + i);
		}
	}

	//初始化控件
	private void initViews() {
		banner = (XBanner) findViewById(R.id.banner_1);
		listView = (InnerListView) findViewById(R.id.listview);
		srl = (SwipeRefreshLayout) findViewById(R.id.swipe);
	}

	class MyAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			return names.size();
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
			TextView textView = new TextView(BannerActivity.this);
			textView.setTextSize(25);
			textView.setText(names.get(position));
			return textView;
		}
	}
}
