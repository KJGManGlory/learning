package com.lizza.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Resource1 {
    private String flag = "A";
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void print5() {
        lock.lock();
        try {
            while (!flag.equals("A")) {
                condition1.await();
            }
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + ":  " + i);
            }
            flag = "B";
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print10() {
        lock.lock();
        try {
            while (!flag.equals("B")) {
                condition2.await();
            }
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + ":  " + i);
            }
            flag = "C";
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print15() {
        lock.lock();
        try {
            while (!flag.equals("C")) {
                condition3.await();
            }
            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
            flag = "A";
            condition1.signal();
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
 *      使用Lock, Condition加标志位来解决
 */
public class Thread_11 {

    public static void main(String[] args){
        Resource1 resource1 = new Resource1();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                resource1.print5();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                resource1.print10();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                resource1.print15();
            }
        }, "C").start();
    }
}
