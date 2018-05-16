package com.eli.thread;

import java.util.concurrent.CountDownLatch;

/*
3一定在1,2之后才执行
countDownLatch的countDown方法和await方法配合使用。
执行await方法时，当前线程会阻塞，直到CountDownLatch的值变成0（每次执行countDown方法会减1）时才会解除阻塞状态
 */
public class CountDownLatchTest {
    static CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws Exception{
        new Thread(() -> {
            System.out.println(1);
            countDownLatch.countDown();
            System.out.println(2);
            countDownLatch.countDown();
        }).start();

        countDownLatch.await();
        System.out.println(3);
    }
}
