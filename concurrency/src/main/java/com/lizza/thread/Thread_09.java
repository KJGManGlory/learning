package com.lizza.thread;

/**
 * 线程间通信
 * 问题:
 *      两个线程, 操作一个初始值为0的数据, 一个线程每次对数据加1, 另一个线程每次
 *      对该数据减1, 实现交替, 操作10次
 * 注意:
 *      当线程不止两个时, 再次运行, 结果会发生截然不同的变化: 原本101010...的输出,
 *      会变的不可预料; 问题的原因在于阻塞中的线程被系统虚假唤醒, 继续执行加1操作, 导致
 *      问题产生
 * 解决:
 *      if换while
 *
 */
class Counter1 {
    private int number;

    public synchronized void increase() {
        if (number != 0) {
//        while (number != 0) {
            try {
                this.wait();
                // 1. 执行完wait后, 被虚假唤醒, if只判断1次, 线程继续向下执行
                // 2. 换成while, 被唤醒后, 会再次进行判断
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        number ++;
        System.out.println(Thread.currentThread().getName() + ": " + number);
        this.notifyAll();
    }

    public synchronized void decrease() {
        if (number == 0) {
//        while (number == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        number --;
        System.out.println(Thread.currentThread().getName() + ": " + number);
        this.notifyAll();
    }
}

public class Thread_09 {

    public static void main(String[] args){
        Counter1 counter1 = new Counter1();
        new Thread(() -> {
            for (int i = 1; i <= 5; i++) counter1.increase();
        }, "A").start();
        new Thread(() -> {
            for (int i = 1; i <= 5; i++) counter1.decrease();
        }, "B").start();
        new Thread(() -> {
            for (int i = 1; i <= 5; i++) counter1.increase();
        }, "C").start();
        new Thread(() -> {
            for (int i = 1; i <= 5; i++) counter1.decrease();
        }, "D").start();
    }
}
