package com.lizza.threadPool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * 线程池的使用:
 * 1. Executors创建常用类型的线程池
 */
public class ThreadPool_1 {

    public static void main(String[] args){
//        ExecutorService executor = Executors.newFixedThreadPool(5);
//        ExecutorService executor = Executors.newSingleThreadExecutor();
        ExecutorService executor = Executors.newCachedThreadPool();
        try {
            for (int i = 0; i < 13; i++) {
                executor.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + " 执行任务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }

    }
}
