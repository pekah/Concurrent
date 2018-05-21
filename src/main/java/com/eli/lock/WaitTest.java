package com.eli.lock;

import com.eli.thread.SleepUtils;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by elizhou on 2018/5/14.
 */
public class WaitTest {
    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();
    private static volatile int i = 0;

    public static void main(String[] args) throws InterruptedException{
        System.out.println(1 << 30);
        System.exit(0);
        Thread t1 = new Thread(new Wait(), "Thread1");
        t1.start();

        SleepUtils.second(5);

        Thread t2 = new Thread(new Signal(), "Thread2");
        t2.start();

    }

    static class Wait implements Runnable{
        @Override
        public void run() {
            lock.lock();
            try {
                while(i == 0){
                    System.out.println("Wait run");
                    try {
                        condition.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }

                System.out.println(i);

            }finally {
                lock.unlock();
            }
        }


    }

    static class Signal implements Runnable {
        @Override
        public void run() {
            lock.lock();
            try {
//                if(i != 1){
//                    i = 1;
                    condition.signal();
//                }
            } finally {
                lock.unlock();
            }
        }
    }
}
