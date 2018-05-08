package com.eli.thread;

/*
 public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=2, locals=3, args_size=1
         0: ldc           #2                  // class com/eli/thread/Synchronized
         2: dup
         3: astore_1
         4: monitorenter
         5: aload_1
         6: monitorexit
         7: goto          15
        10: astore_2
        11: aload_1
        12: monitorexit
        13: aload_2
        14: athrow
        15: invokestatic  #3                  // Method m:()V
        18: return
      Exception table:

public static synchronized void m();
    descriptor: ()V
    flags: ACC_PUBLIC, ACC_STATIC, ACC_SYNCHRONIZED
    Code:
      stack=0, locals=0, args_size=0
         0: return
      LineNumberTable:
        line 19: 0
 */
public class Synchronized {
    public static void main(String[] args) {
        // 对synchronized Class对象进行加锁
        // 同步块的实现使用了monitorenter和monitorexit指令
        synchronized (Synchronized.class) {

        }

        // 静态同步方法，对Synchronized Class对象进行加锁
        m();
    }

    // 同步方法依靠方法修饰符上的ACC_SYNCHRONIZED来完成的。
    public static synchronized void m() {

    }
}
