package org.heima11.mobilesafe.view;

import org.heima11.mobilesafe.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * @author U 自定义组合控件
 */
public class SettingItemView extends LinearLayout {

	public SettingItemView(Context context) {// 在代码产生View的时候使用
		this(context, null);
	}

	public SettingItemView(Context context, AttributeSet attrs) {// 布局文件写的时候，会调用一个构造器
		this(context, attrs, 0);
		// AttributeSet：封装属性： android:layout_width="wrap_content"
	}

	public SettingItemView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// 代码只要这里处理就ok
		// xml---view
		View view = View.inflate(context, R.layout.view_setting_item, null);
		// view 添加到SettingItemView
		// 1 找到TextView
		TextView tv=(TextView) view.findViewById(R.id.tv_setting_type);
		// 1 获取TypeArray
		//TypedArray obtainStyledAttributes(AttributeSet set, int[] attrs)
		TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.SettingItemView);
		// 获取文本
		String text = ta.getString(R.styleable.SettingItemView_siv_text);
		tv.setText(text);
		// 回收TypeArray
		ta.recycle();
		addView(view);
	}
	
	

}
