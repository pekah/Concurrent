package com.eli.thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by elizhou on 2018/5/9.
 */
public class Profiler {

    // 第一次get()方法调用时会进行初始化（前提是没有调用set方法），每个线程最多会调用一次
    private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>() {
        @Override
        protected Long initialValue() {
            return System.currentTimeMillis();
        }
    };

    public static void begin() {
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    };

    public static long end() {
        return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }

    public static void main(String[] args) throws Exception{
        Profiler.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Cost : " + Profiler.end() + " mills");
    }
}
