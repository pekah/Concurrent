package com.eli.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * Created by elizhou on 2018/5/15.
 */
public class AtomicIntegerArrayTest {

    static int[] value = new int[]{1,2};

    static AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(value);

    public static void main(String[] args) {
        atomicIntegerArray.getAndSet(0, 3);
        System.out.println(atomicIntegerArray.get(0));
        System.out.println(value[0]);
    }
}
