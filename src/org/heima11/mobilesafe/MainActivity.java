package org.heima11.mobilesafe;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private ImageView mIvHeima;
	private GridView mGv;
	// 准备数据
	private static final int[] IMGRESID = { R.drawable.sjfd, R.drawable.srlj, R.drawable.rjgj, R.drawable.jcgl,
			R.drawable.lltj, R.drawable.sjsd, R.drawable.hcql, R.drawable.cygj };
	private static final String[] TITLES = { "手机防盗", "骚扰拦截", "软件管家", "进程管理", "流量统计", "手机杀毒", "缓存清理", "常用工具" };
	private static final String[] DES = { "远程定位", "全面骚扰拦截", "管理您的软件", "管理运行进程", "流量一目了然", "病毒无处藏身", "系统快如火箭", "工具大全" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initView();// 初始视图
		initData();// 初始数据
		initEvent();// 初始化事件
	}

	private void initView() {
		setContentView(R.layout.activity_main);
		mIvHeima = (ImageView) findViewById(R.id.iv_heima);
		// 找到GridView
		mGv = (GridView) findViewById(R.id.gv);
	}

	private void initData() {
		// 初始动画
		initAnim();
		mGv.setAdapter(new MainAdapter());
	}

	private void initEvent() {
		// GridView的Item的点击事件进行处理
		mGv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// position:0,1,2,3
//				String title = (String) mGv.getAdapter().getItem(position);
//				Toast.makeText(getApplicationContext(), "哥们我被点了" + id + "-" + title, 0).show();// 0,1,2,3
				switch (position) {
				case 0:// 进入手机防盗
					enterSJFD();
					break;

				default:
					break;
				}
			}
		});
	}
	// 进入手机防盗
	protected void enterSJFD() {
		Toast.makeText(getApplicationContext(), "手机防盗", 0).show();
	}

	// 初始动画
	private void initAnim() {
		// mIvHeima.setTranslationX(translationX);
		// mIvHeima.setRotationY(rotationY);
		// 1 构建ObjectAmnimator的对象
		// target:做动画的View
		// propertyName：view的属性
		// values：可变数组,位移动画：0，100，200，50
		// Android3.0
		ObjectAnimator animator = ObjectAnimator.ofFloat(mIvHeima, "rotationY", 0, 90, 270, 360);
		// 2 设置动画执行时间
		animator.setDuration(2000);// 执行时间是两秒
		// 3 设置循环模式
		animator.setRepeatCount(ObjectAnimator.INFINITE);
		// 4 设置反转模式
		animator.setRepeatMode(ObjectAnimator.REVERSE);
		// 5 开启动画
		animator.start();
	}

	class MainAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			return TITLES.length;
		}

		@Override
		public Object getItem(int position) {
			return TITLES[position];
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// 把xml文件转换一个View
			if (convertView == null) {
				convertView = View.inflate(getApplicationContext(), R.layout.view_gv_main_item, null);
				;
			}
			// 设置数据
			ImageView ivMainType = (ImageView) convertView.findViewById(R.id.iv_main_type);
			TextView tvMainTitle=(TextView) convertView.findViewById(R.id.tv_main_title);
			TextView tvMainDes=(TextView) convertView.findViewById(R.id.tv_main_des);
			ivMainType.setImageResource(IMGRESID[position]);
			tvMainTitle.setText(TITLES[position]);
			tvMainDes.setText(DES[position]);
			return convertView;
		}

	}
	
	
	// 跳转设置界面
	public void doSetting(View view){
		Intent intent=new Intent(this,SettingActivity.class);
		startActivity(intent);
	}

}
