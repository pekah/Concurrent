package com.eli.synchronize;

/**
 * Created by elizhou on 2018/4/9.
 * count++是一个“读取-修改-写入”三个动作的操作序列，因此该类是线程不安全的
 */
public class UnThreadSafeCountingProcessor implements CountingProcessor {

    private long count = 0;

    public void process() {
        doProcess();
        count++;
    }

    public long getCount() {
        return count;
    }

    private void doProcess(){

    }
}
