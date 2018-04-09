package com.eli.concurrent;

/**
 * Created by elizhou on 2018/4/9.
 * https://hzy38324.gitbooks.io/java-concurrency-in-practice/content/volatile.html
 */
public class Game {

    /**
     *  这里有两个线程，main函数所在的主线程和GoalNotifier线程，这两个线程分别从主内存拷贝了一个goal变量的副本，所以当main函数调用
     *  setGoal()方法修改goal时，对主内存不会有影响，更不会对GoalNotifier线程的goal副本产生影响，GoalNotifier线程自然就感知不到goal变成true了。
     *
     *  而在goal变量之前加上volatile修饰符后，让main函数修改了goal之后主动同步到主内存，并且让GoalNotifier线程在读取goal之前，主动从主内存中取最新的goal
     */
    public static void main(String[] args) throws Exception{

        GoalNotifier goalNotifier = new GoalNotifier();
        Thread goalNotifierThread = new Thread(goalNotifier);
        goalNotifierThread.start();

        Thread.sleep(3000);

        goalNotifier.setGoal(true);
    }
}
