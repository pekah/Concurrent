package com.eli.thread;

/*

    .\jps.exe 查看当前应用的pid
    .\jstack.exe 14196 查看线程的状态
 */
public class ThreadState {

    public static void main(String[] args) {
        new Thread(new TimeWaiting(), "TimeWaitingThread").start();
        new Thread(new Waiting(), "WaitingThread").start();
        // 使用两个Blocked线程，一个获取锁成功，另一个被阻塞
        new Thread(new Blocked(), "BlockThread-1").start();
        new Thread(new Blocked(), "BlockThread-2").start();
    }

    // 该线程不断地进行睡眠
    static class TimeWaiting implements Runnable {
        @Override
        public void run() {
            while(true) {
                SleepUtils.second(100);
            }
        }
    }

    // 该线程在Waiting.class实例上等待
    static class Waiting implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (Waiting.class) {
                    try {
                        Waiting.class.wait();
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    // 该线程在Blocked.class实例上加锁后，不会释放锁
    static class Blocked implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (Blocked.class) {
                    SleepUtils.second(100);
                }
            }
        }
    }

}

