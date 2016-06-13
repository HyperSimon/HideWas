package com.roselism.hiddenwas;

import android.content.pm.IPackageDataObserver;
import android.content.pm.IPackageStatsObserver;
import android.content.pm.PackageManager;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by simon on 16-5-23.
 */
public class PackageManagers {

    /**
     * 需要
     * <uses-permission android:name="android.permission.GET_PACKAGE_SIZE"></uses-permission>
     * 这个权限
     *
     * @param pm
     * @param packageName
     * @param observer
     */
    @HiddenWas
    public static void getPackageSizeInfo(PackageManager pm, String packageName, IPackageStatsObserver observer) {
        Class clazz = pm.getClass();
        try {
            Method method = clazz.getDeclaredMethod("getPackageSizeInfo", String.class, IPackageStatsObserver.class);
            method.invoke(pm, packageName, observer); // 请求
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }


    @HiddenWas
    public static void freeStorageAndNotify(PackageManager packageManager, int maxValue, IPackageDataObserver.Stub observer) {
        Class clazz = packageManager.getClass();
        try {
            Method method = clazz.getDeclaredMethod("freeStorageAndNotify", long.class, IPackageDataObserver.class);
            method.invoke(packageManager, maxValue, observer); // 请求
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
