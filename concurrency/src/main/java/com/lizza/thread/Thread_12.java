package com.lizza.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Resource2 {
    private Map<String, String> map = new HashMap<String, String>(){{
        put("A", "B");
        put("B", "C");
        put("C", "A");
    }};
    private String current = "A";
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void print(String flag, int times) {
        lock.lock();
        try {
            while (!flag.equals(current)) {
                condition.await();
            }
            for (int i = 1; i <= times; i++) {
                System.out.println(Thread.currentThread().getName() + ":  " + i);
            }
            current = map.get(flag);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

/**
 * 问题:
 *      多线程之间按顺序调用, 实现A->B->C, 三个个线程启动, 要求如下:
 *      A打印5次, B打10次, C打印15次; 接着A打印5次, B打10次, CC打的15次
 *      来10轮
 * 解决:
 *      使用Lock, Condition加标志位来解决 > 改进版本, 使用1个condition
 */
public class Thread_12 {

    public static void main(String[] args){
        Resource2 resource2 = new Resource2();

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                resource2.print("A", 5);
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                resource2.print("B", 10);
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                resource2.print("C", 15);
            }
        }, "C").start();
    }
}
