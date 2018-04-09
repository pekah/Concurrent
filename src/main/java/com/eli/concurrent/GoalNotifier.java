package com.eli.concurrent;

/**
 * Created by elizhou on 2018/4/9.
 */
public class GoalNotifier implements Runnable {

    /**
     *  被volatile修饰的变量在编译后的汇编代码会加上lock关键字
     *  lock的作用是使得本CPU的Cache写入内存，同时使其他CPU的Cache无效。
     */
    public volatile boolean goal = false;

    public boolean isGoal(){
        return goal;
    }

    public void setGoal(boolean goal){
        this.goal = goal;
    }

    public void run() {
        while (true){
            if (isGoal()){
                System.out.println("Goal!!!");

                setGoal(false);
            }
        }
    }
}
