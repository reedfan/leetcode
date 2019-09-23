package juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * FutureTask 可用于异步获取执行结果或取消执行任务的场景。
 * 当一个计算任务需要执行很长时间，那么就可以用 FutureTask 来封装这个任务，
 * 主线程在完成自己的任务之后再去获取结果。
 */

public class FutureTaskExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Long t1 = System.currentTimeMillis();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int result = 0;
                for (int i = 0; i < 100; i++) {
                    Thread.sleep(30);
                    result += i;
                }
                return result;
            }
        });

        Thread computeThread = new Thread(futureTask);
        computeThread.start();

        //此时可以去干其他的事情
        System.out.println("other task is running...");
        Thread.sleep(3000);

        System.out.println(System.currentTimeMillis()-t1);
        System.out.println(futureTask.get());
        System.out.println(System.currentTimeMillis()-t1);
    }
}
