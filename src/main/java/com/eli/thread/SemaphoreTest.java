package com.eli.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by elizhou on 2018/5/16.
 */
public class SemaphoreTest {
    private static final int THREAD_COUNT = 30;

    private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);

    private static Semaphore semaphore = new Semaphore(10);

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            threadPool.execute(new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println("save data");
                    semaphore.release();
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            }));
        }

        threadPool.shutdown();
    }

}
