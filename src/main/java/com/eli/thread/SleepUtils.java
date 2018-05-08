package com.eli.thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by elizhou on 2018/5/7.
 */
public class SleepUtils {
    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e){

        }
    }
}
