package com.eli.thread;

/**
 * Created by elizhou on 2018/5/16.
 */
public class JoinContDownLatchTest {
    public static void main(String[] args) throws Exception{
        Thread t1 = new Thread(() -> {
            System.out.println("Parse1 finish");
        });

        Thread t2 = new Thread(() -> {
            System.out.println("Parse2 finish");
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("all parse finish");
    }
}
