package com.lizza.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 1. FutureTask的get方法一般放在最后
 */
class Test_1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask task = new FutureTask(new Callable_1());
        new Thread(task, "A").start();
        System.out.println("Calculate Finished!");
        System.out.println("Result: " + task.get());
    }
}
public class Callable_1 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("Into Call Method!");
        Thread.sleep(4000);
        return 10;
    }
}
