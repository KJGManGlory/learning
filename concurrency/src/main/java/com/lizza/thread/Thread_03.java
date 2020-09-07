package com.lizza.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2020-08-20
 */
public class Thread_03 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask<>(() -> {
            System.out.println(Thread.currentThread().getName() + " Is Running!");
            return 10;
        });
        new Thread(task).start();
        System.out.println("Result Is: " + task.get());
    }
}
