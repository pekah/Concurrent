package com.eli.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * Created by elizhou on 2018/5/16.
 */
public class AtomicIntegerFiledUpdaterTest {
    // 创建原子更新器，并设置需要更新的对象类和对象属性
    private static AtomicIntegerFieldUpdater<User> updater = AtomicIntegerFieldUpdater.newUpdater(User.class, "old");

    public static void main(String[] args) {
        User user = new User("he", 10);
        updater.getAndIncrement(user);
        System.out.println(updater.get(user));
    }

    public static class User {
        private String name;
        /*
            1，更新器更新的必须是int类型变量，不能是其包装类型。
            2，更新器更新的必须是volatile类型变量，确保线程之间共享变量时的立即可见性。
            3，变量不能是static的，必须是实例变量。因为Unsafe.objectFieldOffset()方法不支持静态变量（CAS操作本质上是通过对象实例的偏移量来直接进行赋值）
            4，更新期只能修改它可见范围内的变量，因为更新器是通过反射来得到这个变量，如果变量不可见就会报错。

         */
        public volatile int old;

        public User(String name, int old) {
            this.name = name;
            this.old = old;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getOld() {
            return old;
        }

        public void setOld(int old) {
            this.old = old;
        }
    }
}
