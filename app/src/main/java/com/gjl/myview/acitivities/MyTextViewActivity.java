package com.gjl.myview.acitivities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gjl.myview.R;

/**
 * 第一个自定义View
 * TextView
 * 实现的效果：
 * 	1.显示文字
 * 	2.设置文字大小和颜色
 * 	3.使用自定义属性
 */
public class MyTextViewActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_text_view);
	}
}
