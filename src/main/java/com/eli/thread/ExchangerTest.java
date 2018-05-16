package com.eli.thread;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
用于两个线程之间的数据交换，线程A执行 exchanger.exchange方法之后会一直等待，直到线程B执行 exchanger.exchange方法。
当两个线程都到达同步点时，这两个线程就可以交换数据。

 */
public class ExchangerTest {
    private static final Exchanger<String> exchanger = new Exchanger<>();

    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        threadPool.execute(new Thread(() -> {
            try {
                String a = "银行流水A";
                String b = exchanger.exchange(a);

                System.out.println("B数据为 ： " + b);
            } catch (InterruptedException e) {

            }
        }));

        threadPool.execute(new Thread(() -> {
            try {
                String b = "银行流水B";
                String a = exchanger.exchange(b);

                System.out.println("A和B数据是否一致 ： " + a.equals(b) + " A数据为 ： " + a + ",B数据为 ： " + b);
            } catch (InterruptedException e) {

            }
        }));

        threadPool.shutdown();
    }
}
