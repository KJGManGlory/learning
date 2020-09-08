package com.lizza.collection;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 线程不安全的例子: 多个线程操作同一个ArrayList
 * 1. 故障现象
 *      java.util.ConcurrentModificationException
 *
 * 2. 导致原因
 *
 * 3. 解决方案
 *      3.1 Vector
 *      3.2 Collections.synchronizedList()
 *      3.3 CopyOnWriteArrayList
 *
 * 4. 优化建议
 *
 * 写时复制
 * CopyOnWrite容器即写时复制的容器; 往一个容器添加元素的时候, 不直接往当前容器Object[]添加, 而是先将当前容器
 * Object[]进Copy; 复制出一个新的容器Object[] newElements, 然后新的容器Object[] newElements里添加元素
 * 添加完元素之后, 再将原容器的引用指向新的容器 setArray(newElements); 这样做的好处是可以对CopyOnWrite容器
 * 进行并发读, 而不需要加锁, 因为当前容器不会添加任元素; 所以CopyOnWrite容器也是一种读写分离的思想, 读和写不同的容器
    public boolean add(E e) {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            Object[] elements = getArray();
            int len = elements.length;
            Object[] newElements = Arrays.copyOf(elements, len + 1);
            newElements[len] = e;
            setArray(newElements);
            return true;
        } finally {
            lock.unlock();
        }
    }
 */
public class UnsafeList {

    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>(); // new CopyOnWriteArrayList<>(); // Collections.synchronizedList(new ArrayList<>()); // new Vector<>(); // new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}
