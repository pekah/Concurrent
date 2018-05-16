package com.eli.thread;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by elizhou on 2018/5/16.
 */
public class CyclicBarrierTest2 {
    static CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new A());

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                cyclicBarrier.await();
            } catch (Exception e){

            }

            System.out.println(1);
        }).start();

        try {
            cyclicBarrier.await();
        } catch (Exception e){

        }

        System.out.println(2);
    }

    static class A implements Runnable {
        @Override
        public void run() {
            System.out.println(3);
        }
    }
}
