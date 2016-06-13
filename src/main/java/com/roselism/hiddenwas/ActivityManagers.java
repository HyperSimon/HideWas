package com.roselism.hiddenwas;

import android.app.ActivityManager;
import android.content.Context;

/**
 * ActivityManager的增强
 * 将ActiivtyManager中的一些被 @hide的方法通过反射的方式调用
 * Created by simon on 16-5-29.
 */
public class ActivityManagers {

    /**
     * 获取任务管理
     *
     * @param context
     * @return
     */
    private static ActivityManager getActivityManager(Context context) {
        return (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
    }

    /**
     * 根据包名杀掉进程
     *
     * @param context
     * @param packageName
     */
    public static void killBackgroundProcesses(Context context, String packageName) {
        ActivityManager activityManager = getActivityManager(context);
        activityManager.killBackgroundProcesses(packageName);
    }


    public static String availMem(Context context) {
        return android.text.format.Formatter.formatFileSize(context, availMemLong(context));
    }

    public static long availMemLong(Context context) {
        ActivityManager activityManager = getActivityManager(context);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);

        return memoryInfo.availMem;
    }
}
