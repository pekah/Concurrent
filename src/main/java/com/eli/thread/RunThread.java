package com.eli.thread;

/**
 * Created by elizhou on 2018/5/17.
 */
public class RunThread extends Thread{

    private boolean isRunning = true;
    private void setRunning(boolean isRunning){
        this.isRunning = isRunning;
    }

    public void run(){
        System.out.println("进入run方法..");
        int i = 0;
        while(isRunning == true){
            System.out.println(1);
            SleepUtils.second(1);
        }
        System.out.println("线程停止");
    }

    public static void main(String[] args) throws InterruptedException {
        RunThread rt = new RunThread();
        Thread t = new Thread(rt, "hello");
        t.start();
        Thread.sleep(1000);
        rt.setRunning(false);
        System.out.println("isRunning的值已经被设置了false");
    }


}