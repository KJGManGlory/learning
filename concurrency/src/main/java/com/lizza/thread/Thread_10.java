package com.lizza.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程间通信
 * lock版实现
 *
 */
class Counter2 {
    private int number;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increase() {
        lock.lock();
        try {
            while (number != 0) {
                condition.await();    // this.wait();
            }
            number ++;
            System.out.println(Thread.currentThread().getName() + ": " + number);
            condition.signalAll();  // this.notifyAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void decrease() {
        lock.lock();
        try {
            while (number == 0) {
                condition.await();  // this.wait();
            }
            number --;
            System.out.println(Thread.currentThread().getName() + ": " + number);
            condition.signalAll();  // this.notifyAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class Thread_10 {

    public static void main(String[] args){
        Counter2 counter = new Counter2();
        new Thread(() -> {
            for (int i = 1; i <= 5; i++) counter.increase();
        }, "A").start();
        new Thread(() -> {
            for (int i = 1; i <= 5; i++) counter.decrease();
        }, "B").start();
        new Thread(() -> {
            for (int i = 1; i <= 5; i++) counter.increase();
        }, "C").start();
        new Thread(() -> {
            for (int i = 1; i <= 5; i++) counter.decrease();
        }, "D").start();
    }
}
