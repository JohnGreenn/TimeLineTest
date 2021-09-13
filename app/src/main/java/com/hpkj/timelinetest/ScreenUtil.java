package com.hpkj.timelinetest;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

import java.lang.reflect.Field;

public class ScreenUtil {
	public static float density;
	public static float width;
	public static float height;

	public static int dip2px(Context context,float dipValue) {
		DisplayMetrics dm = context.getApplicationContext().getResources().getDisplayMetrics();
		density = dm.density;
		width = dm.widthPixels;
		height = dm.heightPixels;
		return (int) (dipValue * density + 0.5f);
	}

	public static int px2dip(Context context,float pxValue) {
		DisplayMetrics dm = context.getApplicationContext().getResources().getDisplayMetrics();
		density = dm.density;
		return (int) (pxValue / density + 0.5f);
	}

	public static int getStatusBarHeight(Context context) {
		Class<?> c = null;
		Object obj = null;
		Field field = null;
		int x = 0, sbar = 0;
		try {
			c = Class.forName("com.android.internal.R$dimen");
			obj = c.newInstance();
			field = c.getField("status_bar_height");
			x = Integer.parseInt(field.get(obj).toString());
			sbar = context.getResources().getDimensionPixelSize(x);
		} catch (Exception E) {
			E.printStackTrace();
		}
		return sbar;
	}

	public static int getNavBarHeight(Context context){
		Resources resources = context.getResources();
		int resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android");
		if (resourceId > 0) {
			return resources.getDimensionPixelSize(resourceId);
		}
		return 0;
	}
}
