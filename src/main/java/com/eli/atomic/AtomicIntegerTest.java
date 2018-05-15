package com.eli.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by elizhou on 2018/5/15.
 */
public class AtomicIntegerTest {
    static AtomicInteger atomicInteger = new AtomicInteger(1);

    public static void main(String[] args) {
        System.out.println(atomicInteger.getAndIncrement());
        System.out.println(atomicInteger.get());
    }
}
