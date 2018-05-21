package com.eli.concurrent;

import java.util.concurrent.SynchronousQueue;

/**
 * Created by elizhou on 2018/5/18.
 */
public class SynchronousQueueTest {
    public static void main(String[] args) throws Exception{
        SynchronousQueue<Integer> queue = new SynchronousQueue<>(false);

        // poll方法会从队列里获取并移除头部节点，获取不到时返回null
//        Thread pollThread = new Thread(() -> {
//            System.out.println("poll thread start");
//            Integer element = queue.poll();
//            System.out.println(element);
//            System.out.println("poll thread end");
//        });
//
//        pollThread.start();
//
//        Thread.sleep(1000);

        Thread putThread = new Thread(() -> {
            System.out.println("put thread start");
            try {
                queue.put(1);
            } catch (InterruptedException e) {

            }
            System.out.println("put thread end");
        });

        Thread putThread2 = new Thread(() -> {
            System.out.println("put thread2 start");
            try {
                queue.put(2);
            } catch (InterruptedException e) {

            }
            System.out.println("put thread2 end");
        });

        Thread takeThread = new Thread(() -> {
            System.out.println("take thread start");
            try {
                System.out.println("take from put thread : " + queue.take());
            } catch (InterruptedException e) {

            }
            System.out.println("take thread end");
        });

        Thread takeThread2 = new Thread(() -> {
            System.out.println("take thread2 start");
            try {
                System.out.println("take from put thread : " + queue.take());
            } catch (InterruptedException e) {

            }
            System.out.println("take thread2 end");
        });

        putThread.start();
        Thread.sleep(1000);
        putThread2.start();
        Thread.sleep(1000);
        takeThread.start();
        Thread.sleep(1000);
        takeThread2.start();
    }
}
