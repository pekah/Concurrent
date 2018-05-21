package com.eli.thread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by elizhou on 2018/5/16.
 */
public class CopyOnWriteArrayListTest {

    private void test() {
        // 1、初始化CopyOnWriteArrayList
        List<Integer> tempList = Arrays.asList(1, 2);
        CopyOnWriteArrayList<Integer> copyList = new CopyOnWriteArrayList<>(tempList);

        // 2、模拟多线程对list进行读写
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(new ReadThread(copyList));
        executorService.execute(new WriteThread(copyList));
        executorService.execute(new WriteThread(copyList));
        executorService.execute(new WriteThread(copyList));
        executorService.execute(new ReadThread(copyList));
        executorService.execute(new WriteThread(copyList));
        executorService.execute(new ReadThread(copyList));
        executorService.execute(new WriteThread(copyList));

        System.out.println("copyList size : " + copyList.size());

    }

    public static void main(String[] args) {
        new CopyOnWriteArrayListTest().test();
    }

    static class ReadThread implements Runnable {
        private List<Integer> list;

        public ReadThread(List<Integer> list) {
            this.list = list;
        }

        @Override
        public void run() {
            for (Integer item : list) {
                System.out.println("ReadThread : " + item);
            }
            System.out.println("---");
        }
    }

    static class WriteThread implements Runnable {
        private List<Integer> list;

        public WriteThread(List<Integer> list) {
            this.list = list;
        }

        @Override
        public void run() {
            this.list.add(9);
        }
    }
}
