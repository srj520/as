package org.heima11.mobilesafe.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.TextView;

public class MarqueeTextView extends TextView{

	public MarqueeTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public MarqueeTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public MarqueeTextView(Context context) {
		super(context);
	}
	
	//欺骗系统跑马灯一直有焦点
	@Override
	public boolean isFocused() {
		return true;
	}
	
	// 当焦点发生改变的时候，会调这个方法
	@Override
	protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
		super.onFocusChanged(true, direction, previouslyFocusedRect);
	}

	// 当窗体状态发生改变
	@Override
	public void onWindowFocusChanged(boolean hasWindowFocus) {
		// TODO Auto-generated method stub
		super.onWindowFocusChanged(true);
	}
}
