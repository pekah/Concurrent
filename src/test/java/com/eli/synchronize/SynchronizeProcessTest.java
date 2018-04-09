package com.eli.synchronize;

import org.junit.Test;

/**
 * Created by elizhou on 2018/4/9.
 */
public class SynchronizeProcessTest {

    public static final int LOOP_TIME = 1000 * 10000;

    @Test
    public void testUnThreadSafeCountingProcessor(){
        CountingProcessor countingProcessor = new UnThreadSafeCountingProcessor();
        runTask(countingProcessor);
    }


    private void runTask(CountingProcessor countingProcessor){
        Thread thread1 = new Thread(new ProcessTask(countingProcessor, LOOP_TIME), "thread-1");
        Thread thread2 = new Thread(new ProcessTask(countingProcessor, LOOP_TIME), "thread-2");

        thread1.start();
        thread2.start();

        // wait unit all the threads have finished
        while(thread1.isAlive() || thread2.isAlive()) {}
    }


}
