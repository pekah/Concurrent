package com.eli.thread;

/**
 * Created by elizhou on 2018/5/8.
 */
public class Shutdown {

    public static void main(String[] args) throws Exception{
        Thread countThread = new Thread(new Runner(), "CountThread");
        countThread.start();
        // 睡眠1秒，main线程对CountThread进行中断，使CountThread能够感知中断而结束。
        SleepUtils.second(1);
        countThread.interrupt();

        Runner runnerTwo = new Runner();
        countThread = new Thread(runnerTwo, "CountTwoThread");
        countThread.start();
        // 睡眠1s，main线程对CountTwoThread进行取消，使CountTwoThread能够感知On为false而结束
        SleepUtils.second(1);
        runnerTwo.cancel();
    }

    private static class Runner implements Runnable {
        private long i;
        private volatile boolean on  = true;

        @Override
        public void run() {
            while (on && !Thread.currentThread().isInterrupted()) {
                i++;
            }
            System.out.println("Count i = " + i);
        }

        public void cancel () {
            on = false;
        }
    }
}
