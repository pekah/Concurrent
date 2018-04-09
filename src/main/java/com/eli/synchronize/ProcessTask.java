package com.eli.synchronize;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

/**
 * Created by elizhou on 2018/4/9.
 */
public class ProcessTask implements Runnable {

    private static Logger logger = Logger.getLogger(ProcessTask.class);

    private CountingProcessor countingProcessor;
    private long loopTime;

    public ProcessTask(CountingProcessor countingProcessor, long loopTime){
        this.countingProcessor = countingProcessor;
        this.loopTime = loopTime;
    }

    public void run() {
        int i = 0;
        while (i < loopTime){
            countingProcessor.process();
            i++;
        }

        System.out.println("result is " + countingProcessor.getCount());

        logger.info("result is " + countingProcessor.getCount());
    }
}
