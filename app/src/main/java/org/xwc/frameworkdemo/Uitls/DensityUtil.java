package org.xwc.frameworkdemo.Uitls;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import org.xwc.frameworkdemo.AppContext;

/**
 * @author Besieger
 */
public class DensityUtil {

	// 根据屏幕密度转换
	private static float mPixels = 0.0F;
	private static float density = -1.0F;

	/**
	 * @param context
	 * @param pixels
	 * @return
	 */
	public static int getDisplayMetrics(Context context, float pixels) {
		if (mPixels == 0.0F)
			mPixels = context.getResources().getDisplayMetrics().density;
		return (int) (0.5F + pixels * mPixels);
	}


	public static int getImageWeidth(Context context, float pixels) {
		return context.getResources().getDisplayMetrics().widthPixels - 66
				- getDisplayMetrics(context, pixels);
	}

	/**
	 * 像素转化dip
	 *
	 * @param context
	 * @param pxValue
	 * @return
	 */
	public static int px2dip(Context context, float pxValue) {

		final float scale = context.getResources().getDisplayMetrics().density;

		return (int) (pxValue / scale + 0.5f);

	}

	/**
	 * dip转化像素
	 *
	 * @param dipValue
	 * @return
	 */
	public static int dip2px(float dipValue) {
		final float scale = Resources.getSystem().getDisplayMetrics().density;
		return (int) (dipValue * scale + 0.5f);

	}

	/**
	 * @param context
	 * @param height
	 * @return
	 */
	public static int getMetricsDensity(Context context, float height) {
		DisplayMetrics localDisplayMetrics = new DisplayMetrics();
		((WindowManager) context.getSystemService(Context.WINDOW_SERVICE))
				.getDefaultDisplay().getMetrics(localDisplayMetrics);
		return Math.round(height * localDisplayMetrics.densityDpi / 160.0F);
	}

	public static int fromDPToPix(Context context, int dp) {
		return Math.round(getDensity(context) * dp);
	}

	/**
	 * @param context
	 * @return
	 */
	public static float getDensity(Context context) {
		if (context == null)
			context = AppContext.getInstance();
		if (density < 0.0F)
			density = context.getResources().getDisplayMetrics().density;
		return density;
	}

	public static int round(Context context, int paramInt) {
		return Math.round(paramInt / getDensity(context));
	}

	// 获取屏幕的宽度
	public static int getScreenWidth(Context context) {
		WindowManager manager = (WindowManager) context
				.getSystemService(Context.WINDOW_SERVICE);
		Display display = manager.getDefaultDisplay();
		return display.getWidth();
	}

	// 获取屏幕的高度
	public static int getScreenHeight(Context context) {
		WindowManager manager = (WindowManager) context
				.getSystemService(Context.WINDOW_SERVICE);
		Display display = manager.getDefaultDisplay();
		return display.getHeight();
	}

}
