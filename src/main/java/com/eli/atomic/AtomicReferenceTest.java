package com.eli.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by elizhou on 2018/5/16.
 */
public class AtomicReferenceTest {

    public static AtomicReference<User> atomicReference = new AtomicReference<>();

    public static void main(String[] args) {
        User user = new User("ca", 16);
        atomicReference.set(user);

        User updateUser = new User("he", 18);
        atomicReference.compareAndSet(user, updateUser);

        System.out.println(atomicReference.get().getName());
        System.out.println(atomicReference.get().getOld());
    }


    static class User {
        private String name;
        private int old;

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
