package com.lizza.thread;

/**
 * 题目: 线程8锁
 * 1. 标准访问, 请问先打印邮件还是短信?
 * 2. 邮件方法暂停3秒钟, 请问先打印邮件还是短信?
 * 3. 新增一个普通方法hello(), 请问先打印邮件还是 hello?
 * 4. 两部手机, 请问先打印邮件还是短信?
 * 5. 两个静态同步方法, 同一部手机, 请问先打印邮件还是短信?
 * 6. 两个静态同步方法, 2部手机, 请问先打印邮件还是短信?
 * 7. 1个普通同步方法, 1个静态同步方法, 1部手机, 请问先打印邮件还是短信?
 * 8. 1个普通同步方法, 1个静态同步方法, 2部手机, 请问先打印邮件还是短信?
 *
 * 笔记
 * 1. 一个对象里面如果有多个synchronized方法, 在某一时刻, 只要一个线程去调用其中一个synchronized方法
 *    其它的线程都只能等待; 换句话说, 在某一时刻, 只能有唯一一个线程去访问这些synchronized方法, 锁的是当前
 *    对象this, 被锁定后, 其它的线程都不能进入到当前对象的其它的synchronized方法
 * 2. 加个普通方法后发现和同步锁无关
 * 3. 换成两个对象后, 不是同一把锁了, 情况立刻变化。
 * 4. 都换成静态同步方法后, 情况又变化
 * 5. 所有的非静态问同步方法用的都是同一把锁: 即实例对象本身
 * 6. synchronized实现同步的基础: Java中的每一个象都可以作为锁; 具体表现为以下3种形式:
 *      6.1 对于普通同步方法, 锁是当前实例对象
 *      6.2 对于静态同步方法, 锁是当前类的Class对象
 *      6.3 对于同步方法块, 锁是synchronized块中配置的对象
 * 7. 当一个线程试图访问同步代码块时, 它首先必须得到锁, 退出或抛出异常时必须释放锁, 也就是说如果一个实例对象
 *    的非静态同步方法获取锁后, 该实例对象的其他非静态同步方法必须等待获取锁的方法释放锁后才能获取锁, 可是别的
 *    实例对象的非静态问同步方法因为跟该实例对象的非静态同步方法用的是不同的锁, 所以须等待该实例对象已获取锁的
 *    静态同步方法释放锁就可以获取他们自已的锁。
 * 8. 所有的静态同步方法用的也是同一把锁: 类对象本身; 这两把锁是两个不同的对象, 所以静态同步方法与非静态问步方法
 *    之间是不会有竞态条件的; 但是一旦一个静态同步方法获取锁后, 其他的静态同步方法都必须等待该方法释放锁后才能获取锁,
 *    而不管是同一个实例对象的静态同步方法之间, 还是不同的实例对象的静态同步方法之间, 只要它们同一个类的实例对象
 */
public class Thread_13 {

    public static void main(String[] args) throws Exception{
        Phone phone = new Phone();
        Phone phone2 = new Phone();
        new Thread(() -> {
            phone.sendEmail();
        }, "A").start();
        Thread.sleep(100);
        new Thread(() -> {
//            phone.hello();
            phone.sendSms();
//            phone2.sendSms();
        }, "B").start();
    }
}

class Phone {

    public synchronized void sendEmail() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(">>> Send Email");
    }

    public static synchronized void sendSms() {
        System.out.println(">>> Send Sms");
    }

    public void hello() {
        System.out.println(">>> Hello");
    }
}
