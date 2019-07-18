package com.yang.sdk.threadpool.utils;

import com.yang.sdk.threadpool.callback.ThreadCallback;

public final class ThreadToolUtils {


    /**
     * 标志：在android平台上
     */
    public static boolean isAndroid;
    /*
     * 静态代码块
     * 判断是否是android环境
     * Class.forName(xxx.xx.xx) 返回的是一个类对象
     * 首先要明白在java里面任何class都要装载在虚拟机上才能运行。
     */
    static {
        try {
            Class.forName("android.os.Build");
            isAndroid = true;
        } catch (Exception e) {
            isAndroid = false;
        }
    }


    /**
     * 重置线程名并设置UnCaughtExceptionHandler包装回调，以便在发生异常时通知用户
     * @param thread The thread who should be reset.
     * @param name  non-null, thread name
     * @param callback a callback to notify user.
     */
    public static void resetThread(Thread thread, final String name, final ThreadCallback callback) {
        thread.setUncaughtExceptionHandler((t, e) -> {
            if (callback != null) {
                callback.onError(name, e);
            }
        });
        thread.setName(name);
    }

    public static void sleepThread(long time) {
        if (time <= 0) {
            return;
        }
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException("Thread has been interrupted", e);
        }
    }
}
