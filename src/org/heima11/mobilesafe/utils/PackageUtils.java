package org.heima11.mobilesafe.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

public class PackageUtils {

	// 1 获取版本名字
	public static String getVersionName(Context context){
		// 1 获取PackageManager
		PackageManager pm=context.getPackageManager();
		// 2 获取PackageInfo
		try {
			PackageInfo packageInfo = pm.getPackageInfo(context.getPackageName(), 0);
			// 3 返回版本名字
			return packageInfo.versionName;
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// 2 获取版本号
	public static int getVersionCode(Context context){
		// 1 获取PackageManager
		PackageManager pm = context.getPackageManager();
		// 2 获取PackageInfo
		try {
			PackageInfo packageInfo = pm.getPackageInfo(context.getPackageName(), 0);
			// 3 返回版本号
			return packageInfo.versionCode;
		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;//-1 获取不到版本号
	}
}
