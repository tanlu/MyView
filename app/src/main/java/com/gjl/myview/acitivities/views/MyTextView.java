package com.gjl.myview.acitivities.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.gjl.myview.R;

/**
 * 不使用自定义属性的
 */

public class MyTextView extends View {
	private String mContent;
	private int mColor;
	private int mSize;

	public MyTextView(Context context) {
		this(context, null);
	}

	public MyTextView(Context context, @Nullable AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public MyTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		//init初始化一些东西
		TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.MyThem, defStyleAttr, 0);
		//获取属性列表之后，遍历
		for (int i = 0; i < typedArray.getIndexCount(); i++) {
			//获取属性
			int attr = typedArray.getIndex(i);
			switch (attr) {
				case R.styleable.MyThem_textContent:
					mContent = typedArray.getString(attr);
					break;
				case R.styleable.MyThem_textColor:
					mColor = typedArray.getColor(attr, Color.BLACK);//默认黑色
					break;
				case R.styleable.MyThem_textSize:
//					mSize = typedArray.getDimension(attr,30);
					break;
			}
		}

	}
}
