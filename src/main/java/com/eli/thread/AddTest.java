package com.eli.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by elizhou on 2018/5/17.
 */
public class AddTest {
    public static int count = 0;

    public static synchronized void inc() {
        //这里延迟1毫秒，使得结果明显
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
    }

    public static void main(String[] args) throws Exception {
        Thread[] threads = new Thread[100];
        //同时启动100个线程，去进行i++计算，看看实际结果
        for (int i = 0; i < 100; i++) {
            threads[i] = new Thread(new Runnable() {
                public void run() {
                    AddTest.inc();
                }
            });
            threads[i].start();
        }

        for (int i = 0; i < 100; i++) {
            threads[i].join();
        }

        //这里每次运行的值都有可能不同,可能为100
        System.out.println("运行结果:ThreadTest.count=" + AddTest.count);
    }


}